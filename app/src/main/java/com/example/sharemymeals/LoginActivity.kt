package com.example.sharemymeals

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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sharemymeals.data.User
import com.example.sharemymeals.navigation.Screens
import com.example.sharemymeals.ui.theme.ShareMyMealsTheme
import kotlinx.coroutines.launch
import values.UserData

var loggedUser: User? = null


class LoginActivity : ComponentActivity() {

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
val userData = UserData()


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {
    val snackbarHostState = remember { SnackbarHostState() }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Share My Meals!",
            style = TextStyle(fontSize = 30.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username")},
            modifier = Modifier.padding(1.dp))


        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password")},
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(16.dp))
        val coroutineScope = rememberCoroutineScope()
        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally))
        {
            Button(

                onClick = {
                    val user = userData.getUserByUsername(username)

                    if (user != null && user.password == password){
                        navController.navigate(Screens.Home.route)
                        loggedUser = user}
                    else {
                        val message = "Incorrect credentials. Please try again. "
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




@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ShareMyMealsTheme {
       //LoginScreen()
    }
}