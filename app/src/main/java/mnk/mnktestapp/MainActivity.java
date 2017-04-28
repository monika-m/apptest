package mnk.mnktestapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Set;
import java.util.SortedSet;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "mnk.mnktestapp.MESSAGE";

    /** List種類 */
    public static final String LIST_VALUES_TYPE = "mnk.mnktestapp.LIST_VALUES_TYPE";

    /** 保存先キー */
    public static final String SAVED_MESSAGES = "mnk.mnktestapp.SAVED_MESSAGES";

    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = getPreferences(Context.MODE_PRIVATE);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

        Set<String> defaultList = new android.support.v4.util.ArraySet<>();
        Set<String> savedData = sharedPref.getStringSet(SAVED_MESSAGES, defaultList);

        savedData.add(message);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet(SAVED_MESSAGES, savedData);
        editor.commit();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /**
     * 一覧画面を表示する
     * @param view
     */
    public void showAllList(View view) {
        Intent intent = new Intent(this, DisplayListActivity.class);
        Set<String> defaultList = new android.support.v4.util.ArraySet<>();
        Set<String> savedData = sharedPref.getStringSet(SAVED_MESSAGES, defaultList);
        intent.putExtra(LIST_VALUES_TYPE, savedData.toArray(new String[savedData.size()]));
        //intent.putExtra(LIST_VALUES_TYPE, savedData);
        startActivity(intent);
    }
}
