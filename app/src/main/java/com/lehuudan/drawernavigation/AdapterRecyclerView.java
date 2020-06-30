package com.lehuudan.drawernavigation;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder>  {

    Context mContext ;
    private ArrayList<Item> mData;
    public OnItemClickListener mListenerBH;




    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(AdapterRecyclerView.OnItemClickListener listener) {
        mListenerBH = (OnItemClickListener) listener;
    }

//    public BaiHocChiTietAdapter( ArrayList<BaiHocChiTiet> mBaiHocCTItem) {
//        this.mBaiHocCTItem = mBaiHocCTItem;
//    }

    public AdapterRecyclerView(Context mContext, ArrayList<Item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        MyViewHolder evh  = new MyViewHolder(v,mListenerBH);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Item currentItem =mData.get(i);
        String title = currentItem.getTitle();
        String subtitle = currentItem.getSubtitle();
        int image_string = currentItem.getImage();

        myViewHolder.txt_title.setText(title);
        myViewHolder.txt_subtitle.setText(subtitle);
        myViewHolder.img.setBackgroundResource(image_string);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        public TextView txt_title;
        public TextView txt_subtitle;
        public CardView cardview_;
        public ImageView img;
        public MyViewHolder(@NonNull View itemView, final OnItemClickListener mListenerBH) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.item_title);
            txt_subtitle = itemView.findViewById(R.id.item_subtitle);
            img = itemView.findViewById(R.id.item_img2);
            cardview_ = itemView.findViewById(R.id.cardview_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListenerBH != null){
                        int position  = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListenerBH.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
