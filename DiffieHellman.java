import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {

    public static void main(String[] args) {
        // Publicly known values
        BigInteger p = new BigInteger("23"); // prime number
        BigInteger g = new BigInteger("5");  // primitive root

        // Private keys (secretly chosen)
        BigInteger a = new BigInteger("6"); // Person A's private key
        BigInteger b = new BigInteger("15"); // Person B's private key

        // Calculate public keys
        BigInteger A = g.modPow(a, p); // (g^a) mod p
        BigInteger B = g.modPow(b, p); // (g^b) mod p

        // Exchange A and B, and then calculate the shared secret
        BigInteger secretA = B.modPow(a, p); // (B^a) mod p
        BigInteger secretB = A.modPow(b, p); // (A^b) mod p

        System.out.println("Public Key of A: " + A);
        System.out.println("Public Key of B: " + B);
        System.out.println("Shared Secret calculated by A: " + secretA);
        System.out.println("Shared Secret calculated by B: " + secretB);
    }
}
