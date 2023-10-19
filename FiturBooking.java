import java.util.Scanner;

public class FiturBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nama, jenisBooking;
        int jam, banyakOrang;

        System.out.print("Masukkan banyak orang yang akan di rias atau potong: ");
        banyakOrang = sc.nextInt();

        int i = 0;

        while (i < banyakOrang) {
            System.out.println("Pilihan layanan yang akan di booking - Potong, Rias");
            System.out.print("Masukkan layanan orang ke-" + (i+1) + "           : ");
            jenisBooking = sc.next();
            System.out.print("Masukkan nama orang yang akan booking : ");
            nama = sc.next();

            if (jenisBooking.equalsIgnoreCase("potong")) {
                System.out.println("Pilih jam booking mulai dari pukul 7 hingga 20");
                System.out.print("Masukkan jam booking                  : ");
                jam = sc.nextInt();
                System.out.println("Potong dibooking oleh " + nama);
            } else if (jenisBooking.equalsIgnoreCase("rias")) {
                System.out.println("Pilih jam booking mulai dari pukul 7 hingga 20");
                System.out.print("Masukkan jam booking                  : ");
                jam = sc.nextInt();
                System.out.println("Rias dibooking oleh " + nama);
            } else {
                System.out.println("Inputan invalid");
                continue;
            }
            i++;
        }
    }
}