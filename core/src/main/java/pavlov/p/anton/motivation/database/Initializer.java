package pavlov.p.anton.motivation.database;


import pavlov.p.anton.motivation.create.CreateCitation;

public class Initializer {


    private static CreateCitation createCitation;


    public static void load(String driverClass, String url) {

        SQLiteConnection.init(driverClass, url);
        createCitation = new CreateCitation().initialize();


    }

    public static CreateCitation getCreateCitation() {
        return createCitation;
    }
}
