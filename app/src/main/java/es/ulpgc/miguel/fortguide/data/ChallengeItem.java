package es.ulpgc.miguel.fortguide.data;


import java.util.ArrayList;
import java.util.List;

public class ChallengeItem extends ChallengeAbstract {

    public final List<ChallengeItem> items;


    public ChallengeItem(int id, String content) {
       super(id,content);
        items = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

