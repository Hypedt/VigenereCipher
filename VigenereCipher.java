import java.util.*;

class VigenereCipher {

    public static void main (String [] args)
    {
        Scanner input = new Scanner (System.in);

        //Two user inputs of the message and key
        System.out.print("Message: ");
        String message = input.nextLine();
        System.out.print("Keyword: ");
        String keyword = input.nextLine();

        //function method to encrypt and decrypt
        String encrypt = encryption(message, keyword);
        String decrypt = decryption(encrypt, keyword);

        //Print out of the messages
        System.out.println("Original Message: " + message);
        System.out.println("Keyword: " + keyword);
        System.out.println("Encrypted Message: " + encrypt);
        System.out.println("Decrypted Message: " + decrypt);
    }

    public static String encryption (String message, String keyword)
    {
        //Set both string to uppercases
        message = message.toUpperCase();
        keyword = keyword.toUpperCase();

        //Convert String to Char Array
        char text[] = message.toCharArray();
        //Get the character length of the array
        int textLen = text.length;
        int i,j;

        //create new char arrays with the same length as the message
        char key[] = new char[textLen];
        char encrypt[] = new char[textLen];

        //Generate the key in a loop at length of the text[] array
        for (i = 0, j = 0; i < textLen; i++, j++)
        {
            if (j == keyword.length())
            {
                j = 0;
            }
            key[i] = keyword.charAt(j);
        }

        //encryption of the message, includes ascii 32 - 96
        for (i = 0; i < textLen; i++)
        {
            encrypt[i] = (char) (((text[i] + key[i]) % 64) + ' ' );
        }

        return String.valueOf(encrypt);
    }

    public static String decryption (String message, String keyword)
    {
        //Set both string to uppercases
        message = message.toUpperCase();
        keyword = keyword.toUpperCase();

        //Convert String to Char Array
        char text[] = message.toCharArray();
        //Get the character length of the array
        int textLen = text.length;
        int i,j;

        //create new char arrays with the same length as the message
        char key[] = new char[textLen];
        char decrypt[] = new char[textLen];

        //Generate the key in a loop at length of the text[] array
        for (i = 0, j = 0; i < textLen; i++, j++)
        {
            if (j == keyword.length())
            {
                j = 0;
            }
            key[i] = keyword.charAt(j);
        }


        //decryption of the encryption message
        for (i = 0; i < textLen; i++)
        {
            decrypt[i] = (char) ((((text[i] - key[i]) + 64) % 64) + ' ');
        }

        return String.valueOf(decrypt);
    }

}
