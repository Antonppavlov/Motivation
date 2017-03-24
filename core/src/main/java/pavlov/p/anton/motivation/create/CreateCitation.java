package pavlov.p.anton.motivation.create;

import java.util.ArrayList;
import java.util.List;

import pavlov.p.anton.motivation.dao.MainTextDAO;
import pavlov.p.anton.motivation.dao.SourceTextDAO;
import pavlov.p.anton.motivation.object.Citation;
import pavlov.p.anton.motivation.object.MainText;
import pavlov.p.anton.motivation.object.SourceText;

public class CreateCitation {
    private List<Citation> citationList;

    public List<Citation> getCitationList() {
        return citationList;
    }

    public CreateCitation initialize() {
        List<MainText> mainTextList = new MainTextDAO().getAll();
        List<SourceText> sourceTextList = new SourceTextDAO().getAll();


        citationList = new ArrayList<>();

        for (MainText mainText : mainTextList) {
            String textMain = mainText.getTextMain();
            String textSource = sourceTextList.get(mainText.getIdSource()).getTextSource();

            citationList.add(new Citation(textMain, textSource));

        }

        return this;
    }
}
