import java.util.Scanner;

public class KasirAppFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double penjualanHarian[] = new double[30];
        String userKaryawan[] = new String[30];
        String passKaryawan[] = new String[30];
        String dataUserKaryawan[] = { "Hannan", "Evan", "Ayu", "Ilut" };
        String dataPassKaryawan[] = { "pass", "pass", "pass", "pass" };
        int menu;
        boolean kembaliKeLogin = true;
        String jenisLayanan;
        double hasildiDpt;
        double[][] penjualan = new double[31][2];
        String nama, jenisBooking;
        int jam, banyakOrang;

        for (int i = 0; i < penjualanHarian.length; i++) {
            while (kembaliKeLogin) {
                boolean validasiLogin = login(sc, userKaryawan, passKaryawan, dataUserKaryawan, dataPassKaryawan, i);
                if (!validasiLogin) {
                    System.out.println("Login gagal. Coba lagi\n");
                    continue;
                } else {
                    break;
                }
            }
            do {
                tampilkanMenuUtama();
                menu = sc.nextInt();
                System.out.println("__________________________\n");

                switch (menu) {
                    case 1:
                        System.out.println("Hari ke-" + (i + 1));
                        transaksi(sc, userKaryawan, i);
                        break;
                    case 2:
                        // Tambahkan fitur membership
                        Scanner member = new Scanner(System.in);

                        System.out.println("Apakah Anda sudah menjadi anggota membership? (y/t)");
                        String isMember = sc.next();

                        String[][] memberNames = {
                            {"evan", "ilut", "hanan", "ayu"}
                        };

                        if (isMember.equalsIgnoreCase("y")) {
                            System.out.print("Masukkan nama keanggotaan membership: ");
                            String namaMember = sc.next();

                            System.out.print("Masukkan total harga pembelian: ");
                            int totHarga = sc.nextInt();

                            double diskon = 0;
                            if (totHarga >= 300000) {
                                diskon = 0.2;
                            } else if (totHarga >= 100000) {
                                diskon = 0.15;
                            }

                            int hargaAkhir = (int) (totHarga - (totHarga * diskon));

                            System.out.println("Transaksi");
                            System.out.println("Nama: " + namaMember);
                            System.out.println("Total harga: " + totHarga);
                            System.out.println("Diskon: " + diskon);
                            System.out.println("Harga akhir: " + hargaAkhir);

                        } else if (isMember.equalsIgnoreCase("t")) {
                            System.out.println("Anda bukan member. Apakah ingin membuat member? (y/t)");
                            String createMember = sc.next();

                            if (createMember.equalsIgnoreCase("y")) {
                                System.out.print("Masukkan nama keanggotaan membership: ");
                                String namaMember = sc.next();

                                System.out.println("Member berhasil dibuat!");

                                System.out.print("Masukkan total harga pembelian: ");
                                int totHarga = sc.nextInt();

                                double diskon = 0;
                                if (totHarga >= 300000) {
                                    diskon = 0.2;
                                } else if (totHarga >= 100000) {
                                    diskon = 0.15;
                                }

                                int hargaAkhir = (int) (totHarga - (totHarga * diskon));

                                System.out.println("Transaksi");
                                System.out.println("Total harga: " + totHarga);
                                System.out.println("Diskon: " + diskon);
                                System.out.println("Harga akhir: " + hargaAkhir);

                            } else if (createMember.equalsIgnoreCase("t")) {
                                System.out.print("Masukkan total harga pembelian: ");
                                int totHarga = sc.nextInt();

                                double diskon = 0;
                                if (totHarga >= 150000) {
                                    diskon = 0.02;
                                } else if (totHarga >= 80000) {
                                    diskon = 0.005;
                                }

                                int hargaAkhir = (int) (totHarga - (totHarga * diskon));

                                System.out.println("Transaksi");
                                System.out.println("Total harga: " + totHarga);
                                System.out.println("Diskon: " + diskon);
                                System.out.println("Harga akhir: " + hargaAkhir);

                            } else {
                                System.out.println("Input tidak valid");
                            }
                        }
                        break;
                    case 3:
                        // Tambahkan fitur laporan penjualan
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

                            if (jenisLayanan.equalsIgnoreCase("Potong")) {
                                penjualan[tanggal - 1][0] = hasildiDpt;
                            } else if (jenisLayanan.equalsIgnoreCase("Rias")) {
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

                        for (int l = 0; l < 31; l++) {
                            totalPendapatanPotong += penjualan[l][0];
                            totalPendapatanRias += penjualan[l][1];
                        }
                
                        System.out.println("\nTotal pendapatan Potong hingga hari ini : " + totalPendapatanPotong);
                        System.out.println("Total pendapatan Rias hingga hari ini    : " + totalPendapatanRias + "\n");
                        break;
                    case 4:
                        System.out.print("Masukkan banyak orang yang akan di rias atau potong: ");
                        banyakOrang = sc.nextInt();

                        int k = 0;

                        while (k < banyakOrang) {
                            System.out.println("___________________________________________________");
                            System.out.println("Pilihan layanan yang akan di booking - Potong, Rias");
                            System.out.print("Masukkan layanan orang ke-" + (k + 1) + "           : ");
                            jenisBooking = sc.next();
                            System.out.print("Masukkan nama orang yang akan booking : ");
                            nama = sc.next();

                            if (jenisBooking.equalsIgnoreCase("potong")) {
                                System.out.println("Pilih jam booking mulai dari pukul 7 hingga 20");
                                System.out.print("Masukkan jam booking                  : ");
                                jam = sc.nextInt();
                                System.out.println("Potong dibooking oleh " + nama + " Jam " + jam + "\n");
                            } else if (jenisBooking.equalsIgnoreCase("rias")) {
                                System.out.println("Pilih jam booking mulai dari pukul 7 hingga 20");
                                System.out.print("Masukkan jam booking                  : ");
                                jam = sc.nextInt();
                                System.out.println("Rias dibooking oleh " + nama + " Jam " + jam + "\n");
                            } else {
                                System.out.println("Inputan invalid");
                                continue;
                            }
                            k++;
                        }
                        break;
                    case 5:
                        double totalPembelian = inputTotalPembelian();

                        System.out.println("Metode pembayaran :");
                        System.out.println("1. Tunai");
                        System.out.println("2. Non-Tunai");
                        System.out.print("Pilih metode pembayaran (1/2) : ");
                        int metodePembayaran = sc.nextInt();

                        if (metodePembayaran == 1) {
                            pembayaranTunai(totalPembelian);
                        } else if (metodePembayaran == 2) {
                            System.out.println("Pilih metode pembayaran Non-tunai :");
                            System.out.println("1. Qris");
                            System.out.println("2. Transfer Bank");
                            System.out.print("Pilih metode pembayaran Non-Tunai (1/2) : ");
                            int nonTunai = sc.nextInt();

                            if (nonTunai == 1) {
                                pembayaranQris(totalPembelian);
                            } else if (nonTunai == 2) {
                                pembayaranTransferBank(totalPembelian);
                            } else {
                                System.out.println("Pilihan tidak valid.");
                            }
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                        break;
                    case 6:
                        // Variabel
                        double totalHarga, bayar;
                        // Input total pembelian
                        System.out.print("Total Pembelian : ");
                        totalHarga = sc.nextDouble();
                        // Ketentuan diskon
                        double potonganDiskon = Diskon(totalHarga);
                        // Bayar
                        bayar = totalHarga - potonganDiskon;
                        // Riwayat diskon
                        System.out.println("Potongan Diskon : " + potonganDiskon);
                        System.out.println("Bayar : " + bayar);
                        break;
                    case 7:
                        pengaturanStok();
                        break;
                    case 0:
                        System.out.println("\n====================================================");
                        System.out.println("-----TERIMAKASIH TELAH MENGGUNAKAN SISTEM KASIR-----");
                        System.out.println("====================================================\n");
                        kembaliKeLogin = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                        break;
                }
            } while (menu != 0);

            if (!kembaliKeLogin) {
                kembaliKeLogin = true;
                continue;
                
            }
        }

        sc.close();
    }

    // Login karyawan kasir
    private static boolean login(Scanner sc, String[] userKaryawan, String[] passKaryawan,
            String[] dataUserKaryawan, String[] dataPassKaryawan, int i) {
        System.out.println(" --------------------");
        System.out.println("|   Aplikasi salon   |");
        System.out.println(" --------------------");
        System.out.print("\nLogin karyawan    : ");
        userKaryawan[i] = sc.next();
        System.out.print("Masukkan password : ");
        passKaryawan[i] = sc.next();
        System.out.println("==================");

        return verifikasiLogin(userKaryawan[i], passKaryawan[i], dataUserKaryawan, dataPassKaryawan);
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
    private static void tampilkanMenuUtama(int i) {
        System.out.println("\n======================================");
        System.out.println("|  Selamat datang di aplikasi salon  |");
        System.out.println("======================================\n");
        System.out.println("    ----Menu----    ");
        System.out.println("====================");
        System.out.println("1. Fitur transaksi");
        System.out.println("2. Membership");
        System.out.println("3. Laporan penjualan");
        System.out.println("4. Booking");
        System.out.println("5. Sistem pembayaran");
        System.out.println("6. Diskon");
        System.out.println("7. Stok hari ini");
        System.out.println("0. Keluar");
        System.out.print("\nPilih menu : ");
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

        // Input diskon

        System.out.print("Apakah hari khusus? (y/t) : ");
        String isDiskon = sc.next();
        double potonganDiskon = 0;
        
        if (isDiskon.equalsIgnoreCase("y")) {
            if (totalHarga >= 300000) {
                potonganDiskon = totalHarga * 0.15;
            } else if (100000 <= totalHarga) {
                potonganDiskon = totalHarga * 0.10;
            } else if (60000 <= totalHarga) {
                potonganDiskon = totalHarga * 0.05;
            } else {
                potonganDiskon = 0;
            }
        } else {
            potonganDiskon = 0;
        }

        totalHarga -= potonganDiskon;
        

        System.out.println("Potongan diskon : Rp." + potonganDiskon);

        System.out.println("Total Harga     : Rp." + totalHarga);

        System.out.print("Uang diterima   : Rp.");
        double uangDiterima = sc.nextDouble();

        System.out.println("Uang Kembalian  : Rp." + (uangDiterima - totalHarga));

        System.out.println("Cetak struk? (y/t)");
        String cetakStruk = sc.next();

        if (cetakStruk.equalsIgnoreCase("y")) {
            cetakStrukBelanjaan(userKaryawan[i], namaJenisPelayanan, nomorItem, jumlah, harga, j, totalHarga,
                    uangDiterima, potonganDiskon);
        }
    }

    private static void cetakStrukBelanjaan(String kasir, String[] namaJenisPelayanan, int[] nomorItem, int[] jumlah,
            double[] harga, int j, double totalHarga, double uangDiterima, double potonganDiskon) {
        System.out.println("\n===========================================================");
        System.out.println("Struk Belanjaan");
        System.out.println("Kasir: " + kasir);
        System.out.println("===========================================================");
        System.out.printf("| %-5s | %-20s | %-7s | %-15s \n", "No.", "Item", "Jumlah", "Harga");
        System.out.println("===========================================================");

        for (int k = 0; k < j; k++) {
            System.out.printf("| %-5d | %-20s | %-7d | Rp.%-11.2f |\n",
                    k + 1, namaJenisPelayanan[nomorItem[k] - 1], jumlah[k], harga[k]);
        }

        System.out.println("===========================================================");
        System.out.printf("| %-28s : Rp.%-21.2f |\n", "Potongan diskon", potonganDiskon);
        System.out.printf("| %-28s : Rp.%-21.2f |\n", "Total Harga", totalHarga);
        System.out.printf("| %-28s : Rp.%-21.2f |\n", "Uang Diterima", uangDiterima);
        System.out.printf("| %-28s : Rp.%-21.2f |\n", "Uang Kembalian", (uangDiterima - totalHarga));
        System.out.println("===========================================================");
        System.out.println("\n===========================================================");
        System.out.println("---------TERIMA KASIH TELAH MENGUNJUNGI SALON KAMI---------");
        System.out.println("===========================================================\n");
        System.out.println("\n");
    }

    public static double inputTotalPembelian() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Total Harga Pembelian : ");
        return sc.nextDouble();
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
        Scanner sc = new Scanner(System.in);
        int pilihan;
        boolean kembaliKeStok = false;
        do {
            System.out.println("Menu:");
            System.out.println("1. Lihat Stok Barang");
            System.out.println("2. Input Stok Barang");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            pilihan = sc.nextInt();
            System.out.println("\n");

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
        Scanner sc = new Scanner(System.in);

        System.out.println("Input Stok Barang:");
        for (int kategori = 0; kategori < kategoriBarang.length; kategori++) {
            System.out.println("Kategori: " + kategoriBarang[kategori]);
            for (int i = 0; i < barang[kategori].length; i++) {
                System.out.print("Masukkan jumlah tambahan stok " + barang[kategori][i] + ": ");
                int tambahanStok = sc.nextInt();
                stok[kategori][i] += tambahanStok;
            }
            System.out.println();
        }

        System.out.println("Input stok berhasil.\n");
    }

    // Fungsi sistem pembayaran
    public static void pembayaranTunai(double totalHarga) {
        System.out.println("Pembayaran tunai.");
        System.out.println("Total Pembelian : " + totalHarga);
        System.out.println("Transaksi penjualan berhasil.");
    }

    public static void pembayaranQris(double totalHarga) {
        System.out.println("Pembayaran non-tunai menggunakan Qris.");
        System.out.println("Total Pembelian : " + totalHarga);
        System.out.println("Pindai Qris untuk menyelesaikan pembayaran.");
        System.out.println("Transaksi penjualan berhasil.");
    }

    public static void pembayaranTransferBank(double totalHarga) {
        System.out.println("Pembayaran non-tunai menggunakan transfer bank.");
        System.out.println("Total Pembelian : " + totalHarga);
        System.out.println("Silakan transfer ke rekening yang tertera.");
        System.out.println("Transaksi penjualan berhasil.");
    }

    // Diskon
    public static double Diskon(double totalPembelian) {
        double potonganDiskon;
        if (totalPembelian >= 300000) {
            potonganDiskon = totalPembelian * 0.15;
        } else if (100000 <= totalPembelian) {
            potonganDiskon = totalPembelian * 0.10;
        } else if (60000 <= totalPembelian) {
            potonganDiskon = totalPembelian * 0.05;
        } else {
            potonganDiskon = 0;
        }
        return potonganDiskon;
    }
}
