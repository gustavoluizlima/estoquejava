package com.controle.estoque;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CadastroView {
    private VBox root;
    public CadastroView(Stage stage, Item item) {
        root = new VBox(10);
        root.setPadding(new Insets(20));

        Text title = new Text(item != null && item.getId() > 0 ? "Editar Item" : "Cadastro de Item");

        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        TextField tipoField = new TextField();
        tipoField.setPromptText("Tipo");

        TextField quantidadeField = new TextField();
        quantidadeField.setPromptText("Quantidade");

        TextField localField = new TextField();
        localField.setPromptText("Local");

        DatePicker dataPicker = new DatePicker();
        dataPicker.setPromptText("Data de Entrada");

        Label statusLabel = new Label();

        // Preenche os campos se for edição
        if (item != null) {
            nomeField.setText(item.getNome());
            tipoField.setText(item.getTipo());
            quantidadeField.setText(String.valueOf(item.getQuantidade()));
            localField.setText(item.getLocal());
            dataPicker.setValue(java.time.LocalDate.parse(item.getDataEntrada()));
        }

        Button salvarBtn = new Button(item != null && item.getId() > 0 ? "Atualizar" : "Salvar");

        salvarBtn.setOnAction(e -> {
            try {
                String nome = nomeField.getText();
                String tipo = tipoField.getText();
                int quantidade = Integer.parseInt(quantidadeField.getText());
                String local = localField.getText();
                String data = dataPicker.getValue().toString();
                
                final Item[] itemRef = new Item[1];
                itemRef[0] = item;

                if (itemRef[0] != null && itemRef[0].getId() > 0) {
                    // Edição
                    itemRef[0] = new Item(itemRef[0].getId(), nome, tipo, quantidade, local, data);
                    ItemDAO.atualizar(itemRef[0]);
                    statusLabel.setText("Item atualizado com sucesso!");
                } else {
                    // Cadastro
                    itemRef[0] = new Item(nome, tipo, quantidade, local, data);
                    boolean sucesso = ItemDAO.salvar(itemRef[0]);
                    statusLabel.setText(sucesso ? "Item salvo com sucesso!" : "Erro ao salvar.");
                }
            } catch (Exception ex) {
                statusLabel.setText("Verifique os campos.");
                ex.printStackTrace();
            }
        });

        Button btnVoltar = new Button("Voltar para Lista");
        btnVoltar.setOnAction(e -> {
            ListagemView listagemView = new ListagemView(stage);
            Scene scene = new Scene(listagemView.getView(), 600, 400);
            stage.setScene(scene);
        });

        root.getChildren().addAll(title, nomeField, tipoField, quantidadeField, localField, dataPicker, salvarBtn, btnVoltar, statusLabel);
    }

    public VBox getView() {
        return root;
    }
}

