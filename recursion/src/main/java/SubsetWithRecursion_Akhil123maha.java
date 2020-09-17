import java.util.ArrayList;
import java.util.List;

public class SubsetWithRecursion_Akhil123maha {

    static int recursion_count = 0;
    public static void main(String[] args) {
        List<Integer> arr_val = new ArrayList<>();
        arr_val.add(2);
        arr_val.add(5);
        arr_val.add(3);
        solve_with_bitmasking(arr_val);
        solve_with_recursion(arr_val);
        solve_with_backtracking(arr_val);
    }

    private static void solve_with_backtracking(List<Integer> arr_val) {
        System.out.println("Enter Backtracking");
        int n = arr_val.size();
        recursion_count=0;
        List<Integer> subsets = new ArrayList<>();
        for(int i =0; i<n+1;i++){
            solve_backtrack(0,subsets,i,arr_val);
        }
        System.out.println("Exit Backtracking");
    }

    private static void solve_backtrack(int index, List<Integer> subsets, int size, List<Integer> arr_val) {

        if(subsets.size() == size){
            System.out.print(recursion_count + " subset {");
            subsets.forEach((Integer value) -> System.out.print(" "+value));
            recursion_count++;
            System.out.println("}");
            return;
        }
        for(int i=index;i<arr_val.size();i++)
        {
          subsets.add(arr_val.get(i));
          solve_backtrack(i+1,subsets,size,arr_val);
          subsets.remove(subsets.size()-1);
        }
    }

    private static void solve_with_recursion(List<Integer> arr_val) {
        System.out.println("Enter Recursion");
        recursion_count = 0;
        List<Integer> Subset = new  ArrayList<>();
        solve_recursion(arr_val,0, Subset);
        System.out.println("Exit Recursion");
    }



    private static void solve_recursion(List<Integer> arr_val, int index, List<Integer> subset) {
         if(index == arr_val.size()){
             System.out.print(recursion_count + " subset {");
             subset.forEach((Integer value) -> System.out.print(" "+value));
             recursion_count++;
             System.out.println("}");
             return;
         }
         solve_recursion(arr_val, index+1 , subset);
         List<Integer> temp_subset = subset;
         temp_subset.add(arr_val.get(index));
         solve_recursion(arr_val,index+1,temp_subset);
         subset.remove(subset.size()-1);
         return;
    }

    private static void solve_with_bitmasking(List<Integer> arr_val) {
        //Complexity O(2^n * n)
        System.out.println("Bitmasking Starts");
        int size = arr_val.size();
        int mask = 1<<size;

        for(int i=0;i<mask;i++)
        {
            System.out.print(i + " subset {");
            for(int j=0;j<size;j++)
            {
                if( (i&(1<<j)) > 0 )
                {
                    System.out.print(" " + arr_val.get(j));
                }
            }
            System.out.println("}");
        }
        System.out.println("Bitmasking ends");
        return ;
    }

}
