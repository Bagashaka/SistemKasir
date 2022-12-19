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
import model.PenjualanModel;
import static model.dbHelper.getConnection;
import uapbo_final.Penjualan;
import uapbo_final.Produk;

public class PenjualanDeleteController implements Initializable {
    PenjualanModel pj = new PenjualanModel();
    @FXML
    private TableColumn<Produk, Double> cHarga;

    @FXML
    private TableColumn<Produk, String> cNama;
    
    @FXML
    private TableView<Produk> tbDataPenjualan;
    
    @FXML
    private TableColumn<Penjualan, Integer> cJumPro;

    @FXML
    private TableColumn<Penjualan, String> cNamPem;
    
    @FXML
    private TableColumn<Penjualan, Double> cTotHar;
    
    @FXML
    private TableView<Penjualan> tbPembelian;
    
    @FXML
    private TextField flNamPro;
    
    @FXML
    private ComboBox<String> cmDataPenjualan;
    

    
    @FXML
    void pilihPenjualan(ActionEvent event) {
         cmDataPenjualan.getSelectionModel().getSelectedItem().toString();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPenjualan();
        showPembelian();
        ObservableList<String> InputPenjualan = FXCollections.observableArrayList("Tambah","Hapus","Kembali");
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
            }else if (selected.equals("Hapus")) {
                try {
                    Penjualan peju = new Penjualan(flNamPro.getText());
                    pj.deletePenjualan(peju);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/PenjualanDelete.fxml"));
                    Parent root = (Parent) loader.load();
                    Stage stage = (Stage) cmDataPenjualan.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (selected.equals("Kembali")) {
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
    
   public ObservableList<Penjualan> getPembelianList(){
       ObservableList<Penjualan> pembelianList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT * FROM penjualan;";
       Statement st;
       ResultSet rs; 
       
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Penjualan peju;
           while(rs.next()){
              peju = new Penjualan(rs.getString("nama_produk"),rs.getInt("jumlahProduk"),rs.getDouble("harga"));
               pembelianList.add(peju);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return pembelianList;
   }
   
    public void showPembelian(){
       ObservableList<Penjualan> list = getPembelianList();
       cNamPem.setCellValueFactory(new PropertyValueFactory<Penjualan,String>("nama_produk"));    
       cJumPro.setCellValueFactory(new PropertyValueFactory<Penjualan,Integer>("jumlahProduk"));
       cTotHar.setCellValueFactory(new PropertyValueFactory<Penjualan,Double>("harga"));
       tbPembelian.setItems(list);
   }
}
