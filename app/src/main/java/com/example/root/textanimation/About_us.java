package com.example.root.textanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class About_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        WebView webView = (WebView)findViewById(R.id.webViewAbout);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/about.html");
    }
}
