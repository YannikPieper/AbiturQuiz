package com.eastereggdev.abiturprepare;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class QuestionSettings extends Activity {

    public int Questions = 5;
    public int fachNM;
    public String WahlFach;
    public String letztesFach;
    public boolean Fg;
    public String[] NameFach;
    public String[] Category;

    public ListView selectFach;
    public String[] fach;
    public ArrayAdapter<String> listadapter;

    public ListView selectCategory;
    public String[] katmathe;
    public String[] katdeutsch;
    public String[] katenglisch;
    public String[] katfranzoesisch;
    public String[] katspanisch;
    public String[] katgeschichte;
    public String[] katerdkunde;
    public String[] katsport;
    public String[] katchemie;
    public String[] katphysik;
    public String[] katbiologie;
    public String[] katbildendekunst;
    public String[] katmusik;
    public String[] katgemeinschaftskunde;

    public String[] kat;
    public ArrayAdapter<String> listadapterCat;
    public int IKat;
    public String WahlKat;

    public static String filename = "SharedPreferencesFile";
    SharedPreferences serverData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        katmathe = getResources().getStringArray(R.array.kat_mathe);
        katdeutsch = getResources().getStringArray(R.array.kat_deutsch);
        katenglisch = getResources().getStringArray(R.array.kat_englisch);
        katfranzoesisch = getResources().getStringArray(R.array.kat_französich);
        katspanisch = getResources().getStringArray(R.array.kat_spanisch);
        katgeschichte = getResources().getStringArray(R.array.kat_geschichte);
        katerdkunde = getResources().getStringArray(R.array.kat_erdkunde);
        katsport = getResources().getStringArray(R.array.kat_sport);
        katchemie = getResources().getStringArray(R.array.kat_chemie);
        katphysik = getResources().getStringArray(R.array.kat_physik);
        katbiologie = getResources().getStringArray(R.array.kat_biologie);
        katbildendekunst = getResources().getStringArray(R.array.kat_bildendekunst);
        katmusik = getResources().getStringArray(R.array.kat_musik);
        katgemeinschaftskunde = getResources().getStringArray(R.array.kat_gemeinschaftskunde);

        loadData();
        setCategory();
    }

    public void Fach(View view)
    {
        setContentView(R.layout.fach);

        fach = getResources().getStringArray(R.array.fach);

        selectFach = (ListView) findViewById(R.id.fach);
        listadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fach);
        selectFach.setAdapter(listadapter);

        selectFach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                fachNM = selectFach.getPositionForView(view);

                WahlFach = fach[fachNM];
                Fg = true;
                loadData();
                setCategory();
            }
        });

    }

    public void setCategory()
    {
        if(fachNM == 0) {
            kat = katmathe;
        }
        if(fachNM == 1) {
            kat = katdeutsch;
        }
        if(fachNM == 2) {
            kat = katenglisch;
        }
        if(fachNM == 3) {
            kat = katfranzoesisch;
        }
        if(fachNM == 4) {
            kat = katspanisch;
        }
        if(fachNM == 5) {
            kat = katgeschichte;
        }
        if(fachNM == 6) {
            kat = katerdkunde;
        }
        if(fachNM == 7) {
            kat = katsport;
        }
        if(fachNM == 8) {
            kat = katchemie;
        }
        if(fachNM == 9) {
            kat = katphysik;
        }
        if(fachNM == 10) {
            kat = katbiologie;
        }
        if(fachNM == 11) {
            kat = katbildendekunst;
        }
        if(fachNM == 12) {
            kat = katmusik;
        }
        if(fachNM == 13) {
            kat = katgemeinschaftskunde;
        }

        selectCategory = (ListView) findViewById(R.id.kategorien);
        listadapterCat = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,kat);
        selectCategory.setAdapter(listadapterCat);
        final TextView ausgewaehlteKat = (TextView) findViewById(R.id.kat);
        selectCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                IKat = selectCategory.getPositionForView(view);

                WahlKat = kat[IKat];
                ausgewaehlteKat.setText(WahlKat);
            }
        });

    }

    public void loadData()
    {
        setContentView(R.layout.settings);
        final TextView quNumber = (TextView) findViewById(R.id.quNumber);
        Button fachauswahl = (Button) findViewById(R.id.fach);
        quNumber.setText("" + Questions);
        if(Fg == true) {
            fachauswahl.setText(WahlFach);
        }else {
            serverData = getSharedPreferences(filename, 0);
            fachNM = serverData.getInt("fach", 0);
            NameFach = getResources().getStringArray(R.array.fach);
            letztesFach = NameFach[fachNM];
            fachauswahl.setText(letztesFach);
        }
    }

    public void minus(View view)
    {
        final TextView quNumber = (TextView) findViewById(R.id.quNumber);
        if (Questions > 5) {
            Questions = Questions - 5;
            quNumber.setText("" + Questions);
        } else {
            Toast.makeText(getApplicationContext(), "Du musst mindestens fünf Fragen beantworten", Toast.LENGTH_SHORT).show();
        }

    }

    public void plus(View view)
    {
        final TextView quNumber = (TextView) findViewById(R.id.quNumber);
        if (Questions < 100) {
            Questions = Questions + 5;
            quNumber.setText("" + Questions);
        } else {
            Toast.makeText(getApplicationContext(), "Es können maximal 100 Fragen beantwortet werden", Toast.LENGTH_SHORT).show();
        }

    }


    public void startQuestions(View view)
    {
        serverData = getSharedPreferences(filename, 0);
        SharedPreferences.Editor editor = serverData.edit();

        editor.putInt("kategorie", IKat);
        editor.putInt("questionNumber", Questions);
        editor.putInt("fach", fachNM);
        editor.commit();

        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
        finish();
    }



}
