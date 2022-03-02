package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Checker {
    static int Tries=0;
    static char @NotNull [] Spit(char[] word, char[] cword)
    {
        boolean[] locally_found = new boolean[5];
        char[] ans = new char[5];
        Arrays.fill(ans,'B');
        for(int i=0;i<5;++i) {
            if(word[i]==cword[i])
            {
                ans[i]='G';
                locally_found[i]=true;
            }
        }
        for(int i=0;i<5;++i)
        {
            for(int j=0;j<5;++j)
                if(!locally_found[j]&&word[i]==cword[j])
                {
                    ans[i]='Y';
                    locally_found[j]=true;
                }
        }
        return ans;
    }
}
