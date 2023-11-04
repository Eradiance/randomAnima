package com.example.randomanima.controlers;

import com.example.randomanima.model.Anima;
import com.example.randomanima.service.AnimaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnimaController {

    private final AnimaService animaService;

    public AnimaController(AnimaService animaService) {
        this.animaService = animaService;
    }

    @RequestMapping("/")
    public String getAnimaList(Model model){
        var animaList = animaService.finaAllAnim();
        model.addAttribute("anims", animaList);
        return "AnimaList.html";
    }

    @RequestMapping("/anima/{animaTitle}")
    public String getAnima(@PathVariable String animaTitle, Model page) {
        page.addAttribute("animaName", animaTitle);
        return "AnimaPage.html";
    }

    @PostMapping("/")
    public String addAnima(@RequestParam String title, @RequestParam Integer countSeries, Model model) {

        Anima anima = new Anima();
        anima.setTitle(title);
        anima.setCountSeries(countSeries);
        animaService.addAnima(anima);

        var amimaList = animaService.finaAllAnim();
        model.addAttribute("anims", amimaList);

        return "AnimaList.html";
    }
}
