package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MakananModel;
import uapbo_final.Makanan;

public class MakananInputController implements Initializable {
    MakananModel mkn = new MakananModel();
    
    @FXML
    private TextField flDayatahan;

    @FXML
    private TextField flDiskon;

    @FXML
    private TextField flHarga;

    @FXML
    private TextField flId;

    @FXML
    private TextField flJumlah;

    @FXML
    private TextField flNama;

    @FXML
    private ComboBox<String> cmMakanan;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String> InputMakanan = FXCollections.observableArrayList("Tambah", "Hapus","Kembali");
        cmMakanan.setItems(InputMakanan);

        cmMakanan.setOnAction(event ->{
            String selected = cmMakanan.getSelectionModel().getSelectedItem();
            
            if (selected.equals("Tambah")) {
                try {
                    Makanan mkn1 = new Makanan(Integer.parseInt(flId.getText()),flNama.getText(),Double.parseDouble(flHarga.getText()),Integer.parseInt(flJumlah.getText()), Double.parseDouble(flDiskon.getText()), Integer.parseInt(flDayatahan.getText()));
                    mkn.addMakanan(mkn1);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/MakananOutput.fxml"));
                    Parent root = (Parent) loader.load();
                    Stage stage = (Stage) cmMakanan.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (selected.equals("Hapus")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/MakananDelete.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmMakanan.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (selected.equals("Kembali")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/MakananOutput.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmMakanan.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    } 
    
    
    @FXML
    void pilihMakanan(ActionEvent event) {
        cmMakanan.getSelectionModel().getSelectedItem().toString();
    }
    
}
