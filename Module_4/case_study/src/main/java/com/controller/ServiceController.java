package com.controller;

import com.dto.CustomerDto;
import com.dto.ServiceDto;
import com.model.entity.Customer;
import com.model.entity.Service;
import com.model.service.IRentTypeService;
import com.model.service.IServiceService;
import com.model.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/services")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IServiceTypeService serviceTypeService;
    @Autowired
    private IRentTypeService rentTypeService;
    @GetMapping
    public String showServices(Model model, @RequestParam Optional<String> name, @PageableDefault(size = 4) Pageable pageable){
        String keyword="";
        if (name.isPresent()){
            keyword=name.get();
        }
        Page<Service> servicePage = serviceService.findByName(keyword,pageable);
        model.addAttribute("servicePage", servicePage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("success","");
        return "/service/display";
    }
    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("serviceDto",new ServiceDto());
        model.addAttribute("serviceType",serviceTypeService.findAll());
        model.addAttribute("rentType",rentTypeService.findAll());
        return "/service/create";
    }
    @PostMapping(value = "/save")
    public String saveService(@Valid @ModelAttribute("serviceDto") ServiceDto serviceDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            return "/service/create";
        }
        Service service=new Service();
        BeanUtils.copyProperties(serviceDto,service);

        serviceService.save(service);
        redirectAttributes.addFlashAttribute("success","Create successful!");
        return "redirect:/services/";
    }
}
