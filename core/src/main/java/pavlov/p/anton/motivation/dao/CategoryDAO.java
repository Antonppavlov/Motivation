package pavlov.p.anton.motivation.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pavlov.p.anton.motivation.database.SQLiteConnection;
import pavlov.p.anton.motivation.object.Category;

public class CategoryDAO {
    private List<Category> categories;
    private Map<Integer, String> identityMap;

    public CategoryDAO() {
        categories = getAll();
        identityMap = new HashMap<>();

        for (Category source : categories) {
            identityMap.put(source.getId(), source.getName());
        }
    }

    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try (PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement("SELECT * FROM category")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories.add(new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public List<Category> getSources() {
        return categories;
    }

    public Map<Integer, String> getIdentityMap() {
        return identityMap;
    }
}

