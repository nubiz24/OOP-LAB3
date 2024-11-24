import java.util.Scanner;

public class sortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("So luong phan tu mang: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("Cac phan tu mang:");
        for (int i = 0; i < n; i++) {
            System.out.print("phan tu " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        bubbleSort(numbers);

        System.out.println("mang da sap xep la: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        double average = (double) sum / numbers.length;

        System.out.println("Tong cua mang la: " + sum);
        System.out.println("Gia tri trung binh: " + average);

        scanner.close();
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
