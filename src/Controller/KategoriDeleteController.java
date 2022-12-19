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
import model.KategoriModel;
import static model.dbHelper.getConnection;
import uapbo_final.Kategori;

public class KategoriDeleteController implements Initializable {
    KategoriModel ktg = new KategoriModel();
    
    @FXML
    private TextField flDelKategori;
    
    @FXML
    private TableColumn<Kategori, String> cKategori;

    @FXML
    private ComboBox<String> cmKategori;

    @FXML
    private TableView<Kategori> tbKategori;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showKategori();
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
                    Kategori ktg1 = new Kategori(flDelKategori.getText());
                    ktg.deleteKategori(ktg1);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/KategoriOutput.fxml"));
                    Parent root = (Parent) loader.load();
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
    
    
    
    public ObservableList<Kategori> getKategoriList(){  
       ObservableList<Kategori> kategoriList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT * FROM kategori;";
       Statement st;
       ResultSet rs; 
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Kategori kategori;
           while(rs.next()){
              kategori = new Kategori(rs.getString("nama_kategori"));
               kategoriList.add(kategori);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return kategoriList;
    }
     
     public void showKategori(){
       ObservableList<Kategori> list = getKategoriList();
       cKategori.setCellValueFactory(new PropertyValueFactory<Kategori,String>("nama_kategori"));
       tbKategori.setItems(list);     
   }  
}
