package es.ulpgc.miguel.fortguide.data;

import java.util.ArrayList;

public class SupportItem extends SupportAbstract {

    public final ArrayList<SupportProfileItem> items;

    public SupportItem(int id, String content) {
        super(id, content);
        items = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

