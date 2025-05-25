package com.example;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private int pontos = 0;
    private List<Carta> cartas = new ArrayList<>();
    private boolean parou = false;

    public void receberCarta(Carta carta){
        if (carta != null) {
            this.cartas.add(carta);
            this.pontos = this.pontos + carta.getNumero();
        }
    }

    public void parar() {
        this.parou = true;
    }

    public int getPontos() {
        return this.pontos;
    }

    public List<Carta> getCartas() {
        return new ArrayList<>(this.cartas);
    }

    public boolean parou(){
        return this.parou;
    }
}