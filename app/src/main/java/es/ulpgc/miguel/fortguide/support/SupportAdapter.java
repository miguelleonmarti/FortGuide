package es.ulpgc.miguel.fortguide.support;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.SupportItem;

public class SupportAdapter extends ArrayAdapter<SupportItem> {

  private ArrayList<SupportItem> itemList = new ArrayList<>();
  private final View.OnClickListener clickListener;

  public SupportAdapter(Context context, View.OnClickListener clickListener) {
    super(context, 0, new ArrayList());
    this.clickListener = clickListener;
  }

  public void addItem(SupportItem item) {
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<SupportItem> items) {
    itemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(ArrayList<SupportItem> items) {
    itemList = items;
    notifyDataSetChanged();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;

    if (itemView == null) {
      itemView = LayoutInflater
          .from(parent.getContext())
          .inflate(R.layout.support_list, parent, false);
    }

    itemView.setTag(itemList.get(position));
    itemView.setOnClickListener(clickListener);

    final TextView contentView = itemView.findViewById(R.id.textView1);
    contentView.setText(itemList.get(position).content);

    return itemView;
  }


  @Override
  public int getCount() {
    return itemList.size();
  }

  @Override
  public SupportItem getItem(int position) {
    return itemList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return getItem(position).id;
  }

}
