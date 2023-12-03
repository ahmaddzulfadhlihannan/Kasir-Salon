import java.util.Scanner;

public class KasirAppFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double penjualanHarian[] = new double[30];
        String userKaryawan[] = new String[30];
        String passKaryawan[] = new String[30];
        String dataUserKaryawan[] = { "albedo", "ainz", "demiurge", "cocytus", "shaltear", "sebas" };
        String dataPassKaryawan[] = { "ainssama", "diamlah", "subarashi", "ojisan", "dearinsaka", "tuanku" };
        int menu;
        boolean kembaliKeLogin = false;

        for (int i = 0; i < penjualanHarian.length; i++) {
            login(sc, userKaryawan, passKaryawan, dataUserKaryawan, dataPassKaryawan, i);
            do {
                tampilkanMenuUtama();
                menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        transaksi(sc, userKaryawan, i);
                        break;
                    case 2:
                        // Tambahkan fitur membership
                        int jumlahTransaksi;

                        System.out.print("Masukkan jumlah transaksi: ");
                        jumlahTransaksi = sc.nextInt();

                        String[] member = new String[jumlahTransaksi];
                        int[] totHarga = new int[jumlahTransaksi];
                        double[] diskon = new double[jumlahTransaksi];
                        int[] hargaAkhir = new int[jumlahTransaksi];

                        for (int j = 0; j < jumlahTransaksi; j++) {
                            System.out.print("Membership atau bukan (transaksi ke-" + (j + 1) + "): ");
                            member[j] = sc.next();

                            if (member[j].equalsIgnoreCase("membership") || member[i].equalsIgnoreCase("bukan")) {
                                System.out.print("Masukkan total harga pembelian (transaksi ke-" + (j + 1) + "): ");
                                totHarga[j] = sc.nextInt();
                            } else {
                                System.out.println("Jenis keanggotaan tidak valid (transaksi ke-" + (j + 1) + ")");
                                continue;
                            }
                        }

                        for (int k = 0; k < jumlahTransaksi; k++) {
                            if (member[k].equalsIgnoreCase("membership")) {
                                if (totHarga[k] >= 300000) {
                                    diskon[k] = 0.2;
                                } else if (totHarga[k] >= 100000) {
                                    diskon[k] = 0.15;
                                } else {
                                    diskon[k] = 0;
                                }
                            } else if (member[k].equalsIgnoreCase("bukan")) {
                                if (totHarga[k] >= 150000) {
                                    diskon[k] = 0.02;
                                } else if (totHarga[k] >= 80000) {
                                    diskon[k] = 0.005;
                                } else {
                                    diskon[k] = 0;
                                }
                            } else {
                                System.out.println("Bukan pelanggan (transaksi ke-" + (k + 1) + ")");
                                continue;
                            }

                            hargaAkhir[k] = (int) (totHarga[k] - (totHarga[k] * diskon[k]));
                            System.out.println(
                                    "Total harga yang perlu dibayar (transaksi ke-" + (k + 1) + "): " + hargaAkhir[k]);
                        }
                        break;
                    case 3:
                        // Tambahkan fitur laporan penjualan
                        break;
                    case 7:
                        pengaturanStok();
                        break;
                    case 0:
                        kembaliKeLogin = true;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                        break;
                }
            } while (menu != 0);

            if (kembaliKeLogin) {
                kembaliKeLogin = false;
            }
        }

        sc.close();
    }

    // Login karyawan kasir
    private static void login(Scanner sc, String[] userKaryawan, String[] passKaryawan,
            String[] dataUserKaryawan, String[] dataPassKaryawan, int i) {
        System.out.println("Aplikasi salon");
        System.out.println("Login karyawan");
        userKaryawan[i] = sc.next();
        System.out.println("Masukkan password");
        passKaryawan[i] = sc.next();
        System.out.println("===============");

        boolean loginSukses = verifikasiLogin(userKaryawan[i], passKaryawan[i], dataUserKaryawan, dataPassKaryawan);

        if (!loginSukses) {
            System.out.println("Login gagal. Coba lagi.");
            i--;
        }
    }

    private static boolean verifikasiLogin(String user, String pass, String[] dataUser, String[] dataPass) {
        for (int karyawanKasir = 0; karyawanKasir < dataUser.length; karyawanKasir++) {
            if (user.equals(dataUser[karyawanKasir]) && pass.equals(dataPass[karyawanKasir])) {
                return true;
            }
        }
        return false;
    }

    // Tampilan menu fitur
    private static void tampilkanMenuUtama() {
        System.out.println("Selamat datang di aplikasi salon");
        System.out.println("Menu");
        System.out.println("1. Fitur transaksi");
        System.out.println("2. Membership");
        System.out.println("3. Laporan penjualan");
        System.out.println("4. Booking");
        System.out.println("5. Sistem pembayaran");
        System.out.println("6. Ketentuan diskon");
        System.out.println("7. Stok hari ini");
        System.out.println("0. Keluar");
        System.out.println("Pilih menu");
    }

    // Fungsi fitur transaksi
    private static void transaksi(Scanner sc, String[] userKaryawan, int i) {
        String namaJenisPelayanan[] = { "Potong", "Rias", "Paket potong rias" };
        double hargaJenisPelayanan[] = { 15000, 25000, 36000 };
        int nomorItem[] = new int[100], jumlah[] = new int[100];
        double harga[] = new double[100], totalHarga = 0;
        int j = 0;

        System.out.println("=====Fitur utama pembayaran=====");
        System.out.println("List jenis pelayanan :");
        for (int k = 0; k < namaJenisPelayanan.length; k++) {
            System.out.println((k + 1) + ". " + namaJenisPelayanan[k] + " - Rp" + hargaJenisPelayanan[k]);
        }
        System.out.println("Masukkan 0 pada Nomor item untuk mengakhiri transaksi dan menghitung total pembelian");

        do {
            System.out.print("Nomor item : ");
            nomorItem[j] = sc.nextInt();

            if (nomorItem[j] == 0 || nomorItem[j] > namaJenisPelayanan.length) {
                break;
            }

            System.out.print("Jumlah: ");
            jumlah[j] = sc.nextInt();
            harga[j] = hargaJenisPelayanan[nomorItem[j] - 1] * jumlah[j];
            totalHarga += harga[j];
            j++;
        } while (nomorItem[j - 1] != 0);

        System.out.println("Total Harga: Rp" + totalHarga);

        System.out.print("Uang diterima: Rp");
        double uangDiterima = sc.nextDouble();

        System.out.println("Uang Kembalian: Rp" + (uangDiterima - totalHarga));

        System.out.println("Cetak struk? (y/t)");
        String cetakStruk = sc.next();

        if (cetakStruk.equalsIgnoreCase("y")) {
            cetakStrukBelanjaan(userKaryawan[i], namaJenisPelayanan, nomorItem, jumlah, harga, j, totalHarga,
                    uangDiterima);
        }
    }

    private static void cetakStrukBelanjaan(String kasir, String[] namaJenisPelayanan, int[] nomorItem, int[] jumlah,
            double[] harga, int j, double totalHarga, double uangDiterima) {
        System.out.println("==========================================================");
        System.out.println("Struk Belanjaan");
        System.out.println("Kasir: " + kasir);
        System.out.println("==========================================================");
        System.out.printf("| %-5s | %-20s | %-7s | %-15s |\n", "No.", "Item", "Jumlah", "Harga");
        System.out.println("==========================================================");

        for (int k = 0; k < j; k++) {
            System.out.printf("| %-5d | %-20s | %-7d | Rp%-14.2f |\n",
                    k + 1, namaJenisPelayanan[nomorItem[k] - 1], jumlah[k], harga[k]);
        }

        System.out.println("==========================================================");
        System.out.printf("| %-28s : Rp%-15.2f |\n", "Total Harga", totalHarga);
        System.out.printf("| %-28s : Rp%-15.2f |\n", "Uang Diterima", uangDiterima);
        System.out.printf("| %-28s : Rp%-15.2f |\n", "Uang Kembalian", (uangDiterima - totalHarga));
        System.out.println("==========================================================");
    }

    // Fungsi fitur pengaturan stok
    static String[] kategoriBarang = { "Perawatan Rambut", "Rias Wajah" };
    static String[][] barang = {
            { "Shampoo dan Conditioner", "Hair Mask", "Serum dan Minyak Rambut", "Hair Spray dan Gel",
                    "Cat Rambut (Hair Dye)", "Obat rebonding/Smoothing/Krimbat" },
            { "Bedak dan Foundation", "Eyeliner", "Eyeshadow", "Mascara", "Lipstik dan Lip Gloss", "Makeup Remover" }
    };
    static int[][] stok = new int[2][6];

    static void pengaturanStok() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        boolean kembaliKeStok = false;
        do {
            System.out.println("Menu:");
            System.out.println("1. Lihat Stok Barang");
            System.out.println("2. Input Stok Barang");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    lihatStok();
                    break;
                case 2:
                    inputStok();
                    break;
                case 3:
                    System.out.println("Terima kasih. Program selesai.");
                    kembaliKeStok = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (!kembaliKeStok);

    }

    static void lihatStok() {
        System.out.println("Stok Barang:");
        for (int kategori = 0; kategori < kategoriBarang.length; kategori++) {
            System.out.println("Kategori: " + kategoriBarang[kategori]);
            for (int i = 0; i < barang[kategori].length; i++) {
                System.out.println((i + 1) + ". " + barang[kategori][i] + ": " + stok[kategori][i]);
            }
            System.out.println();
        }
    }

    static void inputStok() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Stok Barang:");
        for (int kategori = 0; kategori < kategoriBarang.length; kategori++) {
            System.out.println("Kategori: " + kategoriBarang[kategori]);
            for (int i = 0; i < barang[kategori].length; i++) {
                System.out.print("Masukkan jumlah tambahan stok " + barang[kategori][i] + ": ");
                int tambahanStok = scanner.nextInt();
                stok[kategori][i] += tambahanStok;
            }
            System.out.println();
        }

        System.out.println("Input stok berhasil.");
    }
}
