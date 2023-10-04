import java.util.Scanner;

public class FiturPelangganAktif {
    public static void main(String[] args) {

        //Scanner
        Scanner i = new Scanner(System.in);
        
        //Variabel
        String keaktifan, member, bonus;
        int jumDtg; 

        //Input
        System.out.print("Dalam sebulan datang\t:\t");
        jumDtg = i.nextInt();
        System.out.print("Membership\t\t:\t");
        member = i.next();

        //Pemilihan
        if (jumDtg >= 8) {
            keaktifan = "Sangat aktif";
            if (member.equalsIgnoreCase("member")) {
                bonus = "Pijat kepala 10 menit";
                 System.out.print("Keaktifan\t\t:\t" + keaktifan + "\n");
                 System.out.print("Bonus\t\t\t:\t" + bonus);
            }
            else if (member.equalsIgnoreCase("bukan")) {
                bonus = "Pijat kepala 7 menit";
                System.out.print("Keaktifan\t\t:\t" + keaktifan + "\n");
                System.out.print("Bonus\t\t\t:\t" + bonus);
            }
            else {
                System.out.print("member salah");
            }
           
        }
        else if (jumDtg >= 4 && jumDtg < 8) {
            keaktifan = "Aktif";
            if (member.equalsIgnoreCase("member")) {
                bonus = "Pijat kepala 8 menit";
                System.out.print("Keaktifan\t\t:\t" + keaktifan + "\n");
                System.out.print("Bonus\t\t\t:\t" + bonus);
            }
            else if (member.equalsIgnoreCase("bukan")) {
                bonus = "Pijat kepala 6 menit";
                System.out.print("Keaktifan\t\t:\t" + keaktifan + "\n");
                System.out.print("Bonus\t\t\t:\t" + bonus);
            }
            else {
                System.out.print("member salah");
            }
        }
        else if (jumDtg >= 2 && jumDtg < 4) {
            keaktifan = "Jarang";
            if (member.equalsIgnoreCase("member")) {
                bonus = "Pijat kepala 7 menit";
                System.out.print("Keaktifan\t\t:\t" + keaktifan + "\n");
                System.out.print("Bonus\t\t\t:\t" + bonus);
            }
            else if (member.equalsIgnoreCase("bukan")) {
                bonus = "Pijat kepala 5 menit";
                System.out.print("Keaktifan\t\t:\t" + keaktifan + "\n");
                System.out.print("Bonus\t\t\t:\t" + bonus);
            }
            else {
                System.out.print("member salah");
            }
        }
        else {
            keaktifan = "Tidak aktif";
            System.out.print("Keaktifan\t\t:\t" + keaktifan + "\n");
        }

        //Tutup scanner
        i.close();

    }
}
