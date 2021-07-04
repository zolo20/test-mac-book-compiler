import java.util.Arrays;
import java.util.regex.Pattern;

public class DecodeLine {
    public static void main(String[] args) {
        String line = "12[ab]ke2[c]";
        System.out.println(decodedLine(line));
    }

    public static String decodedLine(String line) {
        if (!line.contains("[") || !line.contains("]")) {
            return line;
        }

        int[] strIndex = new int[line.length()];
        int index = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '[') {
                index++;
            } else if (line.charAt(i) == ']') {
                index--;
            }
            strIndex[i] = index;
        }

        for (int i = 1; i < strIndex.length; i++) {
            if (strIndex[i - 1] < strIndex[i]) {
                String tempStr = "";
                String num = getNumber(line, i, String.valueOf(line.charAt(i - 1)));
                int tempNum = Integer.parseInt(num);
                int j = i + 1;
                while (strIndex[j - 1] <= strIndex[j] || strIndex[j] != 0) {
                    tempStr += line.charAt(j);
                    j++;
                }
                line = line.replaceAll(Pattern.quote(line.substring(i - num.length(), j + 1)), tempStr.repeat(tempNum));
                break;
            }
        }
        return decodedLine(line);
    }

    private static String getNumber(String line, int i, String num) {
        int k = i - 2;
        String tmpNum = num;
        while (k >= 0 && tmpNum.matches("\\d+")) {
            tmpNum = line.charAt(k) + tmpNum;
            if (tmpNum.matches("\\d+")) {
                num = tmpNum;
            }
            k--;
        }
        return num;
    }
}
