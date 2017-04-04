package pavlov.p.anton.motivation.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pavlov.p.anton.motivation.database.SQLiteConnection;
import pavlov.p.anton.motivation.object.Post;

public class FilterDAO {

    private List<Post> postList;
    private Map<Integer, Post> identityMap = new HashMap<>();
    private Map<Type, List<Post>> postMap = new EnumMap<>(Type.class);


    private static String sql = "SELECT\n" +
            "\"quote\".id as id,\n" +
            "\"quote\".name as quote,\n" +
            "source.name as author,\n" +
            "category.name as category,\n" +
            "\"quote\".favorite as favorite\n" +
            "\n" +
            "from \"quote\"\n" +
            "\n" +
            "INNER JOIN source on quote.source_id=source.id\n" +
            "INNER JOIN category on quote.category_id=category.id ";


    public FilterDAO() throws SQLException {
        createPosts();
    }


    public void createPosts() throws SQLException {
        this.postList = getAllPost();
        distributionPost(postList);
        for (Post post : this.postList) {
            identityMap.put(post.getId(), post);
        }
    }


    private void distributionPost(List<Post> postList) {
        List<Post> cartoons = new ArrayList<>();
        List<Post> ourFilms = new ArrayList<>();
        List<Post> foreignFilms = new ArrayList<>();
        List<Post> peopleList = new ArrayList<>();

        for (Post post : postList) {
            switch (post.getCategory()) {
                case "мультфильмы": {
                    cartoons.add(post);
                    break;
                }
                case "наше кино": {
                    ourFilms.add(post);
                    break;
                }
                case "иностранные": {
                    foreignFilms.add(post);
                    break;
                }
                case "люди": {
                    peopleList.add(post);
                    break;
                }
            }


        }
        postMap.put(Type.CARTOONS, cartoons);
        postMap.put(Type.OUR_FILMS, ourFilms);
        postMap.put(Type.FOREIGN_FILMS, foreignFilms);
        postMap.put(Type.PEOPLE, peopleList);
    }


    private List<Post> getAllPost() throws SQLException {
        List<Post> postList = new ArrayList<>();
        PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            postList.add(createObject(resultSet));
        }
        return postList;
    }


    public List<Post> getFilterPostsByText(String searchText) throws SQLException {
        List<Post> postList = new ArrayList<>();
        PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement(sql +
                        "where \"quote\".name like +'%" + searchText + "%'" +
                        "or source.name like +'%" + searchText + "%'" +
                        "or category.name like  +'%" + searchText + "%'"
                );
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                postList.add(createObject(resultSet));
            }
        }
        return postList;
    }


    public List<Post> getFavoriteAllPost() throws SQLException {
        List<Post> postList = new ArrayList<>();
        PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement(sql + " where favorite='true'");
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                postList.add(createObject(resultSet));
            }
        }
        return postList;
    }


    public void updateQuoteStatusFavorite(boolean checked, int idText) throws SQLException {


        PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement("UPDATE quote " +
                        "SET favorite = '" + checked + "'" +
                        " where id = " + idText + " ;");
        preparedStatement.executeUpdate();

//        if (checked) {
//            if(!getFavoriteAllPost().contains(identityMap.get(idText))){
//                updateQuoteStatusFavorite(checked, idText);
//            }
//        }
//        else {
//            if(getFavoriteAllPost().contains(identityMap.get(idText))){
//                updateQuoteStatusFavorite(checked, idText);
//            }
//        }

    }


    private Post createObject(ResultSet resultSet) throws SQLException {
        return new Post(
                resultSet.getInt("id"),
                resultSet.getString("quote"),
                resultSet.getString("author"),
                resultSet.getString("category"),
                resultSet.getString("favorite"))
                ;
    }


    public List<Post> getShufflePostList() {
        Collections.shuffle(postList);
        return postList;
    }


    public List<Post> getPostList() {
        return postList;
    }


    public List<Post> getPostList(Type type) {
        List<Post> posts = postMap.get(type);
        return posts;
    }


    public List<Post> getShufflePostList(Type type) {
        List<Post> posts = postMap.get(type);
        Collections.shuffle(posts);
        return posts;
    }


    public Map<Integer, Post> getIdentityMap() {
        return identityMap;
    }


    public Map<Type, List<Post>> getPostMap() {
        return postMap;
    }

}
