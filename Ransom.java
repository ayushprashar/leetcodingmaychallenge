/*
 Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true


*/

public class Ransom {
	public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        
        for(int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            if(magazineMap.containsKey(c)) {
                magazineMap.put(c, magazineMap.get(c) + 1);
            } else {
                magazineMap.put(c,1);
            }
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            if(magazineMap.containsKey(c)) {
                if(magazineMap.get(c) == 1) {
                    magazineMap.remove(c);
                } else magazineMap.put(c, magazineMap.get(c) - 1);
            } else return false;
        }
        return true;
        
    }
}