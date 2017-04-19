package mnk.mnktestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "mnk.mnktestapp.MESSAGE";

    /** List種類 */
    public static final String LIST_VALUES_TYPE = "mnk.mnktestapp.LIST_VALUES_TYPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /**
     * 一覧画面を表示する
     * @param view
     */
    public void showAllList(View view) {
        Intent intent = new Intent(this, DisplayListActivity.class);
        intent.putExtra(LIST_VALUES_TYPE, "messages");
        startActivity(intent);
    }
}
