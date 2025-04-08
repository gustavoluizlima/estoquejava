package com.controle.estoque;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application
{
    @Override
    public void start(Stage stage) {
    	Database.initDatabase();
    	
    	MainView mainView = new MainView();
    	Scene scene = new Scene(mainView.getView(), 400, 300);
    	
    	stage.setTitle("Controle de Estoque");
    	stage.setScene(scene);
    	stage.show();
    }
    
    public static void main(String[] args) {
    	launch();
	}
}
