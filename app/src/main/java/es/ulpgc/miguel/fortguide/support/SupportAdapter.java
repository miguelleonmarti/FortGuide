package es.ulpgc.miguel.fortguide.support;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.SupportItem;

public class SupportAdapter extends RecyclerView.Adapter<SupportAdapter.ViewHolder> {

  private List<SupportItem> itemList;
  private final View.OnClickListener clickListener;

  public SupportAdapter(View.OnClickListener clickListener) {
    itemList = new ArrayList();
    this.clickListener = clickListener;
  }

  public void addItem(SupportItem item){
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<SupportItem> items){
    itemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<SupportItem> items){
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
        .inflate(R.layout.support_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(itemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.textView.setText(itemList.get(position).details);

  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView textView;

    ViewHolder(View view) {
      super(view);
      textView = view.findViewById(R.id.detailView);
    }
  }
}
