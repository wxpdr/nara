package com.example;

import com.example.model.Carta;
import com.example.model.Jogo;
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

    private Jogo jogo;

    @FXML
    public void initialize() {
        novoJogo();
    }

    public void turno() {
        if (!jogo.getJogador().isParou()) {
            jogo.distribuirCarta(jogo.getJogador());
        }

        if (!jogo.getComputador().isParou()) {
            jogo.distribuirCarta(jogo.getComputador());
        }

        atualizar();

        if (jogo.acabou()) {
            resultado.setText(jogo.resultado());
        }
    }

    public void atualizar() {
        pontosJogador.setText("Jogador: " + jogo.getJogador().getPontuacao());
        pontosMesa.setText("Mesa: " + jogo.getComputador().getPontuacao());

        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();

        jogo.getJogador().getMao().forEach(
            carta -> mesaDoJogador.getChildren().add(imagemCarta(carta))
        );
        jogo.getComputador().getMao().forEach(
            carta -> mesaDoComputador.getChildren().add(imagemCarta(carta))
        );
    }

    public void novoJogo() {
        jogo = new Jogo();
        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();
        pontosJogador.setText("Jogador: 0");
        pontosMesa.setText("Mesa: 0");
        resultado.setText("");
    }

    public void pedirCarta() {
        turno();
    }

    public void parar() {
        jogo.getJogador().parar();
        turno();
    }

    private ImageView imagemCarta(Carta carta) {
        ImageView img = new ImageView(App.class.getResource(carta.imagePath()).toString());
        img.setFitHeight(100);
        img.setFitWidth(70);
        return img;
    }
}
