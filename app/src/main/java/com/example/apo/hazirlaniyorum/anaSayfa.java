package com.example.apo.hazirlaniyorum;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Apo on 8.03.2017.
 */

public class anaSayfa extends AppCompatActivity {

    TabHost tabHost;
//////////////////////////////////////////////////YGS BÖLÜMÜ

    private ArrayList<dersEkle> dersListYgs;
    private ExpListAdapter expand_adapterYGS;
    private HashMap<dersEkle, ArrayList<konuEkle>> konularListYGS;
    final ArrayList<konuEkle> konularFizikYGS=new ArrayList<konuEkle>();
    final ArrayList<konuEkle> konularKimyaYGS=new ArrayList<konuEkle>();
    private ExpandableListView expandlist_viewYGS;
    /////////////////////////////////////////LYS bölümü

    private ArrayList<dersEkle>dersListLys;
    private ExpListAdapter expand_adapterLYS;
    private HashMap<dersEkle, ArrayList<konuEkle>> konularListLYS;
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
            expand_adapterYGS = new ExpListAdapter(getApplicationContext(), dersListYgs, konularListYGS);
            expandlist_viewYGS.setAdapter(expand_adapterYGS);  // oluşturduğumuz adapter sınıfını set ediyoruz

            //////////////////////////////////LYS bölümü
            expandlist_viewLYS = (ExpandableListView)findViewById(R.id.exp_listLYS);
            HazırlaLYS(); // expandablelistview içeriğini hazırlamak için

            // Adapter sınıfımızı oluşturmak için başlıklardan oluşan listimizi ve onlara bağlı olan elemanlarımızı oluşturmak için HaspMap türünü yolluyoruz
            expand_adapterLYS = new ExpListAdapter(getApplicationContext(), dersListLys, konularListLYS);
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
            dersListYgs=new ArrayList<dersEkle>();

            konularListYGS = new HashMap<>();

            dersListYgs.add(new dersEkle("FİZİK-I",1));
            dersListYgs.add(new dersEkle("KİMYA-I",2));

            konularFizikYGS.add(new konuEkle("kaldıracYgs", 1));
            konularFizikYGS.add(new konuEkle("vektorYgs", 2));
            konularKimyaYGS.add(new konuEkle("gazlarYgs", 3));
            konularKimyaYGS.add(new konuEkle("molekulYgs", 4));

            konularListYGS.put(dersListYgs.get(0), konularFizikYGS);
            konularListYGS.put(dersListYgs.get(1), konularKimyaYGS);

        } catch (Exception ex) {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage(), durtion);
            toast.show();
        }
    }
    private void HazırlaLYS() {


        // başlıklara bağlı elemenları tutmak için oluşturduk
        try {
            dersListLys=new ArrayList<dersEkle>();

            konularListLYS=new HashMap<>();

            dersListLys.add(new dersEkle("FİZİK-II",3));
            dersListLys.add(new dersEkle("KİMYA-II",4));

            konularFizikLYS.add(new konuEkle("kaldırac", 1));
            konularFizikLYS.add(new konuEkle("vektor", 2));
            konularKimyaLYS.add(new konuEkle("gazlar", 3));
            konularKimyaLYS.add(new konuEkle("molekul", 4));

            konularListLYS.put(dersListLys.get(0), konularFizikLYS);
            konularListLYS.put(dersListLys.get(1), konularKimyaLYS);

        } catch (Exception ex) {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage(), durtion);
            toast.show();
        }
    }
    public void onBackPressed() {
        try {
            backButtonHandler();
            //return;
            //super.onBackPressed();
        }catch (Exception ex)
        {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage() + " onBack", durtion);
            toast.show();
        }

    }
    public void backButtonHandler() {
        try {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                    anaSayfa.this);
            alertDialog.setTitle("Uygulamadan Çıkmak?");
            alertDialog.setMessage("Uygulamadan cıkmak istediginizden emin misiniz");
            alertDialog.setIcon(R.mipmap.ic_launcher);
            alertDialog.setPositiveButton("EVET",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), GirisActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra("EXIT", true);
                            startActivity(intent);
                            //finish();
                           // System.exit(0);
                        }
                    });
            alertDialog.setNegativeButton("HAYIR",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            alertDialog.show();
        }catch ( Exception ex)
        {
            int durtion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, ex.getMessage() + " onBack", durtion);
            toast.show();
        }

    }


}


