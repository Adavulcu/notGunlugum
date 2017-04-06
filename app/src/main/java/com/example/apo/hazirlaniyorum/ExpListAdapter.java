package com.example.apo.hazirlaniyorum;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Apo on 14.03.2017.
 */

public class ExpListAdapter extends BaseExpandableListAdapter {

    public ArrayList<String> list_parent;
    public HashMap<String, ArrayList<konuEkle>> list_child;
    public Context context;
    public TextView dersAd;
    public TextView toplamKonu;
    public TextView toplamSoru;
    public TextView bitenSoru;
    public TextView bitenKonu;
    public Button ID;
    public CheckBox txt_child;
    public LayoutInflater inflater;
    @Override
    public int getGroupCount() {

        return list_parent.size();
    }

    public ExpListAdapter(Context context, ArrayList<String> list_parent, HashMap<String, ArrayList<konuEkle>> list_child)
    {
        this.context = context;
        this.list_parent = list_parent;
        this.list_child = list_child;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        return list_child.get(list_parent.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        return list_parent.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return list_child.get(list_parent.get(groupPosition)).get(childPosition);

    }

    @Override
    public long getGroupId(int groupPosition) {

        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {

        return childPosition;
    }

    @Override
    public boolean hasStableIds() {

        return true;

    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View view, ViewGroup parent) {
        String title_name = (String)getGroup(groupPosition);

        if(view == null)
        {
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dersler,null);
        }
        bitenKonu=(TextView)view.findViewById(R.id.bitenKonu);
        bitenKonu.setText("15");
        bitenSoru=(TextView)view.findViewById(R.id.bitenSoru);
        bitenSoru.setText("150");
        toplamKonu=(TextView)view.findViewById(R.id.toplamkonu);
        toplamSoru=(TextView)view.findViewById(R.id.toplamSoru);
        dersAd = (TextView)view.findViewById(R.id.dersAd);
        dersAd.setText(title_name);

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View view, ViewGroup parent) {
        try {


            // kaçıncı pozisyonda ise başlığımızın elemanı onun ismini alarak string e atıyoruz
            konuEkle konu = (konuEkle) getChild(groupPosition, childPosition);

            if (view == null) {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.konular, null);
                // fonksiyon adından da anlaşılacağı gibi parent a bağlı elemanlarının layoutunu inflate ediyoruz böylece o görüntüye ulaşmış oluyoruz
            }

            // listview_child ulaştığımıza göre içindeki bileşeni de kullanabiliyoruz daha sonradan view olarak return ediyoruz
            txt_child = (CheckBox) view.findViewById(R.id.konuAd);
            txt_child.setText(konu.getKonuAd());
            ID=(Button) view.findViewById(R.id.ID);
            ID.setText("soru gir");
            //ID.setId(konu.getID());
        }
        catch (Exception ex)
        {
            int durtion= Toast.LENGTH_LONG;
            Toast toast= Toast.makeText(context,ex.getMessage()+"exp",durtion);
            toast.show();
        }
        return view;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }


}
