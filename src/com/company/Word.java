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
           // return ("crows".toCharArray());
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
            String sword=new String(word);
           while(l<r)
           {
               int m=(l+r+1)/2;
             //  if(Checker.Tries==5)
               //    System.out.println(l+" "+r+" "+m+" "+Wordlist[m]);
               if(compare(Wordlist[m],sword)<=0)
                   l=m;
               else r=m-1;
           }
           if(l>=Wordlist.length)
               return false;
           if(compare(Wordlist[l],sword)==0)
               return true;
           return false;
    }
    static char[] found_word = new char[5];
    static char[] cand = new char[5];
    static boolean flag=false;
    static int bkt_count=0;
    static int nrdmax=0;
    static int nrdif(char [] word)
    {
        int ans=0;
        int used[]= new int[26];
        Arrays.fill(used,0);
        for(int i=0;i<5;++i)
            used[word[i]-'a']=1;
        for(int i=0;i<26;++i)
            ans+=used[i];
        return ans;
    }
    static void bkt(ArrayList<Character>[] a, int k, String[] Wordlist, String mode)
    {
        if(k<5&&!flag)
        {
            for(int i=0;i<a[k].size()&&!flag;++i) {
                found_word[k] = a[k].get(i);
                bkt(a, k + 1, Wordlist, mode);
            }
        }
        else if(k==5&&!flag)
        {
           // if(Checker.Tries==5)
             //   System.out.println(found_word);
            bkt_count++;
            if(find_word(found_word,Wordlist)) {
                if(mode=="brute")
                    flag = true;
                else
                {
                    int x=nrdif(found_word);
                    if(x>nrdmax) {
                        nrdmax = x;
                        cand=Arrays.copyOf(found_word,5);
                    }
                    if(nrdmax==5)
                        flag=true;
                }
            }
        }
    }
    static char[] choose_word(ArrayList<Character>[] a, String [] Wordlist, String mode)
    {
        flag=false;
        nrdmax=0;
      //  if(Checker.Tries==5)
        //    System.out.println("am aj aici");
        bkt(a,0,Wordlist, mode);
        if(flag==false&&mode=="brute")
            return "nopos".toCharArray();
        if(mode=="brute")
        return found_word;
        return cand;
    }
}
