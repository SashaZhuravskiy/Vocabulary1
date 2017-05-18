package com.example.admin.vocabulary1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.admin.vocabulary1.DatabaseMyHelper.TABLE_VOCABULARY;

public class Test extends AppCompatActivity implements View.OnClickListener {

    TextView TV,TV4;
    WordTranslate[] NewWords;
    Button btCheck;
    EditText edText;
    int i;

    final Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        DatabaseMyHelper dbHelper= new DatabaseMyHelper(this);
        final SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.query(TABLE_VOCABULARY, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(dbHelper.KEY_ID);
            int wordIndex = cursor.getColumnIndex(dbHelper.KEY_WORD);
            int translateIndex = cursor.getColumnIndex(dbHelper.KEY_TRANSLATE);
            NewWords = new WordTranslate[cursor.getCount()];
            int i=0;
            do {
                NewWords[i]= new WordTranslate (cursor.getString(wordIndex),cursor.getString(translateIndex), cursor.getInt(idIndex));
                i++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        TV= (TextView)findViewById(R.id.textView3);
        TV4= (TextView)findViewById(R.id.textView4);

        btCheck = (Button)findViewById(R.id.button4);
        btCheck.setOnClickListener(this);

        edText = (EditText) findViewById(R.id.editText);

        i=random.nextInt(NewWords.length);
        TV.setText(NewWords[i].GetWord());}


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button4:
                //if( edText.getText().equals(NewWords[i].GetWord())) {
                Toast.makeText(this,NewWords[i].GetWord()+ " - "+ edText.getText(),Toast.LENGTH_SHORT).show();
                if( NewWords[i].GetTranslate().contentEquals(edText.getText())) {
                    TV4.setTextColor(Color.GREEN);
                    TV4.setText("ВЕРНО");
                }
                else {
                    TV4.setTextColor(Color.RED);
                    TV4.setText("НЕВЕРНО");
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        TV4.setText("");
                        edText.setText("");
                        i=random.nextInt(NewWords.length);
                        TV.setText(NewWords[i].GetWord());
                    }
                }, 1500);
                break;
        }
    }
}
