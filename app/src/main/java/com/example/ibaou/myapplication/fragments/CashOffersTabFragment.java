package com.example.ibaou.myapplication.fragments;

/**
 * Created by ibaou on 7/29/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ibaou.myapplication.R;
import com.example.ibaou.myapplication.adapters.CashOfferAdapter;
import com.example.ibaou.myapplication.adapters.CashRequestAdapter;
import com.example.ibaou.myapplication.domain.CashOffer;
import com.example.ibaou.myapplication.domain.CashRequest;
import com.example.ibaou.myapplication.domain.Location;
import com.example.ibaou.myapplication.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class CashOffersTabFragment extends Fragment {

    private RecyclerView recyclerView;
    private CashOfferAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.offers_tab, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mAdapter = new CashOfferAdapter(getCashOffers());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    private List<CashOffer> getCashOffers(){
        List<CashOffer> offersList = new ArrayList<>();

        Location l1 = new Location(100L, 200L);
        Person p1 = new Person("1", "I.Baourdos", "Ioannis", "Baourdos", Integer.valueOf(4).shortValue(), "GR", "Athens");
        CashRequest cr1 = new CashRequest("1", 50.0, p1, l1);

        Location lo1 = new Location(100L, 200L);
        Person po1 = new Person("1", "N.Labrou", "Nikos", "Labrou", Integer.valueOf(4).shortValue(), "GR", "Athens");
        CashOffer co1 = new CashOffer(2.00, "bonus", "epistrofh", cr1, po1, lo1, 500.00);

        Location lo2 = new Location(100L, 200L);
        Person po2 = new Person("1", "N.Labrou", "Nikos", "Labrou", Integer.valueOf(5).shortValue(), "GR", "Athens");
        CashOffer co2 = new CashOffer(3.00, "bonus", "epistrofh", cr1, po1, lo1, 800.00);

        Location lo3 = new Location(100L, 200L);
        Person po3 = new Person("1", "M.Anastasiou", "Maria", "Anastasiou", Integer.valueOf(5).shortValue(), "GR", "Maroussi");
        CashOffer co3 = new CashOffer(2.00, "cash", "", cr1, po1, lo1, 1200.00);


        offersList.add(co1);

        return offersList;
    }
}