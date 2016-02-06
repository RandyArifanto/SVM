/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produk;

/**
 *
 * @author AO756
 */
public class Minuman extends Produk {

    private String nama_produk;
    private String varian_rasa;

    public Minuman(int id_produk, int jumlah, long harga, String nama_produk, String varian_rasa) {
        super(id_produk, jumlah, harga);
        this.nama_produk = nama_produk;
        this.varian_rasa = varian_rasa;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public String getVarian_rasa() {
        return varian_rasa;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public void setVarian_rasa(String varian_rasa) {
        this.varian_rasa = varian_rasa;
    }

    @Override
    public void editProduk() {
        System.out.println("============================");
        System.out.println("Varian Rasa: " + this.getVarian_rasa());
        super.editProduk();
    }

    @Override
    public void printProduk() {
        System.out.println(this.getVarian_rasa() + ": ");
        super.printProduk();
    }
}
