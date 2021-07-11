package com.controller;

import com.dto.CustomerDto;
import com.dto.EmployeeDto;
import com.model.entity.Customer;
import com.model.entity.Employee;
import com.model.service.*;
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
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IAppUserService appUserService;
    @GetMapping
    public String showEmployees(Model model, @RequestParam Optional<String> name, @PageableDefault(size = 4) Pageable pageable){
        String keyword="";
        if (name.isPresent()){
            keyword=name.get();
        }
        Page<Employee> employeePage = employeeService.findByName(keyword,pageable);
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("success","");
        return "/employee/display";
    }
    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("employeeDto",new EmployeeDto());
        model.addAttribute("position",positionService.findAll());
        model.addAttribute("educationDegree",educationDegreeService.findAll());
        model.addAttribute("division",divisionService.findAll());
        model.addAttribute("appUser",appUserService.findAll());
        return "/employee/create";
    }
    @PostMapping(value = "/save")
    public String saveEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            return "/employee/create";
        }
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success","Create successful!");
        return "redirect:/employees/";
    }
    @GetMapping(value = "/edit/{id}")
    public String showEditForm(Model model,@PathVariable int id){
        Employee employee=employeeService.findById(id);
        EmployeeDto employeeDto=new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        model.addAttribute("position",positionService.findAll());
        model.addAttribute("educationDegree",educationDegreeService.findAll());
        model.addAttribute("division",divisionService.findAll());
        model.addAttribute("appUser",appUserService.findAll());

        return "/employee/edit";
    }
    @PostMapping(value = "/update")
    public String updateEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "/employee/edit";
        }
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success","Edit successful!");
        return "redirect:/employees/";
    }
    @PostMapping(value = "/delete")
    public String deleteEmployee(@RequestParam int id, RedirectAttributes redirectAttributes){
        employeeService.deleteByFlag(id);
        redirectAttributes.addFlashAttribute("success","Delete Successful!");
        return "redirect:/employees/";
    }
}
