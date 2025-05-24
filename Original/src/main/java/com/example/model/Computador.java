package main.java.com.example.model;

import java.util.Random;

public class Computador extends Jogador {
    private EstrategiaDeParada estrategia;

    public Computador() {
        // Escolhe uma das duas estratégias aleatoriamente
        if (new Random().nextBoolean()) {
            estrategia = new EstrategiaCautelosa();
        } else {
            estrategia = new EstrategiaAgressiva();
        }
    }

    @Override
    public boolean isParou() {
        return estrategia.deveParar(this) || parou;
    }
}
