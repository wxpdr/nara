package com.example;

public class Jogo {
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo() {
        this.monte.embaralhar();
    }

    public Carta distribuiCartaParaJogador(Jogador jogador) {
        if (jogador.parou()) {
            return null;
        }

        Carta novaCarta = monte.virar();
        jogador.receberCarta(novaCarta);

        return novaCarta;
    }

    public boolean acabou() {
        boolean ambosPararam = computador.parou() && jogador.parou();
        boolean algumEstourou = jogador.getPontos() > 21 || computador.getPontos() > 21;
        return ambosPararam || algumEstourou;
    }

    public String resultado() {
        if (!acabou()) {
            return null;
        }

        int pontosJogador = jogador.getPontos();
        int pontosComputador = computador.getPontos();

        if ((pontosJogador < pontosComputador && pontosComputador <= 21) || pontosJogador > 21) {
            return "Você perdeu";
        }

        if ((pontosComputador < pontosJogador && pontosJogador <= 21) || pontosComputador > 21) {
            return "Você ganhou";
        }

        if (pontosJogador == pontosComputador || (pontosJogador > 21 && pontosComputador > 21)) {
            return "Empate";
        }

        return "";
    }

    public Jogador getJogador() {
        return this.jogador;
    }

    public Computador getComputador() {
        return this.computador;
    }
}