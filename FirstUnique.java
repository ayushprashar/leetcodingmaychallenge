/*
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters. 
*/

public class FirstUnique {
	class MapNode {
        int index;
        char letter;
        MapNode next;
        MapNode prev;
        
        MapNode(){}
        MapNode(int index, char c) {
            this.index = index;
            this .letter = c;
        }
    }
    MapNode head;
    MapNode tail;
    public int firstUniqChar(String s) {
        
        Map<Character, MapNode> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(!map.containsKey(c)) {
                MapNode node = new MapNode(i,c);
                map.put(c, node);
                insertInList(node);
            } else {
                if(map.get(c) != null) {
                    MapNode node = map.get(c);
                    removeNode(node);
                    map.put(c,null);
                }
            }
        }
        if(head == null)
            return -1;
        else return head.index;
    }
    
    private void insertInList(MapNode node) {
        if(tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }
    
    private void removeNode(MapNode node) {
        if((head == node) && (tail == node)) {
            head = null;
            tail = null;
        } else if(head == node) {
            head = head.next;
            head.prev = null;
            node.next = null;
        } else if(tail == node) {
            tail = tail.prev;
            tail.next = null;
            node.prev = null;
        } else {
            MapNode prev = node.prev;
            MapNode next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
        }
    }

}