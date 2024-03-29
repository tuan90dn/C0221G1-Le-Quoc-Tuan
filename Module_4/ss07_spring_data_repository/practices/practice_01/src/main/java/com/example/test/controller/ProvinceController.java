package com.example.test.controller;

import com.example.test.model.entity.Province;
import com.example.test.model.service.province_service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping(value = "/provinces")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;
    @GetMapping("")
    public ModelAndView listProvinces() {
        List<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }
    @GetMapping("/create-province")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Province province = provinceService.findById(id);
        if (province != null) {
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", province);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/province/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-province")
    public ModelAndView updateProvince(Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Province province = provinceService.findById(id);
        if (province != null) {
            ModelAndView modelAndView = new ModelAndView("/province/delete");
            modelAndView.addObject("province", province);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/province/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-province")
    public String deleteProvince(Province province) {
        provinceService.remove(province);
        return "redirect:/provinces";
    }
}
