package com.chriseconomou.depop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chriseconomou.depop.R;
import com.chriseconomou.depop.data.Product;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    private List<Product> mData = Collections.emptyList();
    private LayoutInflater mInflater;
    private Context mContext;

    public ProductsAdapter(Context context, List<Product> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mContext = context;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.view_product_item, viewGroup, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder productViewholder, int i) {
        loadData(productViewholder,i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private void loadData(ProductViewHolder productViewholder, int i){
        Product product= mData.get(i);
        if(product.url!=null){
            Picasso.with(mContext).load(product.url).into(productViewholder.mProductsImage);
        }
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.products_image)
        ImageView mProductsImage;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }

}
