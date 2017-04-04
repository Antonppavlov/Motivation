package pavlov.p.anton.motivation.database;


import java.sql.SQLException;

import pavlov.p.anton.motivation.create.CreatePosts;

public class Initializer {

    private static CreatePosts createPosts;

    public static void load(String driverClass, String url) throws SQLException {
        SQLiteConnection.init(driverClass, url);
        createPosts = new CreatePosts();
    }

    public static CreatePosts getCreatePosts() {
        return createPosts;
    }
}
