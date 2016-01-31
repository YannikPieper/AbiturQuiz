package com.eastereggdev.abiturprepare;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class Menu extends Activity {

    public static String filename = "SharedPreferencesFile";
    SharedPreferences serverData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void start(View view)
    {
        Intent intent = new Intent(this, QuestionSettings.class);
        startActivity(intent);
    }

    public void about(View view)
    {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void statistics(View view)
    {
        Intent intent = new Intent(this, Statistics.class);
        startActivity(intent);
    }

    public void reset(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alle Daten werden gelöscht!") //
                .setMessage("Alle gespeicherten Daten, Spiele und Erfolge werden gelöscht. Willst du das wirklich?") //
                .setPositiveButton(("Ja"), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        serverData = getSharedPreferences(filename, 0);
                        SharedPreferences.Editor editor = serverData.edit();
                        editor.clear();
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "Alle gesammelten Daten wurden gelöscht!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }) //
                .setNegativeButton(("Nein"), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });
        builder.show();
    }
}
