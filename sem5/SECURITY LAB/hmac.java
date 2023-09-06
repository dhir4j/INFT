import javax.crypto.Cipher;
// import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class hmac {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 1) {
                // Generate a secret key
                SecretKey secretKey = generateSecretKey(scanner);

                // Message to be encrypted
                System.out.println("Enter Message:");
                String message = scanner.nextLine();

                // Encryption
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encryptedBytes = cipher.doFinal(message.getBytes());
                String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
                System.out.println("Encrypted: " + encryptedText);
            } else if (choice == 2) {
                // Generate a secret key
                SecretKey secretKey = generateSecretKey(scanner);

                // Encrypted message to be decrypted
                System.out.println("Enter Encrypted Message:");
                String encryptedText = scanner.nextLine();

                // Decryption
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
                String decryptedText = new String(decryptedBytes);
                System.out.println("Decrypted: " + decryptedText);
            } else if (choice == 3) {
                break; // Exit the program
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }

    private static SecretKey generateSecretKey(Scanner scanner) throws Exception {
        SecretKey secretKey = null;
        boolean validKeyLength = false;

        while (!validKeyLength) {
            System.out.println("Enter Secret Key (16, 24, or 32 characters):");
            String secretKeyStr = scanner.nextLine();

            if (secretKeyStr.length() == 16 || secretKeyStr.length() == 24 || secretKeyStr.length() == 32) {
                byte[] encodedKey = secretKeyStr.getBytes();
                secretKey = new SecretKeySpec(encodedKey, "AES");
                validKeyLength = true;
            } else {
                System.out.println("Invalid key length. Please provide a key with 16, 24, or 32 characters.");
            }
        }

        return secretKey;
    }
}
