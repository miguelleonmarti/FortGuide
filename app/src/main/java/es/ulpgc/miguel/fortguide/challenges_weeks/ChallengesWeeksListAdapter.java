package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;

public class ChallengesWeeksListAdapter
    extends RecyclerView.Adapter<ChallengesWeeksListAdapter.ViewHolder> {

  private List<ChallengesWeeksItem> itemList;
  private final View.OnClickListener clickListener;

  public ChallengesWeeksListAdapter(View.OnClickListener listener) {
    itemList = new ArrayList<>();
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
  public int getItemCount() {
    return itemList.size();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.challenges_weeks_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(itemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.contentView.setText(itemList.get(position).content);

  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView contentView;

    ViewHolder(View view) {
      super(view);
      contentView = view.findViewById(R.id.content);
    }
  }
}
