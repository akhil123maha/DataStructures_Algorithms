import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SubsetWithRecursion_No_Duplicates_Sas1905 {

    static int recursion_count = 0;
    public static void main(String[] args) {
        List<Integer> arr_val = new ArrayList<>();
        arr_val.add(2);
        arr_val.add(1);
        arr_val.add(2);
        arr_val.add(2);
        solve_with_backtracking(arr_val);
        //Also can be done through recursion with help of map
    }

    private static void solve_with_backtracking(List<Integer> arr_val) {
        System.out.println("Enter Backtracking");
        int n = arr_val.size();
        recursion_count=0;
        List<Integer> subsets = new ArrayList<>();
        // Sorting won't change subsets
        Collections.sort(arr_val);
        solve_backtrack(0,subsets,arr_val.size(),arr_val);
        System.out.println("Exit Backtracking");
    }

    private static void solve_backtrack(int index, List<Integer> subsets, int size, List<Integer> arr_val) {

        System.out.print(recursion_count + " subset {");
        subsets.forEach((Integer value) -> System.out.print(" "+value));
        recursion_count++;
        System.out.println("}");

        for(int i=index;i<size;i++)
        {
          if(i>index && arr_val.get(i) == arr_val.get(i-1)){
              continue;
          }
          subsets.add(arr_val.get(i));
          solve_backtrack(i+1,subsets,size,arr_val);
          subsets.remove(subsets.size()-1);
        }
    }



}
