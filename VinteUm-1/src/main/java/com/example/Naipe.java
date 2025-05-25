package com.example;

public enum Naipe {
    Hearts("Hearts"),
    Spades("Spades"),
    Diamonds("Diamonds"),
    Clubs("Clubs");

    private final String nome;

    Naipe(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
