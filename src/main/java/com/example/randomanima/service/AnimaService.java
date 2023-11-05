package com.example.randomanima.service;

import com.example.randomanima.model.Anima;
import com.example.randomanima.repository.AnimaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimaService {

    private final AnimaRepository animaRepository;

    public AnimaService(AnimaRepository animaRepository){
        this.animaRepository = animaRepository;
    }


    public Anima addAnima(String title, Integer series) {
        return animaRepository.addAnima(title, series);
    }

    public List<Anima> getAllAnima() {
        return animaRepository.getAnims();
    }
}
