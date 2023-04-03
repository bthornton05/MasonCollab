package GoodCalculator;
import java.util.Scanner;
public class GoodCalculator { //Made by Nickolas Holzer and Bradley Thornton with a big thanks to Samuel Wiseman for explaining 6th grade mathematics
    private static String eq;
    public void eqInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Equation: ");
        eq = sc.next();
        sc.close();
    }
    public String getEq(){
        return eq;
    }
    private int getPreviousTerm(String eq) {
        for(int i = eq.length() - 1; i>= 0; i--){
            if(!Character.isDigit(eq.charAt(i))){
                return i + 1;
            }
            else if(i == 0){
                return 0;
            }
        }
        return -1;
    }
    private int getNextTerm(String eq) {
        for(int i = 0; i< eq.length(); i++){
            if(!Character.isDigit(eq.charAt(i))){
                return i - 1;
            }
            else if(i == eq.length() - 1){
                return i + 1;
            }
        }
        return -1;
    }

    public int goodCalculate(String eq){
        if(eq.indexOf('(') > -1){
            int pLeft = eq.indexOf('(');
            int pRight = -1;
            for(int i = eq.length() - 1; i>=0 ; i--){
                if(eq.charAt(i) == ')'){
                    pRight = i;
                    break;
                }
            }
            String replaceTerm = eq.substring(pLeft, pRight + 1);
            eq = eq.replace(replaceTerm, "" + goodCalculate(eq.substring(pLeft + 1, pRight)));
            
        }
        


        while(eq.indexOf("^") > -1){
            int eOperator = eq.indexOf("^");
            int previousTermIndex = getPreviousTerm(eq.substring(0,eOperator));
            int nextTermIndex = eOperator + getNextTerm(eq.substring(eOperator + 1, eq.length()));
            int previousTerm = Integer.parseInt(eq.substring(previousTermIndex, eOperator));
            int nextTerm = Integer.parseInt(eq.substring(eOperator + 1, nextTermIndex+1));
            int term = (int)Math.pow(previousTerm, nextTerm);
            String miniTerm = eq.substring(previousTermIndex, nextTermIndex + 1);
            eq = eq.replace(miniTerm, "" + term);
        }
        while(eq.indexOf("*") > -1){
            int eOperator = eq.indexOf("*");
            int previousTermIndex = getPreviousTerm(eq.substring(0,eOperator));
            int nextTermIndex = eOperator + getNextTerm(eq.substring(eOperator + 1, eq.length()));
            int previousTerm = Integer.parseInt(eq.substring(previousTermIndex, eOperator));
            int nextTerm = Integer.parseInt(eq.substring(eOperator + 1, nextTermIndex+1));
            int term = previousTerm * nextTerm;
            String miniTerm = eq.substring(previousTermIndex, nextTermIndex + 1);
            eq = eq.replace(miniTerm, "" + term);
        }
        while(eq.indexOf("/") > -1){
            int eOperator = eq.indexOf("/");
            int previousTermIndex = getPreviousTerm(eq.substring(0,eOperator));
            int nextTermIndex = eOperator + getNextTerm(eq.substring(eOperator + 1, eq.length()));
            int previousTerm = Integer.parseInt(eq.substring(previousTermIndex, eOperator));
            int nextTerm = Integer.parseInt(eq.substring(eOperator + 1, nextTermIndex+1));
            int term = previousTerm / nextTerm;
            String miniTerm = eq.substring(previousTermIndex, nextTermIndex + 1);
            eq = eq.replace(miniTerm, "" + term);
        }
        while(eq.indexOf("+") > -1){
            int eOperator = eq.indexOf("+");
            int previousTermIndex = getPreviousTerm(eq.substring(0,eOperator));
            int nextTermIndex = eOperator + getNextTerm(eq.substring(eOperator + 1, eq.length()));
            int previousTerm = Integer.parseInt(eq.substring(previousTermIndex, eOperator));
            int nextTerm = Integer.parseInt(eq.substring(eOperator + 1, nextTermIndex+1));
            int term = previousTerm + nextTerm;
            String miniTerm = eq.substring(previousTermIndex, nextTermIndex + 1);
            eq = eq.replace(miniTerm, "" + term);
        }
        while(eq.indexOf("-") > -1){
            int eOperator = eq.indexOf("-");
            int previousTermIndex = getPreviousTerm(eq.substring(0,eOperator));
            int nextTermIndex = eOperator + getNextTerm(eq.substring(eOperator + 1, eq.length()));
            int previousTerm = Integer.parseInt(eq.substring(previousTermIndex, eOperator));
            int nextTerm = Integer.parseInt(eq.substring(eOperator + 1, nextTermIndex+1));
            int term = previousTerm - nextTerm;
            String miniTerm = eq.substring(previousTermIndex, nextTermIndex + 1);
            eq = eq.replace(miniTerm, "" + term);
        }

        return Integer.parseInt(eq);
    }
   
    
}
