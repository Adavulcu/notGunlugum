package com.example.apo.hazirlaniyorum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Apo on 8.03.2017.
 */

public class anaSayfa extends AppCompatActivity {

    TabHost tabHost;
//////////////////////////////////////////////////YGS BÖLÜMÜ
    private ArrayList<String> ders_listYGS;
    private ExpListAdapter expand_adapterYGS;
    private HashMap<String, ArrayList<konuEkle>> konularListYGS;
    final ArrayList<konuEkle> konularFizikYGS=new ArrayList<konuEkle>();
    final ArrayList<konuEkle> konularKimyaYGS=new ArrayList<konuEkle>();
    private ExpandableListView expandlist_viewYGS;
    /////////////////////////////////////////LYS bölümü
    private ArrayList<String> ders_listLYS;
    private ExpListAdapter expand_adapterLYS;
    private HashMap<String, ArrayList<konuEkle>> konularListLYS;
    final ArrayList<konuEkle> konularFizikLYS=new ArrayList<konuEkle>();
    final ArrayList<konuEkle> konularKimyaLYS=new ArrayList<konuEkle>();
    private ExpandableListView expandlist_viewLYS;

    ///////////////////////// menu bölümü
    public boolean onCreateOptionsMenu(android.view.Menu anaSayfa) {
        super.onCreateOptionsMenu(anaSayfa);
        MenuInflater myMenu = getMenuInflater();
        myMenu.inflate(R.menu.menu, anaSayfa);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            Intent i;
            switch ( item.getItemId())
            {
                case R.id.kayit:
                    i=new Intent(".KAYIT");
                    startActivity(i);
                    break;
                case R.id.tarih:
                    i=new Intent(".TARIHEKLE");
                    startActivity(i);
                    break;
                case R.id.veriYedekle:
                    i=new Intent(".VERIYEDEKLE");
                    startActivity(i);
                    break;
                case R.id.hata:
                    i=new Intent(".HATABILDIRIMI");
                    startActivity(i);
                    break;
                case R.id.rapor:
                    i=new Intent(".RAPOR");
                    startActivity(i);
                    break;
                case R.id.dersAyar:
                    i=new Intent(".DERSAYARLARI");
                    startActivity(i);
                    break;
                default:
                    return super.onOptionsItemSelected(item);

            }
            return true;
        }
        catch (Exception ex)
        {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage() + " anasayfa", durtion);
            toast.show();
        }
        finally {
            return true;
        }


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa);
        try {


           // tabHost = getTabHost();
            tabHost=(TabHost)findViewById(R.id.anatab);
            tabHost.setup();

            TabHost.TabSpec spec = tabHost.newTabSpec("Tab One");
            spec.setContent(R.id.YGS);
            spec.setIndicator("YGS");
            tabHost.addTab(spec);

            //Tab 2
            spec = tabHost.newTabSpec("Tab Two");
            spec.setContent(R.id.LYS);
            spec.setIndicator("LYS");
            tabHost.addTab(spec);
            /////////////////////////////////YGS bülümü
            expandlist_viewYGS = (ExpandableListView)findViewById(R.id.exp_listYGS);
            HazırlaYGS(); // expandablelistview içeriğini hazırlamak için

            // Adapter sınıfımızı oluşturmak için başlıklardan oluşan listimizi ve onlara bağlı olan elemanlarımızı oluşturmak için HaspMap türünü yolluyoruz
            expand_adapterYGS = new ExpListAdapter(getApplicationContext(), ders_listYGS, konularListYGS);
            expandlist_viewYGS.setAdapter(expand_adapterYGS);  // oluşturduğumuz adapter sınıfını set ediyoruz

            //////////////////////////////////LYS bölümü
            expandlist_viewLYS = (ExpandableListView)findViewById(R.id.exp_listLYS);
            HazırlaLYS(); // expandablelistview içeriğini hazırlamak için

            // Adapter sınıfımızı oluşturmak için başlıklardan oluşan listimizi ve onlara bağlı olan elemanlarımızı oluşturmak için HaspMap türünü yolluyoruz
            expand_adapterLYS = new ExpListAdapter(getApplicationContext(), ders_listLYS, konularListLYS);
            expandlist_viewLYS.setAdapter(expand_adapterLYS);  // oluşturduğumuz adapter sınıfını set ediyoruz


            ////////////////////////////////////////////////////////////////////diger yönterm
            // Get TabHost Refference
           
            // Set TabChangeListener called when tab changed
           // tabHost.setOnTabChangedListener((TabHost.OnTabChangeListener) this);



            ////////////////////////////////////////////////////////////////////
           // TabHost.TabSpec spec;
           // Intent intent;

            /************* TAB1 ************/
            // Create  Intents to launch an Activity for the tab (to be reused)
            //intent = new Intent().setClass(this, YGStab.class);
            //spec = tabHost.newTabSpec("First").setIndicator("YGS")
             //       .setContent(intent);

            //Add intent to tab
           // tabHost.addTab(spec);

            /************* TAB2 ************/
            //intent = new Intent().setClass(this, LYStab.class);
           // spec = tabHost.newTabSpec("Second").setIndicator("LYS")
           //         .setContent(intent);
           // tabHost.addTab(spec);


        } catch (Exception ex) {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage() + " anasayfa", durtion);
            toast.show();
        }

    }

    private void HazırlaYGS() {


        // başlıklara bağlı elemenları tutmak için oluşturduk
        try {
            ders_listYGS = new ArrayList<String>();  // başlıklarımızı listemelek için oluşturduk
            konularListYGS = new HashMap<String, ArrayList<konuEkle>>();
            ders_listYGS.add("FİZİK-I");
            ders_listYGS.add("KİMYA-I");

            konularFizikYGS.add(new konuEkle("kaldıracYgs", 1));
            konularFizikYGS.add(new konuEkle("vektorYgs", 2));
            konularKimyaYGS.add(new konuEkle("gazlarYgs", 3));
            konularKimyaYGS.add(new konuEkle("molekulYgs", 4));

            konularListYGS.put(ders_listYGS.get(0), konularFizikYGS);
            konularListYGS.put(ders_listYGS.get(1), konularKimyaYGS);
        } catch (Exception ex) {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage(), durtion);
            toast.show();
        }
    }
    private void HazırlaLYS() {


        // başlıklara bağlı elemenları tutmak için oluşturduk
        try {
            ders_listLYS = new ArrayList<String>();  // başlıklarımızı listemelek için oluşturduk
            konularListLYS=new  HashMap<String, ArrayList<konuEkle>>();
            ders_listLYS.add("FİZİK-II");
            ders_listLYS.add("KİMYA-II");

            konularFizikLYS.add(new konuEkle("kaldırac", 1));
            konularFizikLYS.add(new konuEkle("vektor", 2));
            konularKimyaLYS.add(new konuEkle("gazlar", 3));
            konularKimyaLYS.add(new konuEkle("molekul", 4));

            konularListLYS.put(ders_listLYS.get(0), konularFizikLYS);
            konularListLYS.put(ders_listLYS.get(1), konularKimyaLYS);

        } catch (Exception ex) {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage(), durtion);
            toast.show();
        }
    }


}


