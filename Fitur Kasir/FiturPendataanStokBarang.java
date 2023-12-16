import java.util.Scanner;
public class FiturPendataanStokBarang {
    static String[] kategoriBarang = {"Perawatan Rambut", "Rias Wajah"};
    static String[][] barang = {
            {"Shampoo dan Conditioner", "Hair Mask", "Serum dan Minyak Rambut", "Hair Spray dan Gel", "Cat Rambut (Hair Dye)", "Obat rebonding/Smoothing/Krimbat"},
            {"Bedak dan Foundation", "Eyeliner", "Eyeshadow", "Mascara", "Lipstik dan Lip Gloss", "Makeup Remover"}
    };
    static int[][] stok = new int[2][6];

    public static void main(String[] args) {
        pengaturanStok();
    }

    static void pengaturanStok() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Lihat Stok Barang");
            System.out.println("2. Input Stok Barang");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    lihatStok();
                    break;
                case 2:
                    inputStok();
                    break;
                case 3:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 3);
    }

    static void lihatStok() {
        System.out.println("Stok Barang:");
        for (int kategori = 0; kategori < kategoriBarang.length; kategori++) {
            System.out.println("Kategori: " + kategoriBarang[kategori]);
            for (int i = 0; i < barang[kategori].length; i++) {
                System.out.println((i + 1) + ". " + barang[kategori][i] + ": " + stok[kategori][i]);
            }
            System.out.println();
        }
    }

    static void inputStok() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Stok Barang:");
        for (int kategori = 0; kategori < kategoriBarang.length; kategori++) {
            System.out.println("Kategori: " + kategoriBarang[kategori]);
            for (int i = 0; i < barang[kategori].length; i++) {
                System.out.print("Masukkan jumlah tambahan stok " + barang[kategori][i] + ": ");
                int tambahanStok = scanner.nextInt();
                stok[kategori][i] += tambahanStok;
            }
            System.out.println();
        }

        System.out.println("Input stok berhasil.");
    }
}
