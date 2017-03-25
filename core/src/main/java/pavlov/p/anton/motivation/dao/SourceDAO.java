package pavlov.p.anton.motivation.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pavlov.p.anton.motivation.database.SQLiteConnection;
import pavlov.p.anton.motivation.object.Source;

public class SourceDAO {

    private List<Source> sources;
    private Map<Integer, String> identityMap;

    public SourceDAO() {
        sources = getAll();
        identityMap = new HashMap<>();

        for (Source source : sources) {
            identityMap.put(source.getId(), source.getName());
        }
    }

    public List<Source> getAll() {
        List<Source> sources = new ArrayList<>();
        try (PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement("SELECT * FROM source")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sources.add(new Source(
                        resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sources;
    }

    public List<Source> getSources() {
        return sources;
    }

    public Map<Integer, String> getIdentityMap() {
        return identityMap;
    }
}
