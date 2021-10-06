//Masrik Dahir

import java.util.Scanner;
import static java.lang.Math.abs;

public class cmsc401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] A = new int[number*3];
        int num = 0;
        int stat = 0;
        for(int i = 0 ; i < number*2; i++) {
            if (i%2 == 0){
                stat = sc.nextInt();
            }
            else {
                int val = sc.nextInt();
                for(int j = 0 ; j < val; j++) {
                    A[num] = stat;
                    num++;
                }
            }
        }
        int not_zero = 0;
        for (int i = 0; i < number*3; i++){
            if (A[i] != 0){
                not_zero+=1;
            }
        }
        int B[] = new int[not_zero];
        for (int i = 0; i < not_zero; i++){
            B[i] = A[i];
        }
        int p = 0;
        int r = B.length-1;
        int middle_index = 0;
        if (B.length%2 == 1) {
            middle_index = (((B.length + 1) / 2) - 1);
        }
        else{
            middle_index = (B.length / 2) -1;
        }
        int median = Quicksort_median(B, p, r, middle_index)[middle_index];
        System.out.println(value(B,median));
    }


    public static int Partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++)
            if (A[j] <= x) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }

        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        return i + 1;
    }


    public static int[] Quicksort_median(int[] A, int p, int r, int middle_index){
        if (p<r) {
            int q = Partition(A, p, r);
            if (middle_index == q){
                return A;
            }
            if (middle_index < q){
                Quicksort_median(A, p, q - 1, middle_index);
            }
            else{
                Quicksort_median(A, q + 1, r, middle_index);
            }
        }
        return A;
    }


    public static int value(int[] nums, int j){
        int sum = 0;
        for (int num : nums) {
            int local_value = abs(num - j);
            sum += local_value;
        }
        return sum;
    }
}