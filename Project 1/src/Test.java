//Masrik Dahir

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] nums = new int[number];

        for(int i = 0 ; i < number ; i++) {
            nums[i] = sc.nextInt();
        }
//        highest number in nums: to find the highest number for the range of reserved array
        int higest_number = -1;
        for(int i = 0 ; i < nums.length ; i++) {
            if (nums[i] > higest_number){
                higest_number = nums[i];
            }
        }
//        one-third number of nums: to compare with the number of occurrence
        int one_third = nums.length/3;

        int[] reserve = new int[higest_number+1];

        for (int i = 0; i < reserve.length; i++){
            reserve[i] = -1;
        }

        for (int i = 0; i < nums.length; i++){
            if (reserve[nums[i]] == -1){
                reserve[nums[i]] = 1;
            }
            else{
                reserve[nums[i]]+=1;
            }
        }

        int first_number = -1;
        int first_number_times = 0;
        int second_number = -1;
        int second_number_times = 0;
        for (int i = 0; i < reserve.length; i++){
            if (reserve[i] >= first_number_times){
                second_number = first_number;
                second_number_times = first_number_times;
                first_number = i;
                first_number_times = reserve[i];
            }
        }
        int temp = -1;
        int temp_times = 0;
        if (first_number >= second_number){

            temp = first_number;
            first_number = second_number;
            second_number = temp;

            temp_times = first_number_times;
            first_number_times = second_number_times;
            second_number_times = temp_times;
        }


        if (first_number_times <= one_third){
            first_number = -1;
        }
        if (second_number_times <= one_third){
            second_number = -1;
        }

        //Output
        if (first_number != -1 && second_number == -1){
            System.out.println(first_number);
        }

        else if (first_number == -1 && second_number != -1){
            System.out.println(second_number);
        }

        else if (first_number != -1 && second_number != -1){
            System.out.println(first_number + " " + second_number);
        }

        else if (first_number == -1 && second_number == -1){
            System.out.println("-1");
        }
    }
}

