package com.example.apo.hazirlaniyorum;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ExpandableListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by apo on 05.04.2017.
 */

public class dersAyarlari extends Activity {
    private ArrayList<String> title;
    private zorlukAdapter expand_adapter;
    private HashMap<String, ArrayList<String>> hedef;
    final ArrayList<String> derece = new ArrayList<String>();
    private ExpandableListView expandlist_viewYGS;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dersayarlari);
        try {

            expandlist_viewYGS = (ExpandableListView) findViewById(R.id.zorlukExp);
            Hazırla(); // expandablelistview içeriğini hazırlamak için

            // Adapter sınıfımızı oluşturmak için başlıklardan oluşan listimizi ve onlara bağlı olan elemanlarımızı oluşturmak için HaspMap türünü yolluyoruz
            expand_adapter = new zorlukAdapter(getApplicationContext(), title, hedef);
            expandlist_viewYGS.setAdapter(expand_adapter);  // oluşturduğumuz adapter sınıfını set ediyoruz

        }
        catch (Exception ex)
        {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage() + " dersAyarları", durtion);
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