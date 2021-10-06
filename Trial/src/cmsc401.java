//Masrik Dahir

import java.util.*;

public class cmsc401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] nums;
        int[] result = new int[number];
        for(int i = 0 ; i < number ; i++) {
            int range = sc.nextInt();
            nums = new int[range];
            for(int j = 0; j < range; j++){
                nums[j] = sc.nextInt();
            }

            if (nums[nums[nums.length-1]-1] > nums[nums[nums.length-2]-1]){
                result[i] = (nums[nums[nums.length-2]-1]);
            }
            else{
                result[i] = (nums[nums[nums.length-1]-1]);
            }
        }
        for(int k = 0; k < result.length; k++){
            System.out.println(result[k]);
        }

    }
}

