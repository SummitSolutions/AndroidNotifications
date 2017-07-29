package com.example.ibaou.myapplication.adapters;

/**
 * Created by ibaou on 7/29/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ibaou.myapplication.R;
import com.example.ibaou.myapplication.domain.CashOffer;
import com.example.ibaou.myapplication.domain.CashRequest;

import java.util.List;

public class CashOfferAdapter extends RecyclerView.Adapter<CashOfferAdapter.MyViewHolder> {

    private List<CashOffer> offersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
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
        CashOffer cashRequest = offersList.get(position);
        holder.title.setText(cashRequest.getUuid());
    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }
}