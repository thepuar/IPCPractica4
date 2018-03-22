/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import practica4.Practica4;

/**
 *
 * @author thepuar
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnAmazon;
    @FXML
    private Button btnBing;
    @FXML
    private Button btnEbay;
    @FXML
    private Button btnFacebook;
    @FXML
    private Button btnGooglePlus;
    @FXML
    private Label labelBottom;
    @FXML
    private RadioMenuItem rbAmazon;
    @FXML
    private RadioMenuItem rbEbay;

    private ResourceBundle bundle;
    @FXML
    private MenuItem mIAmazon;
    @FXML
    private MenuItem mIBlogger;
    @FXML
    private MenuItem mIEbay;
    @FXML
    private MenuItem mIFacebook;
    @FXML
    private MenuItem mIGoogle;
    @FXML
    private RadioMenuItem rbSpa;
    @FXML
    private RadioMenuItem rbVal;
    @FXML
    private RadioMenuItem rbEng;

    private URL url;

    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.bundle = rb;
        this.url = url;
        this.labelBottom.setText("");
        //this.labelBottom.setText(bundle.getString("menu.File"));
        this.rbAmazon.setOnAction((ActionEvent e) -> {
            if (this.rbAmazon.isSelected()) {
                this.rbEbay.setSelected(false);
            }
        });
        this.rbEbay.setOnAction((ActionEvent e) -> {
            if (this.rbEbay.isSelected()) {
                this.rbAmazon.setSelected(false);
            }
        });
        System.out.println("Idioma: " + rb.getLocale().getLanguage());
        switch (rb.getLocale().getLanguage()) {
            case "es":
                this.rbSpa.setSelected(true);
                break;
            case "ca":
                this.rbVal.setSelected(true);
                break;
            case "en":
                this.rbEng.setSelected(true);
                break;

        }

//        this.mIAmazon.setOnAction(this::btnAmazonPressed);
//        this.mIBlogger.setOnAction(this::btnBingPressed);
//        this.mIEbay.setOnAction(this::btnEbayPressed);
//        this.mIFacebook.setOnAction(this::btnFacebookPressed);
//        this.mIGoogle.setOnAction(this::btnGooglePressed);
//        
//        
    }

    @FXML
    private void btnFacebookPressed(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Introduce un nombre");
        dialog.setHeaderText("Con que usuario quieres escribir en Facebook");
        dialog.setContentText("Introduce tu nombre:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> this.labelBottom.setText("Mensaje enviado como " + name));

    }

    @FXML
    private void btnBingPressed(MouseEvent event) {
        List<String> choices = new ArrayList<>();
        choices.add("El blog de Athos");
        choices.add("El blog de Porthos");
        choices.add("El blog de Aramis");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("El blog de Athos", choices);
        dialog.setTitle("Selecciona un blog");
        dialog.setHeaderText("¿Que blog quieres visitar?");
        dialog.setContentText("Elige: ");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(option -> this.labelBottom.setText("Visitando " + option));
    }

    @FXML
    private void btnAmazonPressed(MouseEvent event) {
        if (this.rbAmazon.isSelected()) {
            showPurchaseRealized("Amazon");
        } else {
            noPurchaseRealized("Amazon");
        }

    }

    @FXML
    private void btnEbayPressed(MouseEvent event) {
        if (this.rbEbay.isSelected()) {
            showPurchaseRealized("Ebay");
        } else {
            noPurchaseRealized("Ebay");
        }
    }

    @FXML
    private void btnGooglePressed(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Introduce un nombre");
        dialog.setHeaderText("Con que usuario quieres escribir en Google+");
        dialog.setContentText("Introduce tu nombre:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> this.labelBottom.setText("Mensaje enviado como " + name));
    }

    public void showPurchaseRealized(String tienda) {
        this.labelBottom.setText("Has comprado en " + tienda);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Compra realizada correctamente");
        alert.setContentText("Has comprado en " + tienda);
        alert.showAndWait();
    }

    public void noPurchaseRealized(String tienda) {
        this.labelBottom.setText("No se ha podido realizar la compra en " + tienda);
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Negación");
        alert.setHeaderText("La compra no se ha podido realizar");
        alert.setContentText("Por favor, cambia la seleccion actual en el menú Opciones.");
        alert.showAndWait();
    }

    @FXML
    private void exitPressed(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void itemAmazonPressed(ActionEvent event) {
        if (this.rbAmazon.isSelected()) {
            showPurchaseRealized("Amazon");
        } else {
            noPurchaseRealized("Amazon");
        }

    }

    @FXML
    private void itemBingPressed(ActionEvent event) {
        List<String> choices = new ArrayList<>();
        choices.add("El blog de Athos");
        choices.add("El blog de Porthos");
        choices.add("El blog de Aramis");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("El blog de Athos", choices);
        dialog.setTitle("Selecciona un blog");
        dialog.setHeaderText("¿Que blog quieres visitar?");
        dialog.setContentText("Elige: ");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(option -> this.labelBottom.setText("Visitando " + option));

    }

    @FXML
    private void itemEbayPressed(ActionEvent event) {
        if (this.rbEbay.isSelected()) {
            showPurchaseRealized("Ebay");
        } else {
            noPurchaseRealized("Ebay");
        }
    }

    @FXML
    private void itemFacebookPressed(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Introduce un nombre");
        dialog.setHeaderText("Con que usuario quieres escribir en Facebook");
        dialog.setContentText("Introduce tu nombre:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> this.labelBottom.setText("Mensaje enviado como " + name));
    }

    @FXML
    private void itemGooglePressed(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Introduce un nombre");
        dialog.setHeaderText("Con que usuario quieres escribir en Google+");
        dialog.setContentText("Introduce tu nombre:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> this.labelBottom.setText("Mensaje enviado como " + name));
    }

    @FXML
    private void onSpaPressed(ActionEvent event) throws Exception {
        Locale locale = new Locale("es", "ES");
        Practica4 prac = new Practica4();
        prac.carga(locale);
        this.rbEng.setSelected(false);
        this.rbVal.setSelected(false);
    }

    @FXML
    private void onValPressed(ActionEvent event) throws Exception {
        Locale locale = new Locale("ca", "ES");
        Practica4 prac = new Practica4();
        prac.carga(locale);
        this.rbSpa.setSelected(false);
        this.rbEng.setSelected(false);

    }

    @FXML
    private void onEngPressed(ActionEvent event) throws Exception {
        Locale locale = new Locale("en", "US");
        Practica4 prac = new Practica4();
        prac.carga(locale);
        this.rbSpa.setSelected(false);
        this.rbVal.setSelected(false);

    }
}
