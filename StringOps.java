public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        capVowelsLowRest("Hello World");
        camelCase("   Intro  to   coMPUter    sCIEncE ");
        allIndexOf("Hello world",'l'); // output: {2, 3, 9}
    }

    public static String capVowelsLowRest (String string) {
        String vowels = "aeiou";
        String withBigVowels = "";
        boolean isVowel = false;
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < vowels.length(); j++) {
                if (string.charAt(i) == vowels.charAt(j)) {
                    withBigVowels += (char) (string.charAt(i) - 32);
                    isVowel = true;
                }
            }
            if ((string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') && !isVowel) {
                withBigVowels += (char) (string.charAt(i) + 32);
            } else if (!isVowel) {
                withBigVowels += string.charAt(i);
            }
            isVowel = false;
        }
        return withBigVowels;
    }

    public static String camelCase (String string) {
        String camelCaseStr = "";
        int j = 0;
        boolean nextWord = false;
        do {
            if (string.charAt(j) == ' ') {
                j++;
            }
        } while (j < string.length() && string.charAt(j) == ' ');
        // Change first appearing letter to lowercase or if it's lowercase then add it
        if (string.charAt(j) >= 'A' && string.charAt(j) <= 'Z') {
                camelCaseStr += (char) (string.charAt(j) + 32);
        } else if (string.charAt(j) >= 'a' && string.charAt(j) <= 'z') {
            camelCaseStr += string.charAt(j);
        }
        for (int i = j + 1; i < string.length(); i++) {
            // if it's a new word (was a space before it) then check if capital or lowercase
            if (nextWord && (string.charAt(i) >= 'a' && string.charAt(i) <= 'z')) {
                camelCaseStr += (char) (string.charAt(i) - 32);
                nextWord = false;
            } else if (nextWord && (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z')){
                camelCaseStr += string.charAt(i);
                nextWord = false;
            // if it's still the same word = change capital letters to lowercase
            } else if (!nextWord && (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z')) {
                camelCaseStr += (char) (string.charAt(i) + 32);
            } else if (!nextWord && (string.charAt(i) >= 'a' && string.charAt(i) <= 'z')) {
                camelCaseStr += string.charAt(i);
            // if it's not a letter but a 'space' - than mark it a new word
            } else if (string.charAt(i) == ' ') {
                nextWord = true;
            }
        }
        return camelCaseStr;
    }

    public static int[] allIndexOf (String string, char chr) {
        /* The func receives a (not empty) string and at least once appearing char in it
         * first itr in the string and count the given char
         * then itr again and check what is the index of it 
         */
        int countChar = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                countChar++;
            }
        }
        // "Hello World"
        int[] charAppearance = new int[countChar];
        int subStrIndex = 0;
        int i = 0;
        int originalStrIndexCount = 0;
        String subStr = string;
        while (subStr.indexOf(chr) != -1) {
            if (subStrIndex == subStr.indexOf(chr)) {
                charAppearance[i] = originalStrIndexCount + subStr.indexOf(chr); // 0 + 2 = 2
                subStr = subStr.substring(subStrIndex + 1); // "lo World" > "o World" > "d"
                originalStrIndexCount += subStrIndex + 1; // 2 + 1 = 3
                subStrIndex = 0;
                i++;
            } else {
                subStrIndex++;
            }
        }
        return charAppearance;
    }

    public static void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++){
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
                
            } else {
                System.out.print(arr[i] + "}");
            }
        }
    }
}
