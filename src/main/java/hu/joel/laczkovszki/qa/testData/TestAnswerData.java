package hu.joel.laczkovszki.qa.testData;

import hu.joel.laczkovszki.qa.model.Answer;

import java.util.ArrayList;
import java.util.List;

public class TestAnswerData {
    public static List<Answer> answerList = new ArrayList<>() {{
        add(new Answer("I dont know", "https://www.co.elk.pa.us/images/HydrologicCycle.png", 0));
        add(new Answer("I dont know", "", 2));
        add(new Answer("I dont know", "https://www.co.elk.pa.us/images/HydrologicCycle.png", 1));
        add(new Answer("I dont know", "https://www.co.elk.pa.us/images/HydrologicCycle.png", 1));
        add(new Answer("I dont know", "", 1));
        add(new Answer("I dont know", "", 0));
        add(new Answer("I dont know", "https://www.co.elk.pa.us/images/HydrologicCycle.png", 4));
    }};
}
