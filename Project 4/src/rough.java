import java.util.*;

public class rough {
    public static ArrayList<List<java.lang.Integer>> n = new ArrayList<>();
    public static ArrayList<Integer> values = new ArrayList<>();
    public static int _size;
    public static int _cuts;

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        _size = input.nextInt();
        _cuts = input.nextInt();
        int[] arr = new int[_cuts];
        for (int i = 0; i<_cuts;i++){
            arr[i] = input.nextInt();
        }

        int result = rough.value(_size, arr);
        System.out.println(result);
        ArrayList<Integer> a = toArrayList(arr);
        rough.permute(a, 0);

        Collections.sort(values);
        System.out.println(values.get(0));

    }


    public static int value(int size, int[] arr){
        int cost  = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(size);
        for (int i = 0; i < arr.length; i++){
            a.add(arr[i]);
            Collections.sort(a);

            for (int j = 0; j < a.size(); j++){
                if (a.get(j) == arr[i]){
                    cost += a.get(j+1) - a.get(j-1);
                }
            }
        }
        int[] result = new int[a.size()];
        for (int i=0; i<a.size(); i++){
            result[i] = a.get(i);
        }
        return cost;
    }

    public static int[] toArray(List<Integer> a){
        int[] result = new int[a.size()];
        for (int i=0; i<a.size(); i++){
            result[i] = a.get(i);
        }
        return result;
    }

    public static ArrayList<Integer> toArrayList(int[] arr){
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i=0; i<arr.length; i++){
            a.add(arr[i]);
        }
        return a;
    }


    static ArrayList<List<Integer>> permute(List<Integer> arr, int k){
//        for(int i = k; i < arr.size(); i++){
//            java.util.Collections.swap(arr, i, k);
//            permute(arr, k+1, _size);
//            java.util.Collections.swap(arr, k, i);
//        }
//        if (k == arr.size() -1){
//            int value = value(_size, toArray(arr));
//            System.out.println(java.util.Arrays.toString(arr.toArray()));
//            System.out.println(value);
//            n.add(value);
//            Collections.sort(n);
//
//        }
//        return n.get(0);


        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            System.out.println(java.util.Arrays.toString(arr.toArray()));
            int value = value(_size, toArray(arr));
            System.out.println(value);
            values.add(value);
        }
        return n;
    }

}
