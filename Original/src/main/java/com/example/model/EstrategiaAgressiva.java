package main.java.com.example.model;

public class EstrategiaAgressiva implements EstrategiaDeParada {
    @Override
    public boolean deveParar(Jogador computador) {
        return computador.getPontuacao() >= 19;
    }
}
