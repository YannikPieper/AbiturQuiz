package com.eastereggdev.abiturprepare;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Finish extends Activity{

    public static String filename = "SharedPreferencesFile";
    SharedPreferences serverData;

    public int Questions;
    public int QuestionsR;
    public int Fach;
    public int QuFr;
    public int QuFg;
    public int NQuFr;
    public int NQuFg;
    public int APR;
    public int NAPR;
    public boolean dataSaved = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);

        loadData();
    }


    public void nochmal(View view)
    {
        serverData = getSharedPreferences(filename, 0);
        SharedPreferences.Editor editor = serverData.edit();

        editor.putInt("questionNumber", Questions);
        editor.putInt("fach", Fach);
        editor.commit();

        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
        finish();

    }

    public void statistiken(View view)
    {
        Intent intent = new Intent(this, Statistics.class);
        startActivity(intent);
        finish();
    }

    public void menu(View view)
    {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }

    public void loadData()
    {
        serverData = getSharedPreferences(filename, 0);
        SharedPreferences.Editor editor = serverData.edit();
        Questions = serverData.getInt("questionNumber", 0);
        QuestionsR = serverData.getInt("richtig", 0);
        Fach = serverData.getInt("fach", 0);
        TextView perfekt = (TextView) findViewById(R.id.pRunde);

        if(Questions != QuestionsR){
            perfekt.setVisibility(View.INVISIBLE);
        } else {
            perfekt.setVisibility(View.VISIBLE);
        }

        if(dataSaved == false) {
            if (Fach == 0) {
                QuFr = serverData.getInt("sta0richtig", 0);
                QuFg = serverData.getInt("sta0gesamt", 0);

                APR = serverData.getInt("sta0perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;

                editor.putInt("sta0perfekt", NAPR);
                editor.putInt("sta0richtig", NQuFr);
                editor.putInt("sta0gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 1) {
                QuFr = serverData.getInt("sta1richtig", 0);
                QuFg = serverData.getInt("sta1gesamt", 0);

                APR = serverData.getInt("sta1perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta1perfekt", NAPR);
                editor.putInt("sta1richtig", NQuFr);
                editor.putInt("sta1gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 2) {
                QuFr = serverData.getInt("sta2richtig", 0);
                QuFg = serverData.getInt("sta2gesamt", 0);

                APR = serverData.getInt("sta2perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta2perfekt", NAPR);
                editor.putInt("sta2richtig", NQuFr);
                editor.putInt("sta2gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 3) {
                QuFr = serverData.getInt("sta3richtig", 0);
                QuFg = serverData.getInt("sta3gesamt", 0);

                APR = serverData.getInt("sta3perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta3perfekt", NAPR);
                editor.putInt("sta3richtig", NQuFr);
                editor.putInt("sta3gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 4) {
                QuFr = serverData.getInt("sta4richtig", 0);
                QuFg = serverData.getInt("sta4gesamt", 0);

                APR = serverData.getInt("sta4perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta4perfekt", NAPR);
                editor.putInt("sta4richtig", NQuFr);
                editor.putInt("sta4gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 5) {
                QuFr = serverData.getInt("sta5richtig", 0);
                QuFg = serverData.getInt("sta5gesamt", 0);

                APR = serverData.getInt("sta5perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta5perfekt", NAPR);
                editor.putInt("sta5richtig", NQuFr);
                editor.putInt("sta5gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 6) {
                QuFr = serverData.getInt("sta6richtig", 0);
                QuFg = serverData.getInt("sta6gesamt", 0);

                APR = serverData.getInt("sta6perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta6perfekt", NAPR);
                editor.putInt("sta6richtig", NQuFr);
                editor.putInt("sta6gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 7) {
                QuFr = serverData.getInt("sta7richtig", 0);
                QuFg = serverData.getInt("sta7gesamt", 0);

                APR = serverData.getInt("sta7perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta7perfekt", NAPR);
                editor.putInt("sta7richtig", NQuFr);
                editor.putInt("sta7gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 8) {
                QuFr = serverData.getInt("sta8richtig", 0);
                QuFg = serverData.getInt("sta8gesamt", 0);

                APR = serverData.getInt("sta8perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta8perfekt", NAPR);
                editor.putInt("sta8richtig", NQuFr);
                editor.putInt("sta8gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 9) {
                QuFr = serverData.getInt("sta9richtig", 0);
                QuFg = serverData.getInt("sta9gesamt", 0);

                APR = serverData.getInt("sta9perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta9perfekt", NAPR);
                editor.putInt("sta9richtig", NQuFr);
                editor.putInt("sta9gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 10) {
                QuFr = serverData.getInt("sta10richtig", 0);
                QuFg = serverData.getInt("sta10gesamt", 0);

                APR = serverData.getInt("sta10perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta10perfekt", NAPR);
                editor.putInt("sta10richtig", NQuFr);
                editor.putInt("sta10gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 11) {
                QuFr = serverData.getInt("sta11richtig", 0);
                QuFg = serverData.getInt("sta11gesamt", 0);

                APR = serverData.getInt("sta11perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta11perfekt", NAPR);
                editor.putInt("sta11richtig", NQuFr);
                editor.putInt("sta11gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 12) {
                QuFr = serverData.getInt("sta12richtig", 0);
                QuFg = serverData.getInt("sta12gesamt", 0);

                APR = serverData.getInt("sta12perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta12perfekt", NAPR);
                editor.putInt("sta12richtig", NQuFr);
                editor.putInt("sta12gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
            if (Fach == 13) {
                QuFr = serverData.getInt("sta13richtig", 0);
                QuFg = serverData.getInt("sta13gesamt", 0);

                APR = serverData.getInt("sta13perfekt", 0);
                if(Questions == QuestionsR) {
                    NAPR = APR + 1;
                }else {
                    NAPR = APR;
                }

                NQuFr = QuFr + QuestionsR;
                NQuFg = QuFg + Questions;
                editor.putInt("sta13perfekt", NAPR);
                editor.putInt("sta13richtig", NQuFr);
                editor.putInt("sta13gesamt", NQuFg);
                editor.commit();
                dataSaved = true;
            }
        }

        setData();
    }

    public void setData()
    {
        TextView rf = (TextView) findViewById(R.id.rf);
        rf.setText(QuestionsR + "/" + Questions);

    }
}
