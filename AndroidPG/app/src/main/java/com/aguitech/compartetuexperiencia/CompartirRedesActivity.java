package com.aguitech.compartetuexperiencia;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class CompartirRedesActivity extends AppCompatActivity {

    public String getNombreValue = "";
    public String getIDValue = "";
    private ImageButton btnCompartirFacebook;
    private ImageButton btnCompartirTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_compartir_redes);

        ShareLinkContent content = new ShareLinkContent.Builder().setContentUrl(Uri.parse("https://developers.facebook.com")).build();
        ShareButton shareButton = (ShareButton) findViewById(R.id.shareButton);
        shareButton.setShareContent(content);

        btnCompartirTwitter = (ImageButton) findViewById(R.id.btnCompartirTwitterURL);
        btnCompartirTwitter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //ShareLinkContent content = new ShareLinkContent.Builder().setContentUrl(Uri.parse("https://developers.facebook.com")).build();
                //ShareButton shareButton = (ShareButton)findViewById(R.id.btnCompartirFacebookURL);
                //shareButton.setShareContent(content);

                //Intent share = new Intent(Intent.ACTION_SEND);
                //share.putExtra(Intent.EXTRA_TEXT, "Here's some text for Twitter.");
                //startActivity(Intent.createChooser(share, "Share this via"));
                /*
                String tweetUrl = "https://twitter.com/intent/tweet?text=PUT TEXT HERE &url="
                        + "https://www.google.com";
                Uri uri = Uri.parse(tweetUrl);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                */
                // Create intent using ACTION_VIEW and a normal Twitter url:
                //String tweetUrl = String.format("https://twitter.com/intent/tweet?text=%sdsadsadsdsa&url=%sdsadadsadsa", urlEncode("Tweet text"), urlEncode("https://www.google.fi/"));
                String tweetUrl = String.format("https://twitter.com/intent/tweet?text=%s&url=%s", urlEncode("BePartOf"), urlEncode("https://www.emocionganar.com/"));
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl));

                // Narrow down to official Twitter app, if available:
                List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
                for (ResolveInfo info : matches) {
                    if (info.activityInfo.packageName.toLowerCase().startsWith("com.twitter")) {
                        intent.setPackage(info.activityInfo.packageName);
                    }
                }

                startActivity(intent);

            }

        });

/*
        btnCompartirTwitter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //ShareLinkContent content = new ShareLinkContent.Builder().setContentUrl(Uri.parse("https://developers.facebook.com")).build();
                //ShareButton shareButton = (ShareButton)findViewById(R.id.btnCompartirFacebookURL);
                //shareButton.setShareContent(content);

                //Intent share = new Intent(Intent.ACTION_SEND);
                //share.putExtra(Intent.EXTRA_TEXT, "Here's some text for Twitter.");
                //startActivity(Intent.createChooser(share, "Share this via"));

                String tweetUrl = "https://twitter.com/intent/tweet?text=PUT TEXT HERE &url="
                        + "https://www.google.com";
                Uri uri = Uri.parse(tweetUrl);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }

        });
        */

        //btnCompartirFacebookURL = (ImageButton) findViewById(R.id.btnCompartirFacebook);
        /**
        btnCompartirFacebook = (ImageButton) findViewById(R.id.btnCompartirFacebookURL);

        btnCompartirFacebook.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //ShareLinkContent content = new ShareLinkContent.Builder().setContentUrl(Uri.parse("https://developers.facebook.com")).build();
                //ShareButton shareButton = (ShareButton)findViewById(R.id.btnCompartirFacebookURL);
                //shareButton.setShareContent(content);
                ShareLinkContent content = new ShareLinkContent.Builder().setContentUrl(Uri.parse("https://developers.facebook.com")).build();
                ShareButton shareButton = (ShareButton) findViewById(R.id.shareButton);
                shareButton.setShareContent(content);
            }

        });
        */



/**
        btnCompartirFacebook.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ShareLinkContent content = new ShareLinkContent.Builder().setContentUrl(Uri.parse("https://developers.facebook.com")).build();
                //ShareButton shareButton = (ShareButton)findViewById(R.id.btnCompartirFacebookURL);
                //shareButton.setShareContent(content);

            }

        });
        */

                /*
                ShareButton shareButton = (ShareButton)findViewById(R.id.fb_share_button);
                shareButton.setShareContent(content);

                Intent i = new Intent();
                i.putExtra("Nombre", "Mi nombre es Hector");
                //i.setClass(MainActivity.this, PantallaActivity.class);
                //i.setClass(MainActivity.this, RegistroActivity.class);
                i.setClass(LoginActivity.this, RegistroActivity.class);
                startActivity(i);*/





        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            //String getNombreValue =(String) b.get("Nombre");
            getNombreValue =(String) b.get("Nombre");
            //Textv.setText(j);
            Toast.makeText(getApplicationContext(), getNombreValue, Toast.LENGTH_SHORT).show();
            //String getIDValue =(String) b.get("ID");
            getIDValue =(String) b.get("ID");

            Toast.makeText(getApplicationContext(), getIDValue, Toast.LENGTH_SHORT).show();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }
    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            //Log.wtf(TAG, "UTF-8 should always be supported", e);
            throw new RuntimeException("URLEncoder.encode() failed for " + s);
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            //i.setClass(MainActivity.this, PantallaActivity.class);
            //i.setClass(MainActivity.this, RegistroActivity.class);
            i.setClass(CompartirRedesActivity.this, MenuPrincipalActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_blog) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(CompartirRedesActivity.this, BlogActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_eventos) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(CompartirRedesActivity.this, EventosActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_trivias) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(CompartirRedesActivity.this, TriviasActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_ganadores) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(CompartirRedesActivity.this, GanadoresActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_como_participar) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(CompartirRedesActivity.this, ComoParticiparActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_terminos_condiciones) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(CompartirRedesActivity.this, TerminosCondicionesActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_aviso_privacidad) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            //i.setClass(EventosActivity.this, AvisoPrivacidadActivity.class);
            i.setClass(CompartirRedesActivity.this, WebviewActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_contacto) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(CompartirRedesActivity.this, ContactoActivity.class);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

}
