package com.example.submisionnganu;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MouseDetailActivity extends AppCompatActivity {

    public static final String MOUSENAME = "mouse";
    public static final String PRICE = "price";
    public static final String DESKRIPSI = "description";

    private TextView tvMousename;
    private TextView tvPrice;
    private TextView tvDeskripsi;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse_detail);

        tvMousename = findViewById(R.id.tv_province_name);
        tvPrice = findViewById(R.id.tv_capital_name);
        tvDeskripsi = findViewById(R.id.tv_description);
        image = findViewById(R.id.image_province);

        tvMousename.setText(getIntent().getStringExtra(MOUSENAME));
        tvPrice.setText(getIntent().getStringExtra(PRICE));
        tvDeskripsi.setText(getIntent().getStringExtra(DESKRIPSI));
        image.setImageResource(getIntent().getIntExtra("Image", 0));

    }
}
