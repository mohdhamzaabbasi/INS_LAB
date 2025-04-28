public class RailFenceCipher {

    public static String encrypt(String text, int rails) {
        if (rails == 1) return text;

        StringBuilder[] rail = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) {
            rail[i] = new StringBuilder();
        }

        int dir = 1; // 1: down, -1: up
        int row = 0;

        for (char c : text.toCharArray()) {
            rail[row].append(c);

            if (row == 0) dir = 1;
            else if (row == rails - 1) dir = -1;

            row += dir;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rail) {
            result.append(sb);
        }

        return result.toString();
    }

    public static String decrypt(String cipher, int rails) {
        if (rails == 1) return cipher;

        boolean[][] marker = new boolean[rails][cipher.length()];
        int dir = 1, row = 0;

        for (int i = 0; i < cipher.length(); i++) {
            marker[row][i] = true;
            if (row == 0) dir = 1;
            else if (row == rails - 1) dir = -1;
            row += dir;
        }

        char[][] matrix = new char[rails][cipher.length()];
        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < cipher.length(); j++) {
                if (marker[i][j] && index < cipher.length()) {
                    matrix[i][j] = cipher.charAt(index++);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        dir = 1; row = 0;
        for (int i = 0; i < cipher.length(); i++) {
            result.append(matrix[row][i]);
            if (row == 0) dir = 1;
            else if (row == rails - 1) dir = -1;
            row += dir;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String text = "HELLO WORLD";
        int rails = 3;

        String encrypted = encrypt(text.replaceAll("\\s+", ""), rails);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, rails);
        System.out.println("Decrypted: " + decrypted);
    }
}
