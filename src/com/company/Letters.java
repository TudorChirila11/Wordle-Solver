package com.company;

import java.util.ArrayList;

public class Letters {
    static void initialize(ArrayList<Character>[] a)
    {
        char [] letterorder={'e','a','r','i','o','t','n','s','l','c','u','d', 'p','m','h','g','b','f','y','w','k','v','x','z','j','q'};
        for(int i=0;i<5;++i) {
            for (int j = 0; j < 26; ++j)
                a[i].add( letterorder[j]);
        }
    }
    static void purge(ArrayList<Character> a, char toRemove)
    {
            for(int j=0;j<a.size();++j)
                if(a.get(j)==toRemove)
                {
                    a.remove(j);
                    break;
                }
    }
    static void prioritize(ArrayList<Character> a, char toPrioritize)
    {
        boolean exists=false;
        ArrayList<Character> b = new ArrayList<>();
        for(int i=0;i<a.size();++i){
            if(a.get(i)!=toPrioritize)
                b.add(a.get(i));
            else exists=true;
        }
        a.clear();
        if(exists)
            a.add(toPrioritize);
        a.addAll(b);
    }
}
