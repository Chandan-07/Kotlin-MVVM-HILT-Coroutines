package com.example.codewithcb.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class CharacterDetailsActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposable()
        }
    }
    @Composable
    fun MyComposable() {
        Column {
            Text("Hello")
            Text("World")
        }
    }

}