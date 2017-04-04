package pavlov.p.anton.motivation.create;


import java.sql.SQLException;

import pavlov.p.anton.motivation.dao.FilterDAO;

public class CreatePosts {
    private FilterDAO filterDAO;

    public CreatePosts() throws SQLException {
        filterDAO = new FilterDAO();
    }

    public FilterDAO getFilterDAO() {
        return filterDAO;
    }
}
