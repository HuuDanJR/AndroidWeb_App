package com.lehuudan.drawernavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterRecyclerView.OnItemClickListener {
    private static final String TAG = "MainActivity";
    ViewFlipper v_flipper;
    String strName;
    ImageView img_open;
    DrawerLayout drawer;
    Intent i;
    RecyclerView recyclerView;
    public AdapterRecyclerView mAdatper;
    private LinearLayout ln1_vaytien;
    private LinearLayout ln3_baohiem;
    private LinearLayout ln2_magiamgia;
    private LinearLayout ln4_mothetindung;
    private LinearLayout ln5_sanvemaybay;
    private LinearLayout ln5_vexekhach;
    private LinearLayout ln6_timvexe;
    private LinearLayout ln7_timphong;
    private LinearLayout ln8_timtuaDULICH;
    private LinearLayout ln9_timveTAU;
    private LinearLayout ln13_dichvukhac;
    private LinearLayout ln12_kiemtienonline;
    private LinearLayout ln11_thuexe;
    private LinearLayout ln10_timvieclam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ArrayList<Item> mArraylist = new ArrayList<>();
        mArraylist.add(new Item(R.drawable.vaytien, "VAY TIỀN", "thế chấp-tín chấp"));
        mArraylist.add(new Item(R.drawable.giamgia, "MÃ GIẢM GIÁ", "thế chấp-tín chấp"));
        mArraylist.add(new Item(R.drawable.baohiem, "BẢO HIỂM", "Thân thể-tài sản"));
        mArraylist.add(new Item(R.drawable.thetindung, "THẺ TÍN DỤNG", "Ngân hàng"));
        mArraylist.add(new Item(R.drawable.timvemaybay, "SĂN VÉ MÁY BAY", "Giá rẻ"));
        mArraylist.add(new Item(R.drawable.timvexekhach, "SĂN VÉ XE KHÁCH", "Giá rẻ"));
        mArraylist.add(new Item(R.drawable.hotel, "SĂN PHÒNG KHÁCH SẠN", "Giá rẻ"));
        mArraylist.add(new Item(R.drawable.timtuadulich, "TÌM TUA DU LỊCH", "Giá rẻ"));
        mArraylist.add(new Item(R.drawable.discount, "KIẾM TIỀN", "Kiếm tiền online"));
        mArraylist.add(new Item(R.drawable.timvieclam, "VIỆC LÀM", "Toàn quốc"));
        mArraylist.add(new Item(R.drawable.dichvukhac, "XEM THÊM", ""));
        mArraylist.add(new Item(R.drawable.icon_logo, "GIỚI THIỆU", "Về chúng tôi"));
//        mArraylist.add(new Item(R.drawable.introduction, "LIÊN HỆ", "Liên hệ chúng tôi"));


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);

        mAdatper = new AdapterRecyclerView(MainActivity.this, mArraylist);
        recyclerView.setAdapter(mAdatper);
        mAdatper.setOnItemClickListener(MainActivity.this);


//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
// Anh xa
        v_flipper = findViewById(R.id.v_flipper);
        img_open = findViewById(R.id.img_open);
        int imgs[] = {R.drawable.first_banner, R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4};
        v_flipper = (ViewFlipper) findViewById(R.id.v_flipper);
        for (int i = 0; i < imgs.length; i++) {
            flipperImages(imgs[i]);
        }
        ln1_vaytien = (LinearLayout) findViewById(R.id.ln1_tieudung);
        ln2_magiamgia = (LinearLayout) findViewById(R.id.ln2_magiamgia);
        ln3_baohiem = (LinearLayout) findViewById(R.id.ln3_baohiem);
        ln4_mothetindung = (LinearLayout) findViewById(R.id.ln4_mothetindung);
        ln5_sanvemaybay = (LinearLayout) findViewById(R.id.ln4_sanvemaybay);
        ln7_timphong = (LinearLayout) findViewById(R.id.ln7_timphongkhachsan);


        ln5_vexekhach = (LinearLayout) findViewById(R.id.ln5_timvexekhach);
        ln8_timtuaDULICH = (LinearLayout) findViewById(R.id.ln8_timtuadulich);
        ln9_timveTAU = (LinearLayout) findViewById(R.id.ln9_timvetau);
        ln10_timvieclam = (LinearLayout) findViewById(R.id.ln10_timvieclam);
//        ln11_thuexe = (LinearLayout)findViewById(R.id.ln11_thuexe);
        ln12_kiemtienonline = (LinearLayout) findViewById(R.id.ln12_kiemtienONLINE);
        ln13_dichvukhac = (LinearLayout) findViewById(R.id.ln13_dichvukhac);


        ln1_vaytien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c1 = "http://bit.ly/nganhangtindung";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });
        ln2_magiamgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = "http://bit.ly/TONGHOPMAGIAMGIA";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });
        //ln3
        ln3_baohiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = "http://bit.ly/baohiemtonghoponline";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });
        //ln4
        ln4_mothetindung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = "http://bit.ly/mothetindung";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });
        //ln5
        ln5_sanvemaybay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = "http://bit.ly/vemaybayonline";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });//ln5
        ln5_vexekhach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = "http://bit.ly/vexekhachonline";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });
        //ln6

        //ln7
        ln7_timphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = "http://bit.ly/phongkhachsanonline";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });
        //ln8
        ln8_timtuaDULICH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = "http://bit.ly/tuadulichonline";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });
        //ln9
        ln9_timveTAU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = "http://bit.ly/vetauonline";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });
        //ln10
        ln10_timvieclam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = "http://bit.ly/timvieclamonline";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });
        //ln11
//        ln11_thuexe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String c1 = "https://chungxe.vn/";
////                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
//                Intent i = new Intent(getBaseContext(), WebViewThueXe.class);
//                i.putExtra("Link",c1);
//                startActivity(i);
//            }
//        });
        //lm12
        ln12_kiemtienonline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = "http://bit.ly/KIEMTIENONLINEOKAPP";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });
        //ln13
        ln13_dichvukhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = "http://bit.ly/dichvuonline";
//                String c1 = "https://stackoverflow.com/questions/44453099/how-do-i-add-back-home-button-in-action-bar-button-for-webview-in-my-android-a";
                Intent i = new Intent(getBaseContext(), WebViewActivity.class);
                i.putExtra("Link", c1);
                startActivity(i);
            }
        });

//        OPEN TOGGLE button
        img_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawer.openDrawer(GravityCompat.START);

            }
        });
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);//4 sec
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent i = new Intent(getBaseContext(), WebViewActivity.class);
        startActivity(i);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 12) {
            Toast.makeText(this, "sended", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, " not sended", Toast.LENGTH_SHORT).show();

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_view) {

        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(getBaseContext(), IntroductionActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            String shareBody = "Tiêu đề: ";
            String shareEmail = "Ok App Download";
            i.putExtra(Intent.EXTRA_SUBJECT, shareBody);
            i.putExtra(Intent.EXTRA_SUBJECT, shareEmail);
            i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.lehuudan.drawernavigation");
            startActivity(Intent.createChooser(i, "Share Using?"));
//FACEBOOK APP
//            String urlToShare = "https://stackoverflow.com/questions/7545254";
//            Intent intent = new Intent(Intent.ACTION_SEND);
//// intent.putExtra(Intent.EXTRA_SUBJECT, "Foo bar"); // NB: has no effect!
//            intent.putExtra(Intent.EXTRA_TEXT, urlToShare);
//
//// See if official Facebook app is found
//            boolean facebookAppFound = false;
//            List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
//            for (ResolveInfo info : matches) {
//                if (info.activityInfo.packageName.toLowerCase().startsWith("com.facebook.katana")) {
//                    intent.setPackage(info.activityInfo.packageName);
//                    facebookAppFound = true;
//                    break;
//                }
//            }
//
//// As fallback, launch sharer.php in a browser
//            if (!facebookAppFound) {
//                String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + urlToShare;
//                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
//            }
//
//            startActivity(intent);

        } else if (id == R.id.nav_send) {
            String textToShare = "https://stackoverflow.com";

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, textToShare);
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.facebook.orca");
            startActivity(sendIntent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(int position) {
//        Toast.makeText(this, "position"+position, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onItemClick:" + position);
        switch (position) {
            case 0:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_vaytien;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
            case 1:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_magiamgia;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
            case 2:
                Intent i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_baohiem;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
            case 3:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_thetindung;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
            case 4:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_sanvemaybay;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
            case 5:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_sanvexekhach;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
            case 6:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_sanphongkhachsan;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
            case 7:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_tuadulich;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
            case 8:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_kiemtien;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
            case 9:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_vieclam;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
            case 10:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_dichvu;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
                case 11:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_gioithieu;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
                case 12:
                i = new Intent(MainActivity.this, WebViewActivity.class);
                strName = LINK.s_lienhe;
                i.putExtra("STRING_I_NEED", strName);
                startActivity(i);
                break;
            default:
                strName = "";
                break;
        }
    }
    public void chuyenWeb(View view) {
//        Intent i  = new Intent( MainActivity.this, WebViewCustomTab.class);startActivity(i);
    }


}
