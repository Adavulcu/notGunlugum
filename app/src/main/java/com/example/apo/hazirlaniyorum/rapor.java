package com.example.apo.hazirlaniyorum;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by apo on 05.04.2017.
 */

public class rapor extends AppCompatActivity {
    TabHost tabHost;
    //////////////////////////////////////////////////YGS BÖLÜMÜ
    private ArrayList<String> titleYGS;
    private RaporExpListAdapter expand_adapterYGS;
    private HashMap<String, ArrayList<dersEkle>> derslerListYGS;
    final ArrayList<dersEkle> derslerYGS=new ArrayList<dersEkle>();
    private ExpandableListView expandlist_viewYGS;
    /////////////////////////////////////////LYS bölümü
    private ArrayList<String> titleLYS;
    private RaporExpListAdapter expand_adapterLYS;
    private HashMap<String, ArrayList<dersEkle>> derslerListLYS;
    final ArrayList<dersEkle> derslerLYS=new ArrayList<dersEkle>();
    private ExpandableListView expandlist_viewLYS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rapor);
        try {
        // tabHost = getTabHost();
        tabHost=(TabHost)findViewById(R.id.raporTab);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Tab One");
        spec.setContent(R.id.YGSrapor);
        spec.setIndicator("YGS");
        tabHost.addTab(spec);

        //Tab 2
        spec = tabHost.newTabSpec("Tab Two");
        spec.setContent(R.id.LYSrapor);
        spec.setIndicator("LYS");
        tabHost.addTab(spec);
        /////////////////////////////////YGS bülümü
        expandlist_viewYGS = (ExpandableListView)findViewById(R.id.expYGS);
        HazırlaYGS(); // expandablelistview içeriğini hazırlamak için

        // Adapter sınıfımızı oluşturmak için başlıklardan oluşan listimizi ve onlara bağlı olan elemanlarımızı oluşturmak için HaspMap türünü yolluyoruz
        expand_adapterYGS = new RaporExpListAdapter(getApplicationContext(), titleYGS, derslerListYGS);
        expandlist_viewYGS.setAdapter(expand_adapterYGS);  // oluşturduğumuz adapter sınıfını set ediyoruz

        //////////////////////////////////LYS bölümü
        expandlist_viewLYS = (ExpandableListView)findViewById(R.id.expLYS);
        HazırlaLYS(); // expandablelistview içeriğini hazırlamak için

        // Adapter sınıfımızı oluşturmak için başlıklardan oluşan listimizi ve onlara bağlı olan elemanlarımızı oluşturmak için HaspMap türünü yolluyoruz
        expand_adapterLYS = new RaporExpListAdapter(getApplicationContext(), titleLYS, derslerListLYS);
        expandlist_viewLYS.setAdapter(expand_adapterLYS);  // oluşturduğumuz adapter sınıfını set ediyoruz
    } catch (Exception ex) {
        int durtion = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(this, ex.getMessage() + " rapor", durtion);
        toast.show();
    }

    }
    private void HazırlaYGS() {


        // başlıklara bağlı elemenları tutmak için oluşturduk
        try {
            titleYGS = new ArrayList<String>();  // başlıklarımızı listemelek için oluşturduk
            derslerListYGS = new HashMap<String, ArrayList<dersEkle>>();
            titleYGS.add("DERS SEÇİMİ");


            derslerYGS.add(new dersEkle("FİZİK-I",1));
            derslerYGS.add(new dersEkle("KİMYA-I",2));
            derslerYGS.add(new dersEkle("MATEMATİK-I",3));
            derslerYGS.add(new dersEkle("TÜRKCE-I",4));

            derslerListYGS.put(titleYGS.get(0), derslerYGS);

        } catch (Exception ex) {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage()+"raporYGs", durtion);
            toast.show();
        }
    }
    private void HazırlaLYS() {


        // başlıklara bağlı elemenları tutmak için oluşturduk
        try {
            titleLYS = new ArrayList<String>();  // başlıklarımızı listemelek için oluşturduk
            derslerListLYS=new  HashMap<String, ArrayList<dersEkle>>();
            titleLYS.add("DERS SEÇİMİ");


            derslerLYS.add(new dersEkle("FİZİK-II",5));
            derslerLYS.add(new dersEkle("KİMYA-II",6));
            derslerLYS.add(new dersEkle("MATEMATİK-II",7));
           derslerLYS.add(new dersEkle("TÜRKÇE",8));

           derslerListLYS.put(titleLYS.get(0), derslerLYS);


        } catch (Exception ex) {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage()+"raporLys", durtion);
            toast.show();
        }
    }
}
