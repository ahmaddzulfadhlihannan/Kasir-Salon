import java.util.Scanner;

public class KasirSalon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Variabel
        int jumlahBarang, jumlahJenis, i = 0;
        double harga, hargaBarang, diskon = 0, totalHarga = 0, bayar;
        String namaBarang, membership = "", user;

        // Deklarasi 1
        System.out.println("Masukkan jumlah jenis barang");
        jumlahJenis = sc.nextInt();

        // Perulangan

        System.out.println("Apakah pelanggan memiliki membership? (y/t)");
        membership = sc.next();

        if (membership.equalsIgnoreCase("y")) {
            System.out.println("Masukkan user member");
            user = sc.next();
            if (user.equalsIgnoreCase("1587")) {
                while (i < jumlahJenis) {

                    System.out.println("Masukkan nama barang");
                    namaBarang = sc.next();
                    System.out.println("Masukkan harga barang");
                    hargaBarang = sc.nextDouble();
                    System.out.println("Masukkan jumlah barang");
                    jumlahBarang = sc.nextInt();

                    harga = hargaBarang * jumlahBarang;
                    totalHarga += harga;
                    i++;
                }

            } else if (user.equalsIgnoreCase("5698")) {
                while (i < jumlahJenis) {

                    System.out.println("Masukkan nama barang");
                    namaBarang = sc.next();
                    System.out.println("Masukkan harga barang");
                    hargaBarang = sc.nextDouble();
                    System.out.println("Masukkan jumlah barang");
                    jumlahBarang = sc.nextInt();

                    harga = hargaBarang * jumlahBarang;
                    totalHarga += harga;
                    i++;
                }

            } else if (user.equalsIgnoreCase("5698")) {
                while (i < jumlahJenis) {

                    System.out.println("Masukkan nama barang");
                    namaBarang = sc.next();
                    System.out.println("Masukkan harga barang");
                    hargaBarang = sc.nextDouble();
                    System.out.println("Masukkan jumlah barang");
                    jumlahBarang = sc.nextInt();

                    harga = hargaBarang * jumlahBarang;
                    totalHarga += harga;
                    i++;
                }
            } else if (user.equalsIgnoreCase("5984")) {
                while (i < jumlahJenis) {

                    System.out.println("Masukkan nama barang");
                    namaBarang = sc.next();
                    System.out.println("Masukkan harga barang");
                    hargaBarang = sc.nextDouble();
                    System.out.println("Masukkan jumlah barang");
                    jumlahBarang = sc.nextInt();

                    harga = hargaBarang * jumlahBarang;
                    totalHarga += harga;
                    i++;
                }
            } else {
                System.out.println("User salah");
            }

            if (totalHarga >= 300000) {
                diskon = 0.2;
            } else if (totalHarga >= 100000) {
                diskon = 0.15;
            }
            bayar = totalHarga - (totalHarga * diskon);
            System.out.println("Total harga yang perlu dibayar : " + bayar);
        } else if (membership.equalsIgnoreCase("t")) {
            while (i < jumlahJenis) {

                System.out.println("Masukkan nama barang");
                namaBarang = sc.next();
                System.out.println("Masukkan harga barang");
                hargaBarang = sc.nextDouble();
                System.out.println("Masukkan jumlah barang");
                jumlahBarang = sc.nextInt();

                harga = hargaBarang * jumlahBarang;
                totalHarga += harga;
                i++;

            }
            if (totalHarga >= 350000) {
                diskon = 0.2;
            } else if (totalHarga >= 150000) {
                diskon = 0.15;
            }
            bayar = totalHarga - (totalHarga * diskon);
            System.out.println("Total harga yang perlu dibayar : " + bayar);

        } else {
            System.out.println("Input membership salah");
        }

        sc.close();
    }
}
