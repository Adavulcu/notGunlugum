package com.example.apo.hazirlaniyorum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by apo on 05.04.2017.
 */

public class dersAyarlari extends AppCompatActivity {
    private ArrayList<String> title;
    private zorlukAdapter expand_adapter;
    private HashMap<String, ArrayList<String>> hedef;
    final ArrayList<String> derece = new ArrayList<String>();
    private ExpandableListView expandlist_viewYGS;


    private ArrayList<dersEkle> dersTitle;
    private dersAyarlariAdapter dersAyarexpand_adapter;
    private HashMap<dersEkle,ogrtEkle> ogrt;
    final ArrayList<ogrtEkle> ogrtKayit= new ArrayList<ogrtEkle>();
    final ogrtEkle ogrtKayit1= new ogrtEkle("FİZİK"," hulya@gmail.com","Hülya ÜKTE",0,0);
    final ogrtEkle ogrtKayit2= new ogrtEkle("KİMYA"," mustafa@gmail.com","Mustafa DUt",1,2);
    private ExpandableListView dersAyarexpandlist;


    public void onBackPressed() {
        try {
            Intent i=new Intent(".ANASAYFA");
            startActivity(i);
            super.onBackPressed();
        }catch (Exception ex)
        {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage() + " onBack", durtion);
            toast.show();
        }

    }


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dersayarlari);
        try {

            expandlist_viewYGS = (ExpandableListView) findViewById(R.id.zorlukExp);
            Hazırla(); // expandablelistview içeriğini hazırlamak için
            // Adapter sınıfımızı oluşturmak için başlıklardan oluşan listimizi ve onlara bağlı olan elemanlarımızı oluşturmak için HaspMap türünü yolluyoruz
            expand_adapter = new zorlukAdapter(getApplicationContext(), title, hedef);
            expandlist_viewYGS.setAdapter(expand_adapter);  // oluşturduğumuz adapter sınıfını set ediyoruz


            dersAyarexpandlist=(ExpandableListView) findViewById(R.id.ogrtKayitexp);
            hazitlaDersTitle();
            dersAyarexpand_adapter=new dersAyarlariAdapter(getApplicationContext(),dersTitle,ogrt);

            dersAyarexpandlist.setAdapter(dersAyarexpand_adapter);

        }
        catch (Exception ex)
        {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage() + " dersAyarları", durtion);
            toast.show();
        }
    }

    private void hazitlaDersTitle() {

        try
        {


            dersTitle=new ArrayList<dersEkle>();
            ogrt=new HashMap<dersEkle,ogrtEkle>();
            dersTitle.add(new dersEkle("FİZİK",0));
            dersTitle.add(new dersEkle("KİMYA",2));

           // ogrtKayit.add(new ogrtEkle("FİZİK"," hulya@gmail.com","Hülya ÜKTE",0,0));
           // ogrtKayit.add(new ogrtEkle("KİMYA"," mustafa@gmail.com","Mustafa DUt",1,2));

            ogrt.put(dersTitle.get(0),ogrtKayit1);
            ogrt.put(dersTitle.get(1),ogrtKayit2);
        }catch (Exception ex)
        {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage()+"zorluk", durtion);
            toast.show();
        }
    }

    private void Hazırla() {


        // başlıklara bağlı elemenları tutmak için oluşturduk
        try {
            title = new ArrayList<String>();  // başlıklarımızı listemelek için oluşturduk
            hedef = new HashMap<String, ArrayList<String>>();
            title.add("DERS SEÇİMİ");


            derece.add("                  50               100                  150");
            derece.add("                  75               150                  225");
            derece.add("                  10               200                  300");


           hedef.put(title.get(0), derece);

        } catch (Exception ex) {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage()+"zorluk", durtion);
            toast.show();
        }
    }
}