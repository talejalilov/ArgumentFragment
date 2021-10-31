package com.emrebaglayici.lab6.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.emrebaglayici.lab6.R;


public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText subject, message, address;
        Button send;
        subject = view.findViewById(R.id.subjectDetail);
        message = view.findViewById(R.id.messageDetail);
        address = view.findViewById(R.id.addressDetail);
        send = view.findViewById(R.id.send);

        Bundle bundle = this.getArguments();
        if (bundle != null) {


            String mAddress =DetailFragmentArgs.fromBundle(bundle).getAddress();
            String mMessage = DetailFragmentArgs.fromBundle(bundle).getMessage();
            String mSubject = DetailFragmentArgs.fromBundle(bundle).getSubject();

            subject.setText(mSubject);
            message.setText(mMessage);
            address.setText(mAddress);
        }

        send.setOnClickListener(view1 -> shareTxt());

    }

    public void shareTxt() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Send mail ...");
        startActivity(Intent.createChooser(shareIntent, "Send mail ..."));
    }

}