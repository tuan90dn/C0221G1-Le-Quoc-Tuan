package com.controller;

import com.dto.ContractDetailDto;
import com.dto.CustomerDto;
import com.model.entity.ContractDetail;
import com.model.entity.Customer;
import com.model.service.IAttachServiceService;
import com.model.service.IContractDetailService;
import com.model.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/contractdetails")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IAttachServiceService attachServiceService;
    @Autowired
    private IContractService contractService;
    @GetMapping
    public String showContractDetail(Model model,@PageableDefault(size = 4) Pageable pageable){
        model.addAttribute("listContractDetail",contractDetailService.findContractDetails(pageable));
        model.addAttribute("success","");
        return "/contract_detail/display";
    }
    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("contractDetailDto",new ContractDetailDto());
        model.addAttribute("contract",contractService.findAll());
        model.addAttribute("attachService",attachServiceService.findAll());
        return "/contract_detail/create";
    }
    @PostMapping(value = "/save")
    public String saveContractDetail(@Valid @ModelAttribute("contractDetailDto") ContractDetailDto contractDetailDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            return "/contract_detail/create";
        }
        ContractDetail contractDetail=new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);

        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("success","Create successful!");
        return "redirect:/contractdetails/";
    }
}
