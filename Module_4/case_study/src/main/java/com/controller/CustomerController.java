package com.controller;

import com.dto.CustomerDto;
import com.model.entity.Customer;
import com.model.entity.CustomerType;
import com.model.service.ICustomerService;
import com.model.service.ICustomerTypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;
    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypes(){
        return customerTypeService.findAll();
    }
    @GetMapping
    public String showCustomers(Model model, Principal principal, @RequestParam Optional<String> name, @PageableDefault(size = 4) Pageable pageable){
        String keyword="";
        if (name.isPresent()){
            keyword=name.get();
        }
        Page<Customer> customerPage = customerService.findByName(keyword,pageable);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("success","");
        int flag=0;
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        List<GrantedAuthority> grantedAuthorityList= new ArrayList<>(loginedUser.getAuthorities());
        List<String> listString=new ArrayList<>();
        for (GrantedAuthority grantedAuthority:grantedAuthorityList){
            listString.add(grantedAuthority+"");
        }
        for (String role:listString){
            if (role.equals("ROLE_ADMIN")){
                flag=1;
            }
        }
        model.addAttribute("flag", flag);
        return "/customer/display";
    }
    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("customerDto",new CustomerDto());
//        model.addAttribute("customerTypes",customerTypeService.findAll());
        return "/customer/create";
    }
    @PostMapping(value = "/save")
    public String saveCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
        if (bindingResult.hasErrors()){
//            model.addAttribute("customerTypes",customerTypeService.findAll());
            return "/customer/create";
        }
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        List<Customer> customerList=customerService.findAll();
        for (Customer customer1:customerList){
            if (customer.getCode().equals(customer1.getCode())){
                model.addAttribute("message","This code is exist!");
//                model.addAttribute("customerTypes",customerTypeService.findAll());
                return "/customer/create";
            }
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success","Create successful!");
        return "redirect:/customers/";
    }
    @GetMapping(value = "/edit/{id}")
    public String showEditForm(Model model,@PathVariable int id){
        Customer customer=customerService.findById(id);
        CustomerDto customerDto=new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
//        model.addAttribute("customerTypes",customerTypeService.findAll());
        return "/customer/edit";
    }
    @PostMapping(value = "/update")
    public String updateCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
//            model.addAttribute("customerTypes",customerTypeService.findAll());
            return "/customer/edit";
        }
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success","Edit successful!");
        return "redirect:/customers/";
    }
    @PostMapping(value = "/delete")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes){
        customerService.deleteByFlag(id);
        redirectAttributes.addFlashAttribute("success","Delete Successful!");
        return "redirect:/customers/";
    }

}
