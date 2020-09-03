package hu.joel.laczkovszki.qa.testData;

import hu.joel.laczkovszki.qa.model.Question;

import java.util.ArrayList;
import java.util.List;

public class TestQuestionData {
    public static List<Question> questionList = new ArrayList<>() {{
        add(new Question("What does a stream do?",  "https://www.co.elk.pa.us/images/HydrologicCycle.png", 0, new String[]{"stream"}));
        add(new Question("What does a test do?",  "https://i.pinimg.com/originals/26/10/74/2610748d9065b855e28fd3b431a97625.gif", 0, new String[]{"stream"}));
        add(new Question("What does a tessst3 do?",  "", 1, new String[]{"gaming"}));
        add(new Question("What does a stesda do?",  "", 1, new String[]{"gaming"}));
        add(new Question("What does a sdsa do?", "", 1, new String[]{"stream"}));
        add(new Question("What does a streasadsam do?", "", 2, new String[]{"gaming"}));
        add(new Question("What does a stresddsam do?", "", 2, new String[]{"stream"}));
        add(new Question("What does a streasaddsam do?",  "https://www.inskon.fi/itprojects/hcpractice/water_cycle.jpg", 0, new String[]{"stream"}));
    }};
}
