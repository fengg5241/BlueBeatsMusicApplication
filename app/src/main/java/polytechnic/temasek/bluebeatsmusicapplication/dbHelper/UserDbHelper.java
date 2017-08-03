package polytechnic.temasek.bluebeatsmusicapplication.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by feng on 03/08/17.
 */

public class UserDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "zhongweiMusic.db";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /* Inner class that defines the table contents */
    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                    UserEntry._ID + " INTEGER PRIMARY KEY," +
                    UserEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    UserEntry.COLUMN_NAME_PASSWORD + TEXT_TYPE + " )";


    private static final String SQL_QUERY_EXIST_ENTRIES =
            "SELECT * FROM " + UserEntry.TABLE_NAME + " WHERE " +
                    UserEntry.COLUMN_NAME_NAME + "= ? ";

    private static final String SQL_VALIDATE_USER_ENTRIES =
            "SELECT * FROM " + UserEntry.TABLE_NAME + " WHERE " +
                    UserEntry.COLUMN_NAME_NAME + "= ? and " +
                    UserEntry.COLUMN_NAME_PASSWORD + "= ? ";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean isExistUser(String name){
        Cursor cursor = this.getReadableDatabase().rawQuery(SQL_QUERY_EXIST_ENTRIES,
                new String[]{name});
        return cursor.getCount() > 0;
    }

    public boolean validateUser(String name, String password){
        Cursor cursor = this.getReadableDatabase().rawQuery(SQL_VALIDATE_USER_ENTRIES,
                new String[]{name,password});
        return cursor.getCount() > 0;
    }

    public void createUser(String name, String password){
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(UserEntry.COLUMN_NAME_NAME, name);
        values.put(UserEntry.COLUMN_NAME_PASSWORD, password);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = this.getWritableDatabase().insert(UserEntry.TABLE_NAME, null, values);
        return;
    }
}
