package Methods;

public class Palindrome {

    public static void main(String[] args) {
        String palindrome = "Леша на полке клопа нашел";
        System.out.println(isPalindrome(palindrome));
    }

    public static boolean isPalindrome(String text) {
        String cleaned = text.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();;

        StringBuilder readReverse = new StringBuilder();
        int j = cleaned.length() - 1;
        for (int i = 0; i < cleaned.length(); i++) {
            if (cleaned.charAt(i) == cleaned.charAt(j)) {
                readReverse.append(cleaned.charAt(i));
            }
            j--;
        }
        return cleaned.compareTo(String.valueOf(readReverse)) == 0;
    }
}
