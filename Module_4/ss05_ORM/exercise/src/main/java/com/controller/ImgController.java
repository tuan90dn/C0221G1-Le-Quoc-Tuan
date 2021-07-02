package com.controller;

import com.model.entity.Image;
import com.model.service.IImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = {"/","images"})
public class ImgController {
    @Autowired
    private IImgService imgService;
    @GetMapping("")
    public String index(Model model){
        List<Image> imageList=imgService.findAll();
        model.addAttribute("images",imageList);
        model.addAttribute("image",new Image());
        return "index";
    }
    @PostMapping(value = "/images/save")
    public String saveImg(Image image){
        imgService.save(image);
        return "redirect:/images/";
    }
    @GetMapping(value = "/images/increment/{id}")
    public String incrementLike(@PathVariable int id){
        Image image=imgService.findById(id);
        image.setLikeComment(image.getLikeComment()+1);
        saveImg(image);
        return "redirect:/images/";
    }
}
