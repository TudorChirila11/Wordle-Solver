package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Solver {
    static void solve()
    {
        boolean[] yellowed = new boolean[30];
        String [] Wordlist=new String[5757];
        Sorter.parse(Wordlist);
        Arrays.sort(Wordlist);
        ArrayList<Character>[] a = new ArrayList[5];
        for(int i=0;i<5;++i)
            a[i]= new ArrayList<>();
        char cword[]= Word.choose_secret_word(Wordlist);
        String word_choose_mode, play_mode="manual";
        String scword = new String(cword);
        if(play_mode=="automated")
        System.out.println("The wizard chose a random secret word. ("+scword+")");
        else System.out.println("You chose a word, master wizard, and imma guess it.");
        Letters.initialize(a);
        // System.out.println(a[2].size());
        while(Checker.Tries<6)
        {
            Checker.Tries++;
            System.out.println("Trial number "+ Checker.Tries);
            if(Checker.Tries<=2)
                word_choose_mode="query";
            else word_choose_mode="brute";
            char word[]=Word.choose_word(a,Wordlist, word_choose_mode);
            String sword= new String(word);
//            char word[]= Arrays.copyOf(word2, word2.length);
            System.out.println("I chose the word "+sword+".");
            if(Arrays.equals(word,cword))
            {
                System.out.println("I defeated the wizard! Congratulations to me!");
                return;
            }
            char result[]= new char[5];
            if(play_mode=="automated")
                result=Checker.Spit(sword.toCharArray(),scword.toCharArray());
            else result=Checker.Introduce_Verdict();
            String sresult = new String (result);
            System.out.println("The wizard gave me the verdict: "+ sresult);
            Arrays.fill(yellowed,false);
            for(int i=0;i<5;++i)
                if(result[i]=='Y'||result[i]=='G')
                    yellowed[word[i]-'a']=true;
         /*   System.out.println("before");
            for(int i=0;i<5;++i)
                System.out.println(a[i]);
            System.out.println();*/
            for(int i=0;i<5;++i)
            {
                if(result[i]=='G')
                {
                    Letters.prioritize(a[i],word[i]);
                    for(int j=a[i].size()-1;j>0;--j)
                        a[i].remove(j);
                }
                else if(result[i]=='Y')
                {
                    ///purge in i, prioritize in celelalte
                    Letters.purge(a[i],word[i]);
                    for(int j=0;j<5;++j)
                        if(i!=j)
                            Letters.prioritize(a[j],word[i]);
                }
                else
                {
                    Letters.purge(a[i],word[i]);
                    ///purge peste tot unde nu am deja o solutie
                    if(!yellowed[word[i]-'a'])
                        for(int j=0;j<5;++j)
                            if(a[j].size()>1)
                                Letters.purge(a[j],word[i]);
                }
            }
           /* System.out.println("After");
            for(int i=0;i<5;++i)
                System.out.println(a[i]);
            System.out.println();*/
        }
        if(Checker.Tries==6) {
            if(play_mode=="automated")
            System.out.println("Perish, mortal! The word was " + scword + ".");
            else System.out.println("Only you know the word, master...");
        }
    }
}
