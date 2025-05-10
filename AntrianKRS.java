public class AntrianKRS {
    private Mahasiswa[] data;
    private int front;
    private int rear;
    private int size;
    private int max = 10;
    private int jmlSudahDiproses;
    private int jmlMaxDPA = 30;
    
    public AntrianKRS() {
        data = new Mahasiswa[max];
        front = 0;
        rear = -1;
        size = 0;
        jmlSudahDiproses = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        if (!isEmpty()) {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Antrian berhasil dikosongkan");
        } else {
            System.out.println("Antrian sudah kosong");
        }
    }

    public void tambahAntrian(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian.");
    }

    public void prosesKRS() {
        if (size < 2) {
            System.out.println("Antrian kurang dari 2 mahasiswa.");
            return;
        }
        if (jmlSudahDiproses >= jmlMaxDPA) {
            System.out.println("DPA sudah mencapai batas maksimal mahasiswa yang dapat diproses (30).");
            return;
        }

        System.out.println("\nMemproses 2 mahasiswa:");
        for (int i = 0; i < 2; i++) {
            Mahasiswa mhs = data[front];
            System.out.print((i + 1) + ". ");
            mhs.tampilkanData();
            front = (front + 1) % max;
            size--;
            jmlSudahDiproses++;
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("\nDaftar Mahasiswa dalam Antrian:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void tampilkanDuaTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else if (size == 1) {
            System.out.println("\nHanya ada 1 mahasiswa dalam antrian:");
            data[front].tampilkanData();
        } else {
            System.out.println("\nDua mahasiswa terdepan:");
            for (int i = 0; i < 2 && i < size; i++) {
                int index = (front + i) % max;
                System.out.print((i + 1) + ". ");
                data[index].tampilkanData();
            }
        }
    }

    public void tampilkanTerakhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("\nMahasiswa terakhir dalam antrian:");
            data[rear].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size;
    }
    
    public int getJumlahSudahProses() {
        return jmlSudahDiproses;
    }
    
    public int getJumlahBelumProses() {
        return size;
    }
}