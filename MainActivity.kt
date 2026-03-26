package com.daniel.laboratorio2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniel.laboratorio2.ui.theme.Laboratorio2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                Column {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,

                        ) {
                        val usuario: MutableState<String> = remember { mutableStateOf("") }
                        val hidden: MutableState<Boolean> = remember {
                            mutableStateOf(true)
                        }
                        TextField(
                            value = usuario.value,
                            onValueChange = {
                                usuario.value = it
                            },
                            maxLines = 1,
                            minLines = 1,
                            singleLine = true,
                            colors = TextFieldDefaults.colors(
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                disabledTextColor = Color.Black,
                                errorTextColor = Color.Black,
                                focusedContainerColor = Color.Black,
                                unfocusedContainerColor = Color.White,
                                disabledContainerColor = Color.Black,
                                errorContainerColor = Color.Red,
                                cursorColor = Color.Black,
                                errorCursorColor = Color.Black,
                                focusedIndicatorColor = Color.Black,
                                unfocusedIndicatorColor = Color.Black,
                                disabledIndicatorColor = Color.Black,
                                errorIndicatorColor = Color.Black,
                                focusedLeadingIconColor = Color.Black,
                                unfocusedLeadingIconColor = Color.Black,
                                disabledLeadingIconColor = Color.Black,
                                errorLeadingIconColor = Color.Black,
                                focusedTrailingIconColor = Color.Black,
                                unfocusedTrailingIconColor = Color.Black,
                                disabledTrailingIconColor = Color.Black,
                                errorTrailingIconColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                disabledLabelColor = Color.Black,
                                errorLabelColor = Color.Black,
                                focusedPlaceholderColor = Color.Black,
                                unfocusedPlaceholderColor = Color.Black,
                                disabledPlaceholderColor = Color.Black,
                                errorPlaceholderColor = Color.Black,
                                focusedSupportingTextColor = Color.Black,
                                unfocusedSupportingTextColor = Color.White,
                                disabledSupportingTextColor = Color.Black,
                                errorSupportingTextColor = Color.Black,
                                focusedPrefixColor = Color.Black,
                                unfocusedPrefixColor = Color.White,
                                disabledPrefixColor = Color.Black,
                                errorPrefixColor = Color.Black,
                                focusedSuffixColor = Color.Black,
                                unfocusedSuffixColor = Color.White,
                                disabledSuffixColor = Color.Black,
                                errorSuffixColor = Color.Black
                            ),
                            label = { Text("Ingrese su nombre") },
                            placeholder = { Text("Nombre") },
                            supportingText = { Text("Por favor, ingrese su nombre completo.") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Icono de persona"
                                )
                            },
                            isError = false,
                            keyboardActions = KeyboardActions(
                                onNext = {},
                                onDone = {},
                                onGo = {},
                                onPrevious = {},
                                onSearch = {},
                                onSend = {}
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            visualTransformation = PasswordVisualTransformation(),
                            trailingIcon = {
                                if(hidden.value){
                                    Icon(
                                        imageVector = Icons.Default.Visibility,
                                        contentDescription = "Icono para mostrar u ocultar contraseña"
                                    )
                                }
                                else{
                                    Icon(
                                        imageVector = Icons.Default.VisibilityOff,
                                        contentDescription = "Icono para mostrar u ocultar contraseña"
                                    )
                                }
                            },
                            readOnly = false
                        )
                    }

                    Column(
                        modifier = Modifier
                            .height(200.dp)
                            .padding(10.dp)
                            .background(Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        val entries: List<String> = listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten")
                        LazyColumn {
                            itemsIndexed(entries.toList()) { index, item ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = item
                                    )
                                    Text(
                                        text = (index + 1).toString()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Laboratorio2Theme {
        Greeting("Android")
    }
}

@Composable
fun botonGuardarPersona() {
    FloatingActionButton(onClick = { /* LLamar función guardarPersona */ }) {
        Icon(Icons.Default.Add, contentDescription = "Guardar")
    }
}