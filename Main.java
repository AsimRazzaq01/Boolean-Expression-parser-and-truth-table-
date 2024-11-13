import java.util.ArrayList;
import java.util.Scanner ;
public class Main {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    FixConverter parser = new FixConverter();

    System.out.println("Enter infix notation: ");
    String input = scanner.nextLine();

    String postfix = parser.InfixToPost(input) ;
    System.out.println("Your PostFix notation is: "+ postfix);

    ArrayList<Character> var = TruthTable.extractVar(input);


    TruthTable TT = new TruthTable();

    TT.generateTruthTable(postfix,var);









    }
}