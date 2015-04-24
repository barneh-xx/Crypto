package com.Gardsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by gehag on 2014-01-16.
 */
public class Main
{
    static boolean bProceed = true;
    static String pUserInputStr = "";
    static String pCryptedStr = "";
    static BufferedReader br = null;

    public static void main(String[] args)
    {
        Crypting pCrypt = new Crypting();
        br = new BufferedReader(new InputStreamReader(System.in));

        while(bProceed)
        {
            try
            {
                System.out.print("> ");
                pUserInputStr = br.readLine();

                if(pUserInputStr.matches("Exit") || pUserInputStr.matches("exit"))
                {
                    bProceed = false;
                    break;
                }

                String[] pStrInputDivided = pUserInputStr.split(" ");
                for(String pWord : pStrInputDivided)
                {
                    pCrypt.crypt(pWord);
                }

                printJob(pCrypt.getCryptedMessage());
                pCrypt.resetCryptedMessage();
                resetCryptMessage();
            }
            catch (IOException Ex)
            {
                System.out.println("Can't understand you're input!");
                System.out.println("Please try again...");
            }
        }
    }

    private static void printJob(String parInput)
    {
    	System.out.print("Crypted Messsage: ");
        System.out.println(parInput);
    }

    private static void resetCryptMessage()
    {
        pCryptedStr = "";
    }
}