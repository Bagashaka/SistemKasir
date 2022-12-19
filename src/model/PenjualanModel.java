package model;

import static java.nio.file.Files.delete;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uapbo_final.Penjualan;

public class PenjualanModel {
    private final Connection CONN;
    
    public PenjualanModel(){
        this.CONN = dbHelper.getConnection();
    }
    public void addPenjualan(Penjualan pj){
        String insert = "INSERT INTO penjualan VALUES ('"+pj.getNama_produk()+"','"
                + pj.getJumlahProduk() + "', '" +pj.getHarga()+"');"; 
        try {
           if( CONN.createStatement().executeUpdate(insert)>0){
            System.out.println("Data Berhasil Dimasukkan");
            JOptionPane.showMessageDialog(null,"Data Berhasil Dimasukkan","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);  
           }else{
               System.out.println("Data yang dimasukkan sudah ada");
               JOptionPane.showMessageDialog(null,"Data yang dimasukkan sudah ada","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }     
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
            JOptionPane.showMessageDialog(null,"Data Gagal Dimasukkan","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        }
    }
         
     public void deletePenjualan(Penjualan pj){//menghapus data didalam query
        String delete = "DELETE FROM penjualan WHERE nama_produk = '"+ pj.getNama_produk()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }else{
               System.out.println("Data Gagal dihapus");
               JOptionPane.showMessageDialog(null,"Data Gagal dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }     
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
            JOptionPane.showMessageDialog(null,"Data Gagal dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        }           
    }
}
