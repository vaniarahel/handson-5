package Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CollectionsPractice {
    public static void main(String[] args) {

        // ===== PERBEDAAN ARRAY VS ARRAYLIST =====
        System.out.println("=== PERBEDAAN ARRAY VS ARRAYLIST ===");

        // Latihan 1: Demonstrasi keterbatasan array vs keunggulan ArrayList
        int[] arrayTetap = new int[3];
        arrayTetap[0] = 10;
        arrayTetap[1] = 20;
        arrayTetap[2] = 30;
        // arrayTetap[3] = 40; // ❌ Error karena ukuran tetap (fixed size)

        ArrayList<Integer> listDinamis = new ArrayList<>();
        listDinamis.add(10);
        listDinamis.add(20);
        listDinamis.add(30);
        listDinamis.add(40);
        listDinamis.add(50);

        System.out.println("Panjang array: " + arrayTetap.length);
        System.out.println("Ukuran ArrayList: " + listDinamis.size());
        // ➕ Array ukurannya tetap, ArrayList bisa bertambah dinamis

        // ===== GENERICS DASAR =====
        System.out.println("\n=== GENERICS DASAR ===");

        ArrayList tanpaGenerics = new ArrayList(); // raw type
        tanpaGenerics.add("Teks");
        tanpaGenerics.add(123);
        tanpaGenerics.add(45.6);
        System.out.println("Raw ArrayList: " + tanpaGenerics);

        ArrayList<String> listString = new ArrayList<>();
        listString.add("Satu");
        listString.add("Dua");
        listString.add("Tiga");
        System.out.println("ArrayList<String>: " + listString);

        ArrayList<Double> listDouble = new ArrayList<>();
        listDouble.add(3.14);
        listDouble.add(2.71);
        System.out.println("ArrayList<Double>: " + listDouble);

        // listString.add(100); // ❌ Error karena bukan String → inilah type safety

        // ===== OPERASI CRUD PADA ARRAYLIST =====
        System.out.println("\n=== OPERASI CRUD PADA ARRAYLIST ===");

        // Latihan 3: Create - Menambah data
        ArrayList<String> daftarMahasiswa = new ArrayList<>();
        daftarMahasiswa.add("Alice");
        daftarMahasiswa.add("Bob");
        daftarMahasiswa.add("Charlie");
        daftarMahasiswa.add("Diana");
        daftarMahasiswa.add("Eva");

        // Tambahkan mahasiswa di posisi tertentu
        daftarMahasiswa.add(2, "Frank");

        System.out.println("Daftar Mahasiswa Awal: " + daftarMahasiswa);

        // Read
        System.out.println("Mahasiswa pertama: " + daftarMahasiswa.get(0));
        System.out.println("Mahasiswa terakhir: " + daftarMahasiswa.get(daftarMahasiswa.size() - 1));
        System.out.println("Apakah ada Bob? " + daftarMahasiswa.contains("Bob"));
        System.out.println("Index dari Charlie: " + daftarMahasiswa.indexOf("Charlie"));
        System.out.println("Ukuran daftar: " + daftarMahasiswa.size());

        // Update
        daftarMahasiswa.set(1, "Bobby");
        System.out.println("Setelah update: " + daftarMahasiswa);

        // Delete
        daftarMahasiswa.remove(0); // hapus index 0
        daftarMahasiswa.remove("Eva"); // hapus berdasarkan nama
        System.out.println("Setelah penghapusan: " + daftarMahasiswa);

        // Clear
        daftarMahasiswa.clear();
        System.out.println("Setelah clear: " + daftarMahasiswa);
        System.out.println("Apakah kosong? " + daftarMahasiswa.isEmpty());
    }
}

