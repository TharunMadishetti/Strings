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
