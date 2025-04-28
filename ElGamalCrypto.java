import java.math.BigInteger;
import java.security.SecureRandom;

public class ElGamalCrypto {

    public static void main(String[] args) {
        BigInteger p = new BigInteger("467"); // A prime number
        BigInteger g = new BigInteger("2");   // Primitive root

        BigInteger x = new BigInteger("127"); // Private key
        BigInteger y = g.modPow(x, p);         // Public key component

        System.out.println("Public Key (p, g, y): (" + p + ", " + g + ", " + y + ")");
        System.out.println("Private Key (x): " + x);

        BigInteger message = new BigInteger("88"); // Message to encrypt

        // Sender side (encryption)
        BigInteger k = new BigInteger("53"); // Random k
        BigInteger C1 = g.modPow(k, p);
        BigInteger C2 = (message.multiply(y.modPow(k, p))).mod(p);

        System.out.println("Encrypted: (C1: " + C1 + ", C2: " + C2 + ")");

        // Receiver side (decryption)
        BigInteger s = C1.modPow(x, p); // s = C1^x mod p
        BigInteger sInv = s.modInverse(p); // modular inverse of s
        BigInteger decryptedMessage = (C2.multiply(sInv)).mod(p);

        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
