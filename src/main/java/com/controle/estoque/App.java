package com.controle.estoque;

import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application
{
    @Override
    public void start(Stage stage) {
    	Database.initDatabase();
    	
    	// MainView mainView = new MainViewa();
    	// Scene scene = new Scene(mainView.getView(), 400, 300);
    	
    	// CadastroView cadastroView = new CadastroView();
    	// Scene scene = new Scene(cadastroView.getView(), 400, 300);
    	
    	// ListagemView listagemView = new ListagemView();
        // Scene scene = new Scene(listagemView.getView(), 600, 400);
        
        MenuView menu = new MenuView(stage);
        menu.mostrar();
    	
        /*
    	stage.setTitle("Controle de Estoque");
    	stage.setScene(scene);
    	stage.show();
    	*/
    }
    
    public static void main(String[] args) {
    	launch();
	}
}
