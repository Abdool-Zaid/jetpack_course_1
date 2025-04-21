package com.example.jetpack_course_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                    Column {
                        Print_string(
                            "string_1",
                            modifier = Modifier.padding(innerPadding)
                        )
                        Print_string(
                                "string_2"
                        )
                    }

                }
            }
        }
    }
}

@Composable // composible is a kotlin function
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpack_course_1Theme {
        Greeting("Android")
    }
}

@Composable
fun Print_string(str: String , modifier: Modifier = Modifier){
    Text(
        text= str,
        modifier= modifier,
        color = Color.Green,
        fontSize = 20.sp
    )
}