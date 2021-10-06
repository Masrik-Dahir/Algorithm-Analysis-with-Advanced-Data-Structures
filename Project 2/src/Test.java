import java.util.*;

import static java.lang.Math.abs;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] nums = new int[number];
        int[] value = new int[number];
        int num = 0;
        int val = 0;

//        Saving the house coordinate and the value in two arrays: nums and value
        for(int i = 0 ; i < number*2; i++) {
            if (i%2 == 0){
                nums[num] = sc.nextInt();
                num++;
            }
            else {
                value[val] = sc.nextInt();
                val++;
            }
        }

//        Finding the lowest and highest coordinates
        int high = 0;
        int low = nums[0];
        for (int i = 0; i < number; i++){
            int local = nums[i];
            if (local > high){
                high = local;
            }
            if (local < low){
                low = local;
            }
        }


        int lowest_sum = 0;
        int man = 0;
//        finding the value for all possible coordinates from y-lowest and y-higest
        for (int j = low; j<=high; j++){
            int sum = 0;
            for (int i = 0; i < number; i++){
                int local_value = Math.abs(nums[i] - j)*value[i];
                sum += local_value;
            }
            if (j == low){
                lowest_sum = sum;
            }
            if(lowest_sum>sum){
                lowest_sum = sum;
                man = j;
            }
        }
        System.out.println(man);
    }
}
