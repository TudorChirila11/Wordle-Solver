package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String [] Wordlist = new String[6000];
        Sorter.parse(Wordlist);
        ArrayList<Character>[] a = new ArrayList[5];
        for(int i=0;i<5;++i)
            a[i]= new ArrayList<>();
        char cword[]= Word.choose_secret_word(Wordlist);
        System.out.println("The wizard chose a random secret word.");
        Letters.initialize(a);
       // System.out.println(a[2].size());
        while(Checker.Tries<6)
        {
            Checker.Tries++;
            System.out.println("Trial number "+ Checker.Tries);
            char word[]= Arrays.copyOf(Word.choose_word(a,Wordlist), Word.choose_word(a,Wordlist).length);
            System.out.println(word);
            if(Arrays.equals(word,cword))
            {
                System.out.println("I defeated the wizard! Congratulations to me!");
                break;
            }
            char result[]=Checker.Spit(word,cword);
            System.out.println("The wizard gave me the verdict: "+ result.toString());
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
                    ///purge peste tot unde nu am deja o solutie
                    for(int j=0;j<5;++j)
                        if(a[j].size()>1)
                            Letters.purge(a[j],word[i]);
                }
            }
        }
        if(Checker.Tries==6)
            System.out.println("Perish, mortal! The word was "+cword+".");
    }
}
