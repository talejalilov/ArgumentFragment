package com.emrebaglayici.lab6.adapter;

import android.view.View;
import android.widget.TextView;

import com.emrebaglayici.lab6.R;

public class ViewPlaceHolder {
    TextView companyName, subjectID, messageID;

    public ViewPlaceHolder(View view) {


        companyName = view.findViewById(R.id.companyName);
        subjectID = view.findViewById(R.id.subjectID);
        messageID = view.findViewById(R.id.messageID);

    }

}
