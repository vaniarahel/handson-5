package Task1;

import java.util.Arrays;
import java.util.Random;

public class ArraysDeepDivePractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Arrays Deep Dive
         */

        // ===== ARRAY MULTIDIMENSI DASAR =====
        System.out.println("=== ARRAY MULTIDIMENSI DASAR ===");

        int [][] matriks = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println("Menggunakan nested for loop:");
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                System.out.print(matriks[i][j] + " ");
            }
            System.out.println();
        }

        // Latihan 2: Array 2D papan catur
        String[][] catur = {
                {".", ".", "."},
                {".", ".", "."},
                {".", ".", "."}
        };
        catur[0][0] = "X";
        catur[1][1] = "X";
        catur[2][2] = "X";
        catur[0][2] = "O";
        catur[1][0] = "O";
        catur[2][1] = "O";

        System.out.println("\nMengeprint papan catur:");
        for (int i = 0; i < catur.length; i++) {
            for (int j = 0; j < catur[i].length; j++) {
                System.out.print(catur[i][j] + " ");
            }
            System.out.println();
        }

        // ===== ARRAY JAGGED =====
        System.out.println("\n=== ARRAY JAGGED (IRREGULAR) ===");
        int[][] baris = new int[4][];
        baris[0] = new int[2];
        baris[1] = new int[4];
        baris[2] = new int[3];
        baris[3] = new int[5];

        int angka = 1;
        for (int i = 0; i < baris.length; i++) {
            for (int j = 0; j < baris[i].length; j++) {
                baris[i][j] = angka++;
            }
        }
        System.out.println("Array jagged:");
        for (int i = 0; i < baris.length; i++) {
            System.out.print("Baris " + i + " (panjang " + baris[i].length + "): ");
            System.out.println(Arrays.toString(baris[i]));
        }

        // ===== OPERASI LANJUTAN PADA ARRAY =====
        System.out.println("\n=== OPERASI LANJUTAN PADA ARRAY ===");
        int[][] A = {
                {2, 4, 6},
                {1, 3, 5}
        };
        int[][] B = {
                {1, 1, 1},
                {2, 2, 2}
        };

        int[][] hasilTambah = addMatrices(A, B);
        int[][] hasilKali = multiplyByScalar(A, 2);

        System.out.println("Hasil penjumlahan matriks:");
        displayMatrix(hasilTambah);
        System.out.println("Hasil perkalian scalar (x2):");
        displayMatrix(hasilKali);

        // ===== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE =====
        System.out.println("\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array asli: " + Arrays.toString(numbers));

        int[] sorted = sortArray(numbers.clone());
        System.out.println("Setelah sort: " + Arrays.toString(sorted));

        int[] reversed = reverseArray(sorted);
        System.out.println("Setelah dibalik: " + Arrays.toString(reversed));

        int[] minMax = findMinMax(numbers);
        System.out.println("Nilai minimum dan maksimum: " + Arrays.toString(minMax));

        // ===== UTILITY METHODS JAVA.UTIL.ARRAYS =====
        System.out.println("\n=== UTILITY METHODS JAVA.UTIL.ARRAYS ===");
        int[] data = {5, 2, 8, 1, 9, 3};
        System.out.println("Array awal: " + Arrays.toString(data));

        Arrays.sort(data);
        System.out.println("Setelah sort: " + Arrays.toString(data));

        int index = Arrays.binarySearch(data, 8);
        System.out.println("Index elemen 8 (setelah sort): " + index);

        Arrays.fill(data, 7);
        System.out.println("Setelah fill dengan 7: " + Arrays.toString(data));

        int[] data2 = {7, 7, 7, 7, 7, 7};
        System.out.println("Bandingkan data dan data2: " + Arrays.equals(data, data2));

        int[] copy = Arrays.copyOf(data, 10);
        System.out.println("Copy dengan ukuran lebih besar: " + Arrays.toString(copy));

        // ===== ARRAY 3D DAN KOMPLEKS =====
        System.out.println("\n=== ARRAY 3D DAN KOMPLEKS ===");
        int[][][] tigaD = new int[2][3][4];
        int val = 1;
        for (int i = 0; i < tigaD.length; i++) {
            for (int j = 0; j < tigaD[i].length; j++) {
                for (int k = 0; k < tigaD[i][j].length; k++) {
                    tigaD[i][j][k] = val++;
                }
            }
        }

        for (int i = 0; i < tigaD.length; i++) {
            System.out.println("Layer " + i + ":");
            displayMatrix(tigaD[i]);
        }

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("\n=== SKENARIO APLIKASI NYATA ===");
        String[] namaMahasiswa = {"Alice", "Bob", "Charlie", "Diana", "Eva"};
        String[] mataKuliah = {"Math", "Physics", "Chemistry", "Biology"};
        int[][] nilai = new int[5][4];
        fillRandomGrades(nilai, 60, 100);

        System.out.printf("%-10s", "Nama");
        for (String mk : mataKuliah) System.out.printf("%10s", mk);
        System.out.printf("%10s%n", "Rata-rata");

        double tertinggi = 0;
        String namaTertinggi = "";
        for (int i = 0; i < nilai.length; i++) {
            double rata = calculateAverage(nilai[i]);
            System.out.printf("%-10s", namaMahasiswa[i]);
            for (int n : nilai[i]) System.out.printf("%10d", n);
            System.out.printf("%10.2f%n", rata);
            if (rata > tertinggi) {
                tertinggi = rata;
                namaTertinggi = namaMahasiswa[i];
            }
        }
        System.out.println("Mahasiswa dengan nilai tertinggi: " + namaTertinggi + " (" + tertinggi + ")");
    }

    // ===== IMPLEMENTASI METHODS =====
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyByScalar(int[][] matrix, int scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }

    public static int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static int[] reverseArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    public static int[] findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int n : arr) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        return new int[]{min, max};
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    public static void fillRandomGrades(int[][] grades, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                grades[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
    }

    public static double calculateAverage(int[] values) {
        int sum = 0;
        for (int v : values) sum += v;
        return (double) sum / values.length;
    }
}
