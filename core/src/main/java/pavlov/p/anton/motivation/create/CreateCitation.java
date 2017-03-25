package pavlov.p.anton.motivation.create;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import pavlov.p.anton.motivation.dao.MainTextDAO;
import pavlov.p.anton.motivation.dao.SourceTextDAO;
import pavlov.p.anton.motivation.object.Citation;
import pavlov.p.anton.motivation.object.MainText;
import pavlov.p.anton.motivation.object.SourceText;

public class CreateCitation {

    private final MainTextDAO mainTextDAO;
    private final SourceTextDAO sourceTextDAO;
    private List<Citation> citationList;


    public CreateCitation(MainTextDAO mainTextDAO, SourceTextDAO sourceTextDAO) {
        this.mainTextDAO = mainTextDAO;
        this.sourceTextDAO = sourceTextDAO;
        createAllCitation();
    }


    private void createAllCitation() {
        citationList = new ArrayList<>();
        List<MainText> mainTextList = mainTextDAO.getAll();
        Map<Integer, String> identityMapTextDAO = sourceTextDAO.getIdentityMap();

        for (MainText mainText : mainTextList) {
            String textMain = mainText.getTextMain();
            String textSource = identityMapTextDAO.get(mainText.getIdSource());
            citationList.add(new Citation(textMain, textSource));
        }
        Collections.shuffle(citationList);
    }

    public List<Citation> getShuffleCitationList() {
        return citationList;
    }
}
