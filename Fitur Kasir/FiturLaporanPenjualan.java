import java.util.Scanner;
public class FiturLaporanPenjualan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jenisLayanan;
        double hasildiDpt;

        double[][] penjualan = new double[31][2];

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
            jenisLayanan = sc.nextLine();

            if (!jenisLayanan.equalsIgnoreCase("Potong") && !jenisLayanan.equalsIgnoreCase("Rias")) {
                System.out.println("Jenis layanan tidak valid. Harap masukkan Potong atau Rias.");
                continue;
            }

            System.out.print("Masukkan pendapatan hari ini : ");
            hasildiDpt = sc.nextDouble();
            sc.nextLine();

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

        double totalPendapatanPotong = 0;
        double totalPendapatanRias = 0;

        for (int i = 0; i < 31; i++) {
            totalPendapatanPotong += penjualan[i][0];
            totalPendapatanRias += penjualan[i][1];
        }

        System.out.println("\nTotal pendapatan Potong hingga hari ini : " + totalPendapatanPotong);
        System.out.println("Total pendapatan Rias hingga hari ini    : " + totalPendapatanRias + "\n");
    }
}