package es.ulpgc.miguel.fortguide.theory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.TheoryItem;

public class TheoryAdapter extends RecyclerView.Adapter<TheoryAdapter.ViewHolder>  {

  private List<TheoryItem> theoryItemList;
  private final View.OnClickListener clickListener;


  public TheoryAdapter(View.OnClickListener listener){

    theoryItemList = new ArrayList<>();
    clickListener = listener;
  }
  public void addItem(TheoryItem item){
    theoryItemList.add(item);
    notifyDataSetChanged();
  }
  public void  addItems(List<TheoryItem> items){
    theoryItemList.addAll(items);
    notifyDataSetChanged();
  }
  public void setItems(List<TheoryItem> items){
    theoryItemList =items;
    notifyDataSetChanged();
  }
  class ViewHolder extends RecyclerView.ViewHolder{
    final TextView contentView;

    ViewHolder (View view){
      super(view);
      contentView = view.findViewById(R.id.contentView);

    }
  }

  @Override
  public int getItemCount(){return theoryItemList.size();}

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.theory_list_content, parent, false);
    return new ViewHolder(view);

  }
  @Override
  public void onBindViewHolder(final ViewHolder holder, int position){
    holder.itemView.setTag(theoryItemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.contentView.setText(theoryItemList.get(position).getContent());
  }


}
