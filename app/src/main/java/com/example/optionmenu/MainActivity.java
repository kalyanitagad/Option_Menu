package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final int menu_settings = 1, menu_phone_settings = 2, menu_bluethooth_settings = 4, menu_display = 3;
    CheckBox enableSettings;
    int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        makeToast("onCreate - MainActivity");

    }

    private void initViews() {
        enableSettings = findViewById(R.id.enableSettings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu subMenu = menu.addSubMenu(1, menu_settings, 1, "Settings");
        subMenu.add(1, menu_phone_settings, 2, "Booking");
        subMenu.add(1, menu_display, 3, "Check Price");
        subMenu.add(1, menu_bluethooth_settings, 4, "Bluetooth");

        MenuItem menuItemHelp = menu.add(2, 5, 5, "Menu Card");
        MenuItem menuItemAbout = menu.add(3, 6, 6, "About Us");
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        itemId = item.getItemId();
        switch (itemId)
        {
            case menu_settings:
                makeToast("Settings");
                break;

            case menu_phone_settings:
                makeToast("phone settings");
                break;

            case menu_bluethooth_settings:
                makeToast("menu_bluethooth_settings");
                break;

            case menu_display:
                makeToast("menu display");
                break;

            case 5 :
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                makeToast("Menu Card");
                break;

            case 6 :
                Intent intent1  = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent1);
                makeToast ("About Us");
                break;

        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        makeToast("On prepare Options");
        menu.setGroupEnabled(1,enableSettings.isChecked());
        menu.findItem(menu_bluethooth_settings).setVisible(false);
        menu.setGroupVisible(1,true);
        return true;
    }
    
    private void makeToast(String text)
    {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}