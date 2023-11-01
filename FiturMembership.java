import java.util.Scanner;

public class FiturMembership {
    public static void main(String[] args) {
        java.util.Scanner sc = new Scanner(System.in);
        String member;
        int totHarga, hargaAkhir;
        double diskon = 0;

        System.out.print("membership atau bukan          : ");
        member = sc.nextLine();
        System.out.print("Masukkan total harga pembelian : ");
        totHarga = sc.nextInt();

        if (member.equalsIgnoreCase("membership")) {
            if (totHarga >= 300000) {
                diskon = 0.2;
            } else if (totHarga >= 100000) {
                    diskon = 0.15;
                } else {
                    diskon = 0;
            }
            hargaAkhir = (int) (totHarga - (totHarga * diskon));
            System.out.println("Total harga yang perlu dibayar : " + hargaAkhir);
        } else if (member.equalsIgnoreCase("bukan")) {
            if (totHarga >= 150000) {
                diskon = 0.02;
            } else if (totHarga >= 80000) {
                    diskon = 0.005;
                } else {
                    diskon = 0;
            }
        hargaAkhir = (int) (totHarga - (totHarga * diskon));
        System.out.println("Total harga yang perlu dibayar : " + hargaAkhir);
        } else {
            System.out.println("Bukan pelanggan");
        }
    }
}
