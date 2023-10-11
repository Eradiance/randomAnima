package com.example.randomanima.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnimaListController {
    @RequestMapping("/")
    public String getAnimaList(){
        return "AnimaList.html";
    }
}
