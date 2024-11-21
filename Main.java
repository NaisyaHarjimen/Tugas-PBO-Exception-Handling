import java.util.Scanner;

// Kelas Dasar: Item
class Item {
    String kodeBarang;
    String namaBarang;
    double hargaBarang;

    // Konstruktor untuk kelas Item
    public Item(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }
}

// Kelas Turunan: Transaksi (Inheritance dari Item)
class Transaksi extends Item {
    String noFaktur;
    int jumlahBeli;
    double total;

    // Konstruktor untuk kelas Transaksi
    public Transaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang);  // Memanggil konstruktor kelas Item (Inheritance)
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
        this.total = hitungTotal();
    }

    // Metode untuk menghitung total dan menangani exception
    private double hitungTotal() {
        try {
            // Memeriksa apakah harga barang atau jumlah beli bernilai negatif atau nol
            if (hargaBarang <= 0 || jumlahBeli <= 0) {
                throw new IllegalArgumentException("Harga Barang dan Jumlah Beli harus bernilai positif.");
            }
            return hargaBarang * jumlahBeli;  // Menghitung total
        } catch (IllegalArgumentException e) {
            // Menangani exception jika input tidak valid
            System.out.println("Kesalahan: " + e.getMessage());  
            return 0;
        }
    }

    // Metode untuk menampilkan detail transaksi
    public void tampilkanTransaksi() {
        System.out.println("No Faktur: " + noFaktur);
        System.out.println("Kode Barang: " + kodeBarang);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Harga Barang: " + hargaBarang);
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total: " + total);
    }
}

// Kelas Utama
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data transaksi dari pengguna
        System.out.print("Masukkan No Faktur: ");
        String noFaktur = scanner.nextLine();
        System.out.print("Masukkan Kode Barang: ");
        String kodeBarang = scanner.nextLine();
        System.out.print("Masukkan Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Masukkan Harga Barang: ");
        double hargaBarang = scanner.nextDouble();
        scanner.nextLine();  // Memastikan scanner tidak melewatkan input berikutnya
        System.out.print("Masukkan Jumlah Beli: ");
        int jumlahBeli = scanner.nextInt();

        // Membuat objek Transaksi dan menampilkan detail transaksi
        Transaksi transaksi = new Transaksi(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);
        transaksi.tampilkanTransaksi();

        scanner.close();  // Menutup scanner untuk mencegah kebocoran memori
    }
}