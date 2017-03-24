package pavlov.p.anton.motivation.object;

public class MainText {
    private int id;
    private String textMain;
    private int idSource;

    public MainText(int id, String textMain, int idSource) {
        this.id = id;
        this.textMain = textMain;
        this.idSource = idSource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextMain() {
        return textMain;
    }

    public void setTextMain(String textMain) {
        this.textMain = textMain;
    }

    public int getIdSource() {
        return idSource;
    }

    public void setIdSource(int idSource) {
        this.idSource = idSource;
    }
}
