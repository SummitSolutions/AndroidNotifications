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
        Person p1 = new Person("1", "Ioannis.B", "Ioannis", "Baourdos", 4.0, "GR", "Athens", "giannis");
        CashRequest cr1 = new CashRequest("1", 50.0,"EUR", p1, l1);

        Location lo1 = new Location(100L, 200L);
        Person po1 = new Person("2", "Christos.K", "Christos", "Kontogiorgas", 3.5, "GR", "Athens", "christos");
        CashOffer co1 = new CashOffer(2.00, "cash", "EUR", cr1, po1, lo1, 500.00);

        Location lo2 = new Location(100L, 200L);
        Person po2 = new Person("3", "Nikos.L", "Nikos", "Labrou", 5.0, "GR", "Athens", "hugh");
        CashOffer co2 = new CashOffer(3.00, "cash", "EUR", cr1, po2, lo2, 800.00);

        Location lo3 = new Location(100L, 200L);
        Person po3 = new Person("4", "Maria.A", "Maria", "Anastasiou", 5.0, "GR", "Maroussi", "maria");
        CashOffer co3 = new CashOffer(2.00, "cash", "EUR", cr1, po3, lo3, 1200.00);

        Location lo4 = new Location(100L, 200L);
        Person po4 = new Person("5", "Jenny.K", "Jenny", "Karezi", 3.9, "GR", "Kifissia", "jenny");
        CashOffer co4 = new CashOffer(3.00, "cash", "EUR", cr1, po4, lo4, 1500.00);

        offersList.add(co1);
        offersList.add(co2);
        offersList.add(co3);
        offersList.add(co4);

        return offersList;
    }
}