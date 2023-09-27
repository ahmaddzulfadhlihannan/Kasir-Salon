import java.util.Scanner;

public class FiturUtamaPembayaran {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalHrg, uangDiterima, uangKembalian;

        System.out.print("Total pembelian : ");
        totalHrg = sc.nextDouble();
        System.out.print("Uang yang diterima : ");
        uangDiterima = sc.nextDouble();

        if (totalHrg<uangDiterima) {
        uangKembalian=uangDiterima-totalHrg;
        System.out.print("Uang kembalian yang diterima: " +uangKembalian);
        } else if (totalHrg==uangDiterima) {
            System.out.print("Tidak ada kembalian");
        } else {
            uangKembalian=totalHrg-uangDiterima;
            System.out.print("Kembalian kurang: " +uangKembalian); 

        sc.close();
        } 
    }
}