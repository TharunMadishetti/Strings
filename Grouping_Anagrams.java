//problem link ...https://leetcode.com/problems/group-anagrams/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> map= new HashMap<>();
        
        for(String str:strs)
        {
            char[] ar= str.toCharArray();
            Arrays.sort(ar);
            String key= String.valueOf(ar);
            
            if(!map.containsKey(key))
            {
                List<String> list=new ArrayList<>();  // we insert the word(of sorted order) as a key and append the actual string into a new list
                list.add(str);
                map.put(key,list);
            }
            else
            {
                List<String> list=map.get(key);  //as the key is already found ,we can directly insert the string into the list with same key
                list.add(str);
                map.put(key,list);
            }  
        }
        
        return new ArrayList<>(map.values()); //we are returning all the values in the map which are grouped anagrams
    }
}
