package com.example.admin.vocabulary1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Map;

/**
 * Created by User on 13.04.2017.
 */
public class MyAdapter extends BaseAdapter {


    class ViewHolder {
        TextView WordView;
        TextView TranslateView;
    }

    Context WordContext;
    WordTranslate[] NewWords;

    public MyAdapter (Context WordContext, WordTranslate[] NewWords){
        this.WordContext=WordContext;
        this.NewWords=NewWords;
    }
    @Override
    public int getCount() {
        return NewWords.length;
    }

    @Override
    public Object getItem(int position) {
        return  NewWords[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            LayoutInflater wordinflater = (LayoutInflater) WordContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = wordinflater.inflate(R.layout.single_row,null);

            holder = new ViewHolder();
            holder.WordView = (TextView) convertView.findViewById(R.id.textView);
            holder.TranslateView = (TextView) convertView.findViewById(R.id.textView2);

            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder) convertView.getTag();
        }
        WordTranslate CurWord = (WordTranslate) getItem(position);
        holder.WordView.setText(CurWord.GetWord());
        holder.TranslateView.setText(CurWord.GetTranslate());
        return convertView;
    }
}
