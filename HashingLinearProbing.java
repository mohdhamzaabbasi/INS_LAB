import java.util.Arrays;

public class HashingLinearProbing {

    public static void main(String[] args) {
        int tableSize = 7;
        int[] hashTable = new int[tableSize];
        Arrays.fill(hashTable, -1); // -1 means empty

        int[] keys = {10, 20, 15, 7, 22, 32};

        for (int key : keys) {
            int index = key % tableSize;

            while (hashTable[index] != -1) {
                index = (index + 1) % tableSize; // Linear probing
            }
            hashTable[index] = key;
        }

        // Display hash table
        for (int i = 0; i < tableSize; i++) {
            System.out.println(i + " --> " + (hashTable[i] == -1 ? "Empty" : hashTable[i]));
        }
    }
}
