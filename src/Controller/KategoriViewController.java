/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.BarangModel;
import static model.dbHelper.getConnection;
import uapbo_final.Barang;
import uapbo_final.Kategori;


public class KategoriViewController implements Initializable {
    BarangModel brg = new BarangModel();
    
    @FXML
    private TableColumn<Barang, String> cKategori;
    
    @FXML
    private TableColumn<Barang, String> cNama;
    
    @FXML
    private ComboBox<String> cmKategori;
    
    @FXML
    private TableView<Barang> tbKategori;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBaranginKategori();
        ObservableList<String> InputKategori = FXCollections.observableArrayList("Tambah","Hapus","Lihat Daftar","Kembali");
        cmKategori.setItems(InputKategori);

        cmKategori.setOnAction(event ->{
            String selected = cmKategori.getSelectionModel().getSelectedItem();
            
            if (selected.equals("Tambah")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/KategoriInput.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmKategori.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (selected.equals("Hapus")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/KategoriDelete.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmKategori.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (selected.equals("Lihat Daftar")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/KategoriView.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmKategori.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (selected.equals("Kembali")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/home.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmKategori.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        
    }    
    
    @FXML
    void pilihKategori(ActionEvent event) {
         cmKategori.getSelectionModel().getSelectedItem().toString();
    }
    
     public ObservableList<Barang> getBarangList(){
       
       ObservableList<Barang> barangList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT nama_produk,kategori FROM barang ,kategori WHERE barang.kategori = kategori.nama_kategori ;";
       Statement st;
       ResultSet rs; 
       
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Barang barang;
           while(rs.next()){
              barang = new Barang(rs.getString("nama_produk"),rs.getString("kategori"));
               barangList.add(barang);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return barangList;
   }
     
    
     public void showBaranginKategori(){
       ObservableList<Barang> list = getBarangList();
       cNama.setCellValueFactory(new PropertyValueFactory<Barang,String>("nama_produk"));
       cKategori.setCellValueFactory(new PropertyValueFactory<Barang,String>("kategori"));
       
       tbKategori.setItems(list);
       
   }
    
}
