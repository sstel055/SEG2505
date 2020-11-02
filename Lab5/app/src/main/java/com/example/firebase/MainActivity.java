package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseReference ref;
    AlertDialog builder;
    EditText editName;
    EditText editPrice;
    String itemName;
    ListView list;
    ArrayList<Item> items;
    ItemListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        editName = (EditText)findViewById(R.id.txtName);
        editPrice = (EditText)findViewById(R.id.txtPrice);

        items = new ArrayList<>();
        adapter = new ItemListAdapter(MainActivity.this, items);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView name = (TextView)view.findViewById(R.id.name);
                itemName = name.getText().toString();
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setView(R.layout.dialogue);
                dialog.setTitle(name.getText());
                builder = dialog.create();
                builder.show();
            }
        });
        //Adds to list from database
        ref = FirebaseDatabase.getInstance().getReference();


    }
    @Override
    protected void onStart() {
        super.onStart();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                items.clear();
                for(DataSnapshot child: snapshot.getChildren()){
                    //Creates layout to add to list
                    Item product = new Item(child.child("name").getValue().toString(), child.child("price").getValue().toString());
                    items.add(product);
                }
                list.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void Add(View view) {
        String s1 = editName.getText().toString();
        String s2 = editPrice.getText().toString();
        Item it = new Item(s1, s2);
        if(!TextUtils.isEmpty(s1)){
            Item newItem = new Item(s1, s2);
            ref.child(s1).setValue(it);
            editName.setText("");
            editPrice.setText("");
        }
    }

    public void Update(View view) {
        EditText nom = (EditText)builder.findViewById(R.id.editName);
        EditText prix = (EditText)builder.findViewById(R.id.editPrice);
        String s1 = nom.getText().toString();
        String s2 = prix.getText().toString();
        ref.child(itemName).removeValue();
        ref.child(s1).setValue(new Item(s1, s2));
        builder.dismiss();
    }

    public void Delete(View view) {
        ref.child(itemName).removeValue();
        builder.dismiss();
    }
}