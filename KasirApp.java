import java.util.Scanner;
import java.util.Random;

public class KasirApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double penjualanHarian[] = new double[30];
        int menu, maxMembership = 12;
        String[] namaPelanggan = new String[maxMembership];
        String[] nomorMember = new String[maxMembership];
        int jumlahPelanggan = 0;

        for (int i = 0; i < penjualanHarian.length; i++) {
            penjualanHarian[i] = 0;
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
                System.out.println("2. Pendaftaran membership");
                System.out.println("3. Daftar pelanggan membership");
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
                            penjualanHarian[i] += totalHarga;
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

                    case 2:
                        // Pendaftaran pelanggan membership
                        while (jumlahPelanggan < maxMembership) {
                            System.out.println("Pendaftaran Pelanggan Membership");
                            System.out.print("Nama Pelanggan: ");
                            String nama = sc.next();
                
                            // Memastikan nama pelanggan unik
                            if (isNamaPelangganUnique(nama, namaPelanggan, jumlahPelanggan)) {
                                // Generate nomor member secara acak
                                String nomorMemberBaru = generateNomorMember();
                                
                                namaPelanggan[jumlahPelanggan] = nama;
                                nomorMember[jumlahPelanggan] = nomorMemberBaru;
                                jumlahPelanggan++;
                
                                System.out.println("Pendaftaran berhasil!\n");
                            } else {
                                System.out.println("Nama pelanggan sudah terdaftar. Mohon coba lagi.\n");
                            }
                
                            System.out.print("Apakah ingin mendaftar pelanggan lagi? (y/n): ");
                            String jawaban = sc.nextLine();
                
                            if (!jawaban.equalsIgnoreCase("y")) {
                                break;
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\nData Pelanggan Membership:");
                        for (int l = 0; l < jumlahPelanggan; l++) {
                            System.out.println("Pelanggan ke-" + (l + 1));
                            System.out.println("Nama: " + namaPelanggan[l]);
                            System.out.println("Nomor Member: " + nomorMember[l]);
                            System.out.println("--------------------");
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

    // Fungsi untuk memeriksa apakah nama pelanggan sudah terdaftar
    private static boolean isNamaPelangganUnique(String nama, String[] namaPelanggan, int jumlahPelanggan) {
        for (int i = 0; i < jumlahPelanggan; i++) {
            if (nama.equals(namaPelanggan[i])) {
                return false;
            }
        }
        return true;
    }
     


    // Fungsi untuk memeriksa apakah nomor member sudah terdaftar
    /*private static boolean isNomorMemberUnique(String nomorMember, String[] nomorMemberArray, int jumlahPelanggan) {
        for (int i = 0; i < jumlahPelanggan; i++) {
            if (nomorMember.equals(nomorMemberArray[i])) {
                return false;
            }
        }
        return true;
    }*/

    // Fungsi untuk generate nomor member secara acak
    private static String generateNomorMember() {
        Random acak = new Random();
        String karakter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder nomorMemberBaru = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = acak.nextInt(karakter.length());
            nomorMemberBaru.append(karakter.charAt(index));
        }

        return nomorMemberBaru.toString();
    }
}
