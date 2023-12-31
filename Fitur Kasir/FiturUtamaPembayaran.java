import java.util.Scanner;

public class FiturUtamaPembayaran {
    public static void main(String[] args) {

        // Scanner
        Scanner sc = new Scanner(System.in);

        // Masukkan jumlah jenis barang yang dibeli
        System.out.print("Masukkan jumlah jenis barang yang dibeli : ");
        int jumlahJenis = sc.nextInt();

        // Variabel
        String namaBarang[] = new String[jumlahJenis];
        int jumlahBarang[] = new int[jumlahJenis];
        double harga[] = new double[jumlahJenis], totalHarga[] = new double[jumlahJenis], totalPembelian = 0,
                uangDiterima, kembalian;

        // Pembelian
        for (int i = 0; i < jumlahJenis; i++) {
            System.out.printf("Masukkan nama barang\t%d\t\t:\t", (i + 1));
            namaBarang[i] = sc.next();
            System.out.printf("Masukkan harga barang\t%d\t\t:\t", (i + 1));
            harga[i] = sc.nextDouble();
            System.out.printf("Masukkan jumlah barang\t%d\t\t:\t", (i + 1));
            jumlahBarang[i] = sc.nextInt();
            // Perhitungan total harga dan total pembelian
            totalHarga[i] = (double) harga[i] * jumlahBarang[i];
            totalPembelian += totalHarga[i];
        }
        // Perhitungan uang kembalian
        System.out.println("-----------------------------------------------------------");
        System.out.printf("Total pembelian\t:\t%.2f\n", totalPembelian);
        System.out.print("Uang diterima\t:\t");
        uangDiterima = sc.nextDouble();
        kembalian = uangDiterima - totalPembelian;
        System.out.printf("Uang kembalian\t:\t%.2f\n", kembalian);
        System.out.println("-----------------------------------------------------------");

        // Struk pembelian
        System.out.println("------------------------------------------------------------");
        System.out.printf("| %-15s | %-10s | %-10s | %-10s |\n", "Nama Barang", "Harga", "Jumlah", "Total");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < jumlahJenis; i++) {
            System.out.printf("| %-15s | %10.2f | %10d | %10.2f |\n", (i + 1) + ". " + namaBarang[i], harga[i],
                    jumlahBarang[i], totalHarga[i]);
        }
        System.out.println("------------------------------------------------------------");

        System.out.println("-----------------------------------------------------------");
        System.out.printf("Total pembelian\t:\t%.2f\n", totalPembelian);
        System.out.printf("Uang Diterima\t:\t%.2f\n", uangDiterima);
        System.out.printf("Kembalian\t:\t%.2f\n", kembalian);
        System.out.println("----------Terima Kasih Telah Datang Ke Salon Kami----------");

        sc.close();
    }
}
