import java.util.Scanner;

public class FiturUtamaPembayaran {
    public static void main(String[] args) {
        
        //Scannner
        Scanner sc = new Scanner(System.in);

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
        uangDiterima = sc.nextDouble();
        kembalian = uangDiterima - totalPembelian;
        System.out.println("Uang kembalian\t:\t" + kembalian);
        System.out.println("-----------------------------------------------------------");

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

        sc.close();
        } 
    }
