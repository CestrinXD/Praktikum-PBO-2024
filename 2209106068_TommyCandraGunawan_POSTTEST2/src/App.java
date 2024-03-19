import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        ArrayList<Barang> dataBarang = new ArrayList<>();

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println("""
                        Menu
                        1. Tambah Data
                        2. Lihat Data
                        3. Ubah Data
                        4. Hapus Data
                        0. Exit
                    """);
            System.out.print("Masukkan Pilihan : ");
            String menu = br.readLine();
            System.out.println("======================");

            if (menu.equals("1")) {
                System.out.print("Masukkan Nama Barang : ");
                String nama = br.readLine();
                System.out.print("Masukkan Harga Barang : ");
                int harga = Integer.parseInt(br.readLine());
                System.out.print("Masukkan Deskripsi Barang : ");
                String deskripsi = br.readLine();

                Barang barangBaru = new Barang(nama, harga, deskripsi);
                dataBarang.add(barangBaru);
            } else if (menu.equals("2")) {
                for (int i = 0; i < dataBarang.size(); i++) {
                    System.out.println("Barang ke-" + (i+1));
                    dataBarang.get(i).tampil();
                    System.out.println("======================");
                }
            } else if (menu.equals("3")) {
                for (int i = 0; i < dataBarang.size(); i++) {
                    System.out.println("Barang ke-" + (i+1));
                    dataBarang.get(i).tampil();
                    System.out.println("======================");
                }
                System.out.print("Mau ubah data nomor berapa : ");
                int ubah = Integer.parseInt(br.readLine()) - 1;

                if (ubah < dataBarang.size() && ubah >= 0) {
                    System.out.print("Masukkan nama baru : ");
                    dataBarang.get(ubah).setNama(br.readLine());
                    System.out.print("Masukkan harga baru : ");
                    dataBarang.get(ubah).setHarga(Integer.parseInt(br.readLine()));
                    System.out.print("Masukkan deskripsi baru : ");
                    dataBarang.get(ubah).setDeskripsi(br.readLine());
                    System.out.println("\nBerhasil ubah data!");
                } else {
                    System.out.println("Input salah!!");
                }
            } else if (menu.equals("4")) {
                // Meminta nama barang yang akan dihapus dari pengguna
                System.out.print("Masukkan nama barang yang akan dihapus: ");
                String hapusNama = br.readLine();
                
                boolean barangDitemukan = false; // Tambahkan variabel boolean untuk menandai apakah barang ditemukan
                for (int i = 0; i < dataBarang.size(); i++) {
                    if (hapusNama.equals(dataBarang.get(i).getNama())) {
                        dataBarang.remove(i);
                        System.out.println("Barang berhasil dihapus!");
                        barangDitemukan = true; // Set variabel menjadi true jika barang ditemukan
                        break;
                    }
                }
                if (!barangDitemukan) { // Tampilkan pesan jika barang tidak ditemukan
                    System.out.println("Barang tidak ditemukan dalam inventaris.");
                }            
            
            } else if (menu.equals("0")) {
                break;
            } else {
                System.out.println("Input Salah!!");
            }
        }
    }
}