package questiongame;

import java.util.ArrayList;

public class Question {

    public Question(String questionText, String correctAnswerText) {
        question = questionText;
        correctAnswer = correctAnswerText;
        answers = new ArrayList<String>();
        AddAnswer(correctAnswerText);
    }

    public void AddAnswer(String answerText) {
        answers.add(answerText);
    }
    
    public String question;
    public ArrayList<String> answers; //все варианты ответа
    public String correctAnswer;
    
}
