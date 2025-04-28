import java.util.*;

public class PlayfairCipher {
    private static char[][] matrix = new char[5][5];

    public static void generateMatrix(String key) {
        boolean[] used = new boolean[26];
        key = key.toUpperCase().replaceAll("J", "I");

        int x = 0, y = 0;
        for (char c : key.toCharArray()) {
            if (c < 'A' || c > 'Z') continue;
            if (!used[c - 'A']) {
                matrix[x][y++] = c;
                used[c - 'A'] = true;
                if (y == 5) {
                    y = 0;
                    x++;
                }
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'J') continue;
            if (!used[c - 'A']) {
                matrix[x][y++] = c;
                used[c - 'A'] = true;
                if (y == 5) {
                    y = 0;
                    x++;
                }
            }
        }
    }

    public static String prepareText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replaceAll("J", "I");
        StringBuilder prepared = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            prepared.append(text.charAt(i));
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                prepared.append('X');
            }
        }
        if (prepared.length() % 2 != 0) {
            prepared.append('X');
        }
        return prepared.toString();
    }

    public static String encrypt(String text) {
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);

            if (posA[0] == posB[0]) { // Same row
                cipher.append(matrix[posA[0]][(posA[1] + 1) % 5]);
                cipher.append(matrix[posB[0]][(posB[1] + 1) % 5]);
            } else if (posA[1] == posB[1]) { // Same column
                cipher.append(matrix[(posA[0] + 1) % 5][posA[1]]);
                cipher.append(matrix[(posB[0] + 1) % 5][posB[1]]);
            } else { // Rectangle
                cipher.append(matrix[posA[0]][posB[1]]);
                cipher.append(matrix[posB[0]][posA[1]]);
            }
        }
        return cipher.toString();
    }

    public static int[] findPosition(char c) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (matrix[i][j] == c)
                    return new int[]{i, j};
        return null;
    }

    public static void main(String[] args) {
        String key = "MONARCHY";
        String plainText = "INSTRUMENTS";
        
        generateMatrix(key);
        String preparedText = prepareText(plainText);
        String cipherText = encrypt(preparedText);

        System.out.println("Plain Text: " + plainText);
        System.out.println("Prepared Text: " + preparedText);
        System.out.println("Encrypted Text: " + cipherText);
    }
}