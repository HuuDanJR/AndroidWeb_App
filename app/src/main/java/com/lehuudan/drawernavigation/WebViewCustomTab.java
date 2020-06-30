package com.lehuudan.drawernavigation;

import android.content.ComponentName;
import android.graphics.Color;
import android.net.Uri;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WebViewCustomTab extends AppCompatActivity {
String CUSTOM_PACKAGE = "com.android.home";
String websiteUrl = LINK.s_lienhe;
CustomTabsClient customTabsClient;
CustomTabsSession customTabsSession;
CustomTabsServiceConnection customTabsServiceConnection;
CustomTabsIntent customTabsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_custom_tab);

        customTabsServiceConnection  = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                    customTabsClient = customTabsClient;
                    customTabsClient.warmup(0L);
                    customTabsSession = customTabsClient.newSession(null);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                customTabsClient  = null ;
            }
        };
        customTabsClient.bindCustomTabsService(this, CUSTOM_PACKAGE,customTabsServiceConnection);
        customTabsIntent = new CustomTabsIntent.Builder(customTabsSession)
                .setShowTitle(true).setToolbarColor(Color.BLUE).build();


        firstAction();
    }

    public void firstAction() {
        customTabsIntent.launchUrl(this, Uri.parse(websiteUrl));
    }
}
