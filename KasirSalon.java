//Aplikasi Kasir Salon Pertama//

//---import Scanner---//
import java.util.Scanner;

public class KasirSalon {
    public static void main(String[] args) {

        // ---Deklarasi Scanner---//
        Scanner sc = new Scanner(System.in);

        // ---Input dan output---//
        String nmBarang;
        int hrgBarang, jmlBarang;
        double totalHrg, uangDiterima, uangKembalian;

        // ---Memasukkan nilai variabel ke scanner---//
        System.out.printf("Masukkan nama barang yang dibeli : ");
        nmBarang = sc.next();
        System.out.printf("Masukkan harga barang yang dibeli! : ");
        hrgBarang = sc.nextInt();
        System.out.printf("Masukkan jumlah barang yang dibeli! : ");
        jmlBarang = sc.nextInt();

        // ---Hitung jumlah harga---//
        totalHrg = hrgBarang * jmlBarang;
        System.out.printf("Total harga barang : %f", totalHrg);

        // ---Hitung uang kembalian---//
        System.out.printf("\nMasukkan jumlah uang yang diterima : ");
        uangDiterima = sc.nextInt();
        uangKembalian = uangDiterima - totalHrg;

        // ---Cetak rincian pembelian---//
        System.out.printf("\nStruk pembelian");
        System.out.printf("\nNama barang : %s", nmBarang);
        System.out.printf("\nHarga barang : %d", hrgBarang);
        System.out.printf("\nJumlah barang : %d", jmlBarang);
        System.out.printf("\nTotal harga : %f", totalHrg);
        System.out.printf("\nUang diterima : %f", uangDiterima);
        System.out.printf("\nUang kembalian anda adalah : %f", uangKembalian);
        System.out.printf("\nTerima kasih telah datang disalon kami");

        sc.close();
    }
}
