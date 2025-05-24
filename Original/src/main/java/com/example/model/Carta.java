package main.java.com.example.model;

public class Carta {
    private Naipe naipe;
    private int valor;

    public Carta(Naipe naipe, int valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public int getValor() {
        return valor;
    }

    public String imagePath() {
        String[] nomes = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] naipes = {"Hearts", "Spades", "Diamonds", "Clubs"};
        return "/com/example/classic-cards/" + nomes[valor - 1] + naipes[naipe.ordinal()] + ".png";
    }
}