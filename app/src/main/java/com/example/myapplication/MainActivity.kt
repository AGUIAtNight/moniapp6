package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

data class Message(val author: String, val body: String)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
//                    MessageCard(Message("Android", "Jetpack Compose"))
                    AffirmationList(affirmationList =
                    Datasource().loadAffirmations())
                }
            }
        }
    }
}
//
//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyApplicationTheme {
//        Greeting("Android")
//    }
//}
//

@Composable
fun MessageCard(msg: com.example.myapplication.Message,
                modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp), elevation = 4.dp){
    Column {
        Text(text = msg.author)
        Text(text = msg.body)
    }}
}

//@Composable
//fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
//    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
//        Column {
//            Image(
//                painter = painterResource(affirmation.imageResourceId),
//                contentDescription = stringResource(affirmation.stringResourceId),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(194.dp),
//                contentScale = ContentScale.Crop
//            )
//            Text(
//                text = stringResource(affirmation.stringResourceId),
//                modifier = Modifier.padding(16.dp),
//                style = MaterialTheme.typography.h6
//            )
//        }
//    }
//}

@Composable
private fun AffirmationList(affirmationList: List<Message>,
                            modifier: Modifier = Modifier) {
    LazyColumn {
        items(affirmationList){ msg ->
            MessageCard(msg)
        }
}}




//@Preview
//@Composable
//fun PreviewMessageCard() {
//    MessageCard(
//        msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
//    )
//}