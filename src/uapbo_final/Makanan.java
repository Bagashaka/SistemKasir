package uapbo_final;

public class Makanan extends Produk {
    private int id;
    private int daya_tahan;
            
   public Makanan(){}
    
   public Makanan(int id){
      this.id = id;
   }
   public Makanan(int id,String nama_produk,double harga, int jumlah,double diskon,int daya_tahan){
        super(nama_produk,harga,jumlah,diskon);
        this.id = id;
        this.daya_tahan = daya_tahan;
   } 
    public boolean isSpoiled(){
        return true;
    } 
    public int getId() {
        return id;
    }
    public int getDaya_tahan() {
        return daya_tahan;
    }  
    public void setId(int id) {
        this.id = id;
    }   
    public void setDaya_tahan(int daya_tahan) {
        this.daya_tahan = daya_tahan;
    }   
}
