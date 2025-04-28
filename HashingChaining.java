import java.util.*;

public class HashingChaining {

    public static void main(String[] args) {
        int tableSize = 7;
        LinkedList<Integer>[] hashTable = new LinkedList[tableSize];

        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = new LinkedList<>();
        }

        int[] keys = {10, 20, 15, 7, 22, 32};

        for (int key : keys) {
            int index = key % tableSize;
            hashTable[index].add(key);
        }

        // Display hash table
        for (int i = 0; i < tableSize; i++) {
            System.out.print(i + " --> ");
            for (int val : hashTable[i]) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
