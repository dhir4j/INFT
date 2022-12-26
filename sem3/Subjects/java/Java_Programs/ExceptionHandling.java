
public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int a = 12 / 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("End");
    }
}
