/*
    FILE          : TripPlannerDBHelper.java
    PROGRAMMERS   : Conor Barr, Jack Parkinson, Maxim Mikheev, Rick Bloemert
    FIRST-VERSION : 2020-03-09
    DESCRIPTION   :
 */

package com.example.tripplanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class TripPlannerDBHelper extends SQLiteOpenHelper {
    public TripPlannerDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        // Create the Trip table
        database.execSQL(TripPlannerDB.CREATE_TRIP_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldDBVersion, int newDBVersion) {

    }
}
