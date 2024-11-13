import java.util.ArrayList;

public class FixConverter {


/*    public static boolean letterOrDigit(char c)
    {
        // boolean check
        if (Character.isLetterOrDigit(c))
            return true;
        else
            return false;
    }*/

    public static int Heirarchy(char op){
        if (op == '!'){                // NOT
            return 3 ;
        } else if (op == '*' ) {       // AND
            return 2 ;
        }else if (op == '+' ) {        // OR
            return 1 ;
        }else
            return 0 ;
    }

    public static boolean isOperator(char op){
        return  ( op == '!' || op == '*' || op == '+' ) ;
    }

    // METHOD for Shunting Yard Algo
    public static String InfixToPost(String input) {

        // Initialize empty Linked List Stack
        LLStack<Character> myStack = new LLStack<>();

        // Initialize empty string
        StringBuilder output = new StringBuilder();


        for (int i = 0; i < input.length(); i++) {

            char op = input.charAt(i);

            if (Character.isLetterOrDigit(op)) {
                output.append(op);
            } else if (op == '(') {
                myStack.push(op);
            } else if (op == ')') {
                while (!myStack.isEmpty() && myStack.peek() != '(') {
                    output.append(myStack.pop());
                }
                myStack.pop();  // Remove '(' from stack
            } else if (isOperator(op)) {
                while (!myStack.isEmpty() && Heirarchy(myStack.peek()) >= Heirarchy(op)) {
                    output.append(myStack.pop());
                }
                myStack.push(op);

            }
        }

        // pop remaining operators from the stack
        while (!myStack.isEmpty()) {
            output.append(myStack.pop()) ;
        }
        return output.toString();
    }

    public static boolean PostFixSolution(String input, ArrayList<Character> variables, boolean[] values){
        LLStack<Boolean> myStack = new LLStack<>();

        for (char op : input.toCharArray()) {
            if (Character.isLetter(op)) {
                int index = variables.indexOf(op);
                myStack.push(values[index]);
            } else if (op == '!') {
                boolean operand  = myStack.pop();
                myStack.push(!operand);
            }else {
                boolean operand2 = myStack.pop();
                boolean operand1 = myStack.pop();

                switch (op){
                    case '*':
                        myStack.push(operand1 && operand2);
                        break;
                    case '+':
                        myStack.push(operand1 || operand2);
                        break;
                }
            }
        }
        return myStack.pop();
    }


}
