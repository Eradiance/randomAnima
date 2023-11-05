package com.example.randomanima.repository;

import com.example.randomanima.model.Anima;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryAnimaRepository implements AnimaRepository {

    private List<Anima> animaList = new ArrayList<>();

    @Override
    public Anima addAnima(String title, Integer series) {
        Anima anima = new Anima();
        anima.setTitle(title);
        anima.setCountSeries(series);
        animaList.add(anima);
        return anima;
    }

    @Override
    public List<Anima> getAnims() {
        return animaList;
    }

    @Override
    public void removeAnima(String title) {
        animaList.remove(title);
    }
}
