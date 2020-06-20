package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Tramvai> tramvai = new ArrayList<>();
    public RecyclerView recyclerView;
    private CustomAdapter adapter;
    private Tramvai selectedTramvai;

    private static final int REQUEST_CODE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler);

        tramvai.add(new Tramvai("7", "12:50", "30", "20"));
        tramvai.add(new Tramvai("17", "13:50", "40", "30"));
        tramvai.add(new Tramvai("16", "14:50", "30", "10"));
        tramvai.add(new Tramvai("46", "15:50", "40", "15"));
        tramvai.add(new Tramvai("69", "16:50", "50", "16"));

        adapter = new CustomAdapter(tramvai);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setClickListener(new CustomAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedTramvai = tramvai.get(position);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("number", selectedTramvai.getNumber());
                intent.putExtra("hour", selectedTramvai.getHour());
                intent.putExtra("positions", selectedTramvai.getPositions());
                intent.putExtra("taken_positions", selectedTramvai.getTaken_positions());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }
}