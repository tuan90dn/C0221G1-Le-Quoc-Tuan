package com.controller;

import com.model.entity.Smartphone;
import com.model.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/smartphones")
@CrossOrigin
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{smartphoneId}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long smartphoneId) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(smartphoneId);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(smartphoneId);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping(value = "/edit/{smartphoneId}")
    public String showEdit(Model model, @PathVariable Long smartphoneId){
        Optional<Smartphone> smartphone = smartphoneService.findById(smartphoneId);
        model.addAttribute("smartphone",smartphone.get());
        return ("/edit");
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Smartphone> updateSmartphone(@RequestBody Smartphone smartphone,@PathVariable Long id){
        Optional<Smartphone> smartphoneEdit = smartphoneService.findById(id);
        if (!smartphoneEdit.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphone.setId(smartphoneEdit.get().getId());
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
    }
}
