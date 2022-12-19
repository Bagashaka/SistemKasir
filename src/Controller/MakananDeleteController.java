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
import model.MakananModel;
import static model.dbHelper.getConnection;
import uapbo_final.Makanan;

public class MakananDeleteController implements Initializable {
    MakananModel mkn = new MakananModel();
    @FXML
    private TableColumn<Makanan, Integer> CdayaTahan;

    @FXML
    private TableColumn<Makanan, Double> Cdiskon;

    @FXML
    private TableColumn<Makanan, Double> Charga;

    @FXML
    private TableColumn<Makanan, Integer> Cid;

    @FXML
    private TableColumn<Makanan, Integer> Cjumlah;

    @FXML
    private TableColumn<Makanan, String> Cnama;

    @FXML
    private TableView<Makanan> TBmakanan;
    
    @FXML
    private TextField flId;
    
     @FXML
    private ComboBox<String> cmMakanan;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showMakanan();
        ObservableList<String> InputMakanan = FXCollections.observableArrayList("Tambah", "Hapus","Kembali");
        cmMakanan.setItems(InputMakanan);

        cmMakanan.setOnAction(event ->{
            String selected = cmMakanan.getSelectionModel().getSelectedItem();
            
            if (selected.equals("Tambah")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/MakananInput.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) cmMakanan.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (selected.equals("Hapus")) {
                try {
                    Makanan mkn2 = new Makanan();
                    mkn2.setId(Integer.parseInt(flId.getText()));
                    mkn.deleteProduk(mkn2);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/MakananOutput.fxml"));
                    Parent root = (Parent) loader.load();
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
    
    public ObservableList<Makanan> getMakananList(){
       ObservableList<Makanan> makananList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT * FROM makanan;";
       Statement st;
       ResultSet rs; 
       
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Makanan makanan;
           while(rs.next()){
               makanan = new Makanan(rs.getInt("id"),rs.getString("nama_produk"),rs.getDouble("harga"),rs.getInt("jumlah"),rs.getDouble("diskon"),rs.getInt("daya_tahan"));
               makananList.add(makanan);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return makananList;
   }
    
   public void showMakanan(){
       ObservableList<Makanan> list = getMakananList();
       Cid.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("id"));
       Cnama.setCellValueFactory(new PropertyValueFactory<Makanan,String>("nama_produk"));
       Charga.setCellValueFactory(new PropertyValueFactory<Makanan,Double>("harga"));
       Cjumlah.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("jumlah"));
       Cdiskon.setCellValueFactory(new PropertyValueFactory<Makanan,Double>("diskon"));
       CdayaTahan.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("daya_tahan"));
       
       TBmakanan.setItems(list);
   }
    
}

