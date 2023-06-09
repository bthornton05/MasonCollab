package BadCalculator;
import java.util.Scanner;
public class BadCalculator {
    private static String equation;
    private static int tokenRight;
    private static int tokenLeft;
    private static int operatorToken;
    private static double number;
    public void equationInput(){
        Scanner sc = new Scanner(System.in);
        equation = sc.next();
        sc.close();
    }
    public String getEquation(){
        return equation;
    }
    public void scanForParentheses(String eq){
        tokenLeft = 0; 
        tokenRight = equation.length();
        while(!(eq.substring(tokenLeft, tokenLeft + 1).equals("("))){
            tokenLeft++;
            //System.out.println("tokenLeft: " + tokenLeft);
        }
        while(!(eq.substring(tokenRight - 1, tokenRight).equals(")"))){
            tokenRight--;
            //System.out.println("tokenRight: " + tokenRight);
        }
        if ((eq.substring(tokenLeft, tokenLeft + 1).equals("(")) && (eq.substring(tokenRight - 1, tokenRight).equals(")"))){
            scanForOperators(eq);
        }
    }
    public void scanForOperators(String eqn){
        operatorToken = tokenLeft;
        while(!(eqn.substring(operatorToken, operatorToken + 1).equals("^")) || !(eqn.substring(operatorToken, operatorToken + 1).equals("*")) || !(eqn.substring(operatorToken, operatorToken + 1).equals("/")) || !(eqn.substring(operatorToken, operatorToken + 1).equals("+")) || !(eqn.substring(operatorToken, operatorToken + 1).equals("-"))){
            System.out.println("operatorToken: " + operatorToken);
            System.out.println(eqn.substring(operatorToken, operatorToken + 1));
            operatorToken++;
        }
            if(eqn.substring(operatorToken, operatorToken + 1).equals("^")){
                System.out.println("Yay");
                try{
                    number = Math.pow(Double.parseDouble((eqn.substring(0,operatorToken - 1))), Double.parseDouble(equation.substring(operatorToken+1, eqn.length())));
                    equation = equation.substring(0, tokenLeft) + number + equation.substring(tokenLeft+2);
                    System.out.println(equation);
                }
                catch(Exception e){
                    scanForParentheses(eqn.substring(tokenLeft + 1, tokenRight));
                }
            }
            else if(eqn.substring(operatorToken, operatorToken + 1).equals("*")){
                System.out.println("Yay");
                try{
                    number = Double.parseDouble((eqn.substring(0,operatorToken - 1))) * Double.parseDouble(equation.substring(operatorToken+1, eqn.length()));
                    equation = equation.substring(0, tokenLeft) + number + equation.substring(tokenLeft+2);
                    System.out.println(equation);
                }
                catch(Exception e){
                    scanForParentheses(eqn.substring(tokenLeft + 1, tokenRight));
                }
            }
            else if(eqn.substring(operatorToken, operatorToken + 1).equals("/")){
                System.out.println("Yay");
                try{
                    number = Double.parseDouble((eqn.substring(0,operatorToken - 1))) / Double.parseDouble(equation.substring(operatorToken+1, eqn.length()));
                    equation = equation.substring(0, tokenLeft) + number + equation.substring(tokenLeft+2);
                    System.out.println(equation);
                }
                catch(Exception e){
                    scanForParentheses(eqn.substring(tokenLeft + 1, tokenRight));
                }
            }
            else if(eqn.substring(operatorToken, operatorToken + 1).equals("+")){
                System.out.println("Yay");
                try{
                    number = Double.parseDouble((eqn.substring(0,operatorToken - 1))) + Double.parseDouble(equation.substring(operatorToken+1, eqn.length()));
                    equation = equation.substring(0, tokenLeft) + number + equation.substring(tokenLeft+2);
                    System.out.println(equation);
                }
                catch(Exception e){
                    scanForParentheses(eqn.substring(tokenLeft + 1, tokenRight));
                }
            }
            else if(eqn.substring(operatorToken, operatorToken + 1).equals("-")){
                System.out.println("Yay");
                try{
                    number = Double.parseDouble((eqn.substring(0,operatorToken - 1))) - Double.parseDouble(equation.substring(operatorToken+1, eqn.length()));
                    equation = equation.substring(0, tokenLeft) + number + equation.substring(tokenLeft+2);
                    System.out.println(equation);
                }
                catch(Exception e){
                    scanForParentheses(eqn.substring(tokenLeft + 1, tokenRight));
                }
            }
        }
    public double math(String finalEquation){
        return 0;
    }
    int l = 0;
    int r = 0;
    public int calc(String equ, int left, int right ){
        right = equ.length();
        while (true){
            if (left==equ.length()&&(!(equ.substring(left, left+1).equals("(")))){
                left++;
            }
            if ((right==0)&&(!(equ.substring(right-1, right).equals(")")))){
                right++;
            }
        }
    }
}
