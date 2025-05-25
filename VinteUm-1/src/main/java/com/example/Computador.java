package com.example;

public class Computador extends Jogador {

    @Override
    public boolean parou(){
        int totalPontos = this.getPontos();
        return totalPontos > 16;
    }
}