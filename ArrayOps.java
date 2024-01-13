public class ArrayOps {
    public static void main(String[] args) {
    System.out.println(findMissingInt(new int[] {1, 0}));
    // System.out.println(secondMaxValue(new int[] {2, 8, 3, 7, 8}));
    // containsTheSameElements(new int[] {1, 5}, new int[] {5, 1, 5, 1, 5});
    // isSorted(new int[] {1, -2, 3});
    }
    
    
    public static int findMissingInt (int [] array) {
        int missingInt = -1;
        boolean isMissing = false;
        for (int i = 0; i < array.length + 1; i++) {    
            for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
                /* Check if the value is in the array, if yes then
                 * continue to the next value in given array.
                 */
                if ((i != array[arrayIndex])) {
                    isMissing = true;
                    missingInt = i;
                } else if (i == array[arrayIndex]) {
                    isMissing = false;
                    break;
                }
            }
            if (isMissing == true) {
                break;
            }
        }
        return missingInt;
    }

    public static int secondMaxValue(int [] array) {
        int maxInt = 0;
        int secondMaxInt = 0;
        // Find maximum value
        for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
            maxInt = array[arrayIndex] > maxInt ? array[arrayIndex] : maxInt;
        }
        // Find second maximum value compared to the max
        for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
            if ((array[arrayIndex] <= maxInt) && array[arrayIndex] >= secondMaxInt) {
                secondMaxInt = array[arrayIndex];
            }
        }
        return secondMaxInt;
    }

        // {1, 2, 3, 2} {2, 1}
    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        int[] smallSet = array1.length < array2.length ? array1 : array2;
        int[] bigSet = array1.length > array2.length ? array1 : array2;
        boolean isSameSet = false;
        int count = 0;
        for (int i = 0; i < bigSet.length; i++) {
            for (int j = 0; j < smallSet.length; j++) {
                if (bigSet[i] != smallSet[j]) {
                    count++;
                } else if (bigSet[i] == smallSet[j]) {
                    count = 0;
                    isSameSet = true;
                    break;
                }
                if (count == smallSet.length) {
                    return isSameSet = false;
                }
            }
        }
        return isSameSet;
    }

    public static boolean isSorted(int [] array) {
        /* Divide to two events
         * 1. itr each number and check if the next one is bigger or the same
         * 2. if 1 didnt work, check if the next one is smaller or the same
         */
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        boolean isNotBoth = false;
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] == array[i + 1]) {
                continue;
            } else if ((array[i] < array[i + 1]) && isIncreasing) {
                isDecreasing = false;
            } else if ((array[i] > array[i + 1]) && isDecreasing) {
                isIncreasing = false;
            } else if ((isIncreasing && !isDecreasing) || (!isIncreasing && isDecreasing)) {
                return isNotBoth;
            }
        }
        return isDecreasing || isIncreasing;   
    }
}