package JavaApplication11;

class LinkedStack {

    private SNode top;

    LinkedStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(char x) {

        SNode sNew = new SNode(x, top);
        if (top == null) {
            top = sNew;
        } else {
            SNode temp = top;
            top = sNew;
            sNew.next = temp;
        }

    }

    public char pop() {

        if (top == null) {
            System.out.println("Stack is an empty");
            return 0;
        } else {

            char element = top.data;

            top = top.next;

            return element;
        }
    }

    public char peek() {
        if (top == null)
        {
            System.out.println("Stack is an empty");
            return 0;
        } else {

            char element = top.data;

            return element;
        }
    }

    public int size() {

        int count = 0;
        SNode temp = top;

        while (temp != null)
        {

            count += 1;

            temp = temp.next;
        }

        return count;
    }

    public void display() {

        System.out.println("The elements of the stack are: ");
        SNode temp = top;
        while (temp != null) {

            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("null");

        System.out.println();
    }
}

class SNode {

    char data;
    SNode next;

    public SNode(char data, SNode next) {
        this.data = data;
        this.next = next;
    }

    public String toString() {
        return data + " ";
    }
}

public class JavaApplication11
{

    public static void main(String[] args)
    {
        String expr1="{}[()][]";
        if(checkBalance( expr1))
            System.out.println(expr1 + "    is Balance ");
        else
            System.out.println(expr1 + "    is Not Balance");

        String expr2="[{]}";
        if(checkBalance( expr2))
            System.out.println(expr2 +"     is Balance ");
        else
            System.out.println(expr2 +"     is  Not Balance");

        String expr3="}}))";
        if(checkBalance( expr3))
            System.out.println(expr3 +"     is Balance ");
        else
            System.out.println(expr3 +"     is  Not Balance");

        String expr4="{}()[]";
        if(checkBalance( expr4))
            System.out.println(expr4 +"     is Balance ");
        else
            System.out.println(expr4 +"     is  Not Balance");

    }
    static boolean checkBalance(String expr) {   //Given an expression string exp,
        //write a function to examine whether the pairs
        //and the orders of expressions are correct .
        LinkedStack stack = new LinkedStack();
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
            //add you code here//
            if (x == '(' || x == '[' || x == '{')
            {
                stack.push(x);
            } else if (x == ')') {
                if (!stack.isEmpty() && stack.pop() != '(')
                {
                    return false;
                }
            } else if (x == ']') {
                if (!stack.isEmpty() && stack.pop() != '[')
                {
                    return false;
                }
            } else if (x == '}') {
                if (!stack.isEmpty() && stack.pop() != '{')
                {
                    return false;
                }
            }
        }
        //add you code here
        return stack.isEmpty();
        // change it
    }
}
