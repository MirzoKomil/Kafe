package uz.mirzakomil.kafekotlin.model

import android.widget.Button

data class FoodDescription(
    var name: String,
    var cost: String,
    var button: Button?
)
