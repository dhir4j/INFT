import java.math.*;
import java.util.*;

class RSA {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first prime number (p): ");
        int p = sc.nextInt();

        System.out.print("Enter the second prime number (q): ");
        int q = sc.nextInt();

        int n = p * q;
        int z = (p - 1) * (q - 1);
        System.out.println("The value of n = " + n);
        System.out.println("The value of z = " + z);

        int e = findPublicKeyExponent(z);
        System.out.println("The value of e = " + e);

        int d = findPrivateKeyExponent(e, z);
        System.out.println("The value of d = " + d);

        System.out.print("Enter the message to be encrypted: ");
        int msg = sc.nextInt();

        BigInteger encryptedMsg = encryptMessage(msg, e, n);
        System.out.println("Encrypted message is: " + encryptedMsg);

        BigInteger decryptedMsg = decryptMessage(encryptedMsg, d, n);
        System.out.println("Decrypted message is: " + decryptedMsg);
    }

    static int findPublicKeyExponent(int z) {
        for (int e = 2; e < z; e++) {
            if (gcd(e, z) == 1) {
                return e;
            }
        }
        return 0; // No suitable e found
    }

    static int findPrivateKeyExponent(int e, int z) {
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                return x / e;
            }
        }
        return 0; // No suitable d found
    }

    static BigInteger encryptMessage(int msg, int e, int n) {
        BigInteger message = BigInteger.valueOf(msg);
        BigInteger exponent = BigInteger.valueOf(e);
        BigInteger modulus = BigInteger.valueOf(n);

        return message.modPow(exponent, modulus);
    }

    static BigInteger decryptMessage(BigInteger encryptedMsg, int d, int n) {
        BigInteger exponent = BigInteger.valueOf(d);
        BigInteger modulus = BigInteger.valueOf(n);

        return encryptedMsg.modPow(exponent, modulus);
    }

    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
}
