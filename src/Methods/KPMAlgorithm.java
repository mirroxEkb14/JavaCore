package Methods;

import java.util.ArrayList;
import java.util.List;

public class KPMAlgorithm {

    public static void main(String[] args) {
        String text =   "aabaabaaaaaabaabaabaabbaaab";
        String sample = "aabaab";

        searchNaive1(text, sample);
        searchNaive2(text, sample);

        System.out.println(KMPSearch(text, sample));
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();

        int[] prefixFunc = prefixFunction(sample);

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == sample.length()) {
                found.add((i - j));
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return found;
    }

    public static int[] prefixFunction(String sample) {
        int[] values = new int[sample.length()];

        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(i + j) == sample.charAt(j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }

    public static void searchNaive2(String text, String sample) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            int j = 0;
            while (j < sample.length() && i + j < text.length() && text.charAt(i + j) == sample.charAt(j)) {
                j++;
            }
            if (j == sample.length()) {
                list.add(i);
            }
        }

        System.out.println(list);
    }

    public static void searchNaive1(String text, String sample) {
        int resultCounter = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < sample.length(); j++) {
                if (i + j < text.length() && text.charAt(i + j) == sample.charAt(j)) {
                    if (j == sample.length() - 1) {
                        resultCounter++;
                    }
                } else {
                    j = sample.length();
                }
            }
        }
        System.out.println(resultCounter);
    }
}
