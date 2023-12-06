import java.util.Scanner;
public class FiturMembership {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlahTransaksi;

        System.out.print("Masukkan jumlah transaksi: ");
        jumlahTransaksi = sc.nextInt();

        String[] member = new String[jumlahTransaksi];
        int[] totHarga = new int[jumlahTransaksi];
        double[] diskon = new double[jumlahTransaksi];
        int[] hargaAkhir = new int[jumlahTransaksi];

        for (int i = 0; i < jumlahTransaksi; i++) {
            System.out.print("Membership atau bukan (transaksi ke-" + (i + 1) + "): ");
            member[i] = sc.next();
            
            if (member[i].equalsIgnoreCase("membership") || member[i].equalsIgnoreCase("bukan")) {
                System.out.print("Masukkan total harga pembelian (transaksi ke-" + (i + 1) + "): ");
                totHarga[i] = sc.nextInt();
            } else {
                System.out.println("Jenis keanggotaan tidak valid (transaksi ke-" + (i + 1) + ")");
                continue;
            }
        }

        for (int i = 0; i < jumlahTransaksi; i++) {
            if (member[i].equalsIgnoreCase("membership")) {
                if (totHarga[i] >= 300000) {
                    diskon[i] = 0.2;
                } else if (totHarga[i] >= 100000) {
                    diskon[i] = 0.15;
                } else {
                    diskon[i] = 0;
                }
            } else if (member[i].equalsIgnoreCase("bukan")) {
                if (totHarga[i] >= 150000) {
                    diskon[i] = 0.02;
                } else if (totHarga[i] >= 80000) {
                    diskon[i] = 0.005;
                } else {
                    diskon[i] = 0;
                }
            } else {
                System.out.println("Bukan pelanggan (transaksi ke-" + (i + 1) + ")");
                continue;
            }

            hargaAkhir[i] = (int) (totHarga[i] - (totHarga[i] * diskon[i]));
            System.out.println("\nTotal harga yang perlu dibayar (transaksi ke-" + (i + 1) + "): " + hargaAkhir[i]);
        }
    }
}
