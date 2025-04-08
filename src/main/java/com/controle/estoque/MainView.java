package com.controle.estoque;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.Region;

public class MainView {

	public VBox getView() {
		Text title = new Text("Sistema de Controle de Estoque");
		
		Button btnCadastrar = new Button("Cadastrar Item");
		Button btnListar = new Button("Listar Itens");
		
		btnCadastrar.setMaxWidth(Double.MAX_VALUE);
		btnListar.setMaxWidth(Double.MAX_VALUE);
		
		VBox layout = new VBox(15, btnCadastrar, btnListar);
		layout.setPadding(new Insets(20));
		layout.setPrefSize(400, 300);
		
		return layout;
	}
	
}
