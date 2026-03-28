import java.util.Scanner;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhap so luong phan tu cua mang: ");
        int n = sc.nextInt();
        double[] a = new double[n];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            a[i] = sc.nextDouble();
            sum += a[i];
        }

        Arrays.sort(a);

        System.out.println("Mang sau khi sap xep: " + Arrays.toString(a));
        System.out.println("Tong: " + sum);
        System.out.println("Gia tri trung binh: " + (sum / n));
        
        sc.close();
    }
}