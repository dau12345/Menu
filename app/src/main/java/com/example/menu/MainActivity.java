package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent i;

    private ImageButton popupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_context = findViewById(R.id.tv_context);
        registerForContextMenu(tv_context);

        popupBtn = (ImageButton) findViewById(R.id.popupBtn);
        popupBtn.setOnClickListener(this);

        i = new Intent(getApplicationContext(), SecondActivity.class);
    }

    //Popup menu

    @Override
    public void onClick(View view) {
        PopupMenu pop = new PopupMenu(MainActivity.this, popupBtn);
        pop.getMenuInflater().inflate(R.menu.popup_menu, pop.getMenu());
        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.one:
                        i.putExtra("item", "One");
                        startActivity(i);
                        return true;
                    case R.id.two:
                        i.putExtra("item", "Two");
                        startActivity(i);
                        return true;
                    default:
                        return false;
                }
            }
        });
        pop.show();
    }

    //Context menu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit:
                i.putExtra("item", "edit");
                startActivity(i);
                return true;
            case R.id.share:
                i.putExtra("item", "share");
                startActivity(i);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    //Options menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                i.putExtra("item", "settings");
                startActivity(i);
                return true;
            case R.id.favorites:
                i.putExtra("item", "favorites");
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}