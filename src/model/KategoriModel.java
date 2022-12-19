package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uapbo_final.Kategori;

public class KategoriModel {
     private final Connection CONN;
    
    public KategoriModel(){
        this.CONN = dbHelper.getConnection();
    }
    
    public void addKategori(Kategori ktg){
        String insert = "INSERT INTO kategori VALUES ('"+ktg.getNama_kategori()+"');"; 
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
    
    public void deleteKategori(Kategori ktg){
        String delete = "DELETE FROM kategori WHERE nama_kategori = '"+ ktg.getNama_kategori()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
             JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }else{
               System.out.println("Data Gagal dihapus");
               JOptionPane.showMessageDialog(null,"Data Gagal dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
             JOptionPane.showMessageDialog(null,"Data Gagal dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        }  
    }
}
