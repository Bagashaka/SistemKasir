package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button btnKategori;

    @FXML
    private Button btnPenjualan;

    @FXML
    private Button btnProduk;

    @FXML
    private ImageView imageHome;

    @FXML
    void showKategori(ActionEvent event)throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/KategoriOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKategori.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void showPenjualan(ActionEvent event)throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/PenjualanOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnPenjualan.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void showProduk(ActionEvent event)throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller/ProdukOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnProduk.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

}