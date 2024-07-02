package com.blitmatthew.spring_mvc.controller;

import com.blitmatthew.spring_mvc.models.Cybrog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller //@RestController
@Slf4j
@RequestMapping("/cybrog")
public class CybrogController {

    //@GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "hello";
    }

    @GetMapping("/all")
    public String displayListOfCybrog(Model model){
        Cybrog cybrog = Cybrog.builder()
                .name("Cybermen")
                .alloy("Cyberium")
                .serialNumber("hf9832f438fgo378fg2087f2f393t4")
                .noOfWeapons(5)
                .noOfCpus(320000)
                .storage(320000)
                .build();
        Cybrog cybrog1 = Cybrog.builder()
                .name("Dalek Khan")
                .alloy("Dalekum")
                .serialNumber("fh237fow8yg2487g348tg03784y278")
                .noOfWeapons(5)
                .noOfCpus(600000)
                .storage(457357345)
                .build();

        List<Cybrog> cybrogs = List.of(cybrog, cybrog1);
        log.info(cybrogs.toString());
        model.addAttribute("cyborgs", cybrogs);
        log.info(model.toString());
        return "listOfCyborgs";
    }

}
