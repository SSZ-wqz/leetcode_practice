package Hash;

public class Q383赎金信 {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] ransomNoteArr = new int[26];
    int[] magazineArr = new int[26];
    for (int i = 0; i < ransomNote.length(); i++) {
      ransomNoteArr[ransomNote.charAt(i) - 'a']++;
    } 
    for (int i = 0; i < magazine.length(); i++) {
      magazineArr[magazine.charAt(i) - 'a']++;
    } 
    for (int i = 0; i < magazineArr.length; i++) {
      ransomNoteArr[i] = ransomNoteArr[i] - magazineArr[i];
    } 
    for (int i = 0; i < ransomNoteArr.length; i++) {
      if (ransomNoteArr[i] > 0) {
        return false;
      }
    }
    return true;
  }
}
