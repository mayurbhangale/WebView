/*
Author : Mayur Bhangale
Demonstrates usage of WebView
Compiled with SDK version 22 on Android Studio 1.2.2
 */


package com.mayurbhangale.www.webviewdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mayurbhangale.www.webviewdemo.R;

public class MainActivity extends Activity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set Default layout view as activity_main.xml
        setContentView(R.layout.activity_main);
        web= (WebView) findViewById(R.id.webview1);
        web.setWebViewClient(new myWebClient());

        //Enable JavaScript inside WebView
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setDomStorageEnabled(true);
        web.loadUrl("file:///android_res/raw/index.html");
    }

    public class myWebClient extends WebViewClient
    {

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);


        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack())
        {
            web.goBack();
            return true;

        }
        return super.onKeyDown(keyCode, event);
    }



}