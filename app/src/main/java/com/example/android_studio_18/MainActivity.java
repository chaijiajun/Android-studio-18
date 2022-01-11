package com.example.android_studio_18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public String[]list_item = {"item 1","item 2","item 3","item 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt_ItemSelect = findViewById(R.id.tv_select);
        ListView list =  findViewById(R.id.list);

        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("item", list_item[i]);
            arrayList.add(hashMap);
        }

        String[] form = {"item"};
        int value[] = {R.id.tv_listview};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                arrayList,
                R.layout.list,
                form,
                value
        );

        list.setAdapter(simpleAdapter); //將設定好的 simpleAdapter 丟進 ListView

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txt_ItemSelect.setText("你選擇了:"+list_item[i]);
            }
        });


    };
}