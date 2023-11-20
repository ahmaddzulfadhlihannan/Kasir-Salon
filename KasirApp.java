import java.util.Scanner;
import java.util.Random;

public class KasirApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random acak = new Random();

        // Inisialisasi variabel dan array
        double penjualanHarian[] = new double[30];
        double penjualanPotong[] = new double[30];
        double penjualanRias[] = new double[30];
        double penjualanPaket[] = new double[30];
        double potonganDiskonHarian[] = new double[30];
        double totalHargaAsliHarian[] = new double[30];
        double keuntunganHarian[] = new double[30];
        String userKaryawan[] = new String[30];
        String passKaryawan[] = new String[30];
        String dataUserKaryawan[] = { "albedo", "ainz", "demiurge", "cocytus", "shaltear", "sebas" };
        String dataPassKaryawan[] = { "ainssama", "diamlah", "subarashi", "ojisan", "dearinsaka", "tuanku" };
        int menu, menuMembership, menuLaporan, maxMembership = 12;
        String[] namaPelanggan = new String[maxMembership];
        String[] nomorMember = new String[maxMembership];
        int jumlahPelanggan = 0;
        boolean kembaliKeLogin = false;

        // Loop untuk setiap hari kerja
        for (int i = 0; i < penjualanHarian.length; i++) {
            // Inisialisasi nilai array
            penjualanHarian[i] = 0;
            penjualanPotong[i] = 0;
            penjualanRias[i] = 0;
            penjualanPaket[i] = 0;
            potonganDiskonHarian[i] = 0;

            // Login karyawan
            System.out.println("Aplikasi salon");
            System.out.println("Login karyawan");
            userKaryawan[i] = sc.next();
            System.out.println("Masukkan password");
            passKaryawan[i] = sc.next();
            System.out.println("===============");

            // Validasi login
            boolean loginSukses = false;
            for (int karyawanKasir = 0; karyawanKasir < dataUserKaryawan.length; karyawanKasir++) {
                if (userKaryawan[i].equals(dataUserKaryawan[karyawanKasir])
                        && passKaryawan[i].equals(dataPassKaryawan[karyawanKasir])) {
                    loginSukses = true;
                    break;
                }
            }

            // Jika login gagal, ulangi loop login
            if (!loginSukses) {
                System.out.println("Login gagal. Coba lagi.");
                i--;
                continue;
            }

            // Menu utama
            do {
                System.out.println("Selamat datang di aplikasi salon");
                System.out.println("Menu");
                System.out.println("1. Fitur utama pembayaran dan struk");
                System.out.println("2. Membership");
                System.out.println("3. Laporan penjualan");
                System.out.println("0. Keluar");
                System.out.println("Pilih menu");
                menu = sc.nextInt();
                boolean kembaliKeMenu = false;

                switch (menu) {
                    case 1:
                        // Fitur utama pembayaran dan struk
                        String namaJenisPelayanan[] = { "Potong", "Rias", "Paket potong rias" };
                        double hargaAsli[] = { 10000, 20000, 30000 };
                        double hargaJenisPelayanan[] = { 15000, 25000, 36000 };
                        int nomorItem[] = new int[100], jumlah[] = new int[100];
                        double harga[] = new double[100], hitungHargaAsli[] = new double[100], totalHarga = 0;
                        int j = 0;
                        System.out.println("=====Fitur utama pembayaran=====");
                        System.out.println("List jenis pelayanan :");
                        for (int k = 0; k < namaJenisPelayanan.length; k++) {
                            System.out
                                    .println((k + 1) + ". " + namaJenisPelayanan[k] + " - Rp" + hargaJenisPelayanan[k]);
                        }
                        System.out.println(
                                "Masukkan 0 pada Nomor item untuk mengakhiri transaksi dan menghitung total pembelian");

                        do {
                            System.out.print("Nomor item : ");
                            nomorItem[j] = sc.nextInt();
                            if (nomorItem[j] == 0 || nomorItem[j] > 3) {
                                break;
                            }
                            System.out.print("Jumlah: ");
                            jumlah[j] = sc.nextInt();
                            harga[j] = hargaJenisPelayanan[nomorItem[j] - 1] * jumlah[j];
                            hitungHargaAsli[j] = hargaAsli[nomorItem[j] - 1] * jumlah[j];
                            totalHarga += harga[j];
                            if (nomorItem[j] == 1) {
                                penjualanPotong[i] += harga[j];
                            } else if (nomorItem[j] == 2) {
                                penjualanRias[i] += harga[j];
                            } else if (nomorItem[j] == 3) {
                                penjualanPaket[i] += harga[j];
                            }
                            penjualanHarian[i] += totalHarga;
                            totalHargaAsliHarian[i] += hitungHargaAsli[j];
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
                        double jumlahDiskon = (totalHarga * diskon);
                        potonganDiskonHarian[i] += jumlahDiskon;
                        double keuntungan = bayar - totalHargaAsliHarian[i];
                        keuntunganHarian[i] += keuntungan;
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

                    case 2:
                        do {
                            // Fitur Membership
                            System.out.println("Menu membership");
                            System.out.println("1. Pendaftaran pelanggan membership");
                            System.out.println("2. Cek nomor membership pelanggan");
                            System.out.println("3. List daftar pelanggan membership");
                            System.out.println("0. Keluar");
                            menuMembership = sc.nextInt();

                            switch (menuMembership) {
                                case 1:
                                    if (jumlahPelanggan >= maxMembership) {
                                        System.out.println("Maaf, membership bulan ini sudah terisi semua.");
                                        break;
                                    }

                                    System.out.println("Pendaftaran Pelanggan Membership");
                                    System.out.print("Nama Pelanggan: ");
                                    String nama = sc.next();
                                    boolean namaSudahTerdaftar = false;
                                    for (int n = 0; n < jumlahPelanggan; n++) {
                                        if (nama.equals(namaPelanggan[n])) {
                                            namaSudahTerdaftar = true;
                                            break;
                                        }
                                    }
                                    if (!namaSudahTerdaftar) {
                                        // Generate nomor member secara acak
                                        String karakter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                                        StringBuilder nomorMemberBaru = new StringBuilder();

                                        for (int o = 0; o < 8; o++) {
                                            int index = acak.nextInt(karakter.length());
                                            nomorMemberBaru.append(karakter.charAt(index));
                                        }

                                        namaPelanggan[jumlahPelanggan] = nama;
                                        nomorMember[jumlahPelanggan] = nomorMemberBaru.toString();
                                        System.out.println("Pendaftaran berhasil!\n");
                                        System.out.println("Nama Pelanggan : " + namaPelanggan[jumlahPelanggan]);
                                        System.out.println("Nomor Member : " + nomorMember[jumlahPelanggan]);
                                        jumlahPelanggan++;
                                        break;
                                    } else {
                                        System.out.println("Nama pelanggan sudah terdaftar");
                                    }
                                    break;

                                case 2:
                                    System.out.println("Cek nomor membership");
                                    System.out.println("Masukkan nomor membership");
                                    String cariNomorMembership = sc.next();
                                    boolean nomorTerdaftar = false;
                                    for (int p = 0; p < jumlahPelanggan; p++) {
                                        if (cariNomorMembership.equals(nomorMember[p])) {
                                            System.out.println("Nama : " + namaPelanggan[p]);
                                            System.out.println("Nomor member : " + nomorMember[p]);
                                            System.out.println("Nomor terdaftar sebagai membership");
                                            nomorTerdaftar = true;
                                            break;
                                        }
                                    }
                                    if (!nomorTerdaftar) {
                                        System.out.println("Nomor tidak terdaftar sebagai membership");
                                    }
                                    break;

                                case 3:
                                    System.out.println("List daftar pelanggan membership");
                                    for (int l = 0; l < jumlahPelanggan; l++) {
                                        System.out.println("Pelanggan ke-" + (l + 1));
                                        System.out.println("Nama: " + namaPelanggan[l]);
                                        System.out.println("Nomor Member: " + nomorMember[l]);
                                        System.out.println("--------------------");
                                    }
                                    break;

                                case 0:
                                    kembaliKeMenu = true;
                                    break;

                                default:
                                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                                    break;
                            }
                        } while (menuMembership != 0);

                        if (kembaliKeMenu) {
                            kembaliKeMenu = false;
                        }
                        break;

                    case 3:
                        do {
                            // Laporan penjualan
                            System.out.println("Menu");
                            System.out.println("1. Laporan penjualan hari ini");
                            System.out.println("2. Laporan penjualan bulan ini (per 30 hari)");
                            System.out.println("0. Keluar");
                            System.out.println("Pilih menu");
                            menuLaporan = sc.nextInt();

                            switch (menuLaporan) {
                                case 1:
                                    System.out.println("Laporan penjualan hari ini");
                                    System.out.println("Hari ke-" + (i + 1));
                                    System.out.println("Kasir yang bertanggung jawab : " + (userKaryawan[i]));
                                    System.out.println("Penghasilan pelayanan potong : " + (penjualanPotong[i]));
                                    System.out.println("Penghasilan pelayanan rias : " + (penjualanRias[i]));
                                    System.out.println(
                                            "Penghasilan paket peayanan potong dan rias : " + (penjualanPaket[i]));
                                    System.out.println("Penghasilan bersih : " + (totalHargaAsliHarian[i]));
                                    System.out.println("Jumlah potongan diskon harian : " + (potonganDiskonHarian[i]));
                                    System.out.println("Keuntungan harian : " + (keuntunganHarian[i]));
                                    break;

                                case 2:
                                    System.out.println("Laporan penjualan bulan ini (per 30 hari)");
                                    for (int p = 0; p < penjualanHarian.length; p++) {
                                        System.out.println("Hari ke-" + (p + 1));
                                        System.out.println("Kasir yang bertanggung jawab : " + (userKaryawan[p]));
                                        System.out.println("Penghasilan pelayanan potong : " + (penjualanPotong[p]));
                                        System.out.println("Penghasilan pelayanan rias : " + (penjualanRias[p]));
                                        System.out.println(
                                                "Penghasilan paket peayanan potong dan rias : " + (penjualanPaket[p]));
                                        System.out.println("Penghasilan bersih : " + (totalHargaAsliHarian[p]));
                                        System.out.println(
                                                "Jumlah potongan diskon harian : " + (potonganDiskonHarian[p]));
                                        System.out.println("Keuntungan harian : " + (keuntunganHarian[p]));
                                    }
                                    break;

                                case 0:
                                    // Keluar dari fitur menu laporan
                                    kembaliKeMenu = true;
                                    break;

                                default:
                                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                                    break;
                            }
                        } while (menuLaporan != 0);

                        if (kembaliKeMenu) {
                            kembaliKeMenu = false;
                        }
                        break;

                    case 0:
                        // Keluar dari aplikasi
                        kembaliKeLogin = true;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                        break;
                }
            } while (menu != 0);

            // Jika kembali ke login, reset nilai kembaliKeLogin
            if (kembaliKeLogin) {
                kembaliKeLogin = false;
            }
        }
        sc.close();
    }
}
