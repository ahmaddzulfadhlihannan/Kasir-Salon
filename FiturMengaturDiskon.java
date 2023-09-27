import java.util.Scanner;

public class FiturMengaturDiskon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totHarga, potDis, bayar;
        
        System.out.print("Total Pembelian  : ");
        totHarga = sc.nextDouble();

        if (totHarga>=300000) {
            potDis= totHarga*0.15;
        } else if (100000<= totHarga) {
            potDis= totHarga*0.10;
        } else if (60000<= totHarga) {
            potDis= totHarga*0.05;
        } else {
            potDis= 0;
        }

        bayar = totHarga-potDis;
        System.out.println("Potongan Diskon : " +potDis);
        System.out.println("Bayar           : " +bayar);
    }
}