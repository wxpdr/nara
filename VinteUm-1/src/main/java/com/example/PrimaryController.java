package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {

    @FXML private HBox mesaDoJogador;
    @FXML private HBox mesaDoComputador;
    @FXML private ImageView monte;

    @FXML private Label pontosMesa;
    @FXML private Label pontosJogador;
    @FXML private Label resultado;

    private Jogo jogo = new Jogo();

    public void turno(){
        Jogador jogador = jogo.jogador;
        Computador computador = jogo.computador;
        if(!jogo.acabou()) {
            if(!jogador.parou()){
                Carta cartaJogador = jogo.monte.virar();
                jogador.receberCarta(cartaJogador);
            }
        
            if(!computador.parou()){
                Carta cartaComputador = jogo.monte.virar();
                computador.receberCarta(cartaComputador);
            }
        } else {
            resultado.setText(jogo.resultado());
        }
        
        atualizar();
    }

    public void atualizar(){
        pontosJogador.setText("Jogador: " + jogo.jogador.getPontos());
        pontosMesa.setText("Mesa: " + jogo.computador.getPontos());
        
        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();

        jogo.jogador.getCartas().forEach((carta) -> mesaDoJogador.getChildren().add(imagemCarta(carta)));
        jogo.computador.getCartas().forEach((carta) -> mesaDoComputador.getChildren().add(imagemCarta(carta)));
    }

    public void novoJogo(){
        jogo = new Jogo();
        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();
        pontosJogador.setText("Jogador: 0");
        pontosMesa.setText("Mesa: 0");
        resultado.setText("");
    }

    public void pedirCarta(){
       turno();
    }

    public void parar(){
        jogo.jogador.parar();
        turno();
    }
    

    private ImageView imagemCarta(Carta carta) {
       return new ImageView(App.class.getResource(carta.imagePath()).toString());
    }

    private ImageView criarImageDaCarta(Carta carta){
        return imagemCarta(carta);
    }

}
