import java.math.BigInteger;
import java.util.Random;

public class SimpleRSAEncryption {

    public static void main(String[] args) {
        int p = 3; // small prime
        int q = 11; // small prime

        int n = p * q; // n = 33
        int phi = (p - 1) * (q - 1); // phi = 20

        int e = 7; // Choose e such that gcd(e, phi) = 1

        // Public Key: (e, n)
        // Private Key: (d, n), we calculate d later

        int message = 5; // Message must be smaller than n (5 < 33)

        // Encryption: (message ^ e) mod n
        BigInteger m = BigInteger.valueOf(message);
        BigInteger c = m.pow(e).mod(BigInteger.valueOf(n));

        System.out.println("Message: " + message);
        System.out.println("Encrypted Message: " + c);
    }
}
