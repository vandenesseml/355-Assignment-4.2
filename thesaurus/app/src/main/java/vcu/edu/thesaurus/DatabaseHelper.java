package vcu.edu.thesaurus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Max Vandenesse on 3/21/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "thesaurus.db";
    private static final String TABLE_NAME = "thesaurus";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SEARCHTERM = "searchterm";
    private static final String COLUMN_SYNONYM = "synonym";
    private static final String COLUMN_ANTONYM = "antonym";
    SQLiteDatabase db;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static final String TABLE_CREATE = "create table thesaurus (id integer primary key not null , " +
            "searchterm text not null, synonym text not null, antonym text not null);";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public void insertThesaurusEntry(Thesaurus t){
        db = this.getWritableDatabase();
        ContentValues value = new ContentValues();

        String query = "select * from thesaurus";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        value.put(COLUMN_ID, count);
        value.put(COLUMN_SEARCHTERM,t.gettSearchTerm());
        value.put(COLUMN_SYNONYM,t.gettSynonym());
        value.put(COLUMN_ANTONYM,t.getAntonym());

        db.insert(TABLE_NAME, null, value);
        db.close();
    }
    public String searchThesaurus(String searchTerm){
        db=this.getReadableDatabase();
        String query = "select searchterm, synonym, antonym from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b,c,entry="There is no synonym/antonym pair for the word " +
                searchTerm;

        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                b=cursor.getString(1);
                c=cursor.getString(2);
                if(a.equals(searchTerm)){
                    entry="Thesaurus entry: " + searchTerm + "\nSynonym: " +
                            cursor.getString(1) + "\nAntonym: " + cursor.getString(2);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return entry;

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
