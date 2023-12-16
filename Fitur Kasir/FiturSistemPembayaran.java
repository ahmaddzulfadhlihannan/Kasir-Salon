import java.util.Scanner;
public class FiturSistemPembayaran {
    
    public static void pembayaranTunai(double total) {
        System.out.println("Pembayaran tunai dipilih.");
        System.out.println("Total Pembelian : " + total);
        System.out.println("Transaksi penjualan berhasil.");
    }

    public static void pembayaranQris(double total) {
        System.out.println("Pembayaran non-tunai menggunakan Qris dipilih.");
        System.out.println("Total Pembelian : " + total);
        System.out.println("Pindai Qris untuk menyelesaikan pembayaran.");
        System.out.println("Transaksi penjualan berhasil.");
    }

    public static void pembayaranTransferBank(double total) {
        System.out.println("Pembayaran non-tunai menggunakan transfer bank dipilih.");
        System.out.println("Total Pembelian : " + total);
        System.out.println("Silakan transfer ke rekening yang tertera.");
        System.out.println("Transaksi penjualan berhasil.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Total Pembelian : ");
        double totalPembelian = scanner.nextDouble();

        System.out.println("Metode pembayaran :");
        System.out.println("1. Tunai");
        System.out.println("2. Non-Tunai");
        System.out.print("Pilih metode pembayaran (1/2) : ");
        int metodePembayaran = scanner.nextInt();

        if (metodePembayaran == 1) {
            pembayaranTunai(totalPembelian);
        } else if (metodePembayaran == 2) {
            System.out.println("Pilih metode pembayaran Non-tunai :");
            System.out.println("1. Qris");
            System.out.println("2. Transfer Bank");
            System.out.print("Pilih metode pembayaran Non-Tunai (1/2) : ");
            int nonTunai = scanner.nextInt();

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

        scanner.close();
    }
}