//Plaintext cipher Encryption and decryption
//Kavisha Pachalkar
//Roll No. 29
//07/08/23

import java.util.Scanner;

public class plaintextEn {
    private static final String ALPHABET = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
    
    public static char[][] generatePlayfairKey(String key) {
        key = key.toUpperCase().replace("J", "I");
        key = key.replaceAll("[^A-Z]", "");
        key = key + ALPHABET;
        key = key.substring(0, 25);
        
        char[][] playfairMatrix = new char[5][5];
        int index = 0;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                playfairMatrix[i][j] = key.charAt(index);
                index++;
            }
        }
        
        return playfairMatrix;
    }
    
    public static String playfairEncrypt(String plainText, char[][] playfairMatrix) {
        plainText = plainText.toUpperCase().replace("J", "I");
        plainText = plainText.replaceAll("[^A-Z]", "");
        StringBuilder encryptedText = new StringBuilder();
        
        for (int i = 0; i < plainText.length(); i += 2) {
            char char1 = plainText.charAt(i);
            char char2 = (i + 1 < plainText.length()) ? plainText.charAt(i + 1) : 'X';
            
            int[] posChar1 = findPosition(playfairMatrix, char1);
            int[] posChar2 = findPosition(playfairMatrix, char2);
            
            if (posChar1[0] == posChar2[0]) {
                encryptedText.append(playfairMatrix[posChar1[0]][(posChar1[1] + 1) % 5]);
                encryptedText.append(playfairMatrix[posChar2[0]][(posChar2[1] + 1) % 5]);
            } else if (posChar1[1] == posChar2[1]) {
                encryptedText.append(playfairMatrix[(posChar1[0] + 1) % 5][posChar1[1]]);
                encryptedText.append(playfairMatrix[(posChar2[0] + 1) % 5][posChar2[1]]);
            } else {
                encryptedText.append(playfairMatrix[posChar1[0]][posChar2[1]]);
                encryptedText.append(playfairMatrix[posChar2[0]][posChar1[1]]);
            }
        }
        
        return encryptedText.toString();
    }
    
    public static String playfairDecrypt(String encryptedText, char[][] playfairMatrix) {
        StringBuilder decryptedText = new StringBuilder();
        
        for (int i = 0; i < encryptedText.length(); i += 2) {
            char char1 = encryptedText.charAt(i);
            char char2 = encryptedText.charAt(i + 1);
            
            int[] posChar1 = findPosition(playfairMatrix, char1);
            int[] posChar2 = findPosition(playfairMatrix, char2);
            
            if (posChar1[0] == posChar2[0]) {
                decryptedText.append(playfairMatrix[posChar1[0]][(posChar1[1] - 1 + 5) % 5]);
                decryptedText.append(playfairMatrix[posChar2[0]][(posChar2[1] - 1 + 5) % 5]);
            } else if (posChar1[1] == posChar2[1]) {
                decryptedText.append(playfairMatrix[(posChar1[0] - 1 + 5) % 5][posChar1[1]]);
                decryptedText.append(playfairMatrix[(posChar2[0] - 1 + 5) % 5][posChar2[1]]);
            } else {
                decryptedText.append(playfairMatrix[posChar1[0]][posChar2[1]]);
                decryptedText.append(playfairMatrix[posChar2[0]][posChar1[1]]);
            }
        }
        
        return decryptedText.toString();
    }
    
    public static int[] findPosition(char[][] matrix, char target) {
        int[] position = new int[2];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == target) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        
        return position;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the keyword: ");
        String key = scanner.nextLine();
        
        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();
        
        char[][] playfairMatrix = generatePlayfairKey(key);
        
        String encryptedText = playfairEncrypt(plaintext, playfairMatrix);
        String decryptedText = playfairDecrypt(encryptedText, playfairMatrix);
        
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted: " + encryptedText);
        System.out.println("Decrypted: " + decryptedText);
    }
}