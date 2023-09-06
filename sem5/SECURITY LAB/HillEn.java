//Plaintext cipher Encryption and decryption
//Kavisha Pachalkar
//Roll No. 29
//07/08/23

import java.util.Scanner;

public class HillEn {
    private static int[][] keyMatrix = new int[2][2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hill Cipher 2x2 Encryption");

        // Input the key matrix
        System.out.println("Enter the key matrix (2x2):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                keyMatrix[i][j] = scanner.nextInt();
            }
        }

        scanner.nextLine(); // Consume newline

        System.out.print("Enter the plaintext (in uppercase): ");
        String plainText = scanner.nextLine();
        String encryptedText = encrypt(plainText);

        System.out.println("Encrypted Text: " + encryptedText);

        scanner.close();
    }

    public static String encrypt(String plainText) {
        plainText = plainText.toUpperCase();
        int length = plainText.length();

        // Pad the plain text if its length is not even
        if (length % 2 != 0) {
            plainText += 'X';
            length++;
        }

        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < length; i += 2) {
            int char1 = plainText.charAt(i) - 'A';
            int char2 = plainText.charAt(i + 1) - 'A';

            int encryptedChar1 = (keyMatrix[0][0] * char1 + keyMatrix[0][1] * char2) % 26;
            int encryptedChar2 = (keyMatrix[1][0] * char1 + keyMatrix[1][1] * char2) % 26;

            encryptedText.append((char) (encryptedChar1 + 'A')).append((char) (encryptedChar2 + 'A'));
        }

        return encryptedText.toString();
    }
}
