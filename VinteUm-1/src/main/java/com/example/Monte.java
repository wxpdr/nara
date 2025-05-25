package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monte {
    private List<Carta> cartas = new ArrayList<>();

    public Monte() {
        for (Naipe tipo : Naipe.values()) {
            for (int valor = 1; valor <= 13; valor++) {
                Carta novaCarta = new Carta(valor, tipo);
                this.cartas.add(novaCarta);
            }
        }
        this.embaralhar();
    }

    public Carta virar() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
    }

    public void embaralhar() {
        Collections.shuffle(this.cartas);
    }
}
