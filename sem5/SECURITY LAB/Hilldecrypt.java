import java.util.Scanner;

public class Hilldecrypt {
    private static int[][] keyMatrix = new int[2][2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hill Cipher 2x2 Decryption");

        // Input the key matrix
        System.out.println("Enter the key matrix (2x2):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                keyMatrix[i][j] = scanner.nextInt();
            }
        }

        int det = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
        int inverseDet = findInverse(det);

        if (inverseDet == -1) {
            System.out.println("Key matrix is not invertible. Decryption is not possible.");
            scanner.close();
            return;
        }

        int temp = keyMatrix[0][0];
        keyMatrix[0][0] = keyMatrix[1][1];
        keyMatrix[1][1] = temp;

        keyMatrix[0][1] = (keyMatrix[0][1] * -1 + 26) % 26;
        keyMatrix[1][0] = (keyMatrix[1][0] * -1 + 26) % 26;

        scanner.nextLine(); // Consume newline

        System.out.print("Enter the ciphertext (in uppercase): ");
        String cipherText = scanner.nextLine();
        String decryptedText = decrypt(cipherText);

        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }

    public static int findInverse(int det) {
        for (int i = 1; i < 26; i++) {
            if ((det * i) % 26 == 1) {
                return i;
            }
        }
        return -1;
    }

    public static String decrypt(String cipherText) {
        cipherText = cipherText.toUpperCase();
        int length = cipherText.length();

        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < length; i += 2) {
            int char1 = cipherText.charAt(i) - 'A';
            int char2 = cipherText.charAt(i + 1) - 'A';

            int decryptedChar1 = ((keyMatrix[0][0] * char1 + keyMatrix[0][1] * char2) + 26) % 26;
            int decryptedChar2 = ((keyMatrix[1][0] * char1 + keyMatrix[1][1] * char2) + 26) % 26;

            decryptedText.append((char) (decryptedChar1 + 'A')).append((char) (decryptedChar2 + 'A'));
        }

        return decryptedText.toString();
    }
}
