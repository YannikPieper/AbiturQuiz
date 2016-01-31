package com.eastereggdev.abiturprepare;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;


public class Quiz extends Activity {

    public int Questions;
    public int Fach;
    public int QuestionR;
    public int time = 1200;
    public int Kategorie;

    public String frage;
    public String antwort;
    public String falsch1;
    public String falsch2;
    public String falsch3;
    public boolean pressed;

    public String url;
    public String[] urlFach;

    public int correctAnt;
    public int actualQu = 0;

    public static String filename = "SharedPreferencesFile";
    SharedPreferences serverData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        loadData();
    }

    public void loadData()
    {
        serverData = getSharedPreferences(filename, 0);

        //Methode um den Username wieder aus dem SharedPreferences File auszulesen
        Questions = serverData.getInt("questionNumber", 0);
        Fach = serverData.getInt("fach", 0);
        Kategorie = serverData.getInt("kategorie", 0);
        chooseURL();
        loadDataOnline();

        Button antwort1 = (Button) findViewById(R.id.answer1);
        Button antwort2 = (Button) findViewById(R.id.answer2);
        Button antwort3 = (Button) findViewById(R.id.answer3);
        Button antwort4 = (Button) findViewById(R.id.answer4);

        antwort1.setBackgroundResource(R.drawable.quizbtn);
        antwort2.setBackgroundResource(R.drawable.quizbtn);
        antwort3.setBackgroundResource(R.drawable.quizbtn);
        antwort4.setBackgroundResource(R.drawable.quizbtn);
    }

    public void chooseURL()
    {
        urlFach = getResources().getStringArray(R.array.url);
        url = urlFach[Fach];
        //url = urlFach[Fach] + Kategorie;
        System.out.println(url);
    }

    public void loadDataOnline()
    {
        actualQu++;

        if(actualQu > Questions){
            Intent intent = new Intent(this, Finish.class);
            startActivity(intent);

            serverData = getSharedPreferences(filename, 0);
            SharedPreferences.Editor editor = serverData.edit();
            editor.putInt("richtig", QuestionR);
            editor.commit();
            finish();
        }

        GetQuestion startSearch = new GetQuestion();
        startSearch.execute();

    }

    public void setData()
    {
        TextView question = (TextView) findViewById(R.id.frage);
        TextView number = (TextView) findViewById(R.id.number);
        Button antwort1 = (Button) findViewById(R.id.answer1);
        Button antwort2 = (Button) findViewById(R.id.answer2);
        Button antwort3 = (Button) findViewById(R.id.answer3);
        Button antwort4 = (Button) findViewById(R.id.answer4);

        number.setText(actualQu + "/" + Questions);
        question.setText(frage);

        pressed = false;

        Random rand = new Random();
        correctAnt = (rand.nextInt(4) + 1);

        if(correctAnt == 1){
            antwort1.setText(antwort);
            antwort2.setText(falsch1);
            antwort3.setText(falsch2);
            antwort4.setText(falsch3);
        }
        if(correctAnt == 2){
            antwort1.setText(falsch1);
            antwort2.setText(antwort);
            antwort3.setText(falsch2);
            antwort4.setText(falsch3);
        }
        if(correctAnt == 3){
            antwort1.setText(falsch1);
            antwort2.setText(falsch2);
            antwort3.setText(antwort);
            antwort4.setText(falsch3);
        }
        if(correctAnt == 4){
            antwort1.setText(falsch1);
            antwort2.setText(falsch2);
            antwort3.setText(falsch3);
            antwort4.setText(antwort);
        }

    }

    public void answer1(View view)
    {
        Button antwort1 = (Button) findViewById(R.id.answer1);
        Button antwort2 = (Button) findViewById(R.id.answer2);
        Button antwort3 = (Button) findViewById(R.id.answer3);
        Button antwort4 = (Button) findViewById(R.id.answer4);
        if(pressed == false) {
            if (correctAnt == 1) {
                antwort1.setBackgroundResource(R.drawable.settingsbtn);
                QuestionR++;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }, time);
            } else {
                antwort1.setBackgroundResource(R.drawable.falschbtn);
                if (correctAnt == 1) {
                    antwort1.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 2) {
                    antwort2.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 3) {
                    antwort3.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 4) {
                    antwort4.setBackgroundResource(R.drawable.settingsbtn);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }, time);
            }
        }
        pressed = true;
    }

    public void answer2(View view)
    {
        Button antwort1 = (Button) findViewById(R.id.answer1);
        Button antwort2 = (Button) findViewById(R.id.answer2);
        Button antwort3 = (Button) findViewById(R.id.answer3);
        Button antwort4 = (Button) findViewById(R.id.answer4);
        if(pressed == false) {
            if (correctAnt == 2) {
                antwort2.setBackgroundResource(R.drawable.settingsbtn);
                QuestionR++;

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }, time);

            } else {
                antwort2.setBackgroundResource(R.drawable.falschbtn);
                if (correctAnt == 1) {
                    antwort1.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 2) {
                    antwort2.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 3) {
                    antwort3.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 4) {
                    antwort4.setBackgroundResource(R.drawable.settingsbtn);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }, time);
            }
        }
        pressed = true;
    }

    public void answer3(View view)
    {
        Button antwort1 = (Button) findViewById(R.id.answer1);
        Button antwort2 = (Button) findViewById(R.id.answer2);
        Button antwort3 = (Button) findViewById(R.id.answer3);
        Button antwort4 = (Button) findViewById(R.id.answer4);
        if(pressed == false) {
            if (correctAnt == 3) {
                antwort3.setBackgroundResource(R.drawable.settingsbtn);
                QuestionR++;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }, time);
            } else {
                antwort3.setBackgroundResource(R.drawable.falschbtn);
                if (correctAnt == 1) {
                    antwort1.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 2) {
                    antwort2.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 3) {
                    antwort3.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 4) {
                    antwort4.setBackgroundResource(R.drawable.settingsbtn);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }, time);
            }
        }
        pressed = true;
    }

    public void answer4(View view)
    {
        Button antwort1 = (Button) findViewById(R.id.answer1);
        Button antwort2 = (Button) findViewById(R.id.answer2);
        Button antwort3 = (Button) findViewById(R.id.answer3);
        Button antwort4 = (Button) findViewById(R.id.answer4);
        if(pressed == false) {
            if (correctAnt == 4) {
                antwort4.setBackgroundResource(R.drawable.settingsbtn);
                QuestionR++;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }, time);
            } else {
                antwort4.setBackgroundResource(R.drawable.falschbtn);
                if (correctAnt == 1) {
                    antwort1.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 2) {
                    antwort2.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 3) {
                    antwort3.setBackgroundResource(R.drawable.settingsbtn);
                }
                if (correctAnt == 4) {
                    antwort4.setBackgroundResource(R.drawable.settingsbtn);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }, time);
            }
        }
        pressed = true;
    }

    private class GetQuestion extends AsyncTask<Void, Void, Void> {

        ProgressDialog progressDialog;
        public boolean cancelled;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(Quiz.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            ServiceHandlerGet sh = new ServiceHandlerGet();
            String jsonStr = sh.makeServiceCall(url, ServiceHandlerGet.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                        frage = jsonObj.getString("frage");
                        antwort = jsonObj.getString("antwort");
                        falsch1 = jsonObj.getString("falsch_1");
                        falsch2 = jsonObj.getString("falsch_2");
                        falsch3 = jsonObj.getString("falsch_3");


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

        return null;
        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            progressDialog.hide();
            setData();
        }

    }


}
