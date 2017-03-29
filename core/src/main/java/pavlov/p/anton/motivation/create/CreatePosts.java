package pavlov.p.anton.motivation.create;


import pavlov.p.anton.motivation.dao.FilterDAO;

public class CreatePosts {
    private FilterDAO filterDAO;

    public CreatePosts() {
        filterDAO = new FilterDAO();
    }

    public FilterDAO getFilterDAO() {
        return filterDAO;
    }
}
