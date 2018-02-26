package xyz.dnglabs.onlysql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xyz.dnglabs.onlysql.data.HabitContract;
import xyz.dnglabs.onlysql.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {
    private HabitDbHelper mDbHelper = new HabitDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertHabit();
        queryHabit();
    }

    private void insertHabit() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_integer, 42);
        values.put(HabitContract.HabitEntry.COLUMN_String, "nothing");
        db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
    }

    private Cursor queryHabit(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] toRead = {HabitContract.HabitEntry.COLUMN_String};
        Cursor resultsDB = db.query(
                HabitContract.HabitEntry.TABLE_NAME, toRead, null, null, null, null, null);
        return resultsDB;
    }
}
