package Produk;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author AO756
 */
public class Produk {

    private int id_produk;
    private int jumlah;
    private long harga;
    Scanner Scan = new Scanner(System.in);

    public Produk(int id_produk, int jumlah, long harga) {
        this.id_produk = id_produk;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public Produk() {
        this.id_produk = 0;
        this.jumlah = 0;
        this.harga = 0;
    }

    public int getId_produk() {
        return id_produk;
    }

    public long getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public void printProduk() {
        System.out.println(" - Jumlah: " + this.getJumlah());
        System.out.println(" - Harga : " + this.getHarga());
        System.out.println("");
    }

    public void jualProduk() {
        this.jumlah = this.jumlah - 1;
    }

    public boolean isProdukAvailable() {
        return (this.jumlah > 0);
    }

    public void editProduk() {
        int jumlahBaru;
        long hargaBaru;
        System.out.println(" - Jumlah Lama               : " + this.getJumlah());
        System.out.print(" - Jumlah Baru               : ");
        jumlahBaru = Scan.nextInt();
        this.setJumlah(jumlahBaru);
        System.out.println(" - Harga Lama                : " + this.getHarga());
        System.out.print(" - Harga Baru (contoh: 1000) : ");
        hargaBaru = Scan.nextLong();
        this.setHarga(hargaBaru);
    }
}
