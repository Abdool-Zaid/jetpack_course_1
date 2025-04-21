package com.example.jetpack_course_1

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpack_course_1Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            list_viewer(innerPadding)
        }
    }
}
 @Composable
 fun list_viewer(paddingValues: PaddingValues){
     var inp_str: String by remember { mutableStateOf("") }
     var str_list by remember { mutableStateOf(listOf<String>("asdasd", "tertert", "sfsdfe", "24342")) } // added values for testing
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
                 },
                 modifier = Modifier
                     

             )
             Button(onClick = {
                 if (inp_str.isNotBlank()){

                     str_list= str_list+ inp_str
                     inp_str= ""
                 }

             },

             ) {
                 Text("add",
                     modifier = Modifier.alpha(1.0f))
             }

         }
         LazyColumn() {
             items(str_list) { item ->
                 Row (
                     modifier = Modifier.fillMaxWidth()
                         ,
                     verticalAlignment = Alignment.CenterVertically,
                     horizontalArrangement = Arrangement.Start
                 ){
                     Text(item)
                     Button(onClick = {
                        str_list= str_list.filter { it != item }
                     },


                     ) {
                         Icon(imageVector = Icons.Default.Clear,
                             contentDescription = "remove item button",

                           )
                     }
                 }


             }
         }
     }
 }