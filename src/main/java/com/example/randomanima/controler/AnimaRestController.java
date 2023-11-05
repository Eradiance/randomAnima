package com.example.randomanima.controler;

import com.example.randomanima.model.Anima;
import com.example.randomanima.service.AnimaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class AnimaRestController {
    private final AnimaService animaService;

    public AnimaRestController(AnimaService animaService) {
        this.animaService = animaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Anima>> getAllAnima() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(animaService.getAllAnima());
    }

    @PostMapping("/addAnima")
    public ResponseEntity<Anima> addAnima(@RequestParam String title, @RequestParam Integer series) {
        Anima anima = animaService.addAnima(title, series);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(anima);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> removeAnima(@RequestParam String title) {

        List<Anima> listOfAnima = animaService.getAllAnima();

        for (Anima anima : listOfAnima) {
            if (anima.getTitle().equals(title)) {
                listOfAnima.remove(anima);
                break;
            }
        }
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Delete anime: " + title + " closed");
    }

    @GetMapping("/randomAnima")
    public ResponseEntity<List<Anima>> getRandomListOfAnima() {
        List<Anima> randomAnimaList = animaService.getAllAnima();
        Collections.shuffle(randomAnimaList);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(randomAnimaList);
    }
}
