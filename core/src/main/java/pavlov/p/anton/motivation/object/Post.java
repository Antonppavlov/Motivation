package pavlov.p.anton.motivation.object;


public class Post {
    private int id;
    private String quote;
    private String author;
    private String category;
    private Boolean favorite;

    public Post(int id, String quote, String author, String category, Boolean favorite) {
        this.id = id;
        this.quote = quote;
        this.author = author;
        this.category = category;
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getFavorite() {
        return favorite;
    }
}
