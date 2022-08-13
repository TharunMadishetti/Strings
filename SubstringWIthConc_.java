
//Problem link: https://leetcode.com/problems/substring-with-concatenation-of-all-words/submissions/


//Problem stmt: You are given a string s and an array of strings words of the same length.
//Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and 
//without any intervening characters.


//Test Cases:
// Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
// Output: [6,9,12]
You can return the answer in any order.
class Solution {
    List<Integer> l;
    public List<Integer> findSubstring(String s, String[] w) {
        l=new ArrayList<Integer>();
        boolean[] v = new boolean[w.length];
        Arrays.fill(v,false);
        comb(s,w,"",v);
        return l;
    }
    public void comb(String s,String[] w,String pre,boolean[] v)
    {
        boolean all=true;
        for(boolean b : v)
        {
            if(!b)
                all=false;
        }
        if(all)
        {
            if(s.indexOf(pre)!=-1)
            {
                int index=s.indexOf(pre);
                while (index != -1) {
                 System.out.println(index);
                    if(!l.contains(index))
                        l.add(index);
                 index = s.indexOf(pre, index + 1);
                }
            }
                
            return ;
                
        }
        for(int i=0;i<w.length;i++)
        {
            if(!v[i] && s.indexOf(pre+w[i])!=-1)
            {
                v[i]=true;
                comb(s,w,pre+w[i],v);
                v[i]=false;
            }
        }
    }
}
