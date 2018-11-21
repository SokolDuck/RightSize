package com.project.user.rightsize;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Calculator {
    Result result = new Result();
    private boolean isMan;
    private Context context;
    private int buest;
    private int waist;
    private int hips;
    private int neck = 0;
    private int sizeByBuest;
    private int sizeByWaist;
    private int sizeByHips;
    private int sizeByNeck = 0;

    final static float APPLLE_MIN = 0.75;
    final static float APPLLE_MAX = 1;
    final static float HOURGLASS_MIN = 0.65;
    final static float HOURGLASS_MAX = 0.75;
    final static float PEAR_MAX = 0.65;


    public Calculator(boolean flag, Context c, int b, int w, int h, int n) {
        isMan = flag;
        context = c;
        buest = b;
        waist = w;
        hips = h;
        neck = n;
        calculate();
    }


    public Calculator(boolean flag, Context c, int b, int w, int h) {
        isMan = flag;
        context = c;
        buest = b;
        waist = w;
        hips = h;
        calculate();
    }


    public Cursor getWomanDBTable(SQLiteDatabase db) {

        String[] projection = {
                DBStorage.COLUMN_RUS_SIZE,
                DBStorage.COLUMN_USA_SIZE,
                DBStorage.COLUMN_WORLD_SIZE,

                DBStorage.COLUMN_BUEST,
                DBStorage.COLUMN_WAIST,
                DBStorage.COLUMN_HIPS,
        };

        Cursor cursor = db.query(
                DBStorage.WOMAN_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        return cursor;
    }


    public Cursor getManDBTable(SQLiteDatabase db) {

        String[] projection = {
                DBStorage.COLUMN_RUS_SIZE,
                DBStorage.COLUMN_USA_SIZE,
                DBStorage.COLUMN_WORLD_SIZE,

                DBStorage.COLUMN_BUEST,
                DBStorage.COLUMN_WAIST,
                DBStorage.COLUMN_HIPS,
                DBStorage.COLUMN_NECK,
        };

        Cursor cursor = db.query(
                DBStorage.MAN_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        return cursor;
    }


    public void calculate() {
        buest = buest / 4;
        waist = waist / 4;
        hips = hips / 4;
        neck = neck / 2;

        DBStorage dt = new DBStorage(context);
        SQLiteDatabase db = dt.getReadableDatabase();
        Cursor cursor;
        if (isMan == true) {
            cursor = getManDBTable(db);
        } else {
            cursor = getWomanDBTable(db);
        }
        int buestColumnIndex = cursor.getColumnIndex(DBStorage.COLUMN_BUEST);
        int waistColumnIndex = cursor.getColumnIndex(DBStorage.COLUMN_WAIST);
        int hipsColumnIndex = cursor.getColumnIndex(DBStorage.COLUMN_HIPS);
        int neckColumnIndex = cursor.getColumnIndex(DBStorage.COLUMN_NECK);
        int sizeColumnIndex = cursor.getColumnIndex(DBStorage.COLUMN_RUS_SIZE);
        int sizeUSAColumnIndex = cursor.getColumnIndex(DBStorage.COLUMN_USA_SIZE);
        int sizeWorldColumnIndex = cursor.getColumnIndex(DBStorage.COLUMN_WORLD_SIZE);
        while (cursor.moveToNext()) {
            if (cursor.getInt(buestColumnIndex) == buest) {
                sizeByBuest = cursor.getInt(sizeColumnIndex);
            }
            if (cursor.getInt(waistColumnIndex) == waist) {
                sizeByWaist = cursor.getInt(sizeColumnIndex);
            }
            if (cursor.getInt(hipsColumnIndex) == hips) {
                sizeByHips = cursor.getInt(sizeColumnIndex);
            }
            if (isMan) {
                if (cursor.getInt(neckColumnIndex) == neck) {
                    sizeByNeck = cursor.getInt(sizeColumnIndex);
                }
            }
        }
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            if (cursor.getInt(sizeColumnIndex) == getMax()) {
                result.rusSize = cursor.getInt(sizeColumnIndex);
                result.USASize = cursor.getInt(sizeUSAColumnIndex);
                result.worldSize = cursor.getString(sizeWorldColumnIndex);
                break;
            }
        }
        typeOfBody();
        cursor.close();
    }


    public int getMax() {
        if (sizeByBuest >= sizeByWaist && sizeByBuest >= sizeByHips && sizeByBuest >= sizeByNeck) {
            return sizeByBuest;
        }
        if (sizeByWaist >= sizeByBuest && sizeByWaist >= sizeByHips && sizeByWaist >= sizeByNeck) {
            return sizeByWaist;
        }
        if (sizeByHips >= sizeByBuest && sizeByHips >= sizeByWaist && sizeByHips >= sizeByNeck) {
            return sizeByHips;
        }
        if (sizeByNeck >= sizeByBuest && sizeByNeck >= sizeByWaist && sizeByNeck >= sizeByHips) {
            return sizeByNeck;
        }
        return 0;
    }


    public void typeOfBody() {
        float k = ((float) waist) / ((float) hips);
        if (APPLLE_MAX > k && k > APPLLE_MIN) {
            result.typeOfBody = "Яблоко";
            return;
        }
        if (HOURGLASS_MAX > k && k > HOURGLASS_MIN) {
            result.typeOfBody = "Песочные часы";
            return;
        }
        if (k < PEAR_MAX) {
            result.typeOfBody = "Груша ";
            return;
        }
    }
}
