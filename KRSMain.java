import java.util.Scanner;

public class KRSMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AntrianKRS antrianKRS = new AntrianKRS();
        int pilihan;

        do {
            System.out.println("\n=== Menu Antrian Persetujuan KRS ===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Proses KRS (2 Mahasiswa)");
            System.out.println("3. Lihat Semua Antrian");
            System.out.println("4. Lihat 2 Antrian Terdepan");
            System.out.println("5. Lihat Antrian Terakhir") ;
            System.out.println("6. Jumlah Antrian Saat Ini");
            System.out.println("7. Jumlah Sudah Proses KRS");
            System.out.println("8. Jumlah Belum Proses KRS");
            System.out.println("9. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM  : ");
                    String nim = input.nextLine();
                    System.out.print("Nama : ");
                    String nama = input.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = input.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = input.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nim, nama, prodi, kelas);
                    antrianKRS.tambahAntrian(mhs);
                    break;
                case 2:
                    antrianKRS.prosesKRS();
                    break;
                case 3:
                    antrianKRS.tampilkanSemua();
                    break;
                case 4:
                    antrianKRS.tampilkanDuaTerdepan();
                    break;
                case 5:
                    antrianKRS.tampilkanTerakhir();
                    break;
                case 6:
                    System.out.println("Jumlah antrianKRS saat ini: " + antrianKRS.getJumlahAntrian());
                    break;
                case 7:
                    System.out.println("Jumlah mahasiswa yang sudah proses KRS: " + antrianKRS.getJumlahSudahProses());
                    break;
                case 8:
                    System.out.println("Jumlah mahasiswa yang belum proses KRS: " + antrianKRS.getJumlahBelumProses());
                    break;
                case 9:
                    antrianKRS.clear();
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}