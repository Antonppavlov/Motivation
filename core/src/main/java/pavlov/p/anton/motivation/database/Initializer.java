package pavlov.p.anton.motivation.database;


import java.util.List;

import pavlov.p.anton.motivation.create.CreateCitation;
import pavlov.p.anton.motivation.dao.MainTextDAO;
import pavlov.p.anton.motivation.dao.SourceTextDAO;
import pavlov.p.anton.motivation.object.Citation;
import pavlov.p.anton.motivation.object.MainText;
import pavlov.p.anton.motivation.object.SourceText;

public class Initializer {


    private static List<Citation> citationList;

    public static void load(String driverClass, String url) {

        SQLiteConnection.init(driverClass, url);


        CreateCitation createCitation = new CreateCitation(
                new MainTextDAO(),
                new SourceTextDAO());

        citationList = createCitation.getShuffleCitationList();


    }

    public static List<Citation> getCitationList() {
        return citationList;
    }
}
