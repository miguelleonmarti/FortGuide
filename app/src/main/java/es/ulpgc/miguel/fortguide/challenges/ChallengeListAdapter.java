package es.ulpgc.miguel.fortguide.challenges;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;

public class ChallengeListAdapter extends ArrayAdapter<ChallengeItem> {

    private List<ChallengeItem> itemList = new ArrayList();
    private final View.OnClickListener clickListener;

public ChallengeListAdapter (Context context, View.OnClickListener listener){
    super(context,0,new ArrayList());
    clickListener = listener;
}

public void addItem(ChallengeItem item){
    itemList.add(item);
    notifyDataSetChanged();
}

public void addItems(List<ChallengeItem> items){
    itemList = items;
    notifyDataSetChanged();
}
}
