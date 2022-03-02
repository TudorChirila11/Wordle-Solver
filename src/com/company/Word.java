package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Word {
    static char[] choose_secret_word(String[] Wordlist)
    {
        File file = new File("5Lwords");
        try {
            Random rand = new Random();
           // System.out.println(file.getAbsolutePath());
            //System.out.println(file.exists());
            Scanner reader = new Scanner(file);
            int nrrandom = (rand.nextInt() % 5757 + 5757) % 5757, i = 0;
            return Wordlist[nrrandom].toCharArray();
        }
       catch(FileNotFoundException e)
        {
            return "wowie".toCharArray();
        }
    }
    static int compare(String a, String b)
    {
        if(a.length()<b.length())
            return -1;
        else if(a.length()>b.length())
            return 1;
        for(int i=0;i<a.length();++i)
        {
            if(a.charAt(i)<b.charAt(i))
                return -1;
            else if(a.charAt(i)>b.charAt(i))
                return 1;
        }
        return 0;
    }
    static boolean find_word(char[] word, String[] Wordlist)
    {
           int l=0, r=Wordlist.length-1;
           while(l<=r)
           {
               int m=(l+r+1)/2;
               if(compare(Wordlist[m],word.toString())<=0)
                   l=m;
               else r=m-1;
           }
           if(l>=Wordlist.length)
               return false;
           return (compare(Wordlist[l],word.toString())==0);
    }
    static char[] found_word = new char[5];
    static boolean flag=false;
    static int bkt_count=0;
    static void bkt(ArrayList<Character>[] a, int k, String[] Wordlist)
    {
        if(k<5&&!flag)
        {
            for(int i=0;i<a[k].size()&&!flag;++i) {
                found_word[k] = a[k].get(i);
                bkt(a,k+1,Wordlist);
            }
        }
        else if(k==5&&!flag)
        {
            bkt_count++;
            if(find_word(found_word,Wordlist))
                flag=true;
            if(bkt_count%100==0)
                System.out.println(found_word);
        }
    }
    static char[] choose_word(ArrayList<Character>[] a, String [] Wordlist)
    {
        flag=false;
        bkt(a,0,Wordlist
        );
        return found_word;
    }
}
