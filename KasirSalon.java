import java.util.Scanner;

public class KasirSalon {

    public static void main(String[] args) {

        // Scanner
        Scanner sc = new Scanner(System.in);

        // Variabel
        int jumlahBarang, jumlahJenis, i = 0;
        double harga, hargaBarang, diskon = 0, totalHarga = 0, bayar, uangDiterima, kembalian;
        String namaBarang, membership, user;

        // Input jumlah jenis barang yang dibeli
        System.out.printf("Masukkan jumlah jenis barang\t:\t");
        jumlahJenis = sc.nextInt();

        // Input membership
        System.out.printf("Punya membership? (y/t)\t\t:\t");
        membership = sc.next();

        // Jika memiliki membership
        if (membership.equalsIgnoreCase("y")) {
            // Input user
            System.out.printf("Masukkan user member\t\t:\t");
            user = sc.next();
            // Jika user benar
            if (user.equalsIgnoreCase("king1111") || user.equalsIgnoreCase("tatsumaki2222")
                    || user.equalsIgnoreCase("genos3333") || user.equalsIgnoreCase("saitama4444")) {
                // Perulangan untuk menghitung total harga
                while (i < jumlahJenis) {
                    // Input nama, harga, dan jumlah barang yang dibeli
                    System.out.printf("Masukkan nama barang\t\t:\t");
                    namaBarang = sc.next();
                    System.out.printf("Masukkan harga barang\t\t:\t");
                    hargaBarang = sc.nextDouble();
                    System.out.printf("Masukkan jumlah barang\t\t:\t");
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
                System.out.printf("Total harga yang perlu dibayar\t:\t" + bayar + "\n");
                // Input uang diterima untuk menghitung kembalian
                System.out.printf("Uang yang diterima\t\t:\t");
                uangDiterima = sc.nextDouble();

                // Syarat kembalian
                if (uangDiterima >= bayar) {
                    kembalian = uangDiterima - bayar;
                    System.out.printf("Kembalian\t\t\t:\t%f", kembalian);
                } else {
                    kembalian = bayar - uangDiterima;
                    System.out.printf("Uang kurang\t\t\t:\t%f", kembalian);
                }
            }
            // Jika input user salah
            else {
                System.out.printf("User salah");
            }
        }

        // Jika tidak memiliki membership
        else if (membership.equalsIgnoreCase("t")) {
            // Perulangan untuk menghitung total harga
            while (i < jumlahJenis) {
                // Input nama, harga, dan jumlah barang yang dibeli
                System.out.printf("Masukkan nama barang\t\t:\t");
                namaBarang = sc.next();
                System.out.printf("Masukkan harga barang\t\t:\t");
                hargaBarang = sc.nextDouble();
                System.out.printf("Masukkan jumlah barang\t\t:\t");
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
            System.out.printf("Total harga yang perlu dibayar\t:\t" + bayar + "\n");

            // Input uang diterima untuk menghitung kembalian
            System.out.printf("Uang yang diterima\t\t:\t");
            uangDiterima = sc.nextDouble();

            // Syarat kembalian
            if (uangDiterima >= bayar) {
                kembalian = uangDiterima - bayar;
                System.out.printf("Kembalian\t\t\t:\t%f", kembalian);
            } else {
                kembalian = bayar - uangDiterima;
                System.out.printf("Uang kurang\t\t\t:\t%f", kembalian);
            }

        }
        // Jika input membership salah
        else {
            System.out.printf("Input membership salah");
        }

        // Tutup scanner
        sc.close();
    }
}
