import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AES {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("AES Encryption and Decryption");
            System.out.println("1. Generate AES Key");
            System.out.println("2. Encrypt");
            System.out.println("3. Decrypt");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    try {
                        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                        keyGenerator.init(128); // You can change the key size if needed (128, 192, or 256)
                        SecretKey secretKey = keyGenerator.generateKey();
                        System.out.println(
                                "AES Key generated: " + Base64.getEncoder().encodeToString(secretKey.getEncoded()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.print("Enter the plaintext: ");
                    String plaintext = scanner.nextLine();
                    System.out.print("Enter the AES key (Base64): ");
                    String keyString = scanner.nextLine();
                    encrypt(plaintext, keyString);
                    break;

                case 3:
                    System.out.print("Enter the ciphertext (Base64): ");
                    String ciphertext = scanner.nextLine();
                    System.out.print("Enter the AES key (Base64): ");
                    String decryptionKeyString = scanner.nextLine();
                    decrypt(ciphertext, decryptionKeyString);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void encrypt(String plaintext, String keyString) {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(keyString);
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());

            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted Text: " + encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void decrypt(String ciphertext, String keyString) {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(keyString);
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));

            String decryptedText = new String(decryptedBytes);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}