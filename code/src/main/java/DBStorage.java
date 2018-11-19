package com.project.user.rightsize;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBStorage extends SQLiteOpenHelper {
    public final static String WOMAN_TABLE_NAME = "WOMAN_SIZE";
    public final static String MAN_TABLE_NAME = "MAN_SIZE";

    public final static String COLUMN_RUS_SIZE = "rus_size";
    public final static String DATABASE_NAME = "SIZES";
    public final static String COLUMN_USA_SIZE = "usa_size";
    public final static String COLUMN_WORLD_SIZE = "world_size";
    public final static String COLUMN_HIPS = "hips";
    public final static String COLUMN_WAIST = "waist";
    public final static String COLUMN_BUEST = "buest";
    public final static String COLUMN_NECK = "neck";

    private static final int DATABASE_VERSION = 1;

    public DBStorage(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Строка для создания таблицы
        String SQL_CREATE_GUESTS_TABLE_1 = "CREATE TABLE " + DBStorage.WOMAN_TABLE_NAME + " ("
                + DBStorage.COLUMN_RUS_SIZE + " INTEGER PRIMARY KEY, "
                + DBStorage.COLUMN_USA_SIZE + " INTEGER NOT NULL, "
                + DBStorage.COLUMN_WORLD_SIZE + " TEXT NOT NULL, "
                + DBStorage.COLUMN_BUEST + " INTEGER NOT NULL , "
                + DBStorage.COLUMN_WAIST + " INTEGER NOT NULL , "
                + DBStorage.COLUMN_HIPS + " INTEGER NOT NULL );";

        // Запускаем создание таблицы
        db.execSQL(SQL_CREATE_GUESTS_TABLE_1);

        // Строка для создания таблицы
        String SQL_CREATE_GUESTS_TABLE_2 = "CREATE TABLE " + DBStorage.MAN_TABLE_NAME + " ("
                + DBStorage.COLUMN_RUS_SIZE + " INTEGER PRIMARY KEY, "
                + DBStorage.COLUMN_USA_SIZE + " INTEGER NOT NULL, "
                + DBStorage.COLUMN_WORLD_SIZE + " TEXT NOT NULL, "
                + DBStorage.COLUMN_BUEST + " INTEGER NOT NULL , "
                + DBStorage.COLUMN_WAIST + " INTEGER NOT NULL , "
                + DBStorage.COLUMN_HIPS + " INTEGER NOT NULL , "
                + DBStorage.COLUMN_NECK + " INTEGER NOT NULL );";

        // Запускаем создание таблицы
        db.execSQL(SQL_CREATE_GUESTS_TABLE_2);
        newWomanRaw(db, 42, 8, "XXS", 21, 14, 22);
        newWomanRaw(db, 44, 10, "XS", 22, 15, 23);
        newWomanRaw(db, 46, 12, "S", 23, 16, 24);
        newWomanRaw(db, 48, 14, "M", 24, 17, 25);
        newWomanRaw(db, 50, 16, "L", 25, 18, 26);
        newWomanRaw(db, 52, 18, "XL", 26, 19, 27);
        newWomanRaw(db, 54, 20, "XXL", 27, 20, 28);
        newWomanRaw(db, 56, 22, "3XL", 28, 21, 29);
        newWomanRaw(db, 58, 24, "4XL", 29, 22, 30);

        newManRaw(db, 46, 12, "S", 23, 19, 21, 19);
        newManRaw(db, 48, 14, "M", 24, 20, 22, 19);
        newManRaw(db, 50, 16, "L", 25, 21, 23, 20);
        newManRaw(db, 52, 18, "XL", 26, 22, 24, 21);
        newManRaw(db, 54, 20, "XXL", 27, 23, 25, 22);
        newManRaw(db, 56, 22, "3XL", 28, 24, 26, 23);
        newManRaw(db, 58, 24, "4XL", 29, 25, 27, 24);
        newManRaw(db, 60, 26, "5XL", 30, 26, 28, 25);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void newWomanRaw(SQLiteDatabase db, int rus_size, int usa_size, String world_size, int buest, int waist, int hips) {
        ContentValues values = new ContentValues();
        values.put(DBStorage.COLUMN_RUS_SIZE, rus_size);
        values.put(DBStorage.COLUMN_USA_SIZE, usa_size);
        values.put(DBStorage.COLUMN_WORLD_SIZE, world_size);
        values.put(DBStorage.COLUMN_BUEST, buest);
        values.put(DBStorage.COLUMN_WAIST, waist);
        values.put(DBStorage.COLUMN_HIPS, hips);
        db.insert(DBStorage.WOMAN_TABLE_NAME, null, values);
    }

    public void newManRaw(SQLiteDatabase db, int rus_size, int usa_size, String world_size, int buest, int waist, int hips, int neck) {
        ContentValues values = new ContentValues();
        values.put(DBStorage.COLUMN_RUS_SIZE, rus_size);
        values.put(DBStorage.COLUMN_USA_SIZE, usa_size);
        values.put(DBStorage.COLUMN_WORLD_SIZE, world_size);
        values.put(DBStorage.COLUMN_BUEST, buest);
        values.put(DBStorage.COLUMN_WAIST, waist);
        values.put(DBStorage.COLUMN_HIPS, hips);
        values.put(DBStorage.COLUMN_NECK, neck);
        db.insert(DBStorage.MAN_TABLE_NAME, null, values);
    }
}

