package GoodCalculator;
import java.util.Scanner;
public class GoodCalculator { //Made by Nickolas Holzer and Bradley Thornton with a big thanks to Samuel Wiseman for explaining 6th grade mathematics
    private static String eq;
    public void eqInput(){ //Gets equation from user and stores it in class for later use
        Scanner sc = new Scanner(System.in);
        System.out.print("Equation: ");
        eq = sc.next();
        sc.close();
    }
    public String getEq(){ //Returns equation
        return eq;
    }
    private int findPreviousTerm(String eq) { //Finds previous integer term value preceding operator
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
    private int findNextTerm(String eq) { //Finds integer term after operator
        for(int i = 0; i< eq.length(); i++){
            if(!Character.isDigit(eq.charAt(i))){
                return i;
            }
            else if(i == eq.length() - 1){
                return i + 1;
            }
        }
        return -1;
    }

    public int goodCalculate(String eq){ //Function that is called recursively to solve equation
        if(eq.indexOf('(') > -1){ //Finds index of closing and opening parentheses of inner most term to be solved
            int pLeft = -1;
            int pRight = -1;
            for(int i = eq.length() - 1; i>=0 ; i--){
                if(eq.charAt(i) == '('){
                    pLeft = i;
                    //System.out.println(pLeft);
                    break;
                }
            }
            for(int j = pLeft; j < eq.length(); j++){
                if(eq.charAt(j) == ')'){
                    pRight = j;
                    //System.out.println(pRight);
                    break;
                }
            }
            String replacedTerm = eq.substring(pLeft, pRight + 1);
            System.out.println(replacedTerm);
            eq = eq.replace(replacedTerm, "" + goodCalculate(eq.substring(pLeft + 1, pRight))); //Calls method recursively with innermost term to solve equation
            
        }

        while(eq.indexOf("^") > -1){ //Exponent operator
            int eOperator = eq.indexOf("^");
            int previousTermIndex = findPreviousTerm(eq.substring(0,eOperator));
            int nextTermIndex = eOperator + findNextTerm(eq.substring(eOperator + 1, eq.length()));
            int previousTerm = Integer.parseInt(eq.substring(previousTermIndex, eOperator));
            int nextTerm = Integer.parseInt(eq.substring(eOperator + 1, nextTermIndex+1));
            int term = (int)Math.pow(previousTerm, nextTerm);
            String miniTerm = eq.substring(previousTermIndex, nextTermIndex + 1);
            eq = eq.replace(miniTerm, "" + term);
            System.out.println(eq);
        }
        while(eq.indexOf("*") > -1){ //Multiplication operator
            int eOperator = eq.indexOf("*");
            int previousTermIndex = findPreviousTerm(eq.substring(0,eOperator));
            int nextTermIndex = eOperator + findNextTerm(eq.substring(eOperator + 1, eq.length()));
            int previousTerm = Integer.parseInt(eq.substring(previousTermIndex, eOperator));
            int nextTerm = Integer.parseInt(eq.substring(eOperator + 1, nextTermIndex+1));
            int term = previousTerm * nextTerm;
            String miniTerm = eq.substring(previousTermIndex, nextTermIndex + 1);
            eq = eq.replace(miniTerm, "" + term);
            System.out.println(eq);
        }
        while(eq.indexOf("/") > -1){ //Division operator
            int eOperator = eq.indexOf("/");
            int previousTermIndex = findPreviousTerm(eq.substring(0,eOperator));
            int nextTermIndex = eOperator + findNextTerm(eq.substring(eOperator + 1, eq.length()));
            int previousTerm = Integer.parseInt(eq.substring(previousTermIndex, eOperator));
            int nextTerm = Integer.parseInt(eq.substring(eOperator + 1, nextTermIndex+1));
            int term = previousTerm / nextTerm;
            String miniTerm = eq.substring(previousTermIndex, nextTermIndex + 1);
            eq = eq.replace(miniTerm, "" + term);
            System.out.println(eq);
        }
        while(eq.indexOf("+") > -1){ //Addition operator
            int eOperator = eq.indexOf("+");
            int previousTermIndex = findPreviousTerm(eq.substring(0,eOperator));
            int nextTermIndex = eOperator + findNextTerm(eq.substring(eOperator + 1, eq.length()));
            int previousTerm = Integer.parseInt(eq.substring(previousTermIndex, eOperator));
            int nextTerm = Integer.parseInt(eq.substring(eOperator + 1, nextTermIndex+1));
            int term = previousTerm + nextTerm;
            String miniTerm = eq.substring(previousTermIndex, nextTermIndex + 1);
            eq = eq.replace(miniTerm, "" + term);
            System.out.println(eq);
        }
        while(eq.indexOf("-") > -1){ //Subtraction operator
            int eOperator = eq.indexOf("-");
            int previousTermIndex = findPreviousTerm(eq.substring(0,eOperator));
            int nextTermIndex = eOperator + findNextTerm(eq.substring(eOperator + 1, eq.length()));
            int previousTerm = Integer.parseInt(eq.substring(previousTermIndex, eOperator));
            int nextTerm = Integer.parseInt(eq.substring(eOperator + 1, nextTermIndex+1));
            int term = previousTerm - nextTerm;
            String miniTerm = eq.substring(previousTermIndex, nextTermIndex + 1);
            eq = eq.replace(miniTerm, "" + term);
            System.out.println(eq);
        }
        return Integer.parseInt(eq); //Returns string equation as an integer
        }
    }
