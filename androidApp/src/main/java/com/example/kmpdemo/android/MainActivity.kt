package com.example.kmpdemo.android

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmpdemo.Greeting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    GreetingView(Greeting().greet())
//                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column (modifier = Modifier.fillMaxHeight()){
                        val scope = rememberCoroutineScope()
                        var text by remember { mutableStateOf("") }

                        val handleGetApiClick: () -> Unit = {
                            scope.launch(Dispatchers.IO) {
                                runCatching {
//                                    val data = viewModel.getRemoteSource(applicationContext).get("launches")
//                                    val data = viewModel.getRemoteSource(applicationContext).get("todos")
//                                    text = data
                                }.onFailure {
                                    Log.e("--x-x--x-x----", it.toString())
                                }
                            }
                        }

                        val handlePostApiClick: () -> Unit = {
                            Toast.makeText(applicationContext,"Sign up clicked", Toast.LENGTH_SHORT).show()
                            scope.launch(Dispatchers.IO) {
                                runCatching {
                                    val data = viewModel.callPostApi("posts")
//                                    val data = viewModel.postToRemoteSource(applicationContext).post("posts",PostBody("foo","bar",1))
                                    text = "kuch bhi ka data"

                                }.onFailure {
                                    Log.e("--x-x--x-x----", it.toString())
                                }
                            }
                        }
                        Column {
                            ClickableText(
                                text = AnnotatedString("Get API"),
                                onClick = {
                                    text = "Loading..."
                                    handleGetApiClick()
                                }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            ClickableText(
                                text = AnnotatedString("Post API"),
                                onClick = {
                                    text = "Loading..."
                                    handlePostApiClick()
                                }
                            )
                        }

                        /*LaunchedEffect(true) {
                            scope.launch(Dispatchers.IO) {
                                runCatching {
                                    val data = viewModel.getRemoteSource(applicationContext).get("todos")
                                    text = data
                                }.onFailure {
                                    android.util.Log.e("--x-x--x-x----", it.toString())
                                }
                            }
                        }*/
                        Spacer(modifier = Modifier.height(16.dp))
//                        Greeting(text)
                    }

                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
