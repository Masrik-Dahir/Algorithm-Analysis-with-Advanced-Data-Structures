//Masrik Dahir

import java.util.Scanner;
import java.util.Arrays;

public class cmsc401 {

    static class Rod {
        private int rodSize;
        private int numCutPoints;
        private int[] m;
        private int[][] dp;

        public Rod(int rodSize, int numCutPoints) {
            setRodSize(rodSize);
            setNumCutPoints(numCutPoints);

            dp = new int[numCutPoints][numCutPoints];
            this.m = new int[numCutPoints];

            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
        }

        public void setRodSize(int rodSize) {
            this.rodSize = rodSize;
        }

        public void setNumCutPoints(int numCutPoints) {
            this.numCutPoints = numCutPoints;
        }

        public void addCutPoint(int i, int cutPoint) {
            m[i] = cutPoint;
            quickSort(m,0, m.length - 1);
        }

        public int getNumCutPoints() {
            return numCutPoints;
        }

        public int minimumCost() {
            return minimumCost(0, numCutPoints-1, 0, rodSize);
        }

        public int minimumCost(int leftCutIndex, int rightCutIndex, int segmentStart, int segmentEnd) {

            if (rightCutIndex >= numCutPoints || leftCutIndex > rightCutIndex)
                return 0;

            if (leftCutIndex == rightCutIndex)
                return segmentEnd - segmentStart;

            if (dp[leftCutIndex][rightCutIndex] != -1)
                return dp[leftCutIndex][rightCutIndex];

            int currentMin = Integer.MAX_VALUE;

            for(int i = leftCutIndex; i <= rightCutIndex; i++)
                currentMin = Math.min(segmentEnd-segmentStart + minimumCost(leftCutIndex, i-1, segmentStart, m[i]) + minimumCost(i+1, rightCutIndex, m[i], segmentEnd), currentMin);
            dp[leftCutIndex][rightCutIndex] = currentMin;

            return currentMin;
        }

        static void swap(int[] arr, int i, int j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


        static int partition(int[] arr, int low, int high)
        {

            int pivot = arr[high];
            int i = (low - 1);

            for(int j = low; j <= high - 1; j++)
            {
                if (arr[j] < pivot)
                {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return (i + 1);
        }

        static void quickSort(int[] arr, int low, int high)
        {
            if (low < high)
            {

                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rodSize = in.nextInt();

        int m = in.nextInt();

        Rod rod = new Rod(rodSize, m);

        for (int i = 0; i < rod.getNumCutPoints(); i++)
            rod.addCutPoint(i, in.nextInt());

        in.close();


        System.out.println(rod.minimumCost());
    }
}