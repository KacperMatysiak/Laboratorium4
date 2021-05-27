package pl.lublin.wsei.java.cwiczenia;

import javafx.application.HostServices;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller {
    public Label lbFile;
    public TextField txtAdresStrony;
    public Button btnPrzejdzDoStrony;
    public ImageView imgMiniaturka;
    public Button btnPokazInfografike;
    public ImageView imgView;

    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("Pliki XML (*.xml", "*.xml");
    private infografika selInfografika;

    private Stage stage;
    private HostServices hostServices;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    public ListView IstInfografiki;
    ObservableList<String> tytuly = FXCollections.observableArrayList();
    GusInfoGraphicList igList;

    @FXML
    public void initialize() {
        fileChooser.getExtensionFilters().add(xmlFilter);
        IstInfografiki.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number old_val, Number new_val) {
                        int index = new_val.intValue();
                        if (index != -1) {
                            selInfografika = igList.infografiki.get(index);
                            txtAdresStrony.setText(igList.infografiki.get(index).adresStrony);
                            Image image = new Image(igList.infografiki.get(index).adresMiniaturki);
                            imgMiniaturka.setImage(image);
                        } else {
                            txtAdresStrony.setText("");
                            imgMiniaturka.setImage(null);
                            selInfografika = null;
                        }
                    }
                }
        );

    }
    public void btnOpenFileAction(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            igList = new GusInfoGraphicList(file.getAbsolutePath());
            lbFile.setText(file.getAbsolutePath());
            for (infografika ig: igList.infografiki) tytuly.add(ig.tytul);
            IstInfografiki.setItems(tytuly);
        }else{
            lbFile.setText("Proszę wczytać plik ...");
        }
    }

    public void btnZaladujStrone(ActionEvent actionEvent) {
        if (selInfografika != null)
            hostServices.showDocument(selInfografika.adresStrony);
    }
    public void btnPokazInfografike(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("imgViewer.fxml"));
            Parent root = loader.load();
            ImgViewer viewer = loader.getController();
            if (selInfografika != null) {
                Image img = new Image(selInfografika.adresGrafiki);
                viewer.imgView.setFitWidth(img.getWidth());
                viewer.imgView.setFitHeight(img.getHeight());
                viewer.imgView.setImage(img);
            }
            Stage stage = new Stage();
            stage.setTitle("Podgląd infografiki");
            stage.setScene(new Scene(root, 900, 800));
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public class ImgViewer {
        public ImageView imgView;
        public void btnPokazInfografike(ActionEvent actionEvent) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("imgViewer.fxml"));
                Parent root = loader.load();
                ImgViewer viewer = loader.getController();
                if (selInfografika != null) {
                    Image img = new Image(selInfografika.adresGrafiki);
                    viewer.imgView.setFitWidth(img.getWidth());
                    viewer.imgView.setFitHeight(img.getHeight());
                    viewer.imgView.setImage(img);
                }
                Stage stage = new Stage();
                stage.setTitle("Podgląd infografiki");
                stage.setScene(new Scene(root, 900, 800));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}