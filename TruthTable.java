import java.util.ArrayList;

public class TruthTable {

    public static ArrayList<Character> extractVar(String input) {
        ArrayList<Character> var = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c) && !var.contains(c)) {
                var.add(c);
            }
        }
        return var;
    }


    static void generateTruthTable(String postfix, ArrayList<Character> variable) {

        int rows = (int) Math.pow(2, variable.size());

        for (char var : variable){
            System.out.print(var + " | ");
        }
        System.out.println(postfix);
        System.out.println("-".repeat(variable.size()*4 + postfix.length()));

        for (int i = 0; i < rows; i++) {

            boolean[] TF = new boolean[variable.size()];
            for (int j = 0; j < variable.size(); j++) {
                TF[j] = (i & (1 << (variable.size() - j - 1))) != 0;
                System.out.print((TF[j] ? "F" : "T" ) + " | ");
            }
            boolean result = FixConverter.PostFixSolution(postfix, variable, TF);
            System.out.println(result ? 'F' : 'T');

        }

    }

}
