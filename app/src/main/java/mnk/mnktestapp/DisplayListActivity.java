package mnk.mnktestapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayListActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    private String[] messagesList;
    private int tappedPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        // retrieve the type of list to be shown
        Intent intent = getIntent();
        messagesList = intent.getStringArrayExtra(MainActivity.LIST_VALUES_TYPE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, messagesList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(this);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = messagesList[position];
        setPosition(position);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(item);
        alert.show();
        return true;
    }

    public void setPosition(int position) {
        tappedPosition = position;
    }

    public int getPosition() {
        return tappedPosition;
    }
}
