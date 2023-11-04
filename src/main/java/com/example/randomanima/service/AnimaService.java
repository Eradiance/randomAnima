package com.example.randomanima.service;

import com.example.randomanima.model.Anima;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimaService {
    private List<Anima> animaList = new ArrayList<>();

    public void addAnima(Anima anima) {
        animaList.add(anima);
    }

    public List<Anima> finaAllAnim() {
        return animaList;
    }
}
