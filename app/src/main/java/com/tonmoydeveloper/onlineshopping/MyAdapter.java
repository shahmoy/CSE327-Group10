package com.tonmoydeveloper.onlineshopping;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ProductsViewHolder>{

    private Context mContext;
    private List<Products> ProductsList;
    private int lastPosition = -1;

    public MyAdapter(Context mContext, List<Products> productsList) {
        this.mContext = mContext;
        this.ProductsList = productsList;
    }

    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int viewType) {

        View mView = LayoutInflater.from(ViewGroup.getContext()).inflate(R.layout.recycler_row_item,ViewGroup,false);

        return new  ProductsViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {

        Glide.with(mContext)
                .load(ProductsList.get(position).getItemImage())
                .into(holder.imageView);

       //holder.imageView.setImageResource(ProductsList.get(position).getItemImage());
       holder.mTitle.setText(ProductsList.get(position).getItemName());
       holder.mDescription.setText(ProductsList.get(position).getItemDescription());
       holder.mPrice.setText(ProductsList.get(position).getItemPrice());

       holder.mCardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(mContext,DetailActivity.class);
               intent.putExtra("Image",ProductsList.get(holder.getAdapterPosition()).getItemImage());
               intent.putExtra("Description",ProductsList.get(holder.getAdapterPosition()).getItemDescription());
               intent.putExtra("keyValue",ProductsList.get(holder.getAdapterPosition()).getKey());
               mContext.startActivity(intent);
           }
       });
       setAnimation(holder.itemView,position);

    }

    public void setAnimation(View viewToAnimate, int position){
        if(position> lastPosition){

            ScaleAnimation animation = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            animation.setDuration(1500);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }

    }

    @Override
    public int getItemCount() {
        return ProductsList.size();
    }

    public void filteredList(ArrayList<Products> filterList) {

        ProductsList = filterList;
        notifyDataSetChanged();
    }
}

class ProductsViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView mTitle,mDescription,mPrice;
    CardView mCardView;

    public ProductsViewHolder( View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mDescription = itemView.findViewById(R.id.tvDescription);
        mPrice = itemView.findViewById(R.id.tvPrice);

        mCardView = itemView.findViewById(R.id.myCardView);

    }
}
