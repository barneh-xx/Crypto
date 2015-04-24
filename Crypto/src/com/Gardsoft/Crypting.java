package com.Gardsoft;

import javax.crypto.spec.PSource;

/**
 * Created by gehag on 2014-01-16.
 */
public class Crypting
{
    private int pCryptKey = 1;
    private String pCryptedMessage = "";
    private String pDeCryptedMessage = "";
    private static String[] pAlphaArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "ä", "ö", "å"};
    private static String[] pSpecialCharArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "/", "-", "*", ".", ",", "=", "?", "!", "&"};
    private static String pCryptMessageStr = "";

    public void crypt(String parInput)
    {
        if(parInput.matches("^[\\d]+$"))
        {
            setCryptedMessage(parInput);
            return;
        }

        for(int i = 0; i < parInput.length(); i++)
        {
            if(Character.toString(parInput.charAt(i)).toLowerCase().matches("a"))
            {
                pCryptMessageStr += pAlphaArray[pAlphaArray.length - 1];
            }
            else
            {
                for(int j = 0; j < pAlphaArray.length; j++)
                {
                    if(IsSpecialCharacter(parInput.charAt(i)))
                    {
                    	break;
                    }
                    else
                    {
                    	if(Character.toString(parInput.charAt(i)).toLowerCase().matches(pAlphaArray[j]))
                    	{
                    		if(Character.isUpperCase(parInput.charAt(i)))
                    		{
                    			pCryptMessageStr += pAlphaArray[j - pCryptKey].toUpperCase().toString();
                    		}
                    		else
                    		{
                    			pCryptMessageStr += pAlphaArray[j - pCryptKey].toString();
                    		}
                    		break;
                    	}
                    }
                }
                
                //setCryptedMessage(parInput);
            }

        }

        setCryptedMessage(pCryptMessageStr);
        pCryptMessageStr = "";
    }

    public String deCrypt(String parInput)
    {
        // Todo Code
        return pCryptMessageStr;
    }

    public boolean IsSpecialCharacter(Character pChar)
    {
    	boolean bIsSpecial = false;
    	
    	for(int i = 0; i < pSpecialCharArray.length; i++)
    	{
    		if(Character.toString(pChar).equals(pSpecialCharArray[i].toString()))
    		{
    			pCryptMessageStr += pChar.toString();
    			bIsSpecial = true;
    		}
    		//break;
    	}
    	
    	return bIsSpecial;
    }
//---------------------------------------------------------------------------------------------------
    public String getCryptedMessage()
    {
        return pCryptedMessage;
    }

    private void setCryptedMessage(String parCryptedMessage)
    {
        pCryptedMessage += parCryptedMessage + " ";
    }

    public void resetCryptedMessage()
    {
        pCryptedMessage = "";
    }

    public String getDeCryptedMessage()
    {
        return pDeCryptedMessage;
    }

    @SuppressWarnings("unused")
	private void setDeCryptedMessage(String parDeCryptedMessage)
    {
        pDeCryptedMessage += parDeCryptedMessage = " ";
    }

    public void resetDeCryptedMessage()
    {
        pDeCryptedMessage = "";
    }
}
