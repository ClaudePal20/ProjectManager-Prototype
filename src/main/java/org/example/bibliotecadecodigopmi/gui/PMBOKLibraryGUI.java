package org.example.bibliotecadecodigopmi.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class PMBOKLibraryGUI extends Application{
    private PestañaMenuPrincipal pestañaMenuPrincipal;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Libreria para gestion de desarrollo de software");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        pestañaMenuPrincipal = new PestañaMenuPrincipal();
        pestañaMenuPrincipal.setupMenu(primaryStage);
    }

}
