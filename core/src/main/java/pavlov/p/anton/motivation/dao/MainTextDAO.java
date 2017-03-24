package pavlov.p.anton.motivation.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pavlov.p.anton.motivation.database.SQLiteConnection;
import pavlov.p.anton.motivation.object.MainText;

public class MainTextDAO {

    public List<MainText> getAll() {
        List<MainText> mainTexts = new ArrayList<>();
        try (PreparedStatement preparedStatement = SQLiteConnection.getConnection().prepareStatement(
                "SELECT * FROM mainText")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mainTexts.add(fillMainText(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mainTexts;
    }

    private MainText fillMainText(ResultSet resultSet) throws SQLException {
        return new MainText(
                resultSet.getInt("id"),
                resultSet.getString("main_text"),
                resultSet.getInt("source_text_id")
        );
    }
}
