package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;

public class ChallengesWeeksListAdapter extends ArrayAdapter<ChallengesWeeksItem> {

  private List<ChallengesWeeksItem> itemList = new ArrayList();
  private final View.OnClickListener clickListener;

  public ChallengesWeeksListAdapter(Context context, View.OnClickListener listener) {
    super(context, 0, new ArrayList());
    clickListener = listener;
  }

  public void addItem(ChallengesWeeksItem item) {
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<ChallengesWeeksItem> items) {
    itemList = items;
    notifyDataSetChanged();
  }

  public void setItems(List<ChallengesWeeksItem> items) {
    itemList = items;
    notifyDataSetChanged();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;

    if (itemView == null) {
      itemView = LayoutInflater.from(parent.getContext())
          .inflate(R.layout.challenges_weeks_list_content, parent, false);
    }

    itemView.setTag(itemList.get(position));
    itemView.setOnClickListener(clickListener);

    final TextView contentView = itemView.findViewById(R.id.content);
    contentView.setText(itemList.get(position).content);

    return itemView;
  }

  @Override
  public int getCount() {
    return itemList.size();
  }

  @Override
  public ChallengesWeeksItem getItem(int position) {
    return itemList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return getItem(position).id;
  }
}
