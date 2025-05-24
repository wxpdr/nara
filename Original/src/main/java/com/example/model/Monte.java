package main.java.com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monte {
    private List<Carta> cartas;

    public Monte() {
        cartas = new ArrayList<>();
        for (Naipe naipe : Naipe.values()) {
            for (int i = 1; i <= 13; i++) {
                cartas.add(new Carta(naipe, i));
            }
        }
        embaralhar();
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta virar() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return cartas.isEmpty();
    }
}
