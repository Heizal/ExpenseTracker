package com.example.expensetracker

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                //set navController
                val navController = rememberNavController()
                //set this to check whether it (route) has been selected
                //if selected: ->
                //on click: go to that route
                val backStackEntry = navController.currentBackStackEntryAsState()
                Scaffold(
                    bottomBar = {
                                NavigationBar {
                                    //Expenses Item
                                    NavigationBarItem(
                                        selected = backStackEntry.value?.destination?.route == "expenses",
                                        onClick = { navController.navigate("expenses")},
                                        icon = {
                                            Icon(
                                                painterResource(id = R.drawable.upload),
                                                contentDescription = "Upload"
                                            )
                                        },
                                        label = {
                                            Text(text = "Expenses")

                                        },

                                    )
                                    //Reports
                                    NavigationBarItem(
                                        selected = backStackEntry.value?.destination?.route == "reports",
                                        onClick = { navController.navigate("reports")},
                                        icon = {
                                            Icon(
                                                painterResource(id = R.drawable.bar_chart),
                                                contentDescription = "Bar-Chart"
                                            )
                                        },
                                        label = {
                                            Text(text = "Reports")

                                        },
                                    )

                                    //Add
                                    NavigationBarItem(
                                        selected = backStackEntry.value?.destination?.route == "add",
                                        onClick = { navController.navigate("add")},
                                        icon = {
                                            Icon(
                                                painterResource(id = R.drawable.add),
                                                contentDescription = "Add"
                                            )
                                        },
                                        label = {
                                            Text(text = "Add")

                                        },
                                    )

                                    //Settings
                                    NavigationBarItem(
                                        selected = backStackEntry.value?.destination?.route == "settings",
                                        onClick = { navController.navigate("settings")},
                                        icon = {
                                            Icon(
                                                painterResource(id = R.drawable.settings),
                                                contentDescription = "Settings"
                                            )
                                        },
                                        label = {
                                            Text(text = "Settings")

                                        },
                                    )

                                }

                    },
                    //set navHost
                    content = { innerPadding ->
                        NavHost(navController = navController, startDestination = "expenses"){
                            //Composable for expenses
                            composable("expenses"){
                                Surface (
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ) {
                                    Greeting(name = "Expenses")
                                }
                            }
                            //Composable for reports
                            composable("reports"){
                                Surface (
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ) {
                                    Greeting(name = "Reports")
                                }
                            }
                            //Composable for add
                            composable("add"){
                                Surface (
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ) {
                                    Greeting(name = "Add")
                                }
                            }
                            //Composable for settings
                            composable("settings"){
                                Surface (
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ) {
                                    Greeting(name = "Settings")
                                }
                            }

                        }

                    }
                )
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

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    ExpenseTrackerTheme {
        Surface {
            Greeting("Android")
        }
    }
}