//Masrik Dahir

import java.util.Scanner;
import java.util.Arrays;

public class cmsc401 {

    static class Rod {
        private int _size;
        private int _cuts;
        private final int[] single_array;
        private final int[][] double_array;

        public Rod(int _size, int _cuts) {
            set_size(_size);
            set_cuts(_cuts);
            double_array = new int[_cuts][_cuts];
            this.single_array = new int[_cuts];

            for (int[] ints : double_array) {
                Arrays.fill(ints, -1);
            }
        }

        public void set_size(int _size) {
            this._size = _size;
        }

        public void set_cuts(int _cuts) {
            this._cuts = _cuts;
        }

        public void add(int index, int value) {
            single_array[index] = value;
        }

        public int get_cuts() {
            return _cuts;
        }

        public int lowest_cost() {
            return lowest_cost(0, _cuts -1, 0, _size);
        }

        public int lowest_cost(int left, int right, int start, int end) {

            if (right >= _cuts || left > right)
                return 0;

            if (left == right)
                return end - start;

            if (double_array[left][right] != -1)
                return double_array[left][right];

            int local_minimum_cost = Integer.MAX_VALUE;

            for(int i = left; i <= right; i++)
                local_minimum_cost = Math.min(end-start + lowest_cost(left, i-1, start, single_array[i]) + lowest_cost(i+1, right, single_array[i], end), local_minimum_cost);
            double_array[left][right] = local_minimum_cost;

            return local_minimum_cost;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int _size = input.nextInt();
        int _cuts = input.nextInt();
        Rod first = new Rod(_size, _cuts);

        for (int i = 0; i < first.get_cuts(); i++)
            first.add(i, input.nextInt());

        input.close();
        System.out.println(first.lowest_cost());
    }
}