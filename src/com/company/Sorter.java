package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Sorter {
    static void parse(String[] a)
    {
        try
        {
            File L5Words=new File("5Lwords_S");
            Scanner reader = new Scanner(L5Words);
            int n=0;
            while(reader.hasNextLine())
                a[n++]=reader.nextLine();
        }
        catch(FileNotFoundException e)
        {

        }
        catch(IOException e)
        {

        }
    }


}
