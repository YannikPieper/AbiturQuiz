package com.eastereggdev.abiturprepare;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class About extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }

    public void facebook(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/eastereggdev"));
        startActivity(browserIntent);
    }

    public void twitter(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/eastereggdev"));
        startActivity(browserIntent);
    }

    public void homepage(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eastereggdevelopment.com/"));
        startActivity(browserIntent);
    }

}
