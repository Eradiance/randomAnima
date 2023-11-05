package com.example.randomanima.repository;

import com.example.randomanima.model.Anima;

import java.util.List;

public interface AnimaRepository {
    public Anima addAnima(String title, Integer series);
    public void removeAnima(String title);
    public List<Anima> getAnims();
}
