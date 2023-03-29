package BadCalculator;
import java.util.Scanner;
public class BadCalculatorRunner{
public static void main(String[] args){
    BadCalculator Mason = new BadCalculator();
    Scanner pp = new Scanner(System.in);
    System.out.println("Shall we Fortnite?y/n");
    if(pp.next().equals("y")){
        Mason.equationInput();
    }
    else{
        pp.close();
        System.exit(0);
    }
}
}