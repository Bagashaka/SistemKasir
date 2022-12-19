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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.BarangModel;
import static model.dbHelper.getConnection;
import uapbo_final.Barang;

public class BarangDeleteController implements Initializable {
    BarangModel brg = new BarangModel();
    @FXML
    private TableColumn<Barang, String> Cbarcode;

    @FXML
    private TableColumn<Barang, Double> Cdiskon;

    @FXML
    private TableColumn<Barang, String> Cexpired;

    @FXML
    private TableColumn<Barang, Double> Charga;

    @FXML
    private TableColumn<Barang, Integer> Cjumlah;

    @FXML
    private TableColumn<Barang, String> Ckategori;

    @FXML
    private TableColumn<Barang, String> Cnama;
    
    @FXML
    private TextField flBarcode;

    @FXML
    private TableView<Barang> TBbarang;

    @FXML
    private ComboBox<String> cmBarang;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showBarang();
        ObservableList<String> Inputbarang = FXCollections.observableArrayList("Tambah", "Hapus","Kembali");
        cmBarang.setItems(Inputbarang);

        cmBarang.setOnAction(event ->{
            String selected = cmBarang.getSelectionModel().getSelectedItem();
            
            if (selected.equals("Tambah")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/BarangInput.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmBarang.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (selected.equals("Hapus")) {
                try {
                    Barang brg2 = new Barang(flBarcode.getText());
                    brg.deleteProduk(brg2);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/BarangOutput.fxml"));
                    Parent root = (Parent) loader.load();
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
    
    public ObservableList<Barang> getBarangList(){
       ObservableList<Barang> barangList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT * FROM barang;";
       Statement st;
       ResultSet rs; 
       
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Barang barang;
           while(rs.next()){
              barang = new Barang(rs.getString("barcode"),rs.getString("nama_produk"),rs.getDouble("harga"),rs.getInt("jumlah"),rs.getDouble("diskon"),rs.getString("expired"),rs.getString("kategori"));
               barangList.add(barang);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return barangList;
   }
   
    public void showBarang(){
       ObservableList<Barang> list = getBarangList();
       Cbarcode.setCellValueFactory(new PropertyValueFactory<Barang,String>("barcode"));
       Cnama.setCellValueFactory(new PropertyValueFactory<Barang,String>("nama_produk"));
       Charga.setCellValueFactory(new PropertyValueFactory<Barang,Double>("harga"));
       Cjumlah.setCellValueFactory(new PropertyValueFactory<Barang,Integer>("jumlah"));
       Cdiskon.setCellValueFactory(new PropertyValueFactory<Barang,Double>("diskon"));
       Cexpired.setCellValueFactory(new PropertyValueFactory<Barang,String>("expired"));
       Ckategori.setCellValueFactory(new PropertyValueFactory<Barang,String>("kategori"));
       
       TBbarang.setItems(list);
   }
    
}
