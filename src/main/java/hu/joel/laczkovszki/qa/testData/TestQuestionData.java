package hu.joel.laczkovszki.qa.testData;

import hu.joel.laczkovszki.qa.model.Question;

import java.util.ArrayList;
import java.util.List;

public class TestQuestionData {
    public static List<Question> questionList = new ArrayList<>() {{
        add(new Question("What does a stream do?", "Please help me!!", "https://www.co.elk.pa.us/images/HydrologicCycle.png", 0));
        add(new Question("What does a test do?", "Please help me!!", "https://i.pinimg.com/originals/26/10/74/2610748d9065b855e28fd3b431a97625.gif", 0));
        add(new Question("What does a tessst3 do?", "Please help me!!", "", 1));
        add(new Question("What does a stesda do?", "Please help me!!", "", 2));
        add(new Question("What does a sdsa do?", "Please help me!!" ,"", 2));
        add(new Question("What does a streasadsam do?", "Please help me!!" ,"", 2));
        add(new Question("What does a stresddsam do?", "Please help me!!" ,"", 0));
        add(new Question("What does a streasaddsam do?", "Please help me!!", "https://www.inskon.fi/itprojects/hcpractice/water_cycle.jpg", 0));
    }};
}
