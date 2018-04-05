import java.util.*;
import java.io.*; 
public class Hangman_Arunganesh
{
    public static void main(String[] args) throws Exception
    {
        Scanner console = new Scanner(System.in);
        Random randomGen = new Random(); 
        System.out.println("Welcome to Hangman App!"); 
        int number = randomGen.nextInt(7288) +1 ; 
        String secret = ""; 
        Scanner wordC = new Scanner(new File("hangmanwords.txt")); 
        for (int i = 1; i < number; i++)
        {
            wordC.nextLine(); 
        }
        secret = wordC.nextLine(); 
        wordC.close(); 
        String [] secretWord = new String [secret.length()]; 
        String [] masked = new String [secret.length()]; 
        for (int i = 0; i < secret.length(); i++)
        {
            secretWord [i] = secret.substring(i, i+1); 
            masked [i] = "_"; 
        }
        String guessed = ""; 
        int r = 6; 
        int co = 0; 
        String u = ""; 
        boolean win = false;  
        String [] past = new String [6]; 
        while (r>0)
        {
            switch(r)
            {
                case 1: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|        0");
                System.out.println("|       /|\\"); 
                System.out.println("|       /");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break; 

                case 2: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|        0");
                System.out.println("|       /|\\"); 
                System.out.println("|");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break;

                case 3: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|        0");
                System.out.println("|       /|"); 
                System.out.println("|");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break;

                case 4: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|        0");
                System.out.println("|        |"); 
                System.out.println("|");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break;

                case 5: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|        0");
                System.out.println("|"); 
                System.out.println("|");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break;

                case 6: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|");
                System.out.println("|"); 
                System.out.println("|");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break;
            }
            System.out.println("Guessed letters: " + guessed); 
            System.out.println("Guesses remaining: " + r + "\n"); 
            System.out.println("Word to guess: " + Arrays.toString(masked) + "\n"); 
            System.out.print("Enter your guess letter >>> "); 
            u = console.nextLine(); 
            boolean right = false; 
            for (int i = 0; i < secretWord.length; i++)
            {
                if (secretWord[i].equals(u))
                {
                    masked [i] = secretWord[i]; 
                    co++; 
                    right = true; 
                }
            }
            if (right == false)
            {
                if (r == 6)
                {
                    past[0] = u; 
                    guessed += u; 
                }
                else 
                {
                    boolean same = false; 
                    for (int i = 0; i < 6-r; i++)
                    {
                        if (past[i].equals(u))
                        {
                            r++; 
                            same = true; 
                        }
                    }
                    if (same == false)
                    {
                        past[past.length-r] = u; 
                        guessed += u; 
                    }
                }
                r--; 
            }
            System.out.println("\u000c");
            try 
            { 
                Thread.sleep(1500); 
            } 
            catch (Exception e) 
            {

            }
            if (co == secretWord.length)
            {
                win = true; 
                break; 
            }
        }
        if (win == true)
        {
            switch(r)
            {
                case 1: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|        0");
                System.out.println("|       /|\\"); 
                System.out.println("|       /");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break; 

                case 2: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|        0");
                System.out.println("|       /|\\"); 
                System.out.println("|");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break;

                case 3: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|        0");
                System.out.println("|       /|"); 
                System.out.println("|");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break;

                case 4: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|        0");
                System.out.println("|        |"); 
                System.out.println("|");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break;

                case 5: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|        0");
                System.out.println("|"); 
                System.out.println("|");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break;

                case 6: System.out.println(" ---------");
                System.out.println("|        |");
                System.out.println("|");
                System.out.println("|"); 
                System.out.println("|");
                System.out.println("|\n|\n|"); 
                System.out.println("-------------------"); 
                break;
            }
            System.out.println("Congratulations! You have successfully guessed the word: " + secret); 
        }
        else 
        {
            System.out.println(" ---------");
            System.out.println("|        |");
            System.out.println("|        0");
            System.out.println("|       /|\\"); 
            System.out.println("|       / \\");
            System.out.println("|\n|\n|"); 
            System.out.println("-------------------"); 
            System.out.println("You have been defeated! The word to guess was: " + secret); 
            
        }
    }
}
