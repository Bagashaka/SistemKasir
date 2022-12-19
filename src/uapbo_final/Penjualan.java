package uapbo_final;

import java.util.ArrayList;

public class Penjualan extends Produk implements ProductCounter{
    private ArrayList<Produk> listProduk = new ArrayList<>();
    private int jumlahProduk;
    private int stok;
    
    public Penjualan(){}
    
    public Penjualan(String nama_produk){
        super(nama_produk);
    }
    
    public Penjualan(int jumlahProduk, int stok){
    this.jumlahProduk = jumlahProduk;
    this.stok = stok;
    }
    
    public Penjualan(String nama_produk,int jumlahProduk,double harga) {
        super(nama_produk, harga);
        this.jumlahProduk = jumlahProduk;
    }

    public Penjualan(String nama_produk,int jumlahProduk, int stok ,double harga) {
        super(nama_produk, harga);
        this.jumlahProduk = jumlahProduk;
        this.stok = stok;
    }
    
    public ArrayList<Produk> getProduk(){
        return listProduk;
    }

    @Override
    public int hitungJumlahProduk(){
        return jumlahProduk;
    }

    @Override
    public int hitungHargaProduk(){
        return (int) (jumlahProduk * getListProduk().get(0).getHarga());
    }
       
    public ArrayList<Produk> getListProduk() {
        return listProduk;
    }
    public int getJumlahProduk() {
        return jumlahProduk;
    }
    public int getStok() {
        return stok;
    }

    public void setJumlahProduk(int JumlahProduk) {
        this.jumlahProduk = JumlahProduk;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }
    public void setListProduk(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }
}
