//Plaintext cipher Encryption and decryption
//Kavisha Pachalkar
//Roll No. 29
//07/08/23

import java.util.Scanner;

public class Hillch {
    private static final int MATRIX_SIZE = 3; // Change this for different matrix sizes
    private static int[][] keyMatrix = new int[MATRIX_SIZE][MATRIX_SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hill Cipher Encryption");

        // Input the key matrix
        System.out.println("Enter the key matrix (3x3):");
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                keyMatrix[i][j] = scanner.nextInt();
            }
        }

        scanner.nextLine(); // Consume newline

        System.out.print("Enter the plaintext: ");
        String plainText = scanner.nextLine();
        String encryptedText = encrypt(plainText);

        System.out.println("Encrypted Text: " + encryptedText);

        scanner.close();
    }

    public static String encrypt(String plainText) {
        plainText = plainText.toUpperCase();
        int length = plainText.length();

        // Pad the plain text if its length is not a multiple of MATRIX_SIZE
        while (length % MATRIX_SIZE != 0) {
            plainText += 'X';
            length++;
        }

        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < length; i += MATRIX_SIZE) {
            int[] plainTextVector = new int[MATRIX_SIZE];
            int[] encryptedVector = new int[MATRIX_SIZE];

            for (int j = 0; j < MATRIX_SIZE; j++) {
                plainTextVector[j] = plainText.charAt(i + j) - 'A';
            }

            for (int j = 0; j < MATRIX_SIZE; j++) {
                for (int k = 0; k < MATRIX_SIZE; k++) {
                    encryptedVector[j] += keyMatrix[j][k] * plainTextVector[k];
                }
                encryptedVector[j] %= 26; // Mod 26 for wrapping around the alphabet
                encryptedText.append((char) (encryptedVector[j] + 'A'));
            }
        }

        return encryptedText.toString();
    }
}
