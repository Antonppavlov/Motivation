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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != post.id) return false;
        if (quote != null ? !quote.equals(post.quote) : post.quote != null) return false;
        if (author != null ? !author.equals(post.author) : post.author != null) return false;
        if (category != null ? !category.equals(post.category) : post.category != null)
            return false;
        return favorite != null ? favorite.equals(post.favorite) : post.favorite == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (quote != null ? quote.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (favorite != null ? favorite.hashCode() : 0);
        return result;
    }
}
