package pavlov.p.anton.motivation.create;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import pavlov.p.anton.motivation.dao.CategoryDAO;
import pavlov.p.anton.motivation.dao.QuoteDAO;
import pavlov.p.anton.motivation.dao.SourceDAO;
import pavlov.p.anton.motivation.object.Citation;
import pavlov.p.anton.motivation.object.Quote;

public class CreateCitation {

    private final QuoteDAO quoteDAO;
    private final SourceDAO sourceDAO;
    private final CategoryDAO categoryDAO;
    private List<Citation> citationList;


    public CreateCitation(QuoteDAO quoteDAO, SourceDAO sourceDAO, CategoryDAO categoryDAO) {
        this.quoteDAO = quoteDAO;
        this.sourceDAO = sourceDAO;
        this.categoryDAO = categoryDAO;
    }

    private void createAllCitation() {
        citationList = new ArrayList<>();
        List<Quote> quoteList = quoteDAO.getAll();
        Map<Integer, String> sourceDAOIdentityMap = sourceDAO.getIdentityMap();
        Map<Integer, String> categoryDAOIdentityMap = categoryDAO.getIdentityMap();

        for (Quote quote : quoteList) {
            String textMain = quote.getTextMain();
            String textSource = sourceDAOIdentityMap.get(quote.getSourceId());
            String textCategory = categoryDAOIdentityMap.get(quote.getCategoryId());

            citationList.add(new Citation(textMain, textSource,textCategory));
        }

        Collections.shuffle(citationList);
    }

    public List<Citation> getShuffleCitationList() {
        return citationList;
    }
}
