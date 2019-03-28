package es.ulpgc.miguel.fortguide.data;


import java.util.ArrayList;
import java.util.List;

public class ChallengeItem extends ChallengeAbstract {

    public final List<ChallengeItem> items;
    public final String details;

    public ChallengeItem(int id, String content, String details) {
        super(id, content);
        items = new ArrayList<>();
        this.details = details;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

