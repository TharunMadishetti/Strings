//Problem link: https://leetcode.com/problems/word-subsets/

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> l = new ArrayList<String>();
        int[] f = new int[255];
        Arrays.fill(f,0);
        String s="";
        for(int i=0;i<words2.length;i++)
        {
            s=freq(words2[i],f,s);
            System.out.println(s);
        }
        
        for(int i=0;i<words1.length;i++)
        {
            
            if(subs(words1[i],s))
                l.add(words1[i]);
        }
        return l;
    }
    public String freq(String s,int[] f,String res)
    {
        int[] tf = new int[255];
        Arrays.fill(tf,0);
        for(int i=0;i<s.length();i++)
        {
            tf[(int)s.charAt(i)]++;
        }
        for(int i=0;i<s.length();i++)
        {
            if(f[(int)s.charAt(i)]==0)
            {
                res=res+Character.toString(s.charAt(i));
                f[(int)s.charAt(i)]++;
            }
            else
            {
                if(f[(int)s.charAt(i)]>=tf[(int)s.charAt(i)])
                    continue;
                else
                {
                    res=res+Character.toString(s.charAt(i));
                    f[(int)s.charAt(i)]++;
                }
            }
            
        }
        return res;
    }
    public boolean subs(String a,String b)
    {
        
        
        
        HashMap<Character,Integer> h = new HashMap<>();
        for(int i=0;i<a.length();i++)
        h.put(a.charAt(i),h.getOrDefault(a.charAt(i),0)+1);
        
        HashMap<Character,Integer> h2 = new HashMap<>();
        for(int i=0;i<b.length();i++)
        h2.put(b.charAt(i),h2.getOrDefault(b.charAt(i),0)+1);
        
        for(int i=0;i<b.length();i++)
        {
            if(h2.get(b.charAt(i))<=h.getOrDefault(b.charAt(i),0))
                continue;
            else
                return false;
        }
        return true;
//         int[] f = new int[255];
//         Arrays.fill(f,0);
//         for(int i=0;i<a.length();i++)
//         {
//             f[(int)a.charAt(i)]++;
//         }
        
//         int[] f2 = new int[255];
//         Arrays.fill(f2,0);
//         for(int i=0;i<b.length();i++)
//         {
//             f2[(int)b.charAt(i)]++;
//         }
        
//         for(int i=0;i<255;i++)
//         {
//             if(f[i]>=f2[i])
//                 continue;
//             else
//                 return false;
//         }
//         return true;
//         char[] c = a.toCharArray();
//         char[] c2 = b.toCharArray();
//         HashSet<Character> h = new HashSet<>();
//         for(char ch : c)
//             h.add(ch);
//         HashSet<Character> h2 = new HashSet<>();
        //System.out.println(h);
        //return true;
//         for(char ch : c2)
//             h2.add(ch);
        
//         h.retainAll(h2);
//         return h.size()==h2.size();
    }
}
