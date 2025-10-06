package Task3;

import java.util.Arrays;

public class MethodsAdvancedPractice {

    // Static variable
    private static int counter = 0;

    // Instance variable
    private String instanceName;

    // Constructor
    public MethodsAdvancedPractice(String name) {
        this.instanceName = name;
        counter++;
    }

    public static void main(String[] args) {
        System.out.println("=== METHOD SIGNATURE DAN DECLARATION ===");
        System.out.println(calculate(5, 10));
        System.out.println(calculate(2.5, 3.7));
        System.out.println(calculate(1, 2, 3));
        System.out.println(calculate("Halo", " Dunia"));

        System.out.println("\n=== METHOD OVERLOADING ===");
        print(42);
        print(3.14);
        print("Belajar Java");
        print(new int[]{1, 2, 3, 4});

        System.out.println("\n=== STATIC VS INSTANCE METHODS ===");
        System.out.println("Counter awal: " + getCounter());
        incrementCounter();
        System.out.println("Counter setelah increment: " + getCounter());
        MethodsAdvancedPractice obj = new MethodsAdvancedPractice("Objek1");
        obj.displayInfo();

        System.out.println("\n=== PASS BY VALUE - PRIMITIVES ===");
        int originalNumber = 10;
        System.out.println("Sebelum: " + originalNumber);
        modifyPrimitive(originalNumber);
        System.out.println("Sesudah: " + originalNumber);

        System.out.println("\n=== PASS BY VALUE OF REFERENCE - OBJECTS ===");
        int[] arr = {1, 2, 3};
        System.out.println("Sebelum: " + Arrays.toString(arr));
        modifyArray(arr);
        System.out.println("Sesudah: " + Arrays.toString(arr));

        int[] arr2 = {10, 20, 30};
        System.out.println("Sebelum reassign: " + Arrays.toString(arr2));
        reassignArray(arr2);
        System.out.println("Sesudah reassign: " + Arrays.toString(arr2));

        System.out.println("\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");
        int[] data = {5, 2, 8, 1};
        int[] sorted = sortArrayCopy(data);
        System.out.println("Original: " + Arrays.toString(data));
        System.out.println("Sorted: " + Arrays.toString(sorted));
        System.out.println("Stats: " + Arrays.toString(getArrayStats(data)));
        System.out.println("Merged: " + Arrays.toString(mergeArrays(data, new int[]{9, 10})));

        System.out.println("\n=== VARIABLE ARGUMENTS (VARARGS) ===");
        System.out.println("Sum(1,2,3,4): " + sum(1, 2, 3, 4));
        printInfo("Nilai UTS", 70, 80, 90);

        System.out.println("\n=== RECURSIVE METHODS ===");
        System.out.println("Faktorial 5 = " + factorial(5));
        System.out.println("Fibonacci(6) = " + fibonacci(6));

        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Binary search 5: index " + binarySearchRecursive(sortedArray, 5, 0, sortedArray.length - 1));

        System.out.println("\n=== METHOD CHAINING ===");
        Calculator calc = new Calculator(10);
        double hasil = calc.add(5).multiply(2).subtract(4).getResult();
        System.out.println("Hasil kalkulasi chaining: " + hasil);

        System.out.println("\n=== UTILITY STATIC METHODS ===");
        System.out.println("Power(2,3): " + MathUtils.power(2, 3));
        System.out.println("Apakah 7 prima? " + MathUtils.isPrime(7));
        System.out.println("GCD(24,36): " + MathUtils.gcd(24, 36));
        System.out.println("Reverse('Java'): " + StringUtils.reverse("Java"));
        System.out.println("Palindrome 'level'? " + StringUtils.isPalindrome("level"));
        System.out.println("Jumlah kata: " + StringUtils.countWords("Belajar Java dengan senang"));
        int[][] matrix = {{1, 2}, {3, 4}};
        ArrayUtils.printMatrix(matrix);
    }

    // ===== METHOD OVERLOADING =====
    public static int calculate(int a, int b) { return a + b; }
    public static double calculate(double a, double b) { return a + b; }
    public static int calculate(int a, int b, int c) { return a + b + c; }
    public static String calculate(String a, String b) { return a + b; }

    public static void print(int value) { System.out.println("Integer: " + value); }
    public static void print(double value) { System.out.println("Double: " + value); }
    public static void print(String value) { System.out.println("String: " + value); }
    public static void print(int[] array) { System.out.println("Array: " + Arrays.toString(array)); }

    // ===== STATIC VS INSTANCE =====
    public static int getCounter() { return counter; }
    public static void incrementCounter() { counter++; }
    public String getInstanceName() { return instanceName; }
    public void setInstanceName(String name) { this.instanceName = name; }
    public void displayInfo() {
        System.out.println("Instance name: " + instanceName);
        System.out.println("Static counter: " + counter);
    }

    // ===== PASS BY VALUE =====
    public static void modifyPrimitive(int number) {
        number += 10;
        System.out.println("Di dalam method: " + number);
    }
    public static void modifyArray(int[] array) {
        array[0] = 99;
        System.out.println("Di dalam method: " + Arrays.toString(array));
    }
    public static void reassignArray(int[] array) {
        array = new int[]{7, 7, 7};
        System.out.println("Reassigned di dalam method: " + Arrays.toString(array));
    }

    // ===== ARRAY METHODS =====
    public static int[] sortArrayCopy(int[] original) {
        int[] copy = Arrays.copyOf(original, original.length);
        Arrays.sort(copy);
        return copy;
    }
    public static double[] getArrayStats(int[] array) {
        int min = Arrays.stream(array).min().orElse(0);
        int max = Arrays.stream(array).max().orElse(0);
        double avg = Arrays.stream(array).average().orElse(0);
        return new double[]{min, max, avg};
    }
    public static int[] mergeArrays(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        System.arraycopy(a, 0, merged, 0, a.length);
        System.arraycopy(b, 0, merged, a.length, b.length);
        return merged;
    }

    // ===== VARARGS =====
    public static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }
    public static void printInfo(String title, int... values) {
        System.out.println(title + ": " + Arrays.toString(values));
    }

    // ===== RECURSION =====
    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (array[mid] == target) return mid;
        if (target < array[mid]) return binarySearchRecursive(array, target, left, mid - 1);
        else return binarySearchRecursive(array, target, mid + 1, right);
    }

    // ===== UTILITIES =====
    public static class MathUtils {
        public static double power(double base, int exp) {
            if (exp == 0) return 1;
            double result = 1;
            for (int i = 0; i < exp; i++) result *= base;
            return result;
        }
        public static boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++)
                if (n % i == 0) return false;
            return true;
        }
        public static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    public static class StringUtils {
        public static String reverse(String str) {
            return new StringBuilder(str).reverse().toString();
        }
        public static boolean isPalindrome(String str) {
            return str.equalsIgnoreCase(reverse(str));
        }
        public static int countWords(String str) {
            return str.trim().split("\\s+").length;
        }
    }

    public static class ArrayUtils {
        public static void printMatrix(int[][] matrix) {
            System.out.println("Matrix:");
            for (int[] row : matrix) System.out.println(Arrays.toString(row));
        }
        public static boolean areEqual(int[] a, int[] b) {
            return Arrays.equals(a, b);
        }
    }

    // ===== METHOD CHAINING =====
    public static class Calculator {
        private double value;
        public Calculator(double initial) { this.value = initial; }
        public Calculator add(double n) { this.value += n; return this; }
        public Calculator multiply(double n) { this.value *= n; return this; }
        public Calculator subtract(double n) { this.value -= n; return this; }
        public double getResult() { return value; }
    }
}
