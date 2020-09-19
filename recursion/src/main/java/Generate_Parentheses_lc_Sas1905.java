/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Generate_Parentheses_lc_Sas1905 {
    static int N=0;
    public static void main(String[] args) {
        int n = 3;
        solve_ques(n);
    }

    private static void solve_ques(int n) {
        N=2*n;
        String s="";
        all_parentheses(s,0,0);
    }

    private static void all_parentheses(String ans, int index,int open_braces) {
        if(index==N)
        {
            if(open_braces==0)
            {
                System.out.println(ans);
            }
          return;
        }
        if(open_braces  > 0 ){
            ans = ans + ')';
            all_parentheses(ans,index+1,open_braces-1);
            StringBuffer sb= new StringBuffer(ans);
            sb.deleteCharAt(sb.length()-1);
            ans=sb.toString();
        }
        ans = ans + '(';
        all_parentheses(ans,index+1,open_braces+1);
        StringBuffer sb= new StringBuffer(ans);
        sb.deleteCharAt(sb.length()-1);
        ans = sb.toString();
        return;
    }

}
