package uapbo_final;

public class Kategori {
    private Produk produk  = new Produk();
    private String nama_kategori;
    
    public Kategori(){}
    
    public Kategori(String nama_kategori){
        this.nama_kategori = nama_kategori;
    } 
    
    public Produk getProduk(){
        return produk;
    }   
    public String getNama_kategori() {
        return nama_kategori;
    }
    
    public void setProduk(Produk produk) {
        this.produk = produk;
    }
    
    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }    
    
}
