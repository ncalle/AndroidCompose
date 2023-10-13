package com.justify.testcompose.ui.theme.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.justify.testcompose.R


@Composable
fun LoginScreen(context: Context) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Login(context, Modifier.align(Alignment.Center))
    }
}

@Composable
fun Login(context:Context, modifier: Modifier) {

    val loading = false
    val email = ""
    val password = ""
    val enable = false

    if (loading) {
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else {
        Column(modifier = modifier) {

            Logo(modifier = Modifier.width(64.dp)
                .height(64.dp)
                .align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            Title()
            Spacer(modifier = Modifier.padding(16.dp))
            EmailField(email) {
            }
            Spacer(modifier = Modifier.padding(8.dp))
            PasswordField(password) {
            }
            Spacer(modifier = Modifier.padding(16.dp))
            LoginButton(enable) {
                Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


@Composable
fun Title() {
    Text(
        text = "Login",
        modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
        maxLines = 1,
        color = Color(0xFF088F8F),
        style = MaterialTheme.typography.h4
    )
}

    @Composable
    fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
        TextField(
            value = password, onValueChange = { onTextFieldChanged(it) },
            placeholder = { Text(text = "Password") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF636262),
                backgroundColor = Color(0xFFDEDDDD),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }

    @Composable
    fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
        TextField(
            value = email, onValueChange = { onTextFieldChanged(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF636262),
                backgroundColor = Color(0xFFDEDDDD),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }

    @Composable
    fun LoginButton(enable: Boolean, onLoginSelected: () -> Unit) {
        Button(
            onClick = { onLoginSelected() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF088F8F),
                disabledBackgroundColor = Color(0xFF0dbdbd),
                contentColor = Color.White,
                disabledContentColor = Color.White
            ), enabled = enable
        ) {
            Text(text = "Login")
        }
    }

    @Composable
    fun Logo(modifier: Modifier) {
        Image(
            painter = painterResource(id = R.mipmap.login),
            contentDescription = "Logo",
            modifier = modifier,
        )
    }
