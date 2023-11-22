import java.util.Scanner;

public class FiturMengaturDiskon {
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
    
    public static void main(String[] args) {
        // Scanner
        Scanner sc = new Scanner(System.in);
    
        // Variabel
        double totalHarga, bayar;
    
        // Input total pembelian
        System.out.print("Total Pembelian : ");
        totalHarga = sc.nextDouble();
    
        // Ketentuan diskon
        double potonganDiskon = Diskon(totalHarga);
    
        // Bayar
        bayar = totalHarga - potonganDiskon;
    
        // Riwayat diskon
        System.out.println("Potongan Diskon : " + potonganDiskon);
        System.out.println("Bayar           : " + bayar);
    
        sc.close();
    }
}