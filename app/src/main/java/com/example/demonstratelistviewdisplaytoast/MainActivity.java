package com.example.demonstratelistviewdisplaytoast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView fruitView;
    String[] fruits = new String[]
            {
                    "Mango",
                    "Orange",
                    "Guava",
                    "Banana",
                    "Pineapple",
                    "Apple"
            };
    List<String> fruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fruitView = (ListView) findViewById(R.id.listViewID);
        fruitList = new ArrayList<String>(Arrays.asList(fruits));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, fruitList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView ListItemShow = (TextView) view.findViewById(android.R.id.text1);
                ListItemShow.setTextColor(Color.parseColor("#ffffff"));
                return view;
            }
        };
        fruitView.setAdapter(adapter);
        fruitView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "clicked item is " + fruits[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}