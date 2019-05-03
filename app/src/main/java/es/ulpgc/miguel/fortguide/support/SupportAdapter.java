package es.ulpgc.miguel.fortguide.support;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.SupportItem;

//TODO: preguntar a Luis si debe ir aquí

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class SupportAdapter extends RecyclerView.Adapter<SupportAdapter.ViewHolder> {

  // declaring the shopItemList list and listener
  private List<SupportItem> supportItemList;
  private final View.OnClickListener clickListener;

  public SupportAdapter(View.OnClickListener clickListener) {
    this.supportItemList = new ArrayList<>();
    this.clickListener = clickListener;
  }

  public void addItem(SupportItem supportItem) {
    supportItemList.add(supportItem);
    notifyDataSetChanged();
  }

  public void addItems(List<SupportItem> supportItemList) {
    this.supportItemList.addAll(supportItemList);
    notifyDataSetChanged();
  }

  public void setItems(List<SupportItem> supportItemList) {
    this.supportItemList = supportItemList;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return supportItemList.size();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.support_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(supportItemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.detailView.setText(supportItemList.get(position).getDetails());
    holder.contentView.setText(supportItemList.get(position).getContent());
    loadImageFromURL(holder.imageView, supportItemList.get(position).getImage());

  }

  class ViewHolder extends RecyclerView.ViewHolder {
    // declaring the elements of each card
    final ImageView imageView;
    final TextView contentView, detailView;

    ViewHolder(View view) {
      super(view);

      // finding the cards elements id
      detailView = view.findViewById(R.id.detailView);
      contentView = view.findViewById(R.id.contentView);
      imageView = view.findViewById(R.id.imageView);
    }
  }

  private void loadImageFromURL(ImageView imageView, String imageUrl) {
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
    reqBuilder.apply(reqOptions);
    reqBuilder.into(imageView);
  }
}
