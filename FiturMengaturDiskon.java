import java.util.Scanner;

public class FiturMengaturDiskon {
    public static void main(String[] args) {
        
        //Scanner
        Scanner sc = new Scanner(System.in);
        
        //Variabel
        double totHarga, potDis, bayar;
        
        //Input total pembelian
        System.out.print("Total Pembelian  : ");
        totHarga = sc.nextDouble();

        //Ketentuan diskon
        if (totHarga>=300000) {
            potDis= totHarga*0.15;
        } else if (100000<= totHarga) {
            potDis= totHarga*0.10;
        } else if (60000<= totHarga) {
            potDis= totHarga*0.05;
        } else {
            potDis= 0;
        }

        //bayar
        bayar = totHarga-potDis;
        
        //Riwayat diskon
        System.out.println("Potongan Diskon : " +potDis);
        System.out.println("Bayar           : " +bayar);

        sc.close();
    }
}