package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uapbo_final.Makanan;
import uapbo_final.Produk;

public class MakananModel {
    private final Connection CONN;
    
    public MakananModel(){
        this.CONN = dbHelper.getConnection();
    } 
    public void addMakanan(Makanan mkn){
        String insert = "INSERT INTO makanan VALUES ('"+mkn.getId()+"','"+
                                                       mkn.getNama_produk()+"','"+
                                                       mkn.getHarga()+"','"+
                                                       mkn.getJumlah()+"','"+ 
                                                       mkn.getDiskon() + "', '" + 
                                                       mkn.getDaya_tahan()+ "');"; 
        try {
           if( CONN.createStatement().executeUpdate(insert)>0){
            System.out.println("Data Berhasil Dimasukkan");
             JOptionPane.showMessageDialog(null,"Data Gagal dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }else{
               System.out.println("Data yang dimasukkan sudah ada");
               JOptionPane.showMessageDialog(null,"Data yang dimasukkan sudah ada","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }     
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
            JOptionPane.showMessageDialog(null,"Data Gagal Dimasukkan","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
     public void updateProduk(Makanan mkn,Produk prd){
        String update = "UPDATE makanan SET id = '"+mkn.getId()+"', nama_produk = '"+prd.getNama_produk()+
                                        "', harga = '"+prd.getHarga()+"', jumlah = '"+prd.getJumlah()+
                                        "', diskon = '"+prd.getDiskon()+"', daya_tahan = '"+mkn.getDaya_tahan()+
                                        "' WHERE id = '"+mkn.getId()+"';";

        try {
           if( CONN.createStatement().executeUpdate(update)>0){
            System.out.println("Data Berhasil Diperbarui");
            JOptionPane.showMessageDialog(null,"Data Berhasil Diperbarui","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }else{
               System.out.println("Data yang dimasukkan tidak berubah");
               JOptionPane.showMessageDialog(null,"Data yang dimasukkan tidak berubah","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }     
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
            JOptionPane.showMessageDialog(null,"Data Gagal Dimasukkan","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        }
     }
     
     public void deleteProduk(Makanan mkn){
        String delete = "DELETE FROM makanan WHERE id = '"+ mkn.getId()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
             JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }else{
               System.out.println("Data Gagal dihapus");
               JOptionPane.showMessageDialog(null,"Data Gagal dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
           }     
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
            JOptionPane.showMessageDialog(null,"Data Gagal dihapus","Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);      
        }  
    }
}
