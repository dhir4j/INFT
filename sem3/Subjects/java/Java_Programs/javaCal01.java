import java.util.Scanner;

public class javaCal01 {
    public static void main(String[] args) {
        float a;
        float b;
        char op;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Operator (+, -, *, /, %): ");
        op = sc.next().charAt(0);

        System.out.println("Enter First Operand: ");
        a = sc.nextFloat();

        System.out.println("Enter Second Operand: ");
        b = sc.nextFloat();

        switch (op) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));
                break;

            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));
                break;

            case '*':
                System.out.println(a + " * " + b + " = " + (a * b));
                break;

            case '/':
                System.out.println(a + " / " + b + " = " + (a / b));
                break;

            case '%':
                System.out.println(a + " % " + b + " = " + (a % b));
                break;

            default:
                System.out.println("Error : Pls enter Operand Correctly");
                break;
        }

        sc.close();
    }
}
