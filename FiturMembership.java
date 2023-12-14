import java.util.Scanner;

public class FiturMembership {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Apakah Anda sudah menjadi anggota membership? (y/t)");
        String isMember = sc.next();

        String[][] memberNames = {
            {"evan", "ilut", "hanan", "ayu"}
        };

        if (isMember.equalsIgnoreCase("y")) {
            System.out.print("Masukkan nama keanggotaan membership: ");
            String namaMember = sc.next();

            System.out.print("Masukkan total harga pembelian: ");
            int totHarga = sc.nextInt();

            double diskon = 0;
            if (totHarga >= 300000) {
                diskon = 0.2;
            } else if (totHarga >= 100000) {
                diskon = 0.15;
            }

            int hargaAkhir = (int) (totHarga - (totHarga * diskon));

            System.out.println("Transaksi");
            System.out.println("Nama: " + namaMember);
            System.out.println("Total harga: " + totHarga);
            System.out.println("Diskon: " + diskon);
            System.out.println("Harga akhir: " + hargaAkhir);

        } else if (isMember.equalsIgnoreCase("t")) {
            System.out.println("Anda tidak menjadi member. Apakah ingin membuat member? (y/t)");
            String createMember = sc.next();

            if (createMember.equalsIgnoreCase("y")) {
                System.out.print("Masukkan nama keanggotaan membership: ");
                String namaMember = sc.next();

                System.out.println("Member berhasil dibuat!");
            }

            System.out.print("Masukkan total harga pembelian: ");
            int totHarga = sc.nextInt();

            double diskon = 0;
            if (totHarga >= 300000) {
                diskon = 0.2;
            } else if (totHarga >= 100000) {
                diskon = 0.15;
            }

            int hargaAkhir = (int) (totHarga - (totHarga * diskon));

            System.out.println("Transaksi");
            System.out.println("Total harga: " + totHarga);
            System.out.println("Diskon: " + diskon);
            System.out.println("Harga akhir: " + hargaAkhir);

        } else if (isMember.equalsIgnoreCase("t")) {
            System.out.print("Masukkan total harga pembelian: ");
            int totHarga = sc.nextInt();

            double diskon = 0;
            if (totHarga >= 150000) {
                diskon = 0.02;
            } else if (totHarga >= 80000) {
                diskon = 0.005;
            }

            int hargaAkhir = (int) (totHarga - (totHarga * diskon));

            System.out.println("Transaksi");
            System.out.println("Total harga: " + totHarga);
            System.out.println("Diskon: " + diskon);
            System.out.println("Harga akhir: " + hargaAkhir);

        } else {
            System.out.println("Input tidak valid");
        }
    }
}
