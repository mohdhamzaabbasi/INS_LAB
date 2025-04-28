public class HillCipher {

    static int[][] key = { {3, 3}, {2, 5} }; // Example key matrix

    public static int mod26(int x) {
        return (x % 26 + 26) % 26;
    }

    public static String encrypt(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        if (text.length() % 2 != 0) text += "X"; // padding

        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            int a = text.charAt(i) - 'A';
            int b = text.charAt(i + 1) - 'A';

            int x = mod26((key[0][0] * a) + (key[0][1] * b));
            int y = mod26((key[1][0] * a) + (key[1][1] * b));

            cipherText.append((char)(x + 'A'));
            cipherText.append((char)(y + 'A'));
        }
        return cipherText.toString();
    }

    public static void main(String[] args) {
        String plainText = "HI";
        String cipherText = encrypt(plainText);

        System.out.println("Plain Text: " + plainText);
        System.out.println("Encrypted Text: " + cipherText);
    }
}
