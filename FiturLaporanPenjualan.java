import java.util.Scanner;

public class FiturLaporanPenjualan {

    public static void inputPenjualan(Scanner sc, double[][] penjualan) {
        while (true) {
            System.out.print("Masukkan tanggal (1-31) : ");
            int tanggal = sc.nextInt();
            sc.nextLine();

            if (tanggal < 1 || tanggal > 31) {
                System.out.println("Tanggal tidak valid. Harap masukkan tanggal antara 1 hingga 31.");
                continue;
            }

            System.out.println("Jenis layanan Potong atau Rias");
            System.out.print("Masukkan jenis layanan (Potong/Rias) : ");
            String jenisLayanan = sc.nextLine();

            if (!jenisLayanan.equalsIgnoreCase("Potong") && !jenisLayanan.equalsIgnoreCase("Rias")) {
                System.out.println("Jenis layanan tidak valid. Harap masukkan Potong atau Rias.");
                continue;
            }

            double hasildiDpt = inputPendapatan(sc);
            if (jenisLayanan.equals("Potong")) {
                penjualan[tanggal - 1][0] = hasildiDpt;
            } else {
                penjualan[tanggal - 1][1] = hasildiDpt;
            }

            System.out.print("Apakah Anda ingin memasukkan data? (y/n) : ");
            String lanjut = sc.nextLine();
            if (lanjut.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public static double inputPendapatan(Scanner sc) {
        System.out.print("Masukkan pendapatan hari ini : ");
        return sc.nextDouble();
    }

    public static double hitungTotalPendapatanBulanan(double[][] penjualan) {
        double totalPendapatan = 0;

        for (int i = 0; i < penjualan.length; i++) {
            totalPendapatan += penjualan[i][0] + penjualan[i][1];
        }

        return totalPendapatan;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] penjualan = new double[31][2];

        inputPenjualan(sc, penjualan);

        double totalPendapatan = hitungTotalPendapatanBulanan(penjualan);
        System.out.println("Total Pendapatan Bulan Ini: " + totalPendapatan);

        sc.close();
    }
}