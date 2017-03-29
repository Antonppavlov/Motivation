package pavlov.p.anton.motivation.database;


import pavlov.p.anton.motivation.create.CreatePosts;

public class Initializer {

    private static CreatePosts createPosts;

    public static void load(String driverClass, String url) {
        SQLiteConnection.init(driverClass, url);
        createPosts = new CreatePosts();
    }

    public static CreatePosts getCreatePosts() {
        return createPosts;
    }
}
