package String;

public class Q151翻转字符串里的单词 {

    /**
     * 翻转给定string
     */
    public String reverseWords(String s) {
        StringBuilder sb = removeSpaces(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    /**
     * 移除前后的空格和每个单词中间多余的空格
     */
    private StringBuilder removeSpaces(String s) {
        int start = 0;
        int end = s.length() - 1;
        // 移除前后的空格
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        // 移除每个单词中间多余的空格
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') { // 这里非常的巧妙，他检测了多余的空格
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    /**
     * reverse the string given start and end
     */
    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    /**
     * reverse each word in the string that's been trimmed
     */
    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

}
