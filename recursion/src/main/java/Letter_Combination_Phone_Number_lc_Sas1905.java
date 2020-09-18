import java.util.HashMap;
import java.util.Map;

/**
 * GIven a keypad mobile and input of keys pressed.Print all the combinations.
 */
public class Letter_Combination_Phone_Number_lc_Sas1905 {
    static Map<Character,String> pre_store= new HashMap<>();

    public static void main(String[] args) {
        pre_store.put('2',"abc");
        pre_store.put('3',"def");
        pre_store.put('4',"ghi");
        pre_store.put('5',"jkl");
        pre_store.put('6',"mno");
        pre_store.put('7',"pqrs");
        pre_store.put('8',"tuv");
        pre_store.put('9',"wxyz");
        String input = "232";
        int n = input.length();
        String s = "";
        solve_with_recursion(0,input,s);
        System.out.println();
    }

    private static void solve_with_recursion(int left, String input, String s) {
        if(left == input.length()){
            System.out.print(s+" ");
            return;
        }
        String temp = pre_store.get(input.charAt(left));
        for(int i=0;i<temp.length();i++){
            s = s + temp.charAt(i);
            solve_with_recursion(left+1,input,s);
            StringBuffer sb= new StringBuffer(s);
            sb.deleteCharAt(sb.length()-1);
            s=sb.toString();
        }
        return;
    }

}
