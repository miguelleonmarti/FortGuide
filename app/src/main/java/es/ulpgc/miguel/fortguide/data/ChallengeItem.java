package es.ulpgc.miguel.fortguide.data;

import java.util.ArrayList;
import java.util.List;

public class ChallengeItem {

    public final List<ChallengeItem> items;
    public final int id;
    public final String content;


    public ChallengeItem(int id, String content) {
        this.id = id;
        this.content = content;
        items = new ArrayList<>();
    }

    @Override
    public String toString() {
        return content;
    }
}

