package code.array.good;

/**
 * Created by rahul.ka on 18/10/16.
 * https://www.interviewbit.com/problems/evaluate-expression-to-true/
 */
public class EvaluateExpression {
    public int cnttrue(String a) {
        int[][] trueDp = new int[a.length()][a.length()];
        int[][] falseDp = new int[a.length()][a.length()];
        for (int i = 0; i < a.length(); ++i) {
            trueDp[i][i] = 0;
            falseDp[i][i] = 0;
            if (a.charAt(i) == 'T') trueDp[i][i] = 1;
            else if (a.charAt(i) == 'F') falseDp[i][i] = 1;
        }
        for (int l = 1; l < a.length(); ++l) {
            for (int i = 0; i+l < a.length(); ++i) {
                int j = i+l;
                trueDp[i][j] = 0;
                falseDp[i][j] = 0;
                if (l %2 != 0) {
                    continue;
                }
                for (int k = i +1; k < j; ++k) {
                    switch (a.charAt(k)) {
                        case '&' :
                            trueDp[i][j] += (trueDp[i][k-1]*trueDp[k+1][j])%1003;
                            falseDp[i][j] += (falseDp[i][k-1]*trueDp[k+1][j]%1003);
                            falseDp[i][j] += (falseDp[i][k-1]*falseDp[k+1][j]%1003);
                            falseDp[i][j] += (trueDp[i][k-1]*falseDp[k+1][j]%1003);
                            break;
                        case '|' :
                            trueDp[i][j] += (trueDp[i][k-1]*trueDp[k+1][j]%1003);
                            trueDp[i][j] += (falseDp[i][k-1]*trueDp[k+1][j]%1003);
                            trueDp[i][j] += (trueDp[i][k-1]*falseDp[k+1][j]%1003);
                            falseDp[i][j] += (falseDp[i][k-1]*falseDp[k+1][j]%1003);
                            break;
                        case '^' :
                            trueDp[i][j] += (trueDp[i][k-1]*falseDp[k+1][j]%1003);
                            trueDp[i][j] += (falseDp[i][k-1]*trueDp[k+1][j]%1003);
                            falseDp[i][j] += (falseDp[i][k-1]*falseDp[k+1][j]%1003);
                            falseDp[i][j] += (trueDp[i][k-1]*trueDp[k+1][j]%1003);
                            break;
                    }
                }
               // System.out.println("trueDp["+i+"]["+j+"] : " + trueDp[i][j]);
               // System.out.println("falseDp["+i+"]["+j+"] : " + falseDp[i][j]);
            }
        }
        return trueDp[0][a.length()-1]%1003;
    }
}
