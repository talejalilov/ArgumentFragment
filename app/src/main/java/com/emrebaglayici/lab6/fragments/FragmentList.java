package com.emrebaglayici.lab6.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.emrebaglayici.lab6.R;
import com.emrebaglayici.lab6.adapter.MyAdapter;
import com.emrebaglayici.lab6.model.MailModel;

import java.util.ArrayList;


public class FragmentList extends Fragment {


    MyAdapter myAdapter;
    ArrayList<MailModel> modelArrayList;
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        modelArrayList =new ArrayList<>();
        listView = view.findViewById(R.id.listView);

        Resources resources =getResources();
        String[] address = resources.getStringArray(R.array.Address);
        String[] companyName = resources.getStringArray(R.array.CompanyName);
        String[] subject = resources.getStringArray(R.array.Subject);
        String[] message = resources.getStringArray(R.array.Message);

        for (int i = 0; i <companyName.length ; i++) {
            modelArrayList.add(new MailModel(companyName[i], subject[i], message[i]));
        }
        myAdapter = new MyAdapter(modelArrayList, getContext());
        listView.setAdapter(myAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener((adapterView, view1, i, l) -> {


            FragmentListDirections.ActionFragmentListToDetailFragment2 action = FragmentListDirections.actionFragmentListToDetailFragment2(address[i],subject[i],message[i]);
            action.setAddress(address[i]);
            action.setMessage(message[i]);
            action.setSubject(subject[i]);
            Navigation.findNavController(view1).navigate(action);

        });

    }

}