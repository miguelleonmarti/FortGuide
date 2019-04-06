package es.ulpgc.miguel.fortguide.advice;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.AdviceItem;

public class AdviceAdapter extends RecyclerView.Adapter<AdviceAdapter.ViewHolder> {

    private List<AdviceItem> adviceItemList;
    private final View.OnClickListener clickListener;


    public AdviceAdapter(View.OnClickListener listener){

        adviceItemList = new ArrayList<>();
        clickListener = listener;
    }
    public void addItem(AdviceItem item){
        adviceItemList.add(item);
        notifyDataSetChanged();
    }
    public void  addItems(List<AdviceItem> items){
        adviceItemList.addAll(items);
        notifyDataSetChanged();
    }
    public void setItems(List<AdviceItem> items){
        adviceItemList =items;
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
    public int getItemCount(){return adviceItemList.size();}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advice_list_content, parent, false);
        return new ViewHolder(view);

    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position){
        holder.itemView.setTag(adviceItemList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.contentView.setText(adviceItemList.get(position).getContent());
    }


}
