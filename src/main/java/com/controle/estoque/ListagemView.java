package com.controle.estoque;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListagemView {
    private VBox root;
    private Stage stage;

    public ListagemView(Stage stage) {
        this.stage = stage;
        root = new VBox(10);
        root.setPadding(new Insets(20));

        TableView<Item> tabela = new TableView<>();

        TableColumn<Item, String> nomeCol = new TableColumn<>("Nome");
        nomeCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNome()));

        TableColumn<Item, String> tipoCol = new TableColumn<>("Tipo");
        tipoCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTipo()));

        TableColumn<Item, Integer> qtdCol = new TableColumn<>("Quantidade");
        qtdCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getQuantidade()).asObject());

        TableColumn<Item, String> localCol = new TableColumn<>("Local");
        localCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLocal()));

        TableColumn<Item, String> dataCol = new TableColumn<>("Data Entrada");
        dataCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDataEntrada()));

        // Coluna de editar
        TableColumn<Item, Void> editarCol = new TableColumn<>("Editar");
        editarCol.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("Editar");

            {
                btn.setOnAction(e -> {
                    Item item = getTableView().getItems().get(getIndex());
                    CadastroView cadastroView = new CadastroView(stage, item);
                    stage.setScene(new Scene(cadastroView.getView(), 400, 400));
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });

        // Coluna de excluir
        TableColumn<Item, Void> excluirCol = new TableColumn<>("Excluir");
        excluirCol.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("Excluir");

            {
                btn.setOnAction(e -> {
                    Item item = getTableView().getItems().get(getIndex());
                    ItemDAO.excluir(item);
                    getTableView().getItems().remove(item);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });

        tabela.getColumns().addAll(nomeCol, tipoCol, qtdCol, localCol, dataCol, editarCol, excluirCol);

        List<Item> lista = ItemDAO.listarTodos();
        ObservableList<Item> dados = FXCollections.observableArrayList(lista);
        tabela.setItems(dados);

        Label label = new Label("Itens Cadastrados:");

        Button btnVoltar = new Button("Novo Cadastro");
        btnVoltar.setOnAction(e -> {
            CadastroView cadastroView = new CadastroView(stage, null);
            stage.setScene(new Scene(cadastroView.getView(), 400, 400));
        });

        root.getChildren().addAll(label, tabela, btnVoltar);
    }

    public VBox getView() {
        return root;
    }
}
