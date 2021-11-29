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

        public void add(int i, int cutPoint) {
            single_array[i] = cutPoint;
        }

        public int get_cuts() {
            return _cuts;
        }

        public int lowest_cost() {
            return lowest_cost(0, _cuts -1, 0, _size);
        }

        public int lowest_cost(int leftCutIndex, int rightCutIndex, int segmentStart, int segmentEnd) {

            if (rightCutIndex >= _cuts || leftCutIndex > rightCutIndex)
                return 0;

            if (leftCutIndex == rightCutIndex)
                return segmentEnd - segmentStart;

            if (double_array[leftCutIndex][rightCutIndex] != -1)
                return double_array[leftCutIndex][rightCutIndex];

            int currentMin = Integer.MAX_VALUE;

            for(int i = leftCutIndex; i <= rightCutIndex; i++)
                currentMin = Math.min(segmentEnd-segmentStart + lowest_cost(leftCutIndex, i-1, segmentStart, single_array[i]) + lowest_cost(i+1, rightCutIndex, single_array[i], segmentEnd), currentMin);
            double_array[leftCutIndex][rightCutIndex] = currentMin;

            return currentMin;
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