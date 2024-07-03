package com.blitmatthew.spring_mvc.controller;

import com.blitmatthew.spring_mvc.models.Cybrog;
import com.blitmatthew.spring_mvc.service.CybrogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //@RestController
@Slf4j
@RequestMapping("/cybrog")
@RequiredArgsConstructor
public class CybrogController {

    private final CybrogService cybrogService;

    //@GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "hello";
    }

    @GetMapping("/all")
    public String displayListOfCybrog(Model model){
        List<Cybrog> cybrogs = cybrogService.getAllCybrogs();
        log.info(cybrogs.toString());
        model.addAttribute("cyborgs", cybrogs);
        log.info(model.toString());
        return "listOfCyborgs";
    }

    @GetMapping("/add")
    public String addCybrog(Model model) {
        model.addAttribute("cybrog", new Cybrog());
        return "addCybrog";
    }

    @PostMapping("/add")
    public String addCybrog(@ModelAttribute("cybrog") @Valid Cybrog cybrog, Errors errors) {
        if(errors.hasErrors()) {
            return "addCybrog";
        }
        cybrogService.addCybrog(cybrog);
        return "redirect:/cybrog/all";
    }

    @GetMapping("/edit/{id}")
    public String editCybrog(@PathVariable Integer id, Model model) {
        Cybrog cybrog = cybrogService.getCybrogById(id);
        model.addAttribute("cybrog", cybrog);
        return "editCybrog";
    }

    @PostMapping("/edit/{id}")
    public String updateCybrog(@PathVariable Integer id, @ModelAttribute("cybrog") @Valid Cybrog cybrog, Errors errors) {
        log.info(cybrog.toString());
        if (errors.hasErrors()){
            return "editCybrog";
        };

        cybrogService.updateCubrog(cybrog);
        return "redirect:/cybrog/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCybrog(@PathVariable Integer id) {
        cybrogService.deleteCybrog(id);
        return "redirect:/cybrog/all";
    }
}
