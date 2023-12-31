package com.example.sharemymeals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sharemymeals.navigation.HomeAppBar
import com.example.sharemymeals.navigation.Screens
import com.example.sharemymeals.ui.theme.ShareMyMealsTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShareMyMealsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }



    }


}




@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    val user = remember { loggedUser }

    var username = user!!.username
    var name = user!!.name
    var swipeCount = user!!.swipeCount
    var pointsCount = user!!.pointsCount
    HomeAppBar(titleText = "Home", navController = navController)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = name, style = TextStyle(fontSize = 30.sp))
        Text(text = username)

        Box() {
            Row() {
                Text(text = "Swipes: $swipeCount", modifier = Modifier.padding(16.dp))
                Text(text = "Points: $pointsCount", modifier = Modifier.padding(16.dp))
            }
        }

        Button(onClick = { navController.navigate(Screens.Swipes.route) }) {
            Text(text = "Share Swipes")
        }

        Button(onClick = { navController.navigate(Screens.Points.route) }) {
            Text(text = "Share Points")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomePreview(){
    ShareMyMealsTheme {
       // HomeScreen()
    }
}