import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutation_lc_sas1905 {
      static int N=0;
      static List<Integer> given_list = new ArrayList<>();

    public static void main(String[] args) {
         List<Integer> given = new ArrayList<>();
         given.add(1);
         given.add(2);
         given.add(2);
         solve_ques(given);
    }

    private static void solve_ques(List<Integer> given) {
        N = given.size();
        given_list = given;
        permute_with_recursion(given_list,0,N-1);
    }

    private static void permute_with_recursion(List<Integer> given_list, int lo, int hi) {
        if(lo == hi){
            given_list.forEach((Integer value) -> System.out.print(value+""));
            System.out.println();
            return;
        }
        for(int i=lo;i<=hi;i++){
            boolean Swappable = isSwappable(given_list,lo,i); // For Handling Duplicate Permutations,Remove this if all the elements are distinct
            if(Swappable) {
                Collections.swap(given_list, lo, i);
                permute_with_recursion(given_list, lo + 1, hi);
                Collections.swap(given_list, lo, i);
            }
        }
        return;
    }

    private static boolean isSwappable(List<Integer> given_list, int lo, int hi) {
        for(int i=lo;i<hi;i++){
            if (given_list.get(i) == given_list.get(hi)){
                return false;
            }
        }
        return true;
    }
}
