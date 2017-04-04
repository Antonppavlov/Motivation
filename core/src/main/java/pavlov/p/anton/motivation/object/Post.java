package pavlov.p.anton.motivation.object;


public class Post {
    private int id;
    private String quote;
    private String author;
    private String category;
    private String favorite;

    public Post(int id, String quote, String author, String category, String favorite) {
        this.id = id;
        this.quote = quote;
        this.author = author;
        this.category = category;
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }
}
