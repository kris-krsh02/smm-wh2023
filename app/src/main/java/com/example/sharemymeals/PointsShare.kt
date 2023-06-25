package com.example.sharemymeals

import android.content.IntentSender
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sharemymeals.data.User
import com.example.sharemymeals.navigation.PageAppBar
import com.example.sharemymeals.navigation.Screens
import com.example.sharemymeals.ui.theme.ShareMyMealsTheme
import kotlinx.coroutines.launch

class PointsShare : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShareMyMealsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //PointsScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PointsScreen(modifier: Modifier = Modifier, navController: NavController) {

    val userSend = remember { loggedUser }
    val snackbarHostState = remember { SnackbarHostState() }

    PageAppBar(titleText = "Share Points", navController = navController)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Share Points",
            style = TextStyle(fontSize = 30.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        var username by remember {mutableStateOf("") }
        var numPoints by remember { mutableStateOf("") }

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username")},
            modifier = Modifier.padding(1.dp))


        OutlinedTextField(
            value = numPoints,
            onValueChange = { numPoints = it },
            label = { Text("Number of Points")},
            modifier = Modifier.padding(16.dp))


        val coroutineScope = rememberCoroutineScope()
        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally))
        {
            Button(

                onClick = {
                    val user = userData.getUserByUsername(username)

                    if (user != null) {
                        val message = "Transaction successful!"
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(message)
                        }
                    }
                    else {
                        val message = "Incorrect username. Please try again. "
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(message)
                        }
                    }
                },

                modifier = Modifier.align(Alignment.CenterHorizontally)

            ) {
                Text(text = "Login")
            }
            SnackbarHost(snackbarHostState)

        }


    }
}


fun SendPoints (userSender: User?, userReceiver: User?, num: Int) {
    userSender!!.pointsCount = userSender!!.pointsCount - num
    userReceiver!!.pointsCount = userReceiver!!.pointsCount + num



}

@Preview(showBackground = true)
@Composable
fun PointsPreview() {
    ShareMyMealsTheme {
        PointsScreen(navController = rememberNavController())
    }
}

