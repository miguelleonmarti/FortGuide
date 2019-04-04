package es.ulpgc.miguel.fortguide.challenges_detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;

public class ChallengesDetailAdapter
    extends RecyclerView.Adapter<ChallengesDetailAdapter.ViewHolder> {

  private List<ChallengeItem> challengesList;
  private final View.OnClickListener clickListener;

  public ChallengesDetailAdapter(View.OnClickListener listener) {

    challengesList = new ArrayList();
    clickListener = listener;
  }

  public void addItem(ChallengeItem item) {
    challengesList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<ChallengeItem> items) {
    challengesList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<ChallengeItem> items) {
    challengesList = items;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    if (challengesList == null) {
      return 0;
    } else {
      return challengesList.size();
    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.challenge_detail_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(challengesList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.contentView.setText(challengesList.get(position).content);
    holder.detailView.setText(challengesList.get(position).details);
  }



  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView contentView;
    final TextView detailView;
    final CheckBox checkBox;

    ViewHolder(View view) {
      super(view);
      contentView = view.findViewById(R.id.contentChallengeTextView);
      detailView = view.findViewById(R.id.detailChallengeTextView);
      checkBox = view.findViewById(R.id.challengeCheckbox);
    }
  }
}


