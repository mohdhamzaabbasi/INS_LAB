import java.util.*;

public class ColumnarTranspositionCipher {

    public static String encrypt(String text, String key) {
        int col = key.length();
        int row = (int) Math.ceil((double) text.length() / col);

        char[][] matrix = new char[row][col];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (k < text.length())
                    matrix[i][j] = text.charAt(k++);
                else
                    matrix[i][j] = 'X'; // Padding
            }
        }

        StringBuilder cipherText = new StringBuilder();
        char[] keyArr = key.toCharArray();
        Character[] keyChars = new Character[keyArr.length];
        for (int i = 0; i < keyArr.length; i++) {
            keyChars[i] = keyArr[i];
        }

        Arrays.sort(keyChars);

        for (char c : keyChars) {
            int colIndex = key.indexOf(c);
            for (int i = 0; i < row; i++) {
                cipherText.append(matrix[i][colIndex]);
            }
        }

        return cipherText.toString();
    }

    public static void main(String[] args) {
        String text = "WEAREDISCOVERED";
        String key = "4312567";

        String cipherText = encrypt(text.replaceAll("\\s+", ""), key);

        System.out.println("Plain Text: " + text);
        System.out.println("Encrypted Text: " + cipherText);
    }
}
