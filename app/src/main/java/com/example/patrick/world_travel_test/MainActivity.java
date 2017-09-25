package com.example.patrick.world_travel_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CountryListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = (ListView)findViewById(R.id.listView);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);

        Country afghanistan = new Country("drawable://"+ R.drawable.af, "Afghanistan","Asien");
        Country aegypten = new Country("drawable://"+ R.drawable.eg,"Ägypten","Afrika");
        Country albanien = new Country("drawable://"+ R.drawable.al,"Albanien","Europa");
        Country algerien = new Country("drawable://"+ R.drawable.dz,"Algerien","Afrika");
        Country andorra = new Country("drawable://"+ R.drawable.ad,"Andorra","Europa");

        ArrayList<Country> countryList = new ArrayList<>();

        countryList.add(afghanistan);
        countryList.add(aegypten);
        countryList.add(albanien);
        countryList.add(algerien);
        countryList.add(andorra);

        adapter = new CountryListAdapter(this, R.layout.adapter_view_layout, countryList);
        mListView.setAdapter(adapter);

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (MainActivity.this).adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable e) {

            }
        });

    }
}


