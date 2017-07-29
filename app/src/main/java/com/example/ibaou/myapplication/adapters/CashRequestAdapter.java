package com.example.ibaou.myapplication.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ibaou.myapplication.R;
import com.example.ibaou.myapplication.domain.CashRequest;
import com.sumsol.android.common.common.util.FileUtil;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ibaou on 7/29/2017.
 */
public class CashRequestAdapter extends RecyclerView.Adapter<CashRequestAdapter.MyViewHolder> {

    private List<CashRequest> requestsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nickname, distance, request;
        public RatingBar rating;
        public CircleImageView avatar;

        public MyViewHolder(View view) {
            super(view);
            nickname = (TextView) view.findViewById(R.id.nickname);
            rating = (RatingBar) view.findViewById(R.id.rating);
            distance = (TextView) view.findViewById(R.id.distance);
            request = (TextView) view.findViewById(R.id.request);
            avatar = (CircleImageView) view.findViewById(R.id.avatar);
        }
    }

    public CashRequestAdapter(List<CashRequest> requestsList) {
        this.requestsList = requestsList;
    }

    @Override
    public CashRequestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cashrequest_list_row, parent, false);

        return new CashRequestAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CashRequestAdapter.MyViewHolder holder, int position) {
        CashRequest cashRequest = requestsList.get(position);
        holder.nickname.setText(cashRequest.getRequester().getNickname());
        holder.request.setText(cashRequest.getAmount() + " " + cashRequest.getCurrency());
        holder.distance.setText(100.00 + "m");
        holder.rating.setRating(cashRequest.getRequester().getRating().floatValue());

        int id = FileUtil.getDrawableId( cashRequest.getRequester().getAvatar(), holder.avatar.getContext());
        final Bitmap bitmap = BitmapFactory.decodeResource (holder.avatar.getContext().getResources(), id);

        holder.avatar.setImageBitmap(bitmap);

        //getDrawable
    }

    @Override
    public int getItemCount() {
        return requestsList.size();
    }
}