package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static private void run(){
        String word="auto";
        char letter[] = new char[0];
        int life=9;
        Scanner start = new Scanner(System.in);
        String inp = start.next();
        if(inp.equalsIgnoreCase( "run")){
            hangman(word, life, letter);
        }

        else if (inp.equalsIgnoreCase("*")){
            System.out.println("vaarwel");
            System.exit(0);
        }

        else{

            run();
        }

    }


    static private void hangman(String word, int life, char[] letter){
        char[] placeholder = new char[word.length()];
        int i = 0;




       while(i < word.length()){
           placeholder[i] = '*';

           if(word.charAt(i) == ' '){
            placeholder[i] = ' ';
           }
           i++;
        }




        System.out.println(placeholder);
        System.out.println("levens over:" + life);


        Scanner f = new Scanner(System.in);

        ArrayList<Character> gebruikteletters = new ArrayList<Character>();
        int d = 0;


        while(life>0){
            String x = f.next();
            char y = x.charAt(0);
            if (x.length() > 1){
                System.out.println("je hebt teveel letters gebruikt");
            }

           else if (gebruikteletters.contains(y)){
                System.out.println("je hebt dit letter al gebruikt");
            }
            else if(word.contains(y + "")) {

                for (int o = 0; o < word.length(); o++) {
                    if (word.charAt(o) == y) {
                            gebruikteletters.add(y);
                            placeholder[o] = y;
                            System.out.println("goed geraden!");

                            d++;


                            if (d == 4) {
                                System.out.println("je hebt het woord geraden!");
                                System.out.println(word);
                                System.exit(0);
                            }


                        }

                    }

                }



            else if (y == '*'){
                System.out.println("vaarwel");
                System.exit(0);
            }
            else{
                gebruikteletters.add(y);
                life--;
                System.out.println("fout!");
                letter = new char[y];

            }



            System.out.println(placeholder);
            System.out.println("levens over:" + life);
            System.out.println("geraden letters" + gebruikteletters);




        }
        if(life == 0){
            System.out.println("het woord was " + word);
        }














    }














    public static void main(String[] args) {
        System.out.println("welkom bij hangman");
        System.out.println("je mag 1 letter per keer raden. je hebt 9 levens. raad het hele woord om te winnen.");
        System.out.println("typ run om te beginnen. en * om af te sluiten");

        run();

    }
}
