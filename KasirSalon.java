//Aplikasi Kasir Salon Pertama//
import java.util.Scanner;
public class KasirSalon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hrgBarang, jmlBarang;
        double totalHrg, uangDiterima, uangKembalian;

        System.out.println("Masukkan harga barang yang dibeli! ");
        hrgBarang = sc.nextInt();
        System.out.println("Masukkan jumlah barang yang dibeli! ");
        jmlBarang = sc.nextInt();

        totalHrg = hrgBarang * jmlBarang;
        System.out.println("Total harga barang : " + totalHrg);

        System.out.println("Masukkan jumlah uang yang diterima ");
        uangDiterima = sc.nextInt();
        uangKembalian = uangDiterima - totalHrg;

        System.out.println("Uang kembalian anda adalah" + uangKembalian);
    }
}
