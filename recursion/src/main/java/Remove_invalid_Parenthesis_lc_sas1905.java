
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 */
public class Remove_invalid_Parenthesis_lc_sas1905 {
    static int N=0;
    static String temp ="";
    static int min = 0;
    static Map<String,Boolean> duplicate= new HashMap<>();

    public static void main(String[] args) {
        String ques = "(a)())()";
        int n = ques.length();
        solve_ques(ques,n);
    }

    private static void solve_ques(String query, int len) {
        N= len;
        temp = query;
        count_min();
        System.out.println("Minimum deletions is "+ min);
        if(min == 0) {
            System.out.println("String "+ temp);
            return ;
        }
        String ans = "";
        solve_with_recursion(0,ans,0,0);
    }

    private static void solve_with_recursion(int idx, String ans,int operations,int open_braces) {
        if(idx == N){
            if(open_braces == 0 && operations==min){
                if(duplicate.get(ans) == null) {
                    duplicate.put(ans, true);
                    System.out.println("Valid Parenthesis:" + ans);
                }
            }
            return;
        }
        if(operations > min){
            return;
        }
        if(temp.charAt(idx)=='('){
            ans = ans + temp.charAt(idx);
            solve_with_recursion(idx+1,ans,operations,open_braces+1);
            StringBuffer sb= new StringBuffer(ans);
            sb.deleteCharAt(sb.length()-1);
            ans=sb.toString();
            solve_with_recursion(idx+1,ans,operations+1,open_braces);
        }
        else if(temp.charAt(idx)==')'){
            if(open_braces!=0){
                ans = ans + temp.charAt(idx);
                solve_with_recursion(idx+1,ans,operations,open_braces-1);
                StringBuffer sb= new StringBuffer(ans);
                sb.deleteCharAt(sb.length()-1);
                ans=sb.toString();
                solve_with_recursion(idx+1,ans,operations+1,open_braces);
            }
            solve_with_recursion(idx+1,ans,operations+1,open_braces);
        }
        else {
            ans = ans + temp.charAt(idx);
            solve_with_recursion(idx+1,ans,operations,open_braces);
        }
        return;
    }

    private static void count_min() {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<N;i++){
            if(temp.charAt(i) == '('){
                st.push(temp.charAt(i));
            }
            else if(temp.charAt(i)==')'){
               if(st.empty()){
                   min++;
               }
               else {
                   st.pop();
               }
            }
        }
        min += st.size();
        st.clear();
    }
}
