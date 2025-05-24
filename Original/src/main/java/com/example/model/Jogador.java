package main.java.com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    protected List<Carta> mao = new ArrayList<>();
    protected boolean parou = false;

    public void receberCarta(Carta carta) {
        mao.add(carta);
    }

    public int getPontuacao() {
        int total = 0;
        for (Carta c : mao) {
            total += c.getValor();
        }
        return total;
    }

    public boolean isParou() {
        return parou;
    }

    public void parar() {
        parou = true;
    }

    public List<Carta> getMao() {
        return mao;
    }
}
