package com.example.listview;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import java.util.List;

public class Description extends AppCompatActivity {
    TextView titre;
    TextView editText;
    List<Evenement> evts;
    CallbackManager callbackManager;
    boolean isSuivant;
    boolean isPrecedant;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

         titre = findViewById(R.id.textView4);
         editText = findViewById(R.id.textView5);
        Intent i = getIntent();
        Bundle bundle = getIntent().getExtras();
       position = bundle.getInt("position");
      evts =  i.getParcelableArrayListExtra("evenements");
      refreshView();


    }

   public void refreshView(){
       titre.setText(evts.get(position).getTitre());
       editText.setText(evts.get(position).getDiscription());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.fichier :
                Toast.makeText(getApplicationContext(),"fichier",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.facebook:

                Bitmap image = BitmapFactory.decodeResource(getResources(), evts.get(position).getEventImage());

                callbackManager = CallbackManager.Factory.create();
                ShareDialog shareDialog = new ShareDialog(this);

                if (ShareDialog.canShow(SharePhotoContent.class)) {
                    SharePhoto photo = new SharePhoto.Builder()
                            .setBitmap(image) .setCaption(evts.get(position).getDiscription())
                            .build();
                    SharePhotoContent content = new SharePhotoContent.Builder()
                            .addPhoto(photo)
                            .setShareHashtag(new ShareHashtag.Builder().setHashtag(evts.get(position).getTitre())
                                    .build())
                            .build();
                    shareDialog.show(content);
                }

                return true;

            case R.id.suivant:
                if(position != evts.size()-1) {
                    this.position = position + 1;
                    refreshView();
                    isSuivant =false;
                    invalidateOptionsMenu();
                }else {
                    isSuivant =true;
                    invalidateOptionsMenu();
                }

                return true;
            case R.id.precedent:
                if(position != 0) {
                    this.position = position - 1;
                    refreshView();
                    isPrecedant =false;
                    invalidateOptionsMenu();
                }else {
                    isPrecedant =true;
                    invalidateOptionsMenu();
                }
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {
        if (isSuivant ||  position==evts.size()-1) {
           // menu.getItem(1).setEnabled(false);
            menu.findItem(R.id.suivant).setEnabled(false);
            menu.findItem(R.id.precedent).setEnabled(true);
        }else  {
            menu.findItem(R.id.suivant).setEnabled(true);

        }
        if (isPrecedant || position==0) {
            // menu.getItem(1).setEnabled(false);
            menu.findItem(R.id.precedent).setEnabled(false);
            menu.findItem(R.id.suivant).setEnabled(true);
        }else  {
            menu.findItem(R.id.precedent).setEnabled(true);
        }
        return true;
    }
}
