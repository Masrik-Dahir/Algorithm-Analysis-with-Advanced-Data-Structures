//Masrik Dahir

import java.util.*;

public class cmsc401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] nums = new int[number];

        for(int i = 0 ; i < number ; i++) {
            nums[i] = sc.nextInt();
        }

        int first_candidate = -1;
        int first_count = 0;

        int second_candidate = -1;
        int second_count = 0;

        for (int ele: nums){
            if (first_count == 0){
                first_candidate = ele;
            }
            else if (second_count == 0){
                second_candidate = ele;
            }

            if (ele == first_candidate){
                first_count+=2;
            }
            if (ele == second_candidate){
                second_count+=2;
            }
            if (ele != first_candidate && ele != second_candidate){
                first_count--;
                second_count--;
            }

        }

        int first_actual_count = 0;
        int second_actual_count = 0;

        for (int ele: nums){
            if (ele == first_candidate) first_actual_count +=1;
            if (ele == second_candidate) second_actual_count +=1;
        }
        if (first_actual_count <= nums.length/3){
            first_candidate = -1;
        }
        if (second_actual_count <= nums.length/3 || first_candidate == second_candidate){
            second_candidate = -1;
        }

        //Output
        if (first_candidate != -1 && second_candidate == -1){
            System.out.println(first_candidate);
        }

        else if (first_candidate == -1 && second_candidate != -1){
            System.out.println(second_candidate);
        }

        else if (first_candidate != -1 && second_candidate != -1){
            System.out.println(first_candidate + " " + second_candidate);
        }

        else if (first_candidate == -1 && second_candidate == -1){
            System.out.println("-1");
        }
    }
}

