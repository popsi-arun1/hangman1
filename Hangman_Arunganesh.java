//Name: Adithya Arunganesh
//Period: 4A

import java.util.*;
import java.io.*; 
public class Hangman_Arunganesh
{
    public static void main(String[] args) throws Exception
    {
        Scanner console = new Scanner(System.in);
        Random randomGen = new Random(); 
        int[] a = {5, 34, 3, -6, 7, 81, 1, 7, 5, 2, 2, 53, 4, 5, 62, 7};
        int[] b = {1, 3, 4, 90, -4, 60, 12, 13, 4, -4, -1, 2, 4, 4, 9, 8};

        //2
        int sum = 0; 
        for (int i = 0; i < a.length; i++)
        {
            sum += a[i] + b[i]; 
        }
        System.out.println("Integer average of all elements in a and b>>> " + (sum/(a.length+b.length))); 
        System.out.println(); 

        //3
        sum = 0; 
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] - b[i] <= 2 && a[i] - b[i] >= -2 && a[i] - b[i] != 0)
            {
                sum++; 
            }
        }
        System.out.println("Number of times the elements at the same index in both arrays differ by 2 or less, but are not equal>>> " + sum); 
        System.out.println(); 

        //4
        int even = 0; 
        int odd = 0; 
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] % 2 == 0)
            {
                even++; 
            }
            else 
            {
                odd++; 
            }
            if (b[i] % 2 == 0)
            {
                even++; 
            }
            else 
            {
                odd++; 
            }
        }
        if (even > odd)
        {
            System.out.println("More even than odd!"); 
        }
        else if (odd > even)
        {
            System.out.println("More odd than even!"); 
        }
        System.out.println(); 

        //5
        boolean g = true;
        for (int i = 0; i < a.length - 2; i++)
        {
            if (a[i] < a[i+1] && a[i+1] < a[i+2] || b[i] < b[i+1] && b[i+1] < b[i+2] )
            {
                System.out.println("Found three in a row!"); 
                g = false; 
                break; 
            }
        }
        if (g == true)
        {
            System.out.println("Didn't find three in a row!"); 
        }
        System.out.println(); 

        //7
        boolean f = false; 
        g = false; 
        for (int i = 0; i < a.length-1; i++)
        {
            if (a[i] == 2 && a[i+1] == 2)
            {
                f = true; 
            }
            if (a [i] == 4 && a [i+1] == 4)
            {
                g = true; 
            }
        }
        if (f == true && g == true)
        {
            System.out.println("Not two/four!"); 
        }
        else if (f == true || g == true)
        {
            System.out.println("Two/four!");
        }
        else 
        {
            System.out.println("Not two/four!");
        }
        System.out.println(); 

        //8
        int [] c = new int [a.length]; 
        System.out.print("Array a reversed>>> "); 
        for (int i = c.length-1, j = 0; i >= 0; i--, j++)
        {
            c[j] = a[i]; 
            System.out.print(c[j] + " "); 
        }
        System.out.println("\n"); 

        //9
        int max = 0; 
        int min = 0; 
        Arrays.sort(a); 
        Arrays.sort(b);
        min = Math.min(a[0], b[0]); 
        max = Math.max(a[a.length-1], b[b.length-1]); 
        System.out.println("Range of arrays>>> " + (max-min));
        System.out.println("\n"); 

        //Hangman App 
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
