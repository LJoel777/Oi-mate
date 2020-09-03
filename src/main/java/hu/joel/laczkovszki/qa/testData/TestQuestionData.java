package hu.joel.laczkovszki.qa.testData;

import hu.joel.laczkovszki.qa.model.Question;

import java.util.ArrayList;
import java.util.List;

public class TestQuestionData {
    public static List<Question> questionList = new ArrayList<>() {{
        add(new Question("Experience enjoyable JavaScript development with WebStorm. With smart code completion, safe refactoring, and first-class support for Node.js, Angular and React. Download free trial!",  "https://www.bestbyte.hu/JetBrains_WebStorm_1_ev_1_felhasznalo_otthoni_elofizetes_licenc_szoftver-i14263796.jpg", 0, new String[]{"programing"}));
        add(new Question("They are waiting to kill you...",  "https://preview.redd.it/8lb7q231wxk51.jpg?width=640&crop=smart&auto=webp&s=bd8ec36e7fc38db4f2271b92a9f7a21724b58a89", 1, new String[]{"programing"}));
        add(new Question("My programming expirience in a nutshell",  "https://preview.redd.it/vl4cykj0hyk51.png?width=640&crop=smart&auto=webp&s=00b6e473dd89913120d7d8ef688efb853f1ec528", 1, new String[]{"programing"}));
        add(new Question("You program? I have an app idea!?",  "https://i.redd.it/2y8bunt1myk51.jpg", 2, new String[]{"programing"}));
        add(new Question("Guilty", "https://preview.redd.it/o9bfkmrgzyk51.jpg?width=640&crop=smart&auto=webp&s=53569fbaeea6c43c9d429d7cfe1149d6df90c79e", 3, new String[]{"programing"}));
        add(new Question("Back in the day when five fps didn’t even matter", "https://preview.redd.it/zgjklki3dyk51.jpg?width=640&crop=smart&auto=webp&s=140ff481bf7cd844543b7282b6b3a258553734dc", 2, new String[]{"gaming"}));
        add(new Question("RTX mode on", "https://i.redd.it/1c6ocbnp0yk51.jpg", 0, new String[]{"gaming"}));
        add(new Question("Halo infinite giveaway",  "https://i.redd.it/taziir6viyk51.jpg", 3, new String[]{"stream"}));
    }};
}
