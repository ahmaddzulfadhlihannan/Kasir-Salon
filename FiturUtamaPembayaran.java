import java.util.Scanner;

public class FiturUtamaPembayaran {
    public static void main(String[] args) {

        // Scanner
        Scanner sc = new Scanner(System.in);

<<<<<<< HEAD
<<<<<<< HEAD
        System.out.print("Total pembelian : ");
        totalHrg = sc.nextDouble();
        System.out.print("Uang yang diterima : ");
=======
        //Masukkan jumlah jenis barang yang dibeli
        System.out.print("Masukkan jumlah jenis barang yang dibeli : ");
        int jumlahJenis = sc.nextInt();

        //Variabel
        String namaBarang[] = new String[jumlahJenis];
        int jumlahBarang[] = new int[jumlahJenis];
        double harga[] = new double[jumlahJenis], totalHarga[] = new double[jumlahJenis], totalPembelian = 0, uangDiterima, kembalian;

        //Pembelian
        for (int i = 0; i < jumlahJenis; i++) {
            System.out.print("Masukkan nama barang\t" + (i+1) + "\t\t:\t");
            namaBarang[i] = sc.next();
            System.out.print("Masukkan harga barang\t" + (i+1) + "\t\t:\t");
            harga[i] = sc.nextDouble();
            System.out.print("Masukkan jumlah barang\t" + (i+1) + "\t\t:\t");
            jumlahBarang[i] = sc.nextInt();
            //Perhitungan total harga dan total pembelian
            totalHarga[i] = (double) harga[i] * jumlahBarang[i];
            totalPembelian += totalHarga[i];
        }
        //Perhitungan uang kembalian
        System.out.println("-----------------------------------------------------------");
        System.out.println("Total pembelian\t:\t" + totalPembelian);
        System.out.print("Uang diterima\t:\t");
>>>>>>> 572be0473518c4b81b6c67bc8f8749ef1705be20
        uangDiterima = sc.nextDouble();
        kembalian = uangDiterima - totalPembelian;
        System.out.println("Uang kembalian\t:\t" + kembalian);
        System.out.println("-----------------------------------------------------------");

<<<<<<< HEAD
        if (totalHrg<uangDiterima) {
        uangKembalian=uangDiterima-totalHrg;
        System.out.print("Uang kembalian yang diterima: " +uangKembalian);
        } else if (totalHrg==uangDiterima) {
            System.out.print("Tidak ada kembalian");
        } else {
            uangKembalian=totalHrg-uangDiterima;
            System.out.print("Kembalian kurang: " +uangKembalian); 
=======
        //Struk pembelian
        System.out.printf("Nama Barang\tHarga Barang\tJumlah Barang\ttotal Harga\n");
        for (int i = 0; i < jumlahJenis; i++ ) {
            System.out.printf((i+1) + "." + namaBarang[i] + "\t\t" + harga[i] + "\t\t" + jumlahBarang[i] + "\t\t" + totalHarga[i] + "\n");
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Total pembelian\t:\t" + totalPembelian);
        System.out.println("Uang Diterima\t:\t" + uangDiterima);
        System.out.println("Kembalian\t:\t" + kembalian);
        System.out.println("----------Terima Kasih Telah Datang Ke Salon Kami----------");
>>>>>>> 572be0473518c4b81b6c67bc8f8749ef1705be20
=======
        // Masukkan jumlah jenis barang yang dibeli
        System.out.print("Masukkan jumlah jenis barang yang dibeli : ");
        int jumlahJenis = sc.nextInt();

        // Variabel
        String namaBarang[] = new String[jumlahJenis];
        int jumlahBarang[] = new int[jumlahJenis];
        double harga[] = new double[jumlahJenis], totalHarga[] = new double[jumlahJenis], totalPembelian = 0,
                uangDiterima, kembalian;

        // Transaksi pelanggan
        for (int i = 0; i < jumlahJenis; i++) {
            System.out.printf("Masukkan nama barang\t%d\t\t:\t", (i + 1));
            namaBarang[i] = sc.next();
            System.out.printf("Masukkan harga barang\t%d\t\t:\t", (i + 1));
            harga[i] = sc.nextDouble();
            System.out.printf("Masukkan jumlah barang\t%d\t\t:\t", (i + 1));
            jumlahBarang[i] = sc.nextInt();
            // Perhitungan total harga dan total pembelian
            totalHarga[i] = (double) harga[i] * jumlahBarang[i];
            totalPembelian += totalHarga[i];
        }
        // Perhitungan uang kembalian
        System.out.println("-----------------------------------------------------------");
        System.out.printf("Total pembelian\t:\t%.2f\n", totalPembelian);
        System.out.print("Uang diterima\t:\t");
        uangDiterima = sc.nextDouble();
        kembalian = uangDiterima - totalPembelian;
        System.out.printf("Uang kembalian\t:\t%.2f\n", kembalian);
        System.out.println("-----------------------------------------------------------");

        // Struk pembelian
        System.out.println("------------------------------------------------------------");
        System.out.printf("| %-15s | %-10s | %-10s | %-10s |\n", "Nama Barang", "Harga", "Jumlah", "Total");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < jumlahJenis; i++) {
            System.out.printf("| %-15s | %10.2f | %10d | %10.2f |\n", (i + 1) + ". " + namaBarang[i], harga[i],
                    jumlahBarang[i], totalHarga[i]);
        }
        System.out.println("------------------------------------------------------------");

        System.out.println("-----------------------------------------------------------");
        System.out.printf("Total pembelian\t:\t%.2f\n", totalPembelian);
        System.out.printf("Uang Diterima\t:\t%.2f\n", uangDiterima);
        System.out.printf("Kembalian\t:\t%.2f\n", kembalian);
        System.out.println("----------Terima Kasih Telah Datang Ke Salon Kami----------");
>>>>>>> 38f4eb562911e642bbad4ccd32f429e583d206af

        // Perulangan untuk mencetak detail setiap jenis barang
        for (int i = 0; i < jumlahJenis; i++) {
            // Cetak informasi dari array seperti namaBarang, harga, jumlahBarang,
            // totalHarga, dll.
        }

        sc.close();
    }
<<<<<<< HEAD
=======
}
>>>>>>> 38f4eb562911e642bbad4ccd32f429e583d206af
