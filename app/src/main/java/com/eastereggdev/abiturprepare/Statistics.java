package com.eastereggdev.abiturprepare;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Statistics extends Activity{

    public ListView selectFach;
    public String[] fach;
    public ArrayAdapter<String> listadapter;

    public int fachNM;
    public String WahlFach;
    public boolean gF = false;

    public double starichtig;
    public double stagesamt;
    public double staprozent;
    public int Istarichtig;
    public int Istagesamt;
    public int AnzahlPerfekteRunden;

    DecimalFormat f = new DecimalFormat("#0.00");
    public static String filename = "SharedPreferencesFile";
    SharedPreferences serverData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);
        loadData();
    }

    public void pFach(View view)
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
                gF = true;
                loadData();
            }
        });

    }

    public void share(View view)
    {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Ich habe in dem Fach " + WahlFach + " " + starichtig + "/" + stagesamt + " Fragen richtig beantwortet! ");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Abi Quiz");
        startActivity(Intent.createChooser(sharingIntent, "Teile deine Abi Quiz Statistiken!"));
    }

    //beschreibt die Double Variabel genauer
    public static String format(double i)
    {
        DecimalFormat f = new DecimalFormat("#0.00");
        double toFormat = ((double)Math.round(i*100))/100;
        return f.format(toFormat);
    }

    public void loadData()
    {
        setContentView(R.layout.statistics);
        Button fachauswahl = (Button) findViewById(R.id.pFach);
        TextView st1 = (TextView) findViewById(R.id.st1);
        TextView st2 = (TextView) findViewById(R.id.st2);
        fachauswahl.setText(WahlFach);
        TextView pRunde = (TextView) findViewById(R.id.perfekteRunden);

        if(gF == false) {
            serverData = getSharedPreferences(filename, 0);
            fachNM = serverData.getInt("fach", 0);
            fach = getResources().getStringArray(R.array.fach);
            WahlFach = fach[fachNM];
            fachauswahl.setText(WahlFach);
        }

        if(fachNM == 0){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta0richtig", 0);
            stagesamt = serverData.getInt("sta0gesamt", 1);

            Istarichtig = serverData.getInt("sta0richtig", 0);
            Istagesamt = serverData.getInt("sta0gesamt", 0);

            AnzahlPerfekteRunden = serverData.getInt("sta0perfekt", 0);

            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);

            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 1){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta1richtig", 0);
            stagesamt = serverData.getInt("sta1gesamt", 1);

            Istarichtig = serverData.getInt("sta1richtig", 0);
            Istagesamt = serverData.getInt("sta1gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta1perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);

            staprozent = starichtig / stagesamt * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 2){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta2richtig", 0);
            stagesamt = serverData.getInt("sta2gesamt", 1);

            Istarichtig = serverData.getInt("sta2richtig", 0);
            Istagesamt = serverData.getInt("sta2gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta2perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 3){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta3richtig", 0);
            stagesamt = serverData.getInt("sta3gesamt", 1);

            Istarichtig = serverData.getInt("sta3richtig", 0);
            Istagesamt = serverData.getInt("sta3gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta3perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 4){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta4richtig", 0);
            stagesamt = serverData.getInt("sta4gesamt", 1);

            Istarichtig = serverData.getInt("sta4richtig", 0);
            Istagesamt = serverData.getInt("sta4gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta4perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 5){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta5richtig", 0);
            stagesamt = serverData.getInt("sta5gesamt", 1);

            Istarichtig = serverData.getInt("sta5richtig", 0);
            Istagesamt = serverData.getInt("sta5gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta5perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = starichtig / stagesamt * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 6){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta6richtig", 0);
            stagesamt = serverData.getInt("sta6gesamt", 1);

            Istarichtig = serverData.getInt("sta6richtig", 0);
            Istagesamt = serverData.getInt("sta6gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta6perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 7){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta7richtig", 0);
            stagesamt = serverData.getInt("sta7gesamt", 1);

            Istarichtig = serverData.getInt("sta7richtig", 0);
            Istagesamt = serverData.getInt("sta7gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta7perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 8){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta8richtig", 0);
            stagesamt = serverData.getInt("sta8gesamt", 1);

            Istarichtig = serverData.getInt("sta8richtig", 0);
            Istagesamt = serverData.getInt("sta8gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta8perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 9){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta9richtig", 0);
            stagesamt = serverData.getInt("sta9gesamt", 1);

            Istarichtig = serverData.getInt("sta9richtig", 0);
            Istagesamt = serverData.getInt("sta9gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta9perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 10){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta10richtig", 0);
            stagesamt = serverData.getInt("sta10gesamt", 1);

            Istarichtig = serverData.getInt("sta10richtig", 0);
            Istagesamt = serverData.getInt("sta10gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta10perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 11){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta11richtig", 0);
            stagesamt = serverData.getInt("sta11gesamt", 1);

            Istarichtig = serverData.getInt("sta11richtig", 0);
            Istagesamt = serverData.getInt("sta11gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta11perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 12){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta12richtig", 0);
            stagesamt = serverData.getInt("sta12gesamt", 1);

            Istarichtig = serverData.getInt("sta12richtig", 0);
            Istagesamt = serverData.getInt("sta12gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta12perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
        if(fachNM == 13){
            serverData = getSharedPreferences(filename, 0);

            //Methode um den Username wieder aus dem SharedPreferences File auszulesen
            starichtig = serverData.getInt("sta13richtig", 0);
            stagesamt = serverData.getInt("sta13gesamt", 1);

            Istarichtig = serverData.getInt("sta13richtig", 0);
            Istagesamt = serverData.getInt("sta13gesamt", 0);
            AnzahlPerfekteRunden = serverData.getInt("sta13perfekt", 0);
            st1.setText(Istarichtig + "/" + Istagesamt);
            staprozent = (starichtig / stagesamt) * 100;
            st2.setText(format(staprozent) + "%");
            pRunde.setText("" +AnzahlPerfekteRunden);
            if(staprozent > 50){
                st1.setBackgroundColor(Color.parseColor("#8BC34A"));
                st2.setBackgroundColor(Color.parseColor("#8BC34A"));
            }else {
                st1.setBackgroundColor(Color.parseColor("#F44336"));
                st2.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }

    }

}
