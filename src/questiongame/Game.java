package questiongame;

import java.util.*;
import java.io.*;

public class Game {
    public ArrayList<Question> questions; //строки как объекты класса question
    public int countCorrectAnswers;
    
    public Game(String file) throws FileNotFoundException, IOException {
        countCorrectAnswers = 0;
        questions = new ArrayList<Question>();
                
        FileInputStream stream = new FileInputStream ( file ); //блок считывания построчно из файла
        InputStreamReader reader = new InputStreamReader ( stream, "Cp1251");
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            String s;
            while ((s = bufferedReader.readLine()) != null && !s.isEmpty()) {
                ParseQuestionString(s);
            }
        } finally {
            bufferedReader.close();
            reader.close();
            stream.close();
        }
    }
    
    private void ParseQuestionString(String str) {
        
        int EndIndex = str.indexOf('|'); //вопрос
        String questionText = str.substring(0, EndIndex);
        str = str.substring(EndIndex+1);
        
        EndIndex = str.indexOf('|'); //правильный ответ
        String correctAnswerText = str.substring(0, EndIndex);
        str = str.substring(EndIndex+1);
                
        Question questObj = new Question(questionText, correctAnswerText);
        questions.add(questObj);
        
        EndIndex = str.indexOf('|');
        while (EndIndex > -1) { //неправильные ответы
            questObj.AddAnswer( str.substring(0, EndIndex) );
            str = str.substring(EndIndex+1);
            EndIndex = str.indexOf('|');
        }
        questObj.AddAnswer(str);
    }
    
}
