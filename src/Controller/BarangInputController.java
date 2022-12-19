/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.BarangModel;
import uapbo_final.Barang;

public class BarangInputController implements Initializable{
    BarangModel brg = new BarangModel();

    @FXML
    private TextField flBar;

    @FXML
    private TextField flDiskon;

    @FXML
    private TextField flExpired;

    @FXML
    private TextField flHarga;

    @FXML
    private TextField flJumlah;

    @FXML
    private TextField flKategori;

    @FXML
    private TextField flNama;
    
    @FXML
    private ComboBox<String> cmBarang;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> Inputbarang = FXCollections.observableArrayList("Tambah", "Hapus","Kembali");
        cmBarang.setItems(Inputbarang);

        cmBarang.setOnAction(event ->{
            String selected = cmBarang.getSelectionModel().getSelectedItem();
            
            if (selected.equals("Tambah")) {
                try {
                    Barang brg1 = new Barang(flBar.getText(),flNama.getText(),Double.parseDouble(flHarga.getText()),Integer.parseInt(flJumlah.getText()),Double.parseDouble(flDiskon.getText()),flExpired.getText(),flKategori.getText());
                    brg.addBarang(brg1);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/BarangOutput.fxml"));
                    Parent root = (Parent) loader.load();
                    Stage stage = (Stage) cmBarang.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (selected.equals("Hapus")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/BarangDelete.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmBarang.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (selected.equals("Kembali")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/BarangOutput.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmBarang.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    

    @FXML
    void pilihBarang(ActionEvent event) {
        cmBarang.getSelectionModel().getSelectedItem().toString();
    }
}
