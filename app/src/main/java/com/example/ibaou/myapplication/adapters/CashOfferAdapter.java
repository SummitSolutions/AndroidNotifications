package com.example.ibaou.myapplication.adapters;

/**
 * Created by ibaou on 7/29/2017.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ibaou.myapplication.R;
import com.example.ibaou.myapplication.domain.CashOffer;
import com.example.ibaou.myapplication.domain.CashRequest;
import com.sumsol.android.common.common.util.FileUtil;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CashOfferAdapter extends RecyclerView.Adapter<CashOfferAdapter.MyViewHolder> {

    private List<CashOffer> offersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nickname, distance, offer;
        public RatingBar rating;
        public CircleImageView avatar;

        public MyViewHolder(View view) {
            super(view);
            nickname = (TextView) view.findViewById(R.id.nickname);
            rating = (RatingBar) view.findViewById(R.id.rating);
            distance = (TextView) view.findViewById(R.id.distance);
            offer = (TextView) view.findViewById(R.id.offer);
            avatar = (CircleImageView) view.findViewById(R.id.avatar);
        }
    }

    public CashOfferAdapter(List<CashOffer> offersList) {
        this.offersList = offersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cashoffer_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CashOffer cashOffer = offersList.get(position);
        holder.nickname.setText(cashOffer.getOfferrer().getNickname());
        holder.offer.setText(cashOffer.getBonusAmount() + " " + cashOffer.getBonusProgram());
        holder.distance.setText(cashOffer.getDistance().intValue() + "m");
        holder.rating.setRating(cashOffer.getOfferrer().getRating().floatValue());

        int id = FileUtil.getDrawableId( cashOffer.getOfferrer().getAvatar(), holder.avatar.getContext());
        final Bitmap bitmap = BitmapFactory.decodeResource (holder.avatar.getContext().getResources(), id);

        holder.avatar.setImageBitmap(bitmap);

        //getDrawable
    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }
}