package xyz.dnglabs.onlysql.data;

import android.provider.BaseColumns;

public class HabitContract {

    private HabitContract() {}

    public static final class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "habit";
        public final static String COLUMN_String ="string";
        public final static String COLUMN_integer = "integer";
    }
}
