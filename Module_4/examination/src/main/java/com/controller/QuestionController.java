package com.controller;

import com.dto.QuestionDto;
import com.model.entity.Question;
import com.model.entity.QuestionType;
import com.model.service.IQuestionService;
import com.model.service.IQuestionTypeService;
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
@RequestMapping(value = {"/","/questions"})
public class QuestionController {
    @Autowired
    private IQuestionTypeService questionTypeService;
    @Autowired
    private IQuestionService questionService;
    @ModelAttribute("questionType")
    public List<QuestionType> questionType(){
        return questionTypeService.findAll();
    }
    @GetMapping
    public String showQuestions(Model model,@RequestParam Optional<String> title, @RequestParam Optional<String> type, @PageableDefault(size = 4) Pageable pageable){
        String keywordTitle="";
        String keywordType="";
        if (title.isPresent()){
            keywordTitle=title.get();
        }
        if (type.isPresent()){
            keywordType=type.get();
        }
        Page<Question> questionPage = questionService.findQuestionByTitleAndQuestionType(keywordTitle,keywordType,pageable);
        model.addAttribute("questionPage", questionPage);
        model.addAttribute("keywordTitle",keywordTitle);
        model.addAttribute("keywordType",keywordType);
        model.addAttribute("success","");
        return "/question/display";
    }
    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("questionDto",new QuestionDto());
        return "/question/create";
    }
    @PostMapping(value = "/save")
    public String saveQuestion(@Valid @ModelAttribute("questionDto") QuestionDto questionDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            return "/question/create";
        }
        Question question=new Question();
        BeanUtils.copyProperties(questionDto,question);
        questionService.save(question);
        redirectAttributes.addFlashAttribute("success","Create successful!");
        return "redirect:/questions/";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditForm(Model model,@PathVariable int id){
        Question question=questionService.findById(id);
        QuestionDto questionDto=new QuestionDto();
        BeanUtils.copyProperties(question,questionDto);
        model.addAttribute("questionDto",questionDto);
        return "/question/edit";
    }
    @PostMapping(value = "/update")
    public String updateEmployee(@Valid @ModelAttribute("questionDto") QuestionDto questionDto,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "/question/edit";
        }
        Question question=new Question();
        BeanUtils.copyProperties(questionDto,question);
        questionService.save(question);
        redirectAttributes.addFlashAttribute("success","Edit successful!");
        return "redirect:/questions/";
    }
    @PostMapping(value = "/delete")
    public String deleteQuestion(@RequestParam int id, RedirectAttributes redirectAttributes){
        questionService.deleteByFlag(id);
        redirectAttributes.addFlashAttribute("success","Delete Successful!");
        return "redirect:/questions/";
    }
//    @GetMapping(value = "/search")
//    public String searchQuestion(Model model, @RequestParam Optional<String> title, @RequestParam Optional<String> type,@PageableDefault(size = 4) Pageable pageable){
//        String titleQuestion="";
//        String typeQuestion="";
//        if (title.isPresent()){
//            titleQuestion=title.get();
//        }
//        if (type.isPresent()){
//            typeQuestion=type.get();
//        }
//        Page<Question> questionPage=questionService.findQuestionsByTitleContainingAndQuestionType_Name(titleQuestion,typeQuestion,pageable);
//
//        model.addAttribute("questionPage", questionPage);
//        model.addAttribute("success","");
//        return "/question/display";
//    }


}
