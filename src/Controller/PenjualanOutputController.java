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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static model.dbHelper.getConnection;
import uapbo_final.Produk;

public class PenjualanOutputController implements Initializable {
    @FXML
    private TableColumn<Produk, Double> cHarga;

    @FXML
    private TableColumn<Produk, String> cNama;
    
    @FXML
    private TableView<Produk> tbDataPenjualan;
    
    @FXML
    private ComboBox<String> cmDataPenjualan;
    
    @FXML
    void pilihPenjualan(ActionEvent event) {
         cmDataPenjualan.getSelectionModel().getSelectedItem().toString();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPenjualan();
        ObservableList<String> InputPenjualan = FXCollections.observableArrayList("Tambah","Kembali");
        cmDataPenjualan.setItems(InputPenjualan);

        cmDataPenjualan.setOnAction(event ->{
            String selected = cmDataPenjualan.getSelectionModel().getSelectedItem();
            
            if (selected.equals("Tambah")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/PenjualanAdd.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmDataPenjualan.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (selected.equals("Kembali")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/home.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmDataPenjualan.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }  
   
   public ObservableList<Produk> getPenjualanList(){
       ObservableList<Produk> penjualanList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT nama_produk , harga FROM barang UNION SELECT nama_produk, harga FROM makanan;";
       Statement st;
       ResultSet rs; 
       
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Produk pr;
           while(rs.next()){
              pr = new Produk(rs.getString("nama_produk"),rs.getDouble("harga"));
               penjualanList.add(pr);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return penjualanList;
   }
   
    public void showPenjualan(){
       ObservableList<Produk> list = getPenjualanList();
       cNama.setCellValueFactory(new PropertyValueFactory<Produk,String>("nama_produk"));
       cHarga.setCellValueFactory(new PropertyValueFactory<Produk,Double>("harga"));
     
       tbDataPenjualan.setItems(list);
   }
    
}
