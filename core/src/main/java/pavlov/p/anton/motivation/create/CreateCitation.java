package pavlov.p.anton.motivation.create;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pavlov.p.anton.motivation.dao.MainTextDAO;
import pavlov.p.anton.motivation.dao.SourceTextDAO;
import pavlov.p.anton.motivation.object.Citation;
import pavlov.p.anton.motivation.object.MainText;
import pavlov.p.anton.motivation.object.SourceText;

public class CreateCitation {

    private final List<MainText> mainTextList;
    private final List<SourceText> sourceTextList;
    private List<Citation> citationList;


    public CreateCitation(List<MainText> mainTextList, List<SourceText> sourceTextList) {
        this.mainTextList = mainTextList;
        this.sourceTextList = sourceTextList;
//        System.err.println(mainTextList.size());
//        System.err.println(sourceTextList.size());
        createAllCitation();
    }


    private void createAllCitation() {
        citationList = new ArrayList<>();

        for (MainText mainText : mainTextList) {
            String textMain = mainText.getTextMain();
            String textSource = sourceTextList.get(mainText.getIdSource()-1).getTextSource();
            citationList.add(new Citation(textMain, textSource));
        }
        Collections.shuffle(citationList);
    }

    public List<Citation> getCitationList() {
        return citationList;
    }
}
