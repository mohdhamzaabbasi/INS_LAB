import java.math.BigInteger;

public class SimpleRSADecryption {

    public static void main(String[] args) {
        int p = 3;
        int q = 11;

        int n = p * q; // 33
        int phi = (p - 1) * (q - 1); // 20

        int e = 7;
        int d = 3; // d calculated manually or using Extended Euclidean Algorithm

        BigInteger cipher = BigInteger.valueOf(14); // Encrypted message we got earlier

        // Decryption: (cipher ^ d) mod n
        BigInteger decryptedMessage = cipher.pow(d).mod(BigInteger.valueOf(n));

        System.out.println("Encrypted Message: " + cipher);
        System.out.println("Decrypted (Original) Message: " + decryptedMessage);
    }
}
