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
import com.example.ibaou.myapplication.adapters.CashRequestAdapter;
import com.example.ibaou.myapplication.domain.CashRequest;
import com.example.ibaou.myapplication.domain.Location;
import com.example.ibaou.myapplication.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class CashRequestsTabFragment extends Fragment {

    private RecyclerView recyclerView;
    private CashRequestAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.offers_tab, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mAdapter = new CashRequestAdapter(getCashRequests());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    private List<CashRequest> getCashRequests(){
        List<CashRequest> requestsList = new ArrayList<>();

        Location l1 = new Location(100L, 200L);
        Person p1 = new Person("1", "Ioannis.B", "Ioannis", "Baourdos", 5.0, "GR", "Athens", "giannis");
        CashRequest cr1 = new CashRequest("1", 50.0,"EUR", p1, l1);

        Location l2 = new Location(101L, 201L);
        Person p2 = new Person("1", "Christos.K", "Christos", "Kontogiorgas", 5.3, "GR", "Athens", "christos");
        CashRequest cr2 = new CashRequest("2", 60.0,"EUR", p2, l2);

        requestsList.add(cr1);
        requestsList.add(cr2);

        return requestsList;
    }
}