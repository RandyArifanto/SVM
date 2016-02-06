package Uang;

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
public class KoinKembalian extends Koin {

    Scanner Scan = new Scanner(System.in);

    public KoinKembalian() {
        super.setJumlahKoin1000(50);
        super.setJumlahKoin500(50);
        super.setJumlahKoin200(50);
        super.setJumlahKoin100(50);
    }

    public boolean isKembalianCukup(long jumlahKembalian) {
        long tempHitungKoin = jumlahKembalian;
        int jumlahKoin1000 = 0;
        int jumlahKoin500 = 0;
        int jumlahKoin200 = 0;
        int jumlahKoin100 = 0;
        if (super.getJumlahKoin1000()> 0) {
            if (tempHitungKoin >= 1000) {
                do {
                    tempHitungKoin = tempHitungKoin - 1000;
                    jumlahKoin1000++;
                } while (tempHitungKoin >= 1000 && super.getJumlahKoin1000() > 0);
            }
        }
        if (super.getJumlahKoin500() > 0) {
            if (tempHitungKoin >= 500) {
                do {
                    tempHitungKoin = tempHitungKoin - 500;
                    jumlahKoin500++;
                } while (tempHitungKoin >= 500 && super.getJumlahKoin500() > 0);
            }
        }
        if (super.getJumlahKoin200() > 0) {
            if (tempHitungKoin >= 200) {
                do {
                    tempHitungKoin = tempHitungKoin - 200;
                    jumlahKoin200++;
                } while (tempHitungKoin >= 200 && super.getJumlahKoin200() > 0);
            }
        }
        if (super.getJumlahKoin100() > 0) {
            if (tempHitungKoin >= 100) {
                do {
                    tempHitungKoin = tempHitungKoin - 100;
                    jumlahKoin100++;
                } while (tempHitungKoin >= 100 && super.getJumlahKoin100() > 0);
            }
        }
        return tempHitungKoin == 0;
    }

    public void tambahKoinKembalian(long hargaProduk) {
        int jumlahKoin1000 = 0;
        int jumlahKoin500 = 0;
        int jumlahKoin200 = 0;
        int jumlahKoin100 = 0;
        if (hargaProduk >= 1000) {
            do {
                hargaProduk = hargaProduk - 1000;
                jumlahKoin1000++;
            } while (hargaProduk >= 1000);
        }
        if (hargaProduk >= 500) {
            do {
                hargaProduk = hargaProduk - 500;
                jumlahKoin500++;
            } while (hargaProduk >= 1000);
        }
        if (hargaProduk >= 200) {
            do {
                hargaProduk = hargaProduk - 200;
                jumlahKoin200++;
            } while (hargaProduk >= 200);
        }
        if (hargaProduk >= 100) {
            do {
                hargaProduk = hargaProduk - 100;
                jumlahKoin100++;
            } while (hargaProduk >= 100);
        }
        super.tambahKoin(jumlahKoin1000, jumlahKoin500, jumlahKoin200, jumlahKoin100);
    }

    public void editKoinKembalian() {
        int jumlahKoinKembalian;
        System.out.println("Jumlah Koin 1000: " + super.getJumlahKoin1000() + " koin");
        System.out.print("Jumlah Baru: ");
        jumlahKoinKembalian = Scan.nextInt();
        super.setJumlahKoin1000(jumlahKoinKembalian);
        System.out.println("Jumlah Koin 500: " + super.getJumlahKoin500() + " koin");
        System.out.print("Jumlah Baru: ");
        jumlahKoinKembalian = Scan.nextInt();
        super.setJumlahKoin500(jumlahKoinKembalian);
        System.out.println("Jumlah Koin 200: " + super.getJumlahKoin200() + " koin");
        System.out.print("Jumlah Baru: ");
        jumlahKoinKembalian = Scan.nextInt();
        super.setJumlahKoin200(jumlahKoinKembalian);
        System.out.println("Jumlah Koin 100: " + super.getJumlahKoin100() + " koin");
        System.out.print("Jumlah Baru: ");
        jumlahKoinKembalian = Scan.nextInt();
        super.setJumlahKoin100(jumlahKoinKembalian);
    }
}
