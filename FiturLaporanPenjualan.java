import java.util.Scanner;

public class FiturLaporanPenjualan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pendapatanPotong = new int[31];
        int[] pendapatanRias = new int[31];
        int tanggal, pendapatan, layanan;
        boolean masukkanLagi = true;

        while (masukkanLagiLagi) {
            System.out.print("Masukkan tanggal (1-31): ");
            tanggal = sc.nextInt();
            System.out.print("Jenis layanan (1 untuk potong, 2 untuk rias): ");
            layanan = sc.nextInt();
            System.out.print("Masukkan pendapatan: ");
            pendapatan = sc.nextInt();
    

            if (layanan == 1) {
                pendapatanPotong[tanggal - 1] += pendapatan;
            } else if (layanan == 2) {
                pendapatanRias[tanggal - 1] += pendapatan;
            }

            System.out.print("Apakah ingin memasukkan pendapatan lagi? (true/false): ");
            masukkanLagi = sc.nextBoolean();
        }

        // Proses rekap pada hari terakhir di bulan
        int totalPendapatanPotong = 0;
        int totalPendapatanRias = 0;
        for (int i = 0; i < 31; i++) {
            totalPendapatanPotong += pendapatanPotong[i];
            totalPendapatanRias += pendapatanRias[i];
        }

        System.out.println("Total pendapatan potong: " + totalPendapatanPotong);
        System.out.println("Total pendapatan rias: " + totalPendapatanRias);
    }
}