package com.example.jetpack_course_1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpack_course_1.ui.theme.Jetpack_course_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_course_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    list_viewer(innerPadding)
                }
            }
        }
    }
}


 @Composable
 fun list_viewer(paddingValues: PaddingValues){
     var inp_str: String by remember { mutableStateOf("") }
     var str_list by remember { mutableStateOf(listOf<String>()) }
     Column(
         modifier = Modifier.padding(paddingValues)
             .fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         Row {
             TextField(
                 value = inp_str,
                 onValueChange = { text ->
                     inp_str = text
                 }
             )
             Button(onClick = {
                 if (inp_str.isNotBlank()){

                     str_list= str_list+ inp_str
                     inp_str= ""
                 }
             }) {
                 Text("add")
             }

         }
         LazyColumn {
             items(str_list) { item ->
                 Row {
                     Text(item)
                     Button(onClick = {
                        str_list= str_list.filter { it != item }
                     }) {
                         Text("rm")
                     }
                 }


             }
         }
     }
 }