
public class method_overloading {

    int c = 0;
    double c1 = 0.0;

    public static void main(String[] args, double d) {
        method_overloading m1 = new method_overloading();

        m1.sub(10, 20);

        m1.sub(10.0, 12.0, 13.0);
    }

    public void sub(int a, int b) {
        c = a - b;
        System.out.println(" a - b : " + c);
    }

    public void sub(double a, double b, double c) {
        c1 = a - b - c;
        System.out.println("a - b - c : " + c1);
    }
}