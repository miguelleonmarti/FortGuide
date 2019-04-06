package es.ulpgc.miguel.fortguide.shop;

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
import es.ulpgc.miguel.fortguide.data.ShopItem;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

  private List<ShopItem> shopItemList;
  private View.OnClickListener clickListener;

  public ShopAdapter(View.OnClickListener clickListener) {
    this.shopItemList = new ArrayList<>();
    this.clickListener = clickListener;
  }

  public void addItem(ShopItem shopItem) {
    shopItemList.add(shopItem);
    notifyDataSetChanged();
  }

  public void addItems(List<ShopItem> supportItemList) {
    this.shopItemList.addAll(supportItemList);
    notifyDataSetChanged();
  }

  public void setItems(List<ShopItem> shopItemList) {
    this.shopItemList = shopItemList;
    notifyDataSetChanged();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
    View view = LayoutInflater.from(parent.getContext()).
        inflate(R.layout.shop_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.itemView.setTag(shopItemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.contentView.setText(shopItemList.get(position).getContent());
    holder.detailsView.setText(shopItemList.get(position).getDetails());
    loadImageFromURL(holder.imageView, shopItemList.get(position).getImage());
  }

  @Override
  public int getItemCount() {
    return shopItemList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    final TextView contentView, detailsView;
    final ImageView imageView;

    public ViewHolder(View view) {
      super(view);
      contentView = view.findViewById(R.id.contentView);
      detailsView = view.findViewById(R.id.detailView);
      imageView = view.findViewById(R.id.imageView);
    }
  }

  /**
   * Carga desde una URL la imagen
   *
   * @param imageView imagen en la que se guarda
   * @param imageUrl  url o ruta de la imagen
   */
  private void loadImageFromURL(ImageView imageView, String imageUrl) {
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
    reqBuilder.apply(reqOptions);
    reqBuilder.into(imageView);
  }
}
