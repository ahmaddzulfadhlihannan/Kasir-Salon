import java.util.Scanner;

public class FiturMengaturDiskon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Jumlah Transaksi: ");
        int jumlahTransaksi = sc.nextInt();

        double[][] dataTransaksi = new double[jumlahTransaksi][3];

        for (int i = 0; i < jumlahTransaksi; i++) {
            System.out.println("\nTransaksi ke-" + (i + 1));

            System.out.print("Total Pembelian : ");
            dataTransaksi[i][0] = sc.nextDouble();
            dataTransaksi[i][1] = Diskon(dataTransaksi[i][0]);
            dataTransaksi[i][2] = dataTransaksi[i][0] - dataTransaksi[i][1];
        }

        System.out.println("\nHasil Transaksi:");
        for (int i = 0; i < jumlahTransaksi; i++) {
            System.out.println("\nTransaksi ke-" + (i + 1));
            System.out.println("Potongan Diskon : " + dataTransaksi[i][1]);
            System.out.println("Bayar           : " + dataTransaksi[i][2]);
        }

        sc.close();
    }

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
