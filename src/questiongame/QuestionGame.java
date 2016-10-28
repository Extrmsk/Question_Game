package questiongame;

import java.io.*;
import java.util.*;

public class QuestionGame {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Game game = new Game("txt//test_questions.txt");
        
        Collections.shuffle(game.questions);
        
        for (int i = 0; i < game.questions.size(); i++) {
            Question questObj = game.questions.get(i); 
            System.out.println("QUESTION: " + questObj.question);
            
            Collections.shuffle(questObj.answers);
            
            for (int a = 0; a < questObj.answers.size(); a++) {
                Integer j = a+1;
                System.out.println(j.toString() + ": " + questObj.answers.get(a));
            }
            
            System.out.println("Enter the number of the correct answer: ");
            Scanner scrIn = new Scanner(System.in);
            int userAnswer = scrIn.nextInt();
            
            if (questObj.answers.get(userAnswer-1) == questObj.correctAnswer) {
                game.countCorrectAnswers++; 
            }
        }
        
        float percentCorAnswers = game.countCorrectAnswers * 100 / game.questions.size();
        System.out.println("Your correct answers conut is: " + game.countCorrectAnswers);
        System.out.println(percentCorAnswers + "%");
    }
}
