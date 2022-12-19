package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProdukOutputController {
    
    @FXML
    private ImageView ProdukImg;

    @FXML
    private Button btnBarang;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnMakanan;

    @FXML
    void kembali(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/home.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void viewBarang(ActionEvent event)throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/BarangOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnMakanan.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void viewMakanan(ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/MakananOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnMakanan.getScene().getWindow();
       stage.setScene(new Scene(root));
    }
    
}
