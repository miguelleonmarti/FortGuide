package es.ulpgc.miguel.fortguide.weapon;

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
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.data.WeaponItem;
import es.ulpgc.miguel.fortguide.support.SupportAdapter;

public class WeaponAdapter extends RecyclerView.Adapter<WeaponAdapter.ViewHolder> {

  // declaring the shopItemList list and listener
  private List<WeaponItem> weaponList;

  public WeaponAdapter() {
    this.weaponList = new ArrayList<>();
  }

  public void addItem(WeaponItem weaponItem) {
    weaponList.add(weaponItem);
    notifyDataSetChanged();
  }

  public void addItems(List<WeaponItem> weaponList) {
    this.weaponList.addAll(weaponList);
    notifyDataSetChanged();
  }

  public void setItems(List<WeaponItem> weaponList) {
    this.weaponList = weaponList;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return weaponList.size();
  }

  @Override
  public WeaponAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.weapon_list_content, parent, false);
    return new WeaponAdapter.ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final WeaponAdapter.ViewHolder holder, int position) {
    holder.itemView.setTag(weaponList.get(position));
    //holder.itemView.setOnClickListener(clickListener);

    holder.nameText.setText(weaponList.get(position).getName());
    holder.damageBodyText.setText(weaponList.get(position).getDamageBody());
    holder.damageHeadText.setText(weaponList.get(position).getDamageHead());
    holder.dpsText.setText(weaponList.get(position).getDps());
    holder.fireRateText.setText(weaponList.get(position).getFireRate());
    holder.reloadText.setText(weaponList.get(position).getReload());
    holder.sizeText.setText(weaponList.get(position).getSize());
    holder.ammoText.setText(weaponList.get(position).getAmmo());
    loadImageFromURL(holder.weaponImage, weaponList.get(position).getImage());
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    // declaring the elements of each card
    final ImageView weaponImage;
    final TextView nameText, damageBodyText, damageHeadText, dpsText, fireRateText, reloadText, sizeText, ammoText;

    ViewHolder(View view) {
      super(view);

      // finding the cards elements id
      weaponImage = view.findViewById(R.id.weaponImage);
      nameText = view.findViewById(R.id.nameText);
      damageBodyText = view.findViewById(R.id.damageBodyText);
      damageHeadText = view.findViewById(R.id.damageHeadText);
      dpsText = view.findViewById(R.id.dpsText);
      fireRateText = view.findViewById(R.id.fireRateText);
      reloadText = view.findViewById(R.id.reloadText);
      sizeText = view.findViewById(R.id.sizeText);
      ammoText = view.findViewById(R.id.ammoText);
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
