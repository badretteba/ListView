package com.example.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListEvents extends Activity {
    ListView lvList;
    List<Evenement> evenements = new ArrayList<Evenement>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvList=(ListView) findViewById(R.id.lvList);
        remplireListEvents();
        EvenementAdapter adapter = new EvenementAdapter(evenements, this);
        lvList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(ListEvents.this,Description.class);
                it.putExtra("position",position);
                it.putParcelableArrayListExtra("evenements", (ArrayList<? extends Parcelable>) evenements);
                startActivity(it);
            }
        });
    }


    private void remplireListEvents() {
        evenements.clear();

        evenements.add(new Evenement("Festivale Musique Folclorique","sdfsdfsssssssssssssd",R.drawable.image1));
        evenements.add(new Evenement("Festivale Mawazin","sdfsssssssssssssdfsd",R.drawable.image2));
        evenements.add(new Evenement("Festivale Marrakech","sdfsssssssssdfsd",R.drawable.image3));
        evenements.add(new Evenement("Festivale D'Agadir","sdfsdsssssssssfsd",R.drawable.image4));
        evenements.add(new Evenement("Festivale de Tanger","sdfsssssssssssdfsd",R.drawable.image5));
        evenements.add(new Evenement("Festivale de Ouarzazat","sdfsssssssssdfsd",R.drawable.image6));
        evenements.add(new Evenement("Festivale d'essaouira","sdfsssssssdfsd",R.drawable.image7));
        evenements.add(new Evenement("Festivale l'Aaioune","sdfsssssssssdfsd",R.drawable.image8));



    }
}
