package pavlov.p.anton.motivation.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pavlov.p.anton.motivation.database.SQLiteConnection;
import pavlov.p.anton.motivation.object.SourceText;

public class SourceTextDAO {

    private List<SourceText> sourceTexts;
    private Map<Integer, String> identityMap;

    public SourceTextDAO() {
        sourceTexts = getAll();
        identityMap = new HashMap<>();

        for (SourceText sourceText : sourceTexts) {
            identityMap.put(sourceText.getId(), sourceText.getTextSource());
        }
    }

    public List<SourceText> getAll() {
        List<SourceText> sourceTexts = new ArrayList<>();
        try (PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement("SELECT * FROM sourceText")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sourceTexts.add(new SourceText(
                        resultSet.getInt("id"),
                        resultSet.getString("source_text")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sourceTexts;
    }

    public List<SourceText> getSourceTexts() {
        return sourceTexts;
    }

    public Map<Integer, String> getIdentityMap() {
        return identityMap;
    }
}
