package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class Checker {
    static int Tries=0;
    static char @NotNull [] Spit(char[] word, char[] cword)
    {
        boolean[] locally_found = new boolean[5];
        char[] ans = new char[5];
        Arrays.fill(ans,'B');
        Arrays.fill(locally_found,false);
        for(int i=0;i<5;++i) {
            if(word[i]==cword[i])
            {
                ans[i]='G';
                locally_found[i]=true;
            }
        }
        for(int i=0;i<5;++i) ///ma plimb prin cuv meu
            if(ans[i]!='G')
        {
            for(int j=0;j<5;++j) ///ma plimb prin ala corect
                if(!locally_found[j]&&word[i]==cword[j]) ///eroare aici
                {
                    ans[i]='Y';
                    locally_found[j]=true;
                }
        }
        return ans;
    }
    static char[] Introduce_Verdict()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Insert verdict, wizard:");
        String result = scanner.nextLine();
        if(result=="win")
            return "You won, computer".toCharArray();
        return result.toCharArray();
    }
}
