package GoodCalculator;
public class GoodCalculatorRunner {
    public static void main(String[] args){
        GoodCalculator pete = new GoodCalculator();
        pete.eqInput();
        System.out.println(pete.goodCalculate(pete.getEq()));
    }
}
