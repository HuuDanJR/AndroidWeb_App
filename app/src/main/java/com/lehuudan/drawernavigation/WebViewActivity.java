package com.lehuudan.drawernavigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity{
    ProgressBar progressBar;
    ImageView imageView,img_back, img_refresh;
    WebView webView;
    String c1;
    Toolbar toolbar;  String newString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("STRING_I_NEED");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }
        progressBar =findViewById(R.id.progress_bar);
//        toolbar = findViewById(R.id.toolbar);
//        progressBar =findViewById(R.id.progress_bar);
//        imageView = findViewById(R.id.image_view);
        img_back = findViewById(R.id.img_back);
        img_refresh = findViewById(R.id.img_refresh);
        webView =findViewById(R.id.myWebview);
        Bundle bundle = getIntent().getExtras();
//        c1 = bundle.getString("Link");
//        Log.d("Link", c1);
//        progressBar.setMax(100);
//        webView.loadUrl("" + c1 + "");
        webView.loadUrl(newString);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkLoads (false);
//        webView.setWebViewClient(new WebViewClient());
        webView.setInitialScale(1);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);
//        webView.setWebViewClient( new MyWebViewClient());
//        webView.setWebChromeClient(new WebChromeClient());
//        webview.getSettings().setJavaScriptEnabled(true);

        webView.requestFocus(View.FOCUS_DOWN);
        webView.setWebChromeClient(new WebChromeClient() {
            @SuppressLint("NewApi")
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

//                progressBar.setProgressTintList(ColorStateList.valueOf(getColor(R.color.colorPrimary)));
//                progressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
//                getSupportActionBar().setTitle(title);
//                getSupportActionBar().setSubtitle("OK App");
            }
            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
//                imageView.setImageBitmap(icon);
            }

        });
        img_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.reload();
            }
        });
        //    Back
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(webView.canGoBack()) {
                    webView.goBack();
                    Toast.makeText(WebViewActivity.this, "", Toast.LENGTH_SHORT).show();
                }else{
                    Intent i = new Intent(getBaseContext(), MainActivity.class);startActivity(i);
                }
            }
        });
    }




    public void Trangchu(View view) {
        Intent i = new Intent(getBaseContext(),  MainActivity.class);startActivity(i);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }


}
