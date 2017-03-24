package pavlov.p.anton.motivation.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pavlov.p.anton.motivation.database.SQLiteConnection;
import pavlov.p.anton.motivation.object.SourceText;

public class SourceTextDAO {


    public List<SourceText> getAll() {
        List<SourceText> sourceTexts = new ArrayList<>();
        try (PreparedStatement preparedStatement = SQLiteConnection.getConnection().prepareStatement(
                "SELECT * FROM sourceText")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sourceTexts.add(fillSourceText(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sourceTexts;
    }

    private SourceText fillSourceText(ResultSet resultSet) throws SQLException {

        return  new  SourceText (
               resultSet.getInt("id"),
               resultSet.getString("source_text")
       );


    }
}
