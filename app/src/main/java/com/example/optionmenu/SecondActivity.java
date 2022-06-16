package com.example.optionmenu;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    ImageView imageViewOne;
    Button btnBack;
    int menuItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        initListeners();
    }
    private void initViews()
    {
        imageViewOne  = findViewById(R.id.imageViewOne);
        btnBack = findViewById(R.id.btnBack);
    }
    private void initListeners()
    {
        btnBack.setOnClickListener(new BtnBackListeners());
    }
    private class BtnBackListeners implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            finish();

        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater  = getMenuInflater();
        menuInflater.inflate(R.menu.download_menu,menu);
        menu.setHeaderTitle("Context Menu Actions");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        menuItem  = item.getItemId();
        switch (menuItem)
        {
            case R.id.saveAs:
                makeToast("Save As");
                break;
            case R.id.save:
                makeToast("Save ");
                break;
            case R.id.upload:
                makeToast("Upload");
                break;
            case R.id.download:
                makeToast("download");
                break;
            case R.id.copy:
                makeToast("copy");
                break;
        }
        return super.onContextItemSelected(item);
    }
    private void makeToast(String text)
    {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
