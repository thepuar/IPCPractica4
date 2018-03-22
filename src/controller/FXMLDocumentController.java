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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
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

    }

    @FXML
    private void exitPressed(ActionEvent event) {
        Platform.exit();
    }

    //AMAZON
    @FXML
    private void btnAmazonPressed(MouseEvent event) {
        amazonPressed();
    }

    @FXML
    private void itemAmazonPressed(ActionEvent event) {
        amazonPressed();

    }

    private void amazonPressed() {
        if (this.rbAmazon.isSelected()) {
            showPurchaseRealized("Amazon");
        } else {
            noPurchaseRealized("Amazon");
        }
    }

    //BING
    @FXML
    private void btnBingPressed(MouseEvent event) {
        bingPressed();
    }

    @FXML
    private void itemBingPressed(ActionEvent event) {
        bingPressed();
    }

    private void bingPressed() {
        List<String> choices = new ArrayList<>();
        choices.add(this.bundle.getString("choice.Blog.Athos"));
        choices.add(this.bundle.getString("choice.Blog.Porthos"));
        choices.add(this.bundle.getString("choice.Blog.Aramis"));
        ChoiceDialog<String> dialog = new ChoiceDialog<>(this.bundle.getString("choice.Blog.Athos"), choices);
        dialog.setTitle(this.bundle.getString("choice.Blog.Tittle"));
        dialog.setHeaderText(this.bundle.getString("choice.Blog.Header"));
        dialog.setContentText(this.bundle.getString("choice.Blog.Content"));
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(option -> this.labelBottom.setText(this.bundle.getString("label.Visit") + option));

    }

    //EBAY
    @FXML
    private void btnEbayPressed(MouseEvent event) {
        ebayPressed();
    }

    @FXML
    private void itemEbayPressed(ActionEvent event) {
        ebayPressed();
    }

    private void ebayPressed() {
        if (this.rbEbay.isSelected()) {
            showPurchaseRealized("Ebay");
        } else {
            noPurchaseRealized("Ebay");
        }
    }

    //FACEBOOK
    @FXML
    private void itemFacebookPressed(ActionEvent event) {
        facebookPressed();
    }

    @FXML
    private void btnFacebookPressed(MouseEvent event) {
        facebookPressed();
    }

    private void facebookPressed() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle(this.bundle.getString("dialog.Social.Title"));
        dialog.setHeaderText(this.bundle.getString("dialog.Social.Fb.Header"));
        dialog.setContentText(this.bundle.getString("dialog.Social.Context"));
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> this.labelBottom.setText(this.bundle.getString("label.sendMessage") +" "+ name));
    }

    //GOOGLE+
    @FXML
    private void btnGooglePressed(MouseEvent event) {
        googlePressed();
    }

    @FXML
    private void itemGooglePressed(ActionEvent event) {
        googlePressed();
    }

    private void googlePressed() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle(this.bundle.getString("dialog.Social.Title"));
        dialog.setHeaderText(this.bundle.getString("dialog.Social.Gg.Header"));
        dialog.setContentText(this.bundle.getString("dialog.Social.Context"));
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> this.labelBottom.setText(this.bundle.getString("label.sendMessage") +" "+ name));

    }

    //COMPRAS
    public void showPurchaseRealized(String tienda) {
        this.labelBottom.setText(this.bundle.getString("alert.Buy.Yes.Text") + tienda);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(this.bundle.getString("alert.Buy.Yes.Title"));
        alert.setHeaderText(this.bundle.getString("alert.Buy.Yes.Header"));
        alert.setContentText(this.bundle.getString("alert.Buy.Yes.Content") + tienda);
        alert.showAndWait();
    }

    public void noPurchaseRealized(String tienda) {
        this.labelBottom.setText(this.bundle.getString("alert.Buy.No.Text") + tienda);
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(this.bundle.getString("alert.Buy.No.Title"));
        alert.setHeaderText(this.bundle.getString("alert.Buy.No.Header"));
        alert.setContentText(this.bundle.getString("alert.Buy.No.Content"));
        alert.showAndWait();
    }

    //CAMBIOS DE IDIOMAS
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
