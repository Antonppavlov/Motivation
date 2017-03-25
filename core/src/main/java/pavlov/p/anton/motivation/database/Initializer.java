package pavlov.p.anton.motivation.database;


import java.util.List;

import pavlov.p.anton.motivation.create.CreateCitation;
import pavlov.p.anton.motivation.dao.CategoryDAO;
import pavlov.p.anton.motivation.dao.QuoteDAO;
import pavlov.p.anton.motivation.dao.SourceDAO;
import pavlov.p.anton.motivation.object.Citation;

public class Initializer {


    private static List<Citation> citationList;

    public static void load(String driverClass, String url) {

        SQLiteConnection.init(driverClass, url);


        CreateCitation createCitation = new CreateCitation(
                new QuoteDAO(),
                new SourceDAO(),
                new CategoryDAO());

        citationList = createCitation.getShuffleCitationList();


    }

    public static List<Citation> getCitationList() {
        return citationList;
    }
}
