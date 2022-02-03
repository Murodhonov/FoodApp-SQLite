package com.example.foodappsqlite.DB

import com.example.foodappsqlite.Models.Food_Class

interface MyServiceInterface {
    fun addFood(foodClass: Food_Class)
    fun editFood(foodClass: Food_Class):Int
    fun deleteFood(foodClass: Food_Class)
    fun getAllFood():List<Food_Class>
}