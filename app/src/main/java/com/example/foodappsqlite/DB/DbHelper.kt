package com.example.foodappsqlite.DB

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.foodappsqlite.DB.Constants.DB_NAME
import com.example.foodappsqlite.DB.Constants.DB_VERSION
import com.example.foodappsqlite.DB.Constants.DESCRIPTION
import com.example.foodappsqlite.DB.Constants.ID
import com.example.foodappsqlite.DB.Constants.NAME
import com.example.foodappsqlite.DB.Constants.RECIPE
import com.example.foodappsqlite.DB.Constants.TABLE_NAME
import com.example.foodappsqlite.Models.Food_Class

class DbHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION),
    MyServiceInterface {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE $TABLE_NAME ($ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,$NAME TEXT NOT NULL, $RECIPE TEXT NOT NULL, $DESCRIPTION TEXT NOT NULL)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    override fun addFood(foodClass: Food_Class) {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(NAME, foodClass.food_name)
        cv.put(RECIPE, foodClass.food_recipes)
        cv.put(DESCRIPTION, foodClass.food_description)

        db.insert(TABLE_NAME, null, cv)
        db.close()
    }

    override fun editFood(foodClass: Food_Class): Int {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(ID,foodClass.food_id)
        cv.put(NAME,foodClass.food_name)
        cv.put(RECIPE,foodClass.food_recipes)
        cv.put(DESCRIPTION,foodClass.food_description)

        return db.update(TABLE_NAME,cv,"$ID = ?", arrayOf(foodClass.food_id.toString()))
    }

    override fun deleteFood(foodClass: Food_Class) {
        val db = this.writableDatabase

        db.delete(TABLE_NAME, "$ID = ?", arrayOf(foodClass.food_id.toString()))

        db.close()
    }

    @SuppressLint("Recycle")
    override fun getAllFood(): List<Food_Class> {
        val db = this.readableDatabase
        val list = ArrayList<Food_Class>()
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val recipe = cursor.getString(2)
                val description = cursor.getString(3)
                list.add(Food_Class(id,name,recipe,description))
            }while (cursor.moveToNext())
        }
        return list
    }

}