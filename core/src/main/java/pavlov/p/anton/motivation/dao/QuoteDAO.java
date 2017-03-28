//package pavlov.p.anton.motivation.dao;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import pavlov.p.anton.motivation.database.SQLiteConnection;
//import pavlov.p.anton.motivation.object.Quote;
//
//public class QuoteDAO {
//
//    public List<Quote> getAll() {
//        List<Quote> mainTexts = new ArrayList<>();
//        try (PreparedStatement preparedStatement = SQLiteConnection.getConnection()
//                .prepareStatement("SELECT * FROM quote")) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                mainTexts.add(new Quote(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getInt("source_id"),
//                        resultSet.getInt("category_id")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return mainTexts;
//    }
//
//}
