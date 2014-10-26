package com.sinch.android.rtc.sample.messaging;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.net.URL;
import java.util.ArrayList;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.Menu;
import android.view.MenuItem;
//import com.dolby.dap.*;
import java.net.*;
import java.io.*;
import android.R;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.VideoView;

public class MyFeed extends Activity {
    ArrayList<Profile> profiles;
    FrameLayout f;
    ImageButton no;
    ImageButton yes;
    ImageButton info;
    Button notify;
    Button profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.sinch.android.rtc.sample.messaging.R.layout.activity_my_feed);
        f = (FrameLayout) findViewById(com.sinch.android.rtc.sample.messaging.R.id.frame);
        no = (ImageButton) findViewById(com.sinch.android.rtc.sample.messaging.R.id.imageButton);
        yes = (ImageButton) findViewById(com.sinch.android.rtc.sample.messaging.R.id.imageButton2);
        info = (ImageButton) findViewById(com.sinch.android.rtc.sample.messaging.R.id.imageButton3);
        notify = (Button) findViewById(com.sinch.android.rtc.sample.messaging.R.id.button4);
        profile = (Button) findViewById(com.sinch.android.rtc.sample.messaging.R.id.button5);

        this.setUpProfiles();

        no.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                // move onto the next page
                Intent intent = new Intent(MyFeed.this, MyFeed.class);
                startActivity(intent);
            }
        }) ;

        yes.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add profile to list of likes and move onto the next page

                Intent intent = new Intent(MyFeed.this, MyFeed.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyFeed.this, MusicaProfile.class);
                startActivity(intent);
                // go to the person's profile
            }
        });

        notify.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ){
                // go to notifications page
                Intent intent = new Intent(MyFeed.this, Notification.class);
                startActivity(intent);
            } });

        profile.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ){
                // go to your own profile
                Intent intent = new Intent(MyFeed.this, JustinProfile.class);
                startActivity(intent);
            } });
    } // end constructor

    public void setUpProfiles() {
        profiles = new ArrayList<Profile>();
        ArrayList<String> instruments1 = new ArrayList<String>();
        instruments1.add("Violin" + "Piano" + "Ukulele");
        ArrayList<String> instruments2 = new ArrayList<String>();
        instruments2.add("Violin" + "Piano");
        ArrayList<String> instruments3 = new ArrayList<String>();
        instruments3.add("Guitar" + "Cello");
        ArrayList<URL> clip1 = new ArrayList<URL>();
        WebView w = (WebView) findViewById(com.sinch.android.rtc.sample.messaging.R.id.webView);
        WebViewClient wvc = new WebViewClient();
        WebChromeClient chromeClient = new WebChromeClient();

        w.setWebChromeClient(chromeClient);
        w.setWebViewClient(wvc);
        WebSettings webSettings = w.getSettings();

        webSettings.setJavaScriptEnabled(true);


        //       ArrayList<URL> clip2 = new ArrayList<URL>();
//        WebView w2 = (WebView) this.findViewById(R.id.webView2);
//        w2.loadUrl("https://www.youtube.com/watch?v=XqLTe8h0-jo");
        //       ArrayList<URL> clip3 = new ArrayList<URL>();
//        WebView w3 = (WebView) this.findViewById(R.id.webView2);
//        w3.loadUrl("https://www.youtube.com/watch?v=QZpGe5rNJkI");
        try {
            clip1.add(new URL("http://students.engr.scu.edu/~mnaito/musica.html \n"));
           // clip1.add(new URL("http://students.engr.scu.edu/~mnaito/musica.html\n"));
           // clip1.add(new URL("<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/cmSbXsFE3l8\" frameborder=\"0\" allowfullscreen></iframe>\n"));
        } // end try
        catch (IOException e) {
            e.printStackTrace();
        } // end catch

        w.loadUrl("http://students.engr.scu.edu/~mnaito/musica.html \n");



        ArrayList<String> genres1 = new ArrayList<String>();
        genres1.add("R&B" + "Rock" + "Pop");
        ArrayList<String> genres2 = new ArrayList<String>();
        genres2.add("Metal" + "Classical");
        ArrayList<String> genres3 = new ArrayList<String>();
        genres3.add("Country" + "Rap" + "Hip Hop");
        FriendsList f1 = new FriendsList();
        FriendsList f2 = new FriendsList();
        FriendsList f3 = new FriendsList();
        FriendsList f4 = new FriendsList();

        Profile jason = new Profile("jcapili", "password", "Jason Capili", 18, "Pasasdena", clip1, f1, instruments3, 0, genres1);
        profiles.add(jason);
        Profile justin = new Profile("jmeeken", "abc123", "Justin Meeken", 29, "San Jose", clip1, f2, instruments2, 0, genres2);
        profiles.add(justin);
        Profile maile = new Profile("maile", "password123", "Maile", 18, "Hawaii", clip1, f3, instruments1, 1, genres3);
        profiles.add(maile);
        Profile taylor = new Profile("taylor", "asdf", "Taylor", 34, "Hawaii", clip1, f4, instruments3, 1, genres2);
        profiles.add(taylor);
        Profile daniel = new Profile("daniel", "qwerty", "Daniel", 20, "Santa Clara", clip1, f1, instruments2, 0, genres1);
        profiles.add(daniel);
        Profile robert = new Profile("robert", "accenture", "Robert", 19, "San Francisco", clip1, f2, instruments1, 0, genres1);
        profiles.add(robert);
        Profile chris = new Profile("chawkins", "swig", "Chris Hawkins", 41, "Los Angeles", clip1, f3, instruments3, 0, genres3);
        profiles.add(chris);
        Profile juliana = new Profile("jbanuelos", "501", "Juliana Banuelos", 32, "San Jose", clip1, f4, instruments2, 1, genres2);
        profiles.add(juliana);
        Profile pete = new Profile("pmitchell", "poker", "Pete Mitchell", 22, "San Diego", clip1, f1, instruments1, 0, genres1);
        profiles.add(pete);
        Profile tessie = new Profile("tberghoff", "art", "Tessie Berghoff", 39, "Sacramento", clip1, f2, instruments3, 1, genres2);
        profiles.add(tessie);

        jason.getFriendsList().addFriend(justin);
        justin.getFriendsList().addFriend(maile);
        maile.getFriendsList().addFriend(taylor);
        taylor.getFriendsList().addFriend(daniel);
        daniel.getFriendsList().addFriend(robert);
        robert.getFriendsList().addFriend(chris);
        chris.getFriendsList().addFriend(juliana);
        juliana.getFriendsList().addFriend(pete);
        pete.getFriendsList().addFriend(tessie);
        tessie.getFriendsList().addFriend(jason);
    } // end method setUpProfiles
}