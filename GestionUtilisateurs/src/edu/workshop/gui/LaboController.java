/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.workshop.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LaboController implements Initializable {

    @FXML
    private Label MenuClose;
    @FXML
    private Button btMood;
    @FXML
    private ImageView ImgMood;
    @FXML
    private Button btAllChallenge;
    @FXML
    private Button btchallenge;
    @FXML
    private Button btStatChallenge;
    @FXML
    private Button btAjouterFormation;
    @FXML
    private Button btconsulterFormations;
    @FXML
    private GridPane PnStatChallenge;
    @FXML
    private TableView<?> tabelNbrChallenge;
    @FXML
    private TableColumn<?, ?> ColumnIdStudioT3;
    @FXML
    private TableColumn<?, ?> ColumnIdNbrCT3;
    @FXML
    private Button btHightRecomponse;
    @FXML
    private TableView<?> tabelHightRecompense;
    @FXML
    private TableColumn<?, ?> ColumnNameManger;
    @FXML
    private TableColumn<?, ?> ColumnRecompense3;
    @FXML
    private GridPane PnAllChallenge;
    @FXML
    private TextField chercherMagasin;
    @FXML
    private ComboBox<?> comboCat;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private GridPane pnAfficheFormations;
    @FXML
    private AnchorPane sceneAffichage;
    @FXML
    private TableView<?> tableF;
    @FXML
    private TableColumn<?, ?> tid;
    @FXML
    private TableColumn<?, ?> tnom;
    @FXML
    private TableColumn<?, ?> tduree;
    @FXML
    private TableColumn<?, ?> tprix;
    @FXML
    private TableColumn<?, ?> tIdstudio;
    @FXML
    private TableColumn<?, ?> tdiscp;
    @FXML
    private TextField mnom;
    @FXML
    private TextField mduree;
    @FXML
    private TextField mdisc;
    @FXML
    private Spinner<?> mprix;
    @FXML
    private Button ModifierF;
    @FXML
    private Button SupprimerF;
    @FXML
    private Label labelm;
    @FXML
    private GridPane pnAjouterFormation;
    @FXML
    private TextField fnom;
    @FXML
    private TextField fduree;
    @FXML
    private TextField fdisc;
    @FXML
    private Spinner<?> fprix;
    @FXML
    private Button AjouterF;
    @FXML
    private Label msg;
    @FXML
    private GridPane PnChallenge;
    @FXML
    private TableView<?> TableChallenges;
    @FXML
    private TableColumn<?, ?> Columnduree;
    @FXML
    private TableColumn<?, ?> Columnrecompense;
    @FXML
    private TableColumn<?, ?> Columndescription;
    @FXML
    private TableColumn<?, ?> ColumnIdChallenge;
    @FXML
    private TableColumn<?, ?> ColumnIdStudio;
    @FXML
    private TextField TXTdure;
    @FXML
    private TextField TXTrecmpense;
    @FXML
    private TextField TXTdescrip;
    @FXML
    private Button Ajouterchallenge;
    @FXML
    private Button Updaterchallenge;
    @FXML
    private Button delletedchallenge;
    @FXML
    private Label error_duree;
    @FXML
    private Label error_recompense;
    @FXML
    private Label error_description;
    @FXML
    private TextField TXTimg;
    @FXML
    private Button btImportImg;
    @FXML
    private ImageView lbl_image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ChangeMood(ActionEvent event) {
    }

    @FXML
    private void handleClick(ActionEvent event) {
    }

    @FXML
    private void ShowHightPrixC(ActionEvent event) {
    }

    @FXML
    private void chercherProduitsMag(KeyEvent event) {
    }

    @FXML
    private void clearSelection(MouseEvent event) {
    }

    @FXML
    private void trierCat(ActionEvent event) {
    }

    @FXML
    private void switchToItemInt(MouseEvent event) {
    }

    @FXML
    private void ModifierF(ActionEvent event) {
    }

    @FXML
    private void SupprimerF(ActionEvent event) {
    }

    @FXML
    private void AjouterF(ActionEvent event) {
    }

    @FXML
    private void addChallenge(ActionEvent event) {
    }

    @FXML
    private void updateChallenge(ActionEvent event) {
    }

    @FXML
    private void supprimerChallenge(ActionEvent event) {
    }

    @FXML
    private void Import_Img(ActionEvent event) {
    }

}
