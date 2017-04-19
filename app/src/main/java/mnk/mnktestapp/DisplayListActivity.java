package mnk.mnktestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        // retrieve the type of list to be shown
        Intent intent = getIntent();
        String listType = intent.getStringExtra(MainActivity.LIST_VALUES_TYPE);

        // set some dummy data (find the data to be displayed in the list)
        ArrayList<String> messages = new ArrayList<String>();
        messages.add("Item 1");
        messages.add("Item 2");
        messages.add("Item 3");
        messages.add("Item 4");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, messages);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
