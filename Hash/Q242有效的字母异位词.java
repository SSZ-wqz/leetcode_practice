package Hash;

public class Q242有效的字母异位词 {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false; // Anagrams must have the same length
    }
    int[] record = new int[26];
    for (int i = 0; i < s.length(); i++) {
      record[s.charAt(i) - 'a']++;
      record[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < record.length; i++) {
      if (record[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
