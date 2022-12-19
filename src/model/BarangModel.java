package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uapbo_final.Barang;
import javax.swing.JOptionPane;
import uapbo_final.Kategori;

public class BarangModel {
    private final Connection CONN;
    
    public BarangModel(){
        this.CONN = dbHelper.getConnection();
    }
    public void addBarang(Barang brg){
        String insert = "INSERT INTO barang VALUES ('"+brg.getBarcode()+"','"+brg.getNama_produk()+
                                                    "','"+brg.getHarga()+"','"+brg.getJumlah()+
                                                    "','"+brg.getDiskon()+"','"+brg.getExpired()+"','"+brg.getKategori()+"');";
        try {
           if( CONN.createStatement().executeUpdate(insert)>0){
            System.out.println("Data Berhasil Dimasukkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
           }else{
               System.out.println("Data yang dimasukkan sudah ada");
               JOptionPane.showMessageDialog(null,"Data yang dimasukkan sudah ada","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
            JOptionPane.showMessageDialog(null, "Data Gagal Dimasukkan","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        }
    }    
     public void deleteProduk(Barang brg){//menghapus data didalam query
        String delete = "DELETE FROM barang WHERE barcode = '"+ brg.getBarcode()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }else{
               System.out.println("Data Gagal dihapus");
               JOptionPane.showMessageDialog(null, "Data Gagal dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
            JOptionPane.showMessageDialog(null, "Data Gagal dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        }  
    }
     
    public void selectProduk(Kategori ktg){
        String select = "SELECT FROM barang WHERE barcode = '"+ ktg.getNama_kategori()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(select)>0){
            System.out.println("Data Berhasil Ditampilkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditampilkan","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }else{
               System.out.println("Data Gagal ditampilkan");
               JOptionPane.showMessageDialog(null,"Data Gagal ditampilkan","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal ditampilkan");
            JOptionPane.showMessageDialog(null,"Data Gagal ditampilkan","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        } 
    }     
    
    public void deleteKategori(Barang brg){//menghapus data didalam query
        String delete = "DELETE FROM barang WHERE kategori = '"+ brg.getKategori()+"';";
        
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
