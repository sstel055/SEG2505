package com.example.firebase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends ArrayAdapter<Item> {
    private Activity context;
    List<Item> products;
    public ItemListAdapter(Activity context, List<Item> items) {
        super(context, R.layout.listbtn, items);
        this.context = context;
        products = items;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listviewitem = inflater.inflate(R.layout.listbtn, null, true);

        TextView name = (TextView)listviewitem.findViewById(R.id.name);
        TextView price = (TextView)listviewitem.findViewById(R.id.price);
        name.setText(products.get(position).name);
        price.setHint(products.get(position).price);

        return listviewitem;
    }
}
