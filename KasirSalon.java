import java.util.Scanner;

public class KasirSalon {

    public static void main(String[] args) {

        // Scanner
        Scanner sc = new Scanner(System.in);

        // Variabel
        int jumlahBarang, jumlahJenis, i = 0;
        double harga, hargaBarang, diskon = 0, totalHarga = 0, bayar, uangDiterima, kembalian;
        String namaBarang, membership = "", user;

        // Input jumlah jenis barang yang dibeli
        System.out.println("Masukkan jumlah jenis barang");
        jumlahJenis = sc.nextInt();

        // Input membership
        System.out.println("Apakah pelanggan memiliki membership? (y/t)");
        membership = sc.next();

        // Jika memiliki membership
        if (membership.equalsIgnoreCase("y")) {
            // Input user
            System.out.println("Masukkan user member");
            user = sc.next();
            // Jika user benar
            if (user.equalsIgnoreCase("king1111") || user.equalsIgnoreCase("tatsumaki2222")
                    || user.equalsIgnoreCase("genos3333") || user.equalsIgnoreCase("saitama4444")) {
                // Perulangan untuk menghitung total harga
                while (i < jumlahJenis) {
                    // Input nama, harga, dan jumlah barang yang dibeli
                    System.out.println("Masukkan nama barang");
                    namaBarang = sc.next();
                    System.out.println("Masukkan harga barang");
                    hargaBarang = sc.nextDouble();
                    System.out.println("Masukkan jumlah barang");
                    jumlahBarang = sc.nextInt();

                    // Perhitungan harga dan total harga
                    harga = hargaBarang * jumlahBarang;
                    totalHarga += harga;
                    // Menambahkan nilai 1 untuk variabell i
                    i++;
                }

                // Syarat diskon
                if (totalHarga >= 300000) {
                    diskon = 0.2;
                } else if (totalHarga >= 100000) {
                    diskon = 0.15;
                }

                // Perhitungan bayar
                bayar = totalHarga - (totalHarga * diskon);
                System.out.println("Total harga yang perlu dibayar : " + bayar);
                // Input uang diterima untuk menghitung kembalian
                System.out.println("Uang yang diterima");
                uangDiterima = sc.nextDouble();

                // Syarat kembalian
                if (uangDiterima >= bayar) {
                    kembalian = uangDiterima - bayar;
                    System.out.printf("Kembalian %.2f", kembalian);
                } else {
                    kembalian = bayar - uangDiterima;
                    System.out.printf("Uang kurang %.2f", kembalian);
                }
            }
            // Jika input user salah
            else {
                System.out.println("User salah");
            }
        }

        // Jika tidak memiliki membership
        else if (membership.equalsIgnoreCase("t")) {
            // Perulangan untuk menghitung total harga
            while (i < jumlahJenis) {
                // Input nama, harga, dan jumlah barang yang dibeli
                System.out.println("Masukkan nama barang");
                namaBarang = sc.next();
                System.out.println("Masukkan harga barang");
                hargaBarang = sc.nextDouble();
                System.out.println("Masukkan jumlah barang");
                jumlahBarang = sc.nextInt();

                // Perhitungan harga dan total harga
                harga = hargaBarang * jumlahBarang;
                totalHarga += harga;

                // Menambahkan nilai 1 untuk variabell i
                i++;
            }

            // Syarat diskon
            if (totalHarga >= 350000) {
                diskon = 0.2;
            } else if (totalHarga >= 150000) {
                diskon = 0.15;
            }

            // Perhitungan bayar
            bayar = totalHarga - (totalHarga * diskon);
            System.out.println("Total harga yang perlu dibayar : " + bayar);

            // Input uang diterima untuk menghitung kembalian
            System.out.println("Uang yang diterima");
            uangDiterima = sc.nextDouble();

            // Syarat kembalian
            if (uangDiterima >= bayar) {
                kembalian = uangDiterima - bayar;
                System.out.printf("Kembalian %.2f", kembalian);
            } else {
                kembalian = bayar - uangDiterima;
                System.out.printf("Uang kurang %.2f", kembalian);
            }

        }
        // Jika input membership salah
        else {
            System.out.println("Input membership salah");
        }

        // Tutup scanner
        sc.close();
    }
}
