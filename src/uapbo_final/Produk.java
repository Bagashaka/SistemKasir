package uapbo_final;

public class Produk {
    private String nama_produk;
    private double harga;
    private double diskon;
    private int jumlah;
    
    public Produk(){}
    
    public Produk(String nama_produk){
        this.nama_produk = nama_produk;
    }      
    public Produk(String nama_produk,double harga){
        this.nama_produk = nama_produk;
        this.harga = harga;
    }       
    public Produk(String nama_produk,double harga, int jumlah){
        this.nama_produk = nama_produk;
        this.harga = harga;
        this.jumlah = jumlah;
    } 
    public Produk(String nama_produk,double harga, int jumlah,double diskon){
        this.nama_produk = nama_produk;
        this.harga = harga;
        this.jumlah = jumlah;
        this.diskon = diskon;
    } 
    private double hargaDiskon(){
        return harga - (harga*diskon);
    } 
    public String getNama_produk() {
        return nama_produk;
    }
    public double getHarga() {
        return harga;
    }
    public int getJumlah() {
        return jumlah;
    }
    public double getDiskon() {
        return diskon;
    }
    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }
}
