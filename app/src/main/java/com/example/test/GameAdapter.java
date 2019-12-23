package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class GameAdapter extends BaseAdapter {
    Context MyContext;
    int count;
    List<Integer> colors;

    public GameAdapter(Context _MyContext, int _count, List<Integer> _colors) {
        MyContext = _MyContext;
        count = _count;
        colors = _colors;
    }

    @Override
    public int getCount() {
        return count;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("getView " + position);
        View v = convertView;

        if(convertView == null) {
            v = LayoutInflater.from(MyContext).inflate(R.layout.grid_item, parent, false);
            v.setBackgroundColor(colors.get(position));
        }
        return v;

    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }
}
