package es.ulpgc.miguel.fortguide.place;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.data.PlaceItem;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

  private List<PlaceItem> placeItemList;
  private final View.OnClickListener clickListener;

  public PlaceAdapter(View.OnClickListener clickListener) {
    this.placeItemList = new ArrayList();
    this.clickListener = clickListener;
  }

  public void addItem(PlaceItem item) {
    placeItemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<PlaceItem> items) {
    placeItemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<PlaceItem> items) {
    this.placeItemList = items;
    notifyDataSetChanged();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.place_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(placeItemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.contentView.setText(placeItemList.get(position).getContent());
    loadImageFromURL(holder.imageView, placeItemList.get(position).getImage());
  }

  @Override
  public int getItemCount() {
    return placeItemList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final ImageView imageView;
    final TextView contentView;

    ViewHolder(View view) {
      super(view);
      contentView = view.findViewById(R.id.contentView);
      imageView = view.findViewById(R.id.imageView);
    }
  }

  /**
   * Load an image from an URL
   *
   * @param imageView image where it's saved
   * @param imageUrl  image's URL
   */
  private void loadImageFromURL(ImageView imageView, String imageUrl) {
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqBuilder.into(imageView);
  }
}
