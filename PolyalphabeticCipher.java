public class PolyalphabeticCipher {

    public static String generateKey(String text, String key) {
        StringBuilder newKey = new StringBuilder(key);
        while (newKey.length() < text.length()) {
            newKey.append(key);
        }
        return newKey.substring(0, text.length());
    }

    public static String encrypt(String text, String key) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char x = (char)(((text.charAt(i) + key.charAt(i)) % 26) + 'A');
            cipherText.append(x);
        }
        return cipherText.toString();
    }

    public static String decrypt(String cipherText, String key) {
        StringBuilder origText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char x = (char)((((cipherText.charAt(i) - key.charAt(i)) + 26) % 26) + 'A');
            origText.append(x);
        }
        return origText.toString();
    }

    public static void main(String[] args) {
        String text = "HELLO";
        String keyword = "KEY";

        text = text.toUpperCase();
        keyword = keyword.toUpperCase();

        String key = generateKey(text, keyword);
        String cipherText = encrypt(text, key);
        String decryptedText = decrypt(cipherText, key);

        System.out.println("Original Text: " + text);
        System.out.println("Generated Key: " + key);
        System.out.println("Encrypted Text: " + cipherText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
