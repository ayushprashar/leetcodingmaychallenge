/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2


*/

public class Majority {

	class Max {
        int element;
        int freq;
        
        Max(){}
        
        Max(int e, int f) {
            this.element = e;
            this.freq = f;
        }
    }
    public int majorityElement(int[] nums) {
        Max max = new Max(0,0);
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i<  nums.length; i++) {
            int num = nums[i];
            if(!freqMap.containsKey(num)) {
                freqMap.put(num,0);
            }
            int freq = freqMap.get(num) + 1;
            if(freq > max.freq) {
                max.element = num;
                max.freq = freq;
            }
            freqMap.put(num, freq);
        }
        return max.element;
    }
}