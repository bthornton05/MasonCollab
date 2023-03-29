package BadCalculator;
import java.util.Scanner;
public class BadCalculator {
    private static String equation;
    private static int tokenRight = equation.length();
    private static int tokenLeft = 0; 
    private static int operatorToken = tokenLeft;
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
        while(!(eq.substring(tokenLeft, tokenLeft + 1).equals("("))){
            tokenLeft++;
        }
        while(!(eq.substring(tokenRight - 1, tokenRight).equals(")"))){
            tokenRight--;
        }
        if ((eq.substring(tokenLeft, tokenLeft + 1).equals("(")) && (eq.substring(tokenRight - 1, tokenRight).equals(")"))){
            scanForOperators(eq);
        }
    }
    public void scanForOperators(String eqn){
        while(!(eqn.substring(operatorToken, operatorToken + 1).equals("+")) || !(eqn.substring(operatorToken, operatorToken + 1).equals("-")) || !(eqn.substring(operatorToken, operatorToken + 1).equals("*")) || !(eqn.substring(operatorToken, operatorToken + 1).equals("/")) || !(eqn.substring(operatorToken, operatorToken + 1).equals("^"))){
            tokenLeft++;
        }
            if(eqn.substring(operatorToken, operatorToken + 1).equals("^")){
                try{
                    number = Math.pow(Double.parseDouble((eqn.substring(0,operatorToken - 1))), Double.parseDouble(equation.substring(operatorToken+1, eqn.length())));
                }
                catch(Exception e){
                    scanForOperators(eqn.substring(tokenLeft, tokenRight));
                }
            }
            else if(eqn.substring(operatorToken, operatorToken + 1).equals("*")){
                try{
                    number = Double.parseDouble((eqn.substring(0,operatorToken - 1))) * Double.parseDouble(equation.substring(operatorToken+1, eqn.length()));
                }
                catch(Exception e){
                    scanForOperators(eqn.substring(tokenLeft, tokenRight));
                }
            }
            else if(equation.substring(operatorToken, operatorToken + 1).equals("/")){
                try{
                    number = Double.parseDouble((eqn.substring(0,operatorToken - 1))) / Double.parseDouble(equation.substring(operatorToken+1, eqn.length()));
                }
                catch(Exception e){
                    scanForOperators(eqn.substring(tokenLeft, tokenRight));
                }
            }
            else if(equation.substring(operatorToken, operatorToken + 1).equals("+")){
                try{
                    number = Double.parseDouble((eqn.substring(0,operatorToken - 1))) + Double.parseDouble(equation.substring(operatorToken+1, eqn.length()));
                }
                catch(Exception e){
                    scanForOperators(eqn.substring(tokenLeft, tokenRight));
                }
            }
            else if(equation.substring(operatorToken, operatorToken + 1).equals("-")){
                try{
                    number = Double.parseDouble((eqn.substring(0,operatorToken - 1))) - Double.parseDouble(equation.substring(operatorToken+1, eqn.length()));
                }
                catch(Exception e){
                    scanForOperators(eqn.substring(tokenLeft, tokenRight));
                }
            }
        }
    public double math(String finalEquation){
        return 0;
    }
}
