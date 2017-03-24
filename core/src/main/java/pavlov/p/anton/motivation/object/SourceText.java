package pavlov.p.anton.motivation.object;

public class SourceText {
    private int id;
    private String textSource;

    public SourceText(int id, String textSource) {
        this.id = id;
        this.textSource = textSource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextSource() {
        return textSource;
    }

    public void setTextSource(String textSource) {
        this.textSource = textSource;
    }
}
