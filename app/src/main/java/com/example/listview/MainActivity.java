package com.example.listview;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galery);
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(
                    "com.example.listview",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
        }} catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }catch (NoSuchAlgorithmException e) {

        }


       Gallery gallery = (Gallery) findViewById(R.id.gallery1); // get the reference of Gallery
      final GalleryImageAdapter galleryImageAdapter= new GalleryImageAdapter(this);
        gallery.setAdapter(galleryImageAdapter);

        gallery.setSpacing(10);
        // perform setOnItemClickListener event on the Gallery
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set the selected image in the ImageView
                //selectedImageView.setImageResource(images[position]);
               switch(position){
                   case 0:
                       Intent it = new Intent(MainActivity.this,ListEvents.class);
                       startActivity(it);


               }
            }
        });
    }


}