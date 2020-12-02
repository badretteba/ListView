package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EvenementAdapter extends BaseAdapter {
List<Evenement> events;
LayoutInflater inflater;

    public EvenementAdapter(List<Evenement> events, Context context) {
        this.events = events;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
private class ViewHolder {
        TextView tvTitre;
        TextView tvDiscription;
        ImageView eventImage;
}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView=inflater.inflate(R.layout.itemlivre,null);
            holder.tvTitre=(TextView) convertView.findViewById(R.id.textView);
            holder.tvDiscription=(TextView) convertView.findViewById(R.id.textView2);
            holder.eventImage=(ImageView) convertView.findViewById(R.id.listview_images);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitre.setText(events.get(position).getTitre());
        holder.tvDiscription.setText(events.get(position).getDiscription());
        holder.eventImage.setImageResource(events.get(position).getEventImage());
        return convertView;
    }
}
