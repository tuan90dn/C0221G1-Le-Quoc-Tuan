package com.controller;

import com.dto.ContractDetailDto;
import com.dto.ContractDto;
import com.dto.IContractDto;
import com.model.entity.Contract;
import com.model.entity.ContractDetail;
import com.model.entity.Customer;
import com.model.service.IContractService;
import com.model.service.ICustomerService;
import com.model.service.IEmployeeService;
import com.model.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

@Controller
@RequestMapping(value = "/contracts")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IServiceService serviceService;
//    @GetMapping
//    public String showContracts(Model model, Principal principal, @PageableDefault(size = 4) Pageable pageable){
//        Page<IContractDto> contractPage=contractService.findContracts(pageable);
//
//        model.addAttribute("contractPage",contractPage);
//        model.addAttribute("success","");
//        int flag=0;
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//        List<GrantedAuthority> grantedAuthorityList= new ArrayList<>(loginedUser.getAuthorities());
//        List<String> listString=new ArrayList<>();
//        for (GrantedAuthority grantedAuthority:grantedAuthorityList){
//            listString.add(grantedAuthority+"");
//        }
//        for (String role:listString){
//            if (role.equals("ROLE_ADMIN")){
//                flag=1;
//            }
//        }
//        model.addAttribute("flag", flag);
//        return "/contract/display";
//    }
    @GetMapping(value = {"/list_using"})
    public String showContractsUsing(Model model,Principal principal,@PageableDefault(size = 4) Pageable pageable){
        Page<IContractDto> contractPage=contractService.findListUsingContract(pageable);
        model.addAttribute("contractPage",contractPage);
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
        return "/contract/display";
    }
    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("contractDto",new ContractDto());
        model.addAttribute("employee",employeeService.findAll());
        model.addAttribute("customer",customerService.findAll());
        model.addAttribute("service",serviceService.findAll());
        return "contract/create";
    }
    @PostMapping(value = "/save")
    public String saveContract(@Valid @ModelAttribute("contractDto") ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("employee",employeeService.findAll());
            model.addAttribute("customer",customerService.findAll());
            model.addAttribute("service",serviceService.findAll());
            return "/contract/create";
        }
        Long numDate=ContractDto.daysBetween2Date(contractDto.getStartDate(),contractDto.getEndDate());
        if (numDate<0){
            model.addAttribute("employee",employeeService.findAll());
            model.addAttribute("customer",customerService.findAll());
            model.addAttribute("service",serviceService.findAll());
            model.addAttribute("message","Ngày kết thúc phải trễ hơn ngày bắt đầu!");
            return "/contract/create";
        }
        contractDto.setTotalMoney(contractDto.getService().getCost()*numDate);
        Contract contract=new Contract();
        BeanUtils.copyProperties(contractDto,contract);
//        contract.setTotalMoney(contract.getService().getCost()*Contract.daysBetween2Date(contract.getStartDate(),contract.getEndDate()));

        contractService.save(contract);
        redirectAttributes.addFlashAttribute("success","Create successful!");
        return "redirect:/contracts/list_using";
    }
    @GetMapping(value = "/edit/{id}")
    public String showEdit(Model model, @PathVariable int id){
        Contract contract=contractService.findById(id);
        ContractDto contractDto=new ContractDto();
        BeanUtils.copyProperties(contract,contractDto);
        model.addAttribute("contractDto",contractDto);
        model.addAttribute("employee",employeeService.findAll());
        model.addAttribute("customer",customerService.findAll());
        model.addAttribute("service",serviceService.findAll());
        return "/contract/edit";
    }
    @PostMapping(value = "/update")
    public String updateContract(Model model,@Valid @ModelAttribute("contractDto") ContractDto contractDto,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("employee",employeeService.findAll());
            model.addAttribute("customer",customerService.findAll());
            model.addAttribute("service",serviceService.findAll());
            return "/contract/edit";
        }
        Long numDate=ContractDto.daysBetween2Date(contractDto.getStartDate(),contractDto.getEndDate());
        contractDto.setTotalMoney(contractDto.getService().getCost()*numDate);
        Contract contract=new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("success","Edit successful!");
        return "redirect:/contracts/list_using";
    }
    @PostMapping(value = "/delete")
    public String deleteContract(@RequestParam int id,RedirectAttributes redirectAttributes){
        contractService.deleteByFlag(id);
        redirectAttributes.addFlashAttribute("success","Delete Successful!");
        return "redirect:/contracts/list_using";
    }

    @GetMapping(value = "/search")
    public String searchCustomerUsingService(@RequestParam String name,Model model,@PageableDefault(size = 4) Pageable pageable){
        Page<Contract> contractPage=contractService.findContractsByCustomerName(name,pageable);
        model.addAttribute("contractPage",contractPage);
        model.addAttribute("success","");
        return "/contract/display";
    }
//    public String searchCustomerUsingService(@RequestParam String name,Model model,@PageableDefault(size = 4) Pageable pageable){
//        List<Customer> customerList=customerService.findCustomerByName(name);
//
//        List<Contract> contractList=null;
//        for (Customer customer1:customerList){
//            Contract contract=contractService.findContractByCustomerId(customer1.getId());
//            assert false;
//            contractList.add(contract);
//        }
//        int start = (int) pageable.getOffset();
//        int end = (start + pageable.getPageSize()) > contractList.size() ? contractList.size() : (start + pageable.getPageSize());
//        Page<Contract> contractPage = new PageImpl<Contract>(contractList.subList(start, end), pageable, contractList.size());
//        model.addAttribute("contractPage",contractPage);
//        model.addAttribute("success","");
//        return "/contract/display";
//    }

}
