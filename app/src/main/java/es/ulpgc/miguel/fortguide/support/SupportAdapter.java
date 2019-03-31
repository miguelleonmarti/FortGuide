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

  private List<SupportItem> itemList;
  private final View.OnClickListener clickListener;

  public SupportAdapter(View.OnClickListener clickListener) {
    itemList = new ArrayList();
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

  public void setItems(List<SupportItem> items) {
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

    holder.detailView.setText(itemList.get(position).details);
    holder.contentView.setText(itemList.get(position).content);
    // TODO: preguntar a luis si es asi
    loadImageFromURL(holder.imageView, itemList.get(position).image);
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView detailView;
    final TextView contentView;
    final ImageView imageView;

    ViewHolder(View view) {
      super(view);
      detailView = view.findViewById(R.id.detailView);
      contentView = view.findViewById(R.id.contentView);
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
