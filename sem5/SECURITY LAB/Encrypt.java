import java.util.*;

public class Encrypt {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the plaintext message: ");
        String plaintext = sc.nextLine();
        System.out.println("Enter the value by which each character in the plaintext message gets shifted: ");
        int shift = sc.nextInt();
        String ciphertext = "";
        char alphabet;

        for (int i = 0; i < plaintext.length(); i++) {
            alphabet = plaintext.charAt(i);

            if (alphabet >= 'a' && alphabet <= 'z') {
                alphabet = (char) (alphabet + shift);
                if (alphabet > 'z') {
                    alphabet = (char) (alphabet - 'z' + 'a' - 1);
                }
                ciphertext = ciphertext + alphabet;
            } else if (alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char) (alphabet + shift);
                if (alphabet > 'Z') {
                    alphabet = (char) (alphabet - 'Z' + 'A' - 1);
                }
                ciphertext = ciphertext + alphabet;
            } else {
                ciphertext = ciphertext + alphabet;
            }
        }

        System.out.println("Ciphertext: " + ciphertext);

        // Close the Scanner to release resources
        sc.close();
    }
}
    

