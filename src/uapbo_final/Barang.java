package uapbo_final;

import java.util.ArrayList;

public class Barang extends Produk {
    private String barcode;
    private String expired;
    private String kategori;
    private ArrayList<Kategori> kateori = new ArrayList<>();
    
    public Barang(){}
    
    public Barang(String barcode){
        this.barcode = barcode;
    }
    
    public Barang(String nama_produk,String kategori){
        super(nama_produk);
        this.kategori = kategori;
    }
    
    public Barang(String barcode,String nama_produk,double harga, int jumlah,double diskon,String expired, String kategori){
        super(nama_produk,harga,jumlah,diskon);
        this.barcode = barcode;
        this.expired = expired;
        this.kategori = kategori;        
    }
    
    
    
    public boolean isExpired(){
        return true;
    }   
    public ArrayList<Kategori> addKateori(){
       return kateori;
    } 
    public void printKategori(){
        
    }
    
    public String getBarcode() {
        return barcode;
    }
    public String getExpired() {
        return expired;
    }
    public ArrayList<Kategori> getKateori() {
        return kateori;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }   
    public void setExpired(String expired) {
        this.expired = expired;
    }
    public void setKateori(ArrayList<Kategori> kateori) {
        this.kateori = kateori;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
