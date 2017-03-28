package pavlov.p.anton.motivation.create;


import java.util.List;

import pavlov.p.anton.motivation.dao.FilterDAO;
import pavlov.p.anton.motivation.object.Post;

public class CreatePosts {
    private FilterDAO filterDAO;

    public CreatePosts() {
        filterDAO = new FilterDAO();
    }

    public FilterDAO getFilterDAO() {
        return filterDAO;
    }
}
