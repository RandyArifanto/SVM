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
public class KoinPembeli extends Koin {

    private final String nilai;

    public KoinPembeli(String nilai) {
        super();
        this.nilai = nilai;
    }

    public boolean isKoin() {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(this.nilai, pos);
        return this.nilai.length() == pos.getIndex();
    }

    public boolean isValidKoin() {
        if (this.isKoin()) {
            int koinPembeli = Integer.parseInt(this.nilai);
            return koinPembeli % 100 <= 0;
        } else {
            return false;
        }
    }

    public boolean isKoinCukup(long hargaProduk) {
        return (super.getJumlah() >= hargaProduk);
    }

    public void setKoinPembeli() {
        long koinPembeli = Integer.parseInt(this.nilai);
        int jumlahKoin1000 = 0;
        int jumlahKoin500 = 0;
        int jumlahKoin200 = 0;
        int jumlahKoin100 = 0;
        if (koinPembeli >= 1000) {
            do {
                koinPembeli = koinPembeli - 1000;
                jumlahKoin1000++;
            } while (koinPembeli >= 1000);
        }
        if (koinPembeli >= 500) {
            do {
                koinPembeli = koinPembeli - 500;
                jumlahKoin500++;
            } while (koinPembeli >= 1000);
        }
        if (koinPembeli >= 200) {
            do {
                koinPembeli = koinPembeli - 200;
                jumlahKoin200++;
            } while (koinPembeli >= 200);
        }
        if (koinPembeli >= 100) {
            do {
                koinPembeli = koinPembeli - 100;
                jumlahKoin100++;
            } while (koinPembeli >= 100);
        }
        super.tambahKoin(jumlahKoin1000, jumlahKoin500, jumlahKoin200, jumlahKoin100);
    }

    public boolean isKembalian(long hargaProduk) {
        return (super.getJumlah() > hargaProduk);
    }
    
    public long jumlahKembalian(long hargaProduk){
        return (super.getJumlah() - hargaProduk);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

