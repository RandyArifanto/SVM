package Uang;

import java.text.NumberFormat;
import java.text.ParsePosition;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AO756
 */
public class Koin {

    private int jumlahKoin1000;
    private int jumlahKoin500;
    private int jumlahKoin200;
    private int jumlahKoin100;

    public Koin() {
        this.jumlahKoin1000 = 0;
        this.jumlahKoin500 = 0;
        this.jumlahKoin200 = 0;
        this.jumlahKoin100 = 0;
    }

    public int getJumlahKoin1000() {
        return jumlahKoin1000;
    }

    public int getJumlahKoin500() {
        return jumlahKoin500;
    }

    public int getJumlahKoin200() {
        return jumlahKoin200;
    }

    public int getJumlahKoin100() {
        return jumlahKoin100;
    }

    public void setJumlahKoin1000(int jumlahKoin1000) {
        this.jumlahKoin1000 = jumlahKoin1000;
    }

    public void setJumlahKoin500(int jumlahKoin500) {
        this.jumlahKoin500 = jumlahKoin500;
    }

    public void setJumlahKoin200(int jumlahKoin200) {
        this.jumlahKoin200 = jumlahKoin200;
    }

    public void setJumlahKoin100(int jumlahKoin100) {
        this.jumlahKoin100 = jumlahKoin100;
    }

    public long getJumlah() {
        return ((this.getJumlahKoin1000() * 1000) + (this.getJumlahKoin500() * 500) + (this.getJumlahKoin200() * 200) + (this.getJumlahKoin100() * 100));
    }

    public void tambahKoin(int jumlahKoin1000, int jumlahKoin500, int jumlahKoin200, int jumlahKoin100) {
        this.jumlahKoin1000 = this.jumlahKoin1000 + jumlahKoin1000;
        this.jumlahKoin500 = this.jumlahKoin500 + jumlahKoin500;
        this.jumlahKoin200 = this.jumlahKoin200 + jumlahKoin200;
        this.jumlahKoin100 = this.jumlahKoin100 + jumlahKoin100;
    }
    
    public void printKoin() {
        System.out.println("Koin 1000 : " + jumlahKoin1000 + " koin.");
        System.out.println("Koin 500  : " + jumlahKoin500 + " koin.");
        System.out.println("Koin 200  : " + jumlahKoin200 + " koin.");
        System.out.println("Koin 100  : " + jumlahKoin100 + " koin.");
        System.out.println("Total Koin Kembalian: " + this.getJumlah());
    }
    
    public void keluarKembalian(long tempHitungKoin) {
        int tempJumlahKoin1000 = 0;
        int tempJumlahKoin500 = 0;
        int tempJumlahKoin200 = 0;
        int tempJumlahKoin100 = 0;
        if (this.jumlahKoin1000 > 0) {
            if (tempHitungKoin >= 1000) {
                do {
                    tempHitungKoin = tempHitungKoin - 1000;
                    tempJumlahKoin1000++;
                } while (tempHitungKoin >= 1000 && this.jumlahKoin1000 > 0);
            }
        }
        if (this.jumlahKoin500 > 0) {
            if (tempHitungKoin >= 500) {
                do {
                    tempHitungKoin = tempHitungKoin - 500;
                    tempJumlahKoin500++;
                } while (tempHitungKoin >= 1000 && this.jumlahKoin500 > 0);
            }
        }
        if (this.jumlahKoin200 > 0) {
            if (tempHitungKoin >= 200) {
                do {
                    tempHitungKoin = tempHitungKoin - 200;
                    tempJumlahKoin200++;
                } while (tempHitungKoin >= 200 && this.jumlahKoin200 > 0);
            }
        }
        if (this.jumlahKoin100 > 0) {
            if (tempHitungKoin >= 100) {
                do {
                    tempHitungKoin = tempHitungKoin - 100;
                    tempJumlahKoin100++;
                } while (tempHitungKoin >= 100 && this.jumlahKoin100 > 0);
            }
        }
        this.jumlahKoin1000 = this.jumlahKoin1000 - tempJumlahKoin1000;
        this.jumlahKoin500 = this.jumlahKoin500 - tempJumlahKoin500;
        this.jumlahKoin200 = this.jumlahKoin200 - tempJumlahKoin200;
        this.jumlahKoin100 = this.jumlahKoin100 - tempJumlahKoin100;
    }
}
