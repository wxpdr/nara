package main.java.com.example.model;

public class EstrategiaCautelosa implements EstrategiaDeParada {
    @Override
    public boolean deveParar(Jogador computador) {
        return computador.getPontuacao() >= 16;
    }
}
