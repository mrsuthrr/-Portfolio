package com.example.myapplication

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StateManagement() {
    var username = ""

    var state = remember {
        mutableStateOf("")
    }
    Log.d("TAG", "StateManagement: ${state}" )

    TextField(value = state.value , onValueChange = {
        state.value = it
    } )
}