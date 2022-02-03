package com.example.foodappsqlite.Models

class Food_Class {

    var food_id = 0

    var food_name = ""

    var food_recipes = ""

    var food_description = ""

    constructor()

    constructor(food_name: String, food_recipes: String, food_description: String) {
        this.food_name = food_name
        this.food_recipes = food_recipes
        this.food_description = food_description
    }

    constructor(food_id: Int, food_name: String, food_recipes: String, food_description: String) {
        this.food_id = food_id
        this.food_name = food_name
        this.food_recipes = food_recipes
        this.food_description = food_description
    }

}