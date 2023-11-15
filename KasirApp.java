import java.util.Scanner;

public class KasirApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double penjualanHarian[] = new double[30];
        int menu;

        for (int i = 0; i < penjualanHarian.length; i++) {
            System.out.println("Aplikasi salon");
            System.out.println("Login karyawan");
            String userKaryawan = sc.next();
            System.out.println("Masukkan password");
            String passKaryawan = sc.next();
            System.out.println("===============");

            if (!login(userKaryawan, passKaryawan)) {
                System.out.println("Login gagal. Coba lagi.");
                continue;
            }

            do {
                System.out.println("Selamat datang di aplikasi salon");
                System.out.println("Menu");
                System.out.println("1. Fitur utama pembayaran dan struk");
                System.out.println("0. Keluar");
                System.out.println("Pilih menu");
                menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        String namaJenisPelayanan[] = { "Potong", "Rias", "Paket potong rias" };
                        double hargaJenisPelayanan[] = { 15000, 25000, 36000 };
                        int nomorItem[] = new int[100], jumlah[] = new int[100];
                        double harga[] = new double[100], totalHarga = 0;
                        int j = 0;
                        System.out.println("====================");
                        System.out.println("List jenis pelayanan :");
                        for (int k = 0; k < namaJenisPelayanan.length; k++) {
                            System.out
                                    .println((k + 1) + ". " + namaJenisPelayanan[k] + " - Rp" + hargaJenisPelayanan[k]);
                        }

                        do {
                            System.out.print("Nomor item: ");
                            nomorItem[j] = sc.nextInt();
                            if (nomorItem[j] == 0 || nomorItem[j] > 3) {
                                break;
                            }
                            System.out.print("Jumlah: ");
                            jumlah[j] = sc.nextInt();
                            harga[j] = hargaJenisPelayanan[nomorItem[j] - 1] * jumlah[j];
                            totalHarga += harga[j];
                            j++;
                        } while (nomorItem[j - 1] != 0);

                        System.out.println("Total Harga: Rp" + totalHarga);

                        double diskon;
                        if (totalHarga > 300000) {
                            diskon = 0.1;
                        } else if (totalHarga > 200000) {
                            diskon = 0.05;
                        } else if (totalHarga > 100000) {
                            diskon = 0.03;
                        } else {
                            diskon = 0;
                        }

                        double bayar = totalHarga - (totalHarga * diskon);
                        System.out.println("Total Bayar setelah diskon: Rp" + bayar);

                        System.out.print("Uang diterima: Rp");
                        double uangDiterima = sc.nextDouble();

                        System.out.println("Cetak struk? (y/t)");
                        String cetakStruk = sc.next();

                        if (cetakStruk.equalsIgnoreCase("y")) {
                            System.out.println("Struk belanjaan");
                            System.out.println("Kasir : " + userKaryawan);
                            for (int k = 0; k < j; k++) {
                                System.out.println("Item: " + namaJenisPelayanan[nomorItem[k] - 1]);
                                System.out.println("Jumlah: " + jumlah[k]);
                                System.out.println("Harga: Rp" + harga[k]);
                                System.out.println("====================");
                            }
                            System.out.println("Total Harga: Rp" + totalHarga);
                            System.out.println("Diskon: Rp" + (totalHarga * diskon));
                            System.out.println("Total Bayar: Rp" + bayar);
                            System.out.println("Uang Diterima: Rp" + uangDiterima);
                            System.out.println("Uang Kembalian: Rp" + (uangDiterima - bayar));
                        }
                        break;

                    case 0:
                        // Keluar dari aplikasi
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                        break;
                }
            } while (menu != 0);
        }
    }

    private static boolean login(String username, String password) {
        // Ganti dengan logika login yang sesuai, misalnya dari database
        return username.equals("karyawan") && password.equals("password");

    }
}
