package com.example.submisionnganu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMouse;
    private ArrayList<Mouse> list = new ArrayList<>();
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMouse = findViewById(R.id.rv_province); ///////nganu iki
        rvMouse.setHasFixedSize(true);

        list.addAll(Deskripsi.getListData());
        showCardView();
    }

    private void showCardView(){
        rvMouse.setLayoutManager(new LinearLayoutManager(this));
        GridmouseAdapter cardHeroAdapter = new GridmouseAdapter(list);
        rvMouse.setAdapter(cardHeroAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void moveProfile(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
        startActivity(intent);
    }
}
