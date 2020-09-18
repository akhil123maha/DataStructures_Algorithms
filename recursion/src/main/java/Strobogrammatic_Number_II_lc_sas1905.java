import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 */
public class Strobogrammatic_Number_II_lc_sas1905 {
    static Map<Character,Character> pre_store= new HashMap<>();
    public static void main(String[] args) {
        pre_store.put('0','0');
        pre_store.put('1','1');
        pre_store.put('6','9');
        pre_store.put('8','8');
        pre_store.put('9','6');
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length");
        int n = sc.nextInt();
        String s =  "";
        // Creating a Dummy String of size N.
        
        for(int i=0;i<n;i++){
            s= s+ "p";
        }
        char[] ans_String = s.toCharArray();
        find_numbers_through_backtracking(0,n-1,ans_String);

    }

    private static void find_numbers_through_backtracking(int l, int r, char[] ans_String) {
        if(l>r){
            System.out.println(String.valueOf(ans_String));
            return;
        }
        for (Map.Entry<Character,Character> entry : pre_store.entrySet()) {
            if (l == 0) {
                if (l == r && entry.getKey() == entry.getValue()) {
                    ans_String[l] = entry.getValue();
                    find_numbers_through_backtracking(l + 1, r - 1, ans_String);
                }
                else if(entry.getKey()!='0'){
                   ans_String[l]=entry.getKey();
                   ans_String[r]=entry.getValue();
                   find_numbers_through_backtracking(l+1,r-1,ans_String);
                }
            }
            else if(l==r && (entry.getKey()==entry.getValue())){
                ans_String[l] = entry.getKey();
                find_numbers_through_backtracking(l+1,r-1,ans_String);
            }
            else {
                ans_String[l]=entry.getKey();
                ans_String[r]=entry.getValue();
                find_numbers_through_backtracking(l+1,r-1,ans_String);
            }
        }
        return;
    }
}
