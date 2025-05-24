package main.java.com.example.model;

public class Jogo {
    private Monte monte;
    private Jogador jogador;
    private Computador computador;

    public Jogo() {
        monte = new Monte();
        jogador = new Jogador();
        computador = new Computador();
    }

    public Carta distribuirCarta(Jogador j) {
        if (j.isParou()) return null;
        Carta carta = monte.virar();
        if (carta != null) j.receberCarta(carta);
        return carta;
    }

    public boolean acabou() {
        return jogador.isParou() && computador.isParou()
            || jogador.getPontuacao() > 21
            || computador.getPontuacao() > 21;
    }

    public String resultado() {
        int pontJog = jogador.getPontuacao();
        int pontComp = computador.getPontuacao();

        if (pontJog > 21) return "Você perdeu!";
        if (pontComp > 21) return "Você ganhou!";
        if (pontJog == pontComp) return "Empate!";
        if (pontJog > pontComp) return "Você ganhou!";
        return "Você perdeu!";
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Computador getComputador() {
        return computador;
    }
}
