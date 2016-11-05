package ir.androiddoni;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ir.androiddoni.Authentication.Login;
import ir.androiddoni.activity.AboutActivity;
import ir.androiddoni.activity.ContactActivity;
import ir.androiddoni.javaClass.Car;
import ir.androiddoni.javaClass.Personality;

public class MainActivity extends AppCompatActivity {

    AppCompatTextView txt_about;

    Toolbar toolbar;

    DrawerLayout drawer;
    NavigationView navigation_menu;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        navigation_menu = (NavigationView) findViewById(R.id.navigation_menu);
        fab=(FloatingActionButton)findViewById(R.id.fab);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(MainActivity.this,drawer,toolbar,
                R.string.open,R.string.close);

        drawer.addDrawerListener(new ActionBarDrawerToggle(MainActivity.this,drawer,toolbar,
                R.string.open,R.string.close));
        //drawer.setDrawerListener(toggle);
        toggle.syncState();



        txt_about = (AppCompatTextView) findViewById(R.id.txt_about);

        txt_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);

                startActivity(intent);

            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v,"Floating action",Snackbar.LENGTH_SHORT).show();

            }
        });

        navigation_menu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.item_exit:

                        drawer.closeDrawer(GravityCompat.START);
                       exit_dialog();

                        break;

                    case R.id.item_setting:

                        break;

                    case R.id.item_contact:

                        Intent intent=new Intent(getApplicationContext(), ContactActivity.class);
                        startActivity(intent);

                        break;

                    case R.id.item_call:

                        Intent intent_call=new Intent(Intent.ACTION_VIEW,Uri.parse("tell:02188889"));

                        break;

                    case R.id.item_login:

                        Login.sign_in(MainActivity.this);

                        break;


                }


                return false;
            }
        });


        Log.e("LifeCycle MainActivity", "OnCreate");


    }

    private void exit_dialog(){

        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this,R.style.myDialog);

        builder.setTitle(getResources().getString(R.string.exit));
        builder.setMessage(getResources().getString(R.string.exit_msg));
        builder.setIcon(android.R.drawable.ic_delete);



        builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            finish();

            }
        });

        builder.setNeutralButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });



        builder.show();

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle MainActivity", "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle MainActivity", "onDestroy");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {


            case R.id.item_about:

                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);

                break;

            case R.id.item_exit:

                finish();

                break;

            case R.id.item_call:

                //Intent intent_call=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:091222"));
                Intent intent_call = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:091222"));
                startActivity(intent_call);

                break;

        }


        return super.onOptionsItemSelected(item);
    }
}
