package bit.dail3.city_country_sql;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by dailifeng on 16/4/7.
 */
public class CityCountrySQL {

    private SQLiteDatabase database;

    public CityCountrySQL(Activity main)
    {
        database = main.openOrCreateDatabase("Cities", Context.MODE_PRIVATE, null);
        CreateTable();
        InsertIntoTable("Amsterdam", "The Netherlands");
        InsertIntoTable("Berlin", "Germany");
        InsertIntoTable("Cairo", "Egypt");
        InsertIntoTable("Dunedin", "New Zealand");
        InsertIntoTable("Edmonton", "Canada");
        InsertIntoTable("Florence", "Italian");
        InsertIntoTable("Grenoble", "France");
        InsertIntoTable("Hamburg", "Germany");
        InsertIntoTable("Istanbul", "Turkey");
        InsertIntoTable("Johannesburg", "South Africa");
        InsertIntoTable("Kyoto", "Japan");
        InsertIntoTable("London", "England");
        InsertIntoTable("Montreal", "Canada");
        InsertIntoTable("New York", "USA");
    }

    private void CreateTable()
    {
        String deleteTable = "DROP TABLE IF EXISTS tblCities;";
        database.execSQL(deleteTable);

        String query = "CREATE TABLE IF NOT EXISTS tblCities(" +
                       "cityID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                       "cityName TEXT NOT NULL, "+
                       "countryName TEXT NOT NULL);";
        database.execSQL(query);
    }

    private void InsertIntoTable(String city, String country)
    {
        String query = "INSERT INTO tblCities VALUES(null, '" + city + "', " + "'" + country + "')";
        database.execSQL(query);
    }

    public ArrayList<String> SearchData(String country)
    {
        ArrayList<String> result = new ArrayList<String>();
        String select = "SELECT * FROM tblCities";
        Cursor cursor = database.rawQuery(select, null);

        int count = cursor.getCount();

        int cityNameIndex = cursor.getColumnIndex("cityName");
        int countryNameIndex = cursor.getColumnIndex("countryName");

        cursor.moveToFirst();

        for (int i = 0; i < count; i++)
        {
            if(cursor.getString(countryNameIndex).equals(country))
            {
                result.add(cursor.getString(cityNameIndex));
            }
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }

    public ArrayList<String> getAllCountry()
    {
        ArrayList<String> result = new ArrayList<String>();
        String select = "SELECT countryName FROM tblCities";
        Cursor cursor = database.rawQuery(select, null);

        int count = cursor.getCount();

        int countryNameIndex = cursor.getColumnIndex("countryName");
        cursor.moveToFirst();

        for (int i = 0; i < count; i++)
        {
            result.add(cursor.getString(countryNameIndex));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }
}
