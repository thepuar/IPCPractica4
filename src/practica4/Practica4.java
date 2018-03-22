/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author thepuar
 */
public class Practica4 extends Application {
    public static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Locale locale = Locale.getDefault();
        this.primaryStage = stage;
        carga(locale);
//        Locale locale = Locale.getDefault();
//        ResourceBundle bundle = ResourceBundle.getBundle("idiomas.strings",locale);
//        Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"),bundle);
//
//        Scene scene = new Scene(root);
//        stage.setTitle("Menus y dialogos");
//        
//        stage.setScene(scene);
//        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void carga(Locale locale)throws Exception{
        // Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("idiomas.strings",locale);
        Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"),bundle);

        Scene scene = new Scene(root);
        this.primaryStage.setTitle("Menus y dialogos");
        
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }
    
}
