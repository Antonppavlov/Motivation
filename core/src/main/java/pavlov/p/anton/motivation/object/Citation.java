package pavlov.p.anton.motivation.object;

public class Citation {
    private String textMain;
    private String sourceMain;

    public Citation(String textMain, String sourceMain) {
        this.textMain = textMain;
        this.sourceMain = sourceMain;
    }

    public String getTextMain() {
        return textMain;
    }

    public void setTextMain(String textMain) {
        this.textMain = textMain;
    }

    public String getSourceMain() {
        return sourceMain;
    }

    public void setSourceMain(String sourceMain) {
        this.sourceMain = sourceMain;
    }
}
