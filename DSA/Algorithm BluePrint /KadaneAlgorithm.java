package DSA.AlgorithmBluePrint ;
//Question Leetcode 53 : Maximum Subarray 
public class KadaneAlgorithm {
    public static void main(String[] args) {
        int []arr = {-1,2,-5,4};

        int maxSoFar = arr[0];
        int currSoFar = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if(currSoFar < 0) currSoFar = 0;

            currSoFar += arr[i];

            if (currSoFar > maxSoFar)
                maxSoFar = currSoFar;
        }

        System.out.println(maxSoFar);
    }
}
