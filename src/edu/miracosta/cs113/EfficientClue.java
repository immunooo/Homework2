package edu.miracosta.cs113;

/**
 * EfficientClue.java : Driver that asks assistant jack and gets correct answer in <= 20 tries.
 *
 *
 * @author Joseph Berlucchi
 * @version 1.0
 *
*/
import java.util.Random;
import java.util.Scanner;

import model.AssistantJack;
import model.Theory;

public class EfficientClue {
	/*
     * ALGORITHM:
     *
     * INITIATE integer variables murder = 1, weapon = 1, location = 1
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     * DO
     *      solution = jack.checkAnswer(weapon, location, murder)
     *      IF solution is 1 THEN
     *      	weapon++
     *      ELSE IF solution is 2 THEN
     *      	location++
     *      ELSE IF solution is 3 THEN
     *      	murder++
     *      END IF
     * WHILE solution != 0
     *
     * OUTPUT "Total checks = " + jack.getTimesAsked()
     * IF jack.getTimesAsked() is greater than 20 THEN
     *      OUTPUT "FAILED"
     * ELSE
     *      OUTPUT "PASSED"
     * END IF
     */

    /**
     * Driver method for efficiency guessing approach
     *
     * @param args not used for driver
     */
	
	public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution, murder = 1, weapon = 1, location = 1;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        
   
        jack = new AssistantJack(answerSet);

        do {
        	//Solution outputs: 1 = weapon, 2 = location, 3 = murder
            solution = jack.checkAnswer(weapon, location, murder);
            if(solution == 1) {
            	weapon++;
            } else if(solution == 2) {
            	location++;
            } else if(solution == 3){
            	murder++;
            }
        } while (solution != 0);

        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }
}
