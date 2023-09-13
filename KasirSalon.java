//Aplikasi Kasir Salon Pertama//

//---import Scanner---//
import java.util.Scanner;
public class KasirSalon {
    public static void main(String[] args) {

        //---Deklarasi Scanner---//
        Scanner sc = new Scanner(System.in);

        //---Input dan output---//
        String nmBarang;
        int hrgBarang, jmlBarang;
        double totalHrg, uangDiterima, uangKembalian;

        //---Memasukkan nilai variabel ke scanner---//
        System.out.println("Masukkan nama barang yang dibeli");
        nmBarang = sc.next();
        System.out.println("Masukkan harga barang yang dibeli! ");
        hrgBarang = sc.nextInt();
        System.out.println("Masukkan jumlah barang yang dibeli! ");
        jmlBarang = sc.nextInt();

        //---Hitung jumlah harga---//
        totalHrg = hrgBarang * jmlBarang;
        System.out.println("Total harga barang : " + totalHrg);

        //---Hitung uang kembalian---//
        System.out.println("Masukkan jumlah uang yang diterima ");
        uangDiterima = sc.nextInt();
        uangKembalian = uangDiterima - totalHrg;

        //---Cetak rincian pembelian---//
        System.out.println("Struk pembelian");
        System.out.println("Nama barang : " + nmBarang);
        System.out.println("Harga barang : " + hrgBarang);
        System.out.println("Jumlah barang : " + jmlBarang);
        System.out.println("Total harga : " + totalHrg);
        System.out.println("Uang diterima : " + uangDiterima);
        System.out.println("Uang kembalian anda adalah : " + uangKembalian);
        System.out.println("Terima kasih telah datang disalon kami");

    }
}
