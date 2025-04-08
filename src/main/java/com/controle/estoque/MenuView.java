package com.controle.estoque;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class MenuView {
    private Stage stage;

    public MenuView(Stage stage) {
        this.stage = stage;
    }

    public void mostrar() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        Button btnCadastro = new Button("Cadastrar Novo Item");
        Button btnListagem = new Button("Ver Itens Cadastrados");

        btnCadastro.setOnAction(e -> {
            CadastroView cadastroView = new CadastroView(stage, null); // passando o stage
            Scene scene = new Scene(cadastroView.getView(), 400, 400);
            stage.setScene(scene);
        });

        btnListagem.setOnAction(e -> {
            ListagemView listagemView = new ListagemView(stage); // passando o stage
            Scene scene = new Scene(listagemView.getView(), 600, 400);
            stage.setScene(scene);
        });

        root.getChildren().addAll(btnCadastro, btnListagem);

        Scene menuScene = new Scene(root, 300, 200);
        stage.setScene(menuScene);
        stage.setTitle("Menu Principal");
        stage.show();
    }
}
