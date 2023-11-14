import java.util.Scanner;

public class FiturLaporanPenjualan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jenisLayanan;
        double hasildiDpt;
        int menu;

        double[][] penjualan = new double[31][2];

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Masukkan data penjualan");
            System.out.println("2. Lihat laporan penjualan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3) : ");
            
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
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
                    System.out.println("Data penjualan berhasil dimasukkan.");
                    break;

                case 2:
                    System.out.println("Laporan penjualan:");
                    for (int i = 0; i < penjualan.length; i++) {
                        System.out.println("Tanggal " + (i + 1) + ": Potong = " + penjualan[i][0] + ", Rias = " + penjualan[i][1]);
                    }
                    break;

                case 3:
                    System.out.println("Terima kasih. ");
                    System.exit(0);

                default:
                    System.out.println("Menu tidak valid. Harap pilih menu yang benar.");
                    break;
            }

            System.out.print("Apakah Anda ingin memasukkan data? (y/n) : ");
            String lanjut = sc.nextLine();
            if (lanjut.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}
