//  right click your projects root directory and select Git > Add. This will add all your project files to your Git repository.
//  right click the project name again and this time select Git > Commit Directory.
//  right click the project name, select Git > Repository > Push.


package com.sayapp.selectapp;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Remove the below line after defining your own ad unit ID.
    private static final String TOAST_TEXT = "Test ads are being shown. "
            + "To show live ads, replace the ad unit ID in res/values/strings.xml with your own ad unit ID.";
    private int[] image_resources = {R.drawable.r01, R.drawable.r02, R.drawable.r03, R.drawable.r04,
            R.drawable.r05, R.drawable.r06, R.drawable.r07, R.drawable.r08, R.drawable.r09, R.drawable.r10,
            R.drawable.r11, R.drawable.r12, R.drawable.r13, R.drawable.r14, R.drawable.r15,
            R.drawable.r16, R.drawable.r17};
    private String[] isim_resources = {"Ağlayan robot", "Üzgün robot", "Mutlu robot", "Korkmuş robot", "Utangaç robot",
            "Şakacı robot", "Hasta robot", "Kızgın robot", "Aşık robot", "Kahkahacı robot", "Yorgun robot",
            "Uyuyan robot", "Gururlu robot", "Şaşkın robot", "Kuşkucu robot", "Sıkılmış robot", "İfadesiz robot"};
    private int[] sound_resources = {R.raw.t01,R.raw.t02,R.raw.t03,R.raw.t04,R.raw.t05,R.raw.t06,R.raw.t07,R.raw.t08,
            R.raw.t09,R.raw.t10,R.raw.t11,R.raw.t12,R.raw.t13,R.raw.t14,R.raw.t15,R.raw.t16,R.raw.t17};
    private int[] excludeRows = {1,3,5,7};

    //public ImageButton v1, v2, v3, v4;
    public ImageButton b1, b2, b3, b4;
    public TextView t1;
    public int position = 1, p1, p2, p3, p4, rp;


    int min = 1;    // random number minimum
    int max = 17;    // random number maximum
    int mean = 4;    // random number mean

    MediaPlayer mySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
        //Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show();
        t1 = (TextView) findViewById(R.id.txt1);
        t1.setTextSize(15);
        t1.setText(isim_resources[position-1]);
        Toast.makeText(this, "Duygusal Robot Uygulamasına Hoşgeldiniz...", Toast.LENGTH_LONG).show();
        //mySound = MediaPlayer.create(this, R.raw.s01);
        mySound = MediaPlayer.create(this, sound_resources[position-1]);
        mySound.start();


    }

    public void clicked(View a){
        b1 = (ImageButton)findViewById(R.id.img1);
        b2 = (ImageButton)findViewById(R.id.img2);
        b3 = (ImageButton)findViewById(R.id.img3);
        b4 = (ImageButton)findViewById(R.id.img4);
        t1 = (TextView) findViewById(R.id.txt1);


        if (a.getId()==R.id.img1){
            if (position==1) {
                    refreshIt(); }
             else {
                b1.setImageResource(R.drawable.x);
                mySound = MediaPlayer.create(this, R.raw.err);
                mySound.start();
            }
            }

        if (a.getId()==R.id.img2){
            if (position==2) {
                refreshIt(); }
            else {
                b2.setImageResource(R.drawable.x);
                mySound = MediaPlayer.create(this, R.raw.err);
                mySound.start();
            }
        }

        if (a.getId()==R.id.img3){
            if (position==3) {
                refreshIt(); }
            else {
                b3.setImageResource(R.drawable.x);
                mySound = MediaPlayer.create(this, R.raw.err);
                mySound.start();
            }
        }

        if (a.getId()==R.id.img4){
            if (position==4) {
                refreshIt(); }
            else {
                b4.setImageResource(R.drawable.x);
                mySound = MediaPlayer.create(this, R.raw.err);
                mySound.start();
            }
        }



    }
    public void refreshIt(){

        mySound = MediaPlayer.create(this, R.raw.ca);
        mySound.start();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("Doğru cevap");
        builder.setMessage("Devam etmek için tamama tıklayınız");
        builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //


                b1 = (ImageButton)findViewById(R.id.img1);
                b2 = (ImageButton)findViewById(R.id.img2);
                b3 = (ImageButton)findViewById(R.id.img3);
                b4 = (ImageButton)findViewById(R.id.img4);
                p1 = 0;
                p2 = 0;
                p3 = 0;
                p4 = 0;

                //Random rndm = new Random();
                //p1 = rndm.nextInt(max - min + 1) + min;
                p1= randomNumber();
                b1.setImageResource(image_resources[p1 - 1]);

                //rndm = new Random();
                //p2 = rndm.nextInt(max - min + 1) + min;
                p2= randomNumber();
                b2.setImageResource(image_resources[p2 - 1]);

                //rndm = new Random();
                // p3 = rndm.nextInt(max - min + 1) + min;
                p3= randomNumber();
                b3.setImageResource(image_resources[p3 - 1]);

                //rndm = new Random();
                //p4 = rndm.nextInt(max - min + 1) + min;
                p4= randomNumber();
                b4.setImageResource(image_resources[p4 - 1]);

                Random rndm2 = new Random();
                position = rndm2.nextInt(mean - min + 1) + min;
                //Toast.makeText(getApplicationContext()," "+p1+" "+p2+" "+p3+" "+p4+" "+position, Toast.LENGTH_LONG).show();
                if (position==1) {
                    t1.setText(isim_resources[p1-1]);
                    mySound = MediaPlayer.create(getApplicationContext(), sound_resources[p1-1]);
                    mySound.start();
                }

                if (position==2) {
                    t1.setText(isim_resources[p2-1]);
                    mySound = MediaPlayer.create(getApplicationContext(), sound_resources[p2-1]);
                    mySound.start();
                }

                if (position==3) {
                    t1.setText(isim_resources[p3-1]);
                    mySound = MediaPlayer.create(getApplicationContext(), sound_resources[p3-1]);
                    mySound.start();
                }

                if (position==4) {
                    t1.setText(isim_resources[p4-1]);
                    mySound = MediaPlayer.create(getApplicationContext(), sound_resources[p4-1]);
                    mySound.start();
                }


                // mySound.start();

            }

                });

        // Create the AlertDialog object and return it
        builder.create().show();
    }


    public int randomNumber(){
        Random rndm = new Random();
        rp = rndm.nextInt(max - min + 1) + min;
        boolean success = false;
        while(!success) {
            if (p1 != rp && p2 != rp && p3 != rp && p4 != rp) {
                success = true;
            }
            else {
                rndm = new Random();
                rp = rndm.nextInt(max - min + 1) + min;
            }
        }

        return rp;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // shows the about message
            Toast toast=Toast.makeText(this, "Duygusal Robot uygulaması çocukların duyguları tanımlayabilmesi için eğlence amaçlı olarak geliştirilmiş ve ücretsiz olarak hizmete sunulmuştur.",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 300);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
