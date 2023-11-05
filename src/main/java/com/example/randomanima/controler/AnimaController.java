/*
package com.example.randomanima.controler;

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
        var animaList = animaService.getAllAnima();
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

        animaService.addAnima(title, countSeries);

        var amimaList = animaService.getAllAnima();
        model.addAttribute("anims", amimaList);

        return "AnimaList.html";
    }

}
*/
