import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */

public class Combination_Sum_lc_sas1905 {
    static List<Integer> array = new ArrayList<>();
    static int N=0;
    static int target_sum=0;

    public static void main(String[] args) {

        List<Integer> input_array = new ArrayList<>();
        input_array.add(2);
        input_array.add(3);
        input_array.add(5);
        input_array.add(4);
        input_array.add(1);
        int target = 5;
        solve_ques(input_array,input_array.size(),target);
    }

    private static void solve_ques(List<Integer> input_array, int size, int target) {
        N = size;
        array = input_array;
        target_sum = target;
        List<Integer> ans = new ArrayList<>();
        solve_ques_recursion(0,ans,0);
    }

    private static void solve_ques_recursion(int idx, List<Integer> ans,int sum) {
        if(idx == N){
            if(sum==target_sum){
                ans.forEach((Integer value) -> System.out.print(" "+value));
                System.out.println();
            }
            return;
        }
        solve_ques_recursion(idx+1,ans,sum);
        for(int i=1;sum+(i*array.get(idx))<=target_sum;i++){
            for (int j=0;j<i;j++){
                ans.add(array.get(idx));
            }
            solve_ques_recursion(idx+1,ans,sum+(i* array.get(idx)));
            for (int j=0;j<i;j++){
                ans.remove(ans.size()-1);
            }
        }
        return;
    }
}
