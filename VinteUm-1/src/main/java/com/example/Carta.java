package com.example;

public class Carta {
    private int numero;
    private Naipe naipe;

    public Carta(int numero, Naipe naipe){
        this.numero = numero;
        this.naipe = naipe;
    }

    private String convertCard(int numero){
        if (numero == 1) return "Ace";
        if (numero == 11) return "Jack";
        if (numero == 12) return "Queen";
        if (numero == 13) return "King";
        return String.valueOf(numero);
    }

    public String imagePath() {
        String nome = convertCard(this.numero);
        return String.format("classic-cards/%s%s.png", nome, naipe);
    }

    public int getNumero() {
        return this.numero;
    }

    public Naipe getNaipe() {
        return this.naipe;
    }
}