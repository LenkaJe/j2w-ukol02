package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Controller
public class MainController {


    List<String> seznamCitatu = Arrays.asList("A user interface is like a joke. If you have to explain it, it's not that good.",
            "To replace programmers with robots, clients will have to accurately describe what they want. We're safe.",
            "I have a joke on programming but it only works on my computer.",
            "When I wrote this code, only God & I understood what it did. Now… Only God knows.");
    List<String> seznamFotek = Arrays.asList("SyDmbnO5aV0", "NLkXZQ7kHzI", "JlpLcuMDLCo", "LsqF59OOEC0");

    private final Random random; //generátor náh cisel

    public MainController() {
        random = new Random();
    }

    @GetMapping("/")
    public ModelAndView citatObrazek() { //metoda
        int indexCitat = random.nextInt(4);
        int indexFoto = random.nextInt(4);
        ModelAndView result = new ModelAndView("citat"); //definujeme jakou sablonu ma pouzit
        result.addObject("citatTed", seznamCitatu.get(indexCitat)); //jmeno atributu; hodnota atributu
        result.addObject("fotoTed", "background-image: url(https://source.unsplash.com/"+seznamFotek.get(indexFoto)+"/1600x900)");
        return result; //metoda citatObrazek vrací result
    }
}