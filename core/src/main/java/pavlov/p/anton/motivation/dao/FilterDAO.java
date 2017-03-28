package pavlov.p.anton.motivation.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import pavlov.p.anton.motivation.database.SQLiteConnection;
import pavlov.p.anton.motivation.object.Post;

import static pavlov.p.anton.motivation.dao.Type.CARTOONS;
import static pavlov.p.anton.motivation.dao.Type.OUR_FILMS;

public class FilterDAO {

    private List<Post> postList;
    private Map<Type, List<Post>> postMap = new EnumMap<Type, List<Post>>(Type.class);

    public FilterDAO() {
        createPosts();
    }

    private void createPosts() {
        this.postList = getAllPost();
        getShufflePostList();
        distributionPost(postList);
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
        postMap.put(CARTOONS, cartoons);
        postMap.put(OUR_FILMS, ourFilms);
        postMap.put(Type.FOREIGN_FILMS, foreignFilms);
        postMap.put(Type.PEOPLE, peopleList);
    }


    public List<Post> getFilterPostsByText(String searchText) {
        List<Post> postList = new ArrayList<>();
        try (PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement("SELECT\n" +
                        "\"quote\".id as id\n" +
                        ",\"quote\".name as quote\n" +
                        ",source.name as author\n" +
                        ",category.name as category\n" +
                        "\n" +
                        "from \"quote\"\n" +
                        "\n" +
                        "INNER JOIN source on \"quote\".source_id=source.id\n" +
                        "INNER JOIN category on \"quote\".category_id=category.id\n" +
                        "\n" +
                        "where\n" +
                        "\"quote\".name like +'%" + searchText + "%'" +
                        "or source.name like +'%" + searchText + "%'" +
                        "or category.name like  +'%" + searchText + "%'"
                )) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                postList.add(createObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public List<Post> getAllPost() {
        List<Post> postList = new ArrayList<>();
        try (PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement("SELECT\n" +
                        "\"quote\".id as id\n" +
                        ",\"quote\".name as quote\n" +
                        ",source.name as author\n" +
                        ",category.name as category\n" +
                        "\n" +
                        "from \"quote\"\n" +
                        "\n" +
                        "INNER JOIN source on \"quote\".source_id=source.id\n" +
                        "INNER JOIN category on \"quote\".category_id=category.id\n"
                )) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                postList.add(createObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }


    private Post createObject(ResultSet resultSet) throws SQLException {
        return new Post(
                resultSet.getInt("id"),
                resultSet.getString("quote"),
                resultSet.getString("author"),
                resultSet.getString("category"))
                ;
    }

    public List<Post> getShufflePostList() {
        Collections.shuffle(postList);
        return postList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public List<Post> getTypeList(Type type) {
        createPosts();
        return postMap.get(type);
    }

}
