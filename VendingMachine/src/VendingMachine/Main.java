package VendingMachine;

import Uang.KoinKembalian;
import Uang.KoinPembeli;
import Produk.Minuman;
import Produk.MakananKecil;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AO756
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KoinKembalian koinKembalian = new KoinKembalian();
        Minuman[] data_minuman;
        MakananKecil[] data_makanan;
        data_minuman = new Minuman[9];
        data_makanan = new MakananKecil[4];
        for (int j = 0; j < data_minuman.length; j++) {
            data_minuman[j] = new Minuman(j + 1, 10, 0, "Kopi", "Kopi");
        }
        for (int j = 0; j < 2; j++) {
            data_makanan[j] = new MakananKecil(j + 1, 10, 0, "Taro", "Makanan Kecil", "Taro");
        }
        for (int j = 2; j < 4; j++) {
            data_makanan[j] = new MakananKecil(j + 1, 10, 0, "Chitato", "Makanan Kecil", "Chitato");
        }
        data_minuman[0].setVarian_rasa("House Blend Reguler.");
        data_minuman[0].setHarga(2000);
        data_minuman[1].setVarian_rasa("House Blend Decaf.");
        data_minuman[1].setHarga(2500);
        data_minuman[2].setVarian_rasa("Flavored Coffe.");
        data_minuman[2].setHarga(3000);
        data_minuman[3].setVarian_rasa("Café Latte.");
        data_minuman[3].setHarga(3000);
        data_minuman[4].setVarian_rasa("Café Americano.");
        data_minuman[4].setHarga(4500);
        data_minuman[5].setVarian_rasa("Cappuccino.");
        data_minuman[5].setHarga(4500);
        data_minuman[6].setVarian_rasa("Café Mocha.");
        data_minuman[6].setHarga(4500);
        data_minuman[7].setVarian_rasa("White Chocolate Mocha.");
        data_minuman[7].setHarga(5000);
        data_minuman[8].setVarian_rasa("Caramel Macchiato.");
        data_minuman[8].setHarga(5000);
        data_makanan[0].setVarian_rasa("Seaweed.");
        data_makanan[0].setHarga(3000);
        data_makanan[1].setVarian_rasa("Potato BBq.");
        data_makanan[1].setHarga(3500);
        data_makanan[2].setVarian_rasa("Sapi Panggang.");
        data_makanan[2].setHarga(3000);
        data_makanan[3].setVarian_rasa("Keju Supreme.");
        data_makanan[3].setHarga(3500);
        String perintah;
        Scanner Scan = new Scanner(System.in);
        do {
            System.out.println("==========================================================");
            System.out.println("Menu Utama Vending Machine.");
            System.out.println("Pilih hak Akses Anda:");
            System.out.println("1. Pembeli\n2. Admin.");
            System.out.print("Pilihan: ");
            perintah = Scan.next();
            switch (perintah) {
                case "1":
                    String objekPembeli;
                    int pilihanPembeli;
                    System.out.println("==========================================================");
                    System.out.println("Input Koin");
                    System.out.println("Selain koin dengan pecahan: ");
                    System.out.println("- 1000\n- 500\n- 200\n- 100");
                    System.out.println("Atau koin dengan kelipatan pecahan diatas tidak diterima.");
                    System.out.print("Input Koin: ");
                    objekPembeli = Scan.next();
                    KoinPembeli koinPembeli = new KoinPembeli(objekPembeli);
                    if (!koinPembeli.isValidKoin()) {
                        System.out.println("==========================================================");
                        System.out.println("Koin Tidak Valid.");
                        System.out.println("Anda Mendapat Objek: " + objekPembeli);
                    } else {
                        koinPembeli.setKoinPembeli();
                        System.out.println("==========================================================");
                        System.out.println("Pilih Produk (Koin Anda: " + koinPembeli.getJumlah() + "): ");
                        System.out.println("");
                        for (int i = 0; i < data_minuman.length; i++) {
                            System.out.print(i + 1 + ". ");
                            data_minuman[i].printProduk();
                        }
                        for (int i = 0; i < data_makanan.length; i++) {
                            System.out.print(i + data_minuman.length + ". ");
                            data_makanan[i].printProduk();
                        }
                        System.out.print("Pilihan Produk: ");
                        pilihanPembeli = Scan.nextInt();
                        if (pilihanPembeli >= 1 && pilihanPembeli <= data_minuman.length) {
                            if (data_minuman[pilihanPembeli - 1].isProdukAvailable()) {
                                if (koinPembeli.isKoinCukup(data_minuman[pilihanPembeli - 1].getHarga())) {
                                    koinKembalian.tambahKoinKembalian(koinPembeli.getJumlah());
                                    if (koinPembeli.isKembalian(data_minuman[pilihanPembeli - 1].getHarga())) {
                                        if (koinKembalian.isKembalianCukup(koinPembeli.jumlahKembalian(data_minuman[pilihanPembeli - 1].getHarga()))) {
                                            data_minuman[pilihanPembeli - 1].jualProduk();
                                            koinKembalian.keluarKembalian(koinPembeli.jumlahKembalian(data_minuman[pilihanPembeli - 1].getHarga()));
                                            koinPembeli.keluarKembalian(data_minuman[pilihanPembeli - 1].getHarga());
                                            System.out.println("==========================================================");
                                            System.out.println("Pembelian Berhasil.");
                                            System.out.println("Anda Mendapat Produk: " + data_minuman[pilihanPembeli - 1].getVarian_rasa());
                                            koinPembeli.printKoin();
                                        } else {
                                            System.out.println("==========================================================");
                                            System.out.println("Maaf Kembalian Tidak Cukup.");
                                            System.out.println("Anda Mendapat Koin: " + koinPembeli.getJumlah());
                                        }
                                    } else {
                                        data_minuman[pilihanPembeli - 1].jualProduk();
                                        System.out.println("==========================================================");
                                        System.out.println("Pembelian Berhasil.");
                                        System.out.println("Anda Mendapat Produk: " + data_minuman[pilihanPembeli - 1].getVarian_rasa());
                                    }
                                } else {
                                    System.out.println("==========================================================");
                                    System.out.println("Koin Tidak Cukup.");
                                    System.out.println("Anda Mendapat Koin: " + koinPembeli.getJumlah());
                                }
                            } else {
                                System.out.println("==========================================================");
                                System.out.println("Produk Kosong.");
                                System.out.println("Anda Mendapat Koin: " + koinPembeli.getJumlah());
                            }
                        } else {
                            pilihanPembeli = pilihanPembeli - (data_minuman.length - 1);
                            if (data_makanan[pilihanPembeli - 1].isProdukAvailable()) {
                                if (koinPembeli.isKoinCukup(data_makanan[pilihanPembeli - 1].getHarga())) {
                                    koinKembalian.tambahKoinKembalian(koinPembeli.getJumlah());
                                    if (koinPembeli.isKembalian(data_makanan[pilihanPembeli - 1].getHarga())) {
                                        if (koinKembalian.isKembalianCukup(koinPembeli.jumlahKembalian(data_makanan[pilihanPembeli - 1].getHarga()))) {
                                            data_makanan[pilihanPembeli - 1].jualProduk();
                                            koinKembalian.keluarKembalian(koinPembeli.jumlahKembalian(data_makanan[pilihanPembeli - 1].getHarga()));
                                            koinPembeli.keluarKembalian(data_makanan[pilihanPembeli - 1].getHarga());
                                            System.out.println("==========================================================");
                                            System.out.println("Pembelian Berhasil.");
                                            System.out.println("Anda Mendapat Produk: " + data_makanan[pilihanPembeli - 1].getVarian_rasa());
                                            koinPembeli.printKoin();
                                        } else {
                                            System.out.println("==========================================================");
                                            System.out.println("Maaf Kembalian Tidak Cukup.");
                                            System.out.println("Anda Mendapat Koin: " + koinPembeli.getJumlah());
                                        }
                                    } else {
                                        data_makanan[pilihanPembeli - 1].jualProduk();
                                        System.out.println("==========================================================");
                                        System.out.println("Pembelian Berhasil.");
                                        System.out.println("Anda Mendapat Produk: " + data_makanan[pilihanPembeli - 1].getVarian_rasa());
                                    }
                                } else {
                                    System.out.println("==========================================================");
                                    System.out.println("Koin Tidak Cukup.");
                                    System.out.println("Anda Mendapat Koin: " + koinPembeli.getJumlah());
                                }
                            } else {
                                System.out.println("==========================================================");
                                System.out.println("Produk Kosong.");
                                System.out.println("Anda Mendapat Koin: " + koinPembeli.getJumlah());
                            }
                        }
                    }
                    break;
                case "2":
                    Admin admin = new Admin();
                    String perintahAdmin;
                    String usernameAdmin;
                    String passwordAdmin;
                    System.out.println("============================");
                    System.out.print("Username: ");
                    usernameAdmin = Scan.next();
                    System.out.print("Password: ");
                    passwordAdmin = Scan.next();
                    if (admin.cekLogin(usernameAdmin, passwordAdmin)) {
                        do {
                            System.out.println("============================");
                            System.out.println("Selamat Datang Admin!");
                            System.out.println("Pilih Menu:");
                            System.out.println("0. Logout.\n1. Daftar Produk\n2. Koin Kembalian.");
                            System.out.print("Pilihan: ");
                            perintahAdmin = Scan.next();
                            switch (perintahAdmin) {
                                case "1":
                                    int pilihanMenuDaftar;
                                    int pilihanProduk;
                                    System.out.println("============================");
                                    System.out.println("Daftar Produk: ");
                                    System.out.println("");
                                    for (int i = 0; i < data_minuman.length; i++) {
                                        System.out.print(i + 1 + ". ");
                                        data_minuman[i].printProduk();
                                    }
                                    for (int i = 0; i < data_makanan.length; i++) {
                                        System.out.print(i + data_minuman.length + ". ");
                                        data_makanan[i].printProduk();
                                    }
                                    do {
                                        System.out.println("============================");
                                        System.out.println("Menu Produk: ");
                                        System.out.println("0. Kembali ke Menu Admin.\n1. Edit Produk.");
                                        System.out.print("Pilihan: ");
                                        pilihanMenuDaftar = Scan.nextInt();
                                        if (pilihanMenuDaftar == 1) {
                                            do {
                                                System.out.println("============================");
                                                System.out.print("Nomor Produk: ");
                                                pilihanProduk = Scan.nextInt();
                                                if (pilihanProduk >= data_minuman.length + data_makanan.length || pilihanProduk <= 0) {
                                                    System.out.println("============================");
                                                    System.out.println("Tidak ada Produk dengan Nomor " + pilihanProduk);
                                                } else {
                                                    if (pilihanProduk >= 1 && pilihanProduk <= data_minuman.length) {
                                                        data_minuman[pilihanProduk - 1].editProduk();
                                                        pilihanMenuDaftar = 0;
                                                    } else {
                                                        pilihanProduk = pilihanProduk - (data_minuman.length - 1);
                                                        data_makanan[pilihanProduk - 1].editProduk();
                                                        pilihanMenuDaftar = 0;
                                                    }
                                                }
                                            } while (pilihanProduk > 9 || pilihanProduk < 1);
                                        } else if (pilihanMenuDaftar != 1 && pilihanMenuDaftar != 0) {
                                            System.out.println("============================");
                                            System.out.println("Input Salah!");
                                        }
                                    } while (pilihanMenuDaftar != 0);
//                                System.out.println(data_produk[0].getHarga());
                                    break;
                                case "2":
                                    int pilihanMenuKembalian;
                                    System.out.println("============================");
                                    System.out.println("Daftar Koin Kembalian: ");
                                    koinKembalian.printKoin();
                                    do {
                                        System.out.println("============================");
                                        System.out.println("Menu Koin Kembalian: ");
                                        System.out.println("0. Kembali ke Menu Admin.\n1. Edit Koin Kembalian.");
                                        System.out.print("Pilihan: ");
                                        pilihanMenuKembalian = Scan.nextInt();
                                        if (pilihanMenuKembalian == 1) {
                                            koinKembalian.editKoinKembalian();
                                            pilihanMenuKembalian = 0;
                                        } else if (pilihanMenuKembalian != 1 && pilihanMenuKembalian != 0) {
                                            System.out.println("============================");
                                            System.out.println("Input Salah!");
                                        }
                                    } while (pilihanMenuKembalian != 0);
                                    break;
                            }
                        } while (!perintahAdmin.equals("0"));
                    } else {
                        System.out.println("============================");
                        System.out.println("Username dan Password yang Anda Masukkan Salah!");
                    }
                    break;
            }
        } while (!perintah.equals("exit"));
    }
}
