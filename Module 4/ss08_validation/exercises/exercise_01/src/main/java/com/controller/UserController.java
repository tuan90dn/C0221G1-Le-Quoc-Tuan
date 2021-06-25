package com.controller;

import com.dto.UserDto;
import com.model.entity.User;
import com.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView createUser(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) {
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/index");
        }
        User user=new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        return new ModelAndView("/result");
    }
}
