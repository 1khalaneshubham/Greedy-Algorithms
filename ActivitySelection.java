import java.util.*;

public class ActivitySelection {

    // TC = O(n)
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = { 2,4,6,7,9,9};

        // Sorting
        int Activities[][] = new int[start.length][3];
        for(int i = 0; i<start.length; i++){
            Activities[i][0] = i;
            Activities[i][1] = start[i];
            Activities[i][2] = end[i];
        }
        // lambda function -> shortform
        Arrays.sort(Activities,Comparator.comparingDouble(o -> o[2]));

        // end time basis Sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st Activity
        maxAct = 1;
        ans.add(Activities[0][0]);
        int lastEnd = Activities[0][2];
        for(int i = 0; i<end.length; i++){
             if(Activities[i][1]>= lastEnd){
                // Activity select
                maxAct++;
                ans.add(Activities[i][0]);
               lastEnd = Activities[i][2];
            }
        }

        System.out.println("Max Activities = "+maxAct);
        for(int i = 0; i<ans.size(); i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}