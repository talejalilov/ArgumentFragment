package com.emrebaglayici.lab6.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.emrebaglayici.lab6.R;
import com.emrebaglayici.lab6.model.MailModel;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<MailModel> modelList;
    Context context;

    public MyAdapter(ArrayList<MailModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewPlaceHolder viewPlaceHolder;

        View convertView = view;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview_item, viewGroup, false);
            viewPlaceHolder = new ViewPlaceHolder(convertView);
            convertView.setTag(viewPlaceHolder);

        } else {

            viewPlaceHolder = (ViewPlaceHolder) convertView.getTag();

        }

        MailModel model = modelList.get(i);

        viewPlaceHolder.companyName.setText(model.companyName);
        viewPlaceHolder.messageID.setText(model.message);
        viewPlaceHolder.subjectID.setText(model.subject);

        return convertView;
    }
}
