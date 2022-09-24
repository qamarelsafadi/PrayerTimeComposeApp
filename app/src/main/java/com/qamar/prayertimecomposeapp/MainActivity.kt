package com.qamar.prayertimecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qamar.prayertimecomposeapp.ui.theme.HiltComposeStoreTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltComposeStoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DrawerNavigation()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.h1
    )
}

@Composable
fun DrawerNavigation() {
    val scafoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scafoldState,
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                title = {
                    Toolbar()
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scafoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.menus),
                            "",
                            Modifier.size(20.dp),
                            colorResource(id = R.color.black)
                        )
                    }
                },
                backgroundColor = colorResource(id = R.color.grey),
                contentColor = colorResource(id = R.color.grey)
            )
        },
        drawerBackgroundColor = colorResource(id = R.color.grey),
        drawerContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier =
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text("Hey Drawer")
                Button(onClick = {
                    scope.launch {
                        scafoldState.drawerState.close()
                    }
                }) {
                    Text("Close Drawer")
                }
            }
        },
        backgroundColor = colorResource(id = R.color.grey)
    ) { padding ->  // We need to pass scaffold's inner padding to content. That's why we use Box.
        Column(
            modifier = Modifier
                .padding(vertical = 50.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Top,
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .background(color = colorResource(id = R.color.white))
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Column() {
                    Text(
                        text = stringResource(R.string.fajr), fontSize = 18.sp,
                        color = colorResource(id = R.color.black),
                    )
                    Text(
                        text = stringResource(R.string.fajr_time),
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.grey_light),
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_sunset_svgrepo_com),
                    modifier = Modifier.size(35.dp),
                    contentDescription = "",
                )
            }
            Card(modifier = Modifier.padding(horizontal = 16.dp),
            elevation = 35.dp,
            shape = RoundedCornerShape(0.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.blue))
                ) {
                    Column(Modifier.padding(vertical = 15.dp, horizontal = 15.dp)) {
                        Text(
                            text = stringResource(R.string.duhur), fontSize = 18.sp,
                            color = colorResource(id = R.color.white),
                        )
                        Text(
                            text = stringResource(R.string.duhur_time),
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.white),
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = stringResource(R.string.time_until),
                            fontSize = 11.sp,
                            color = colorResource(id = R.color.white_alpha),
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.sun),
                        modifier = Modifier
                            .padding(end = 24.dp)
                            .size(35.dp),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.white))
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .background(color = colorResource(id = R.color.white))
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Column() {
                    Text(
                        text = stringResource(R.string.asr), fontSize = 18.sp,
                        color = colorResource(id = R.color.black),
                    )
                    Text(
                        text = stringResource(R.string.asr_time),
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.grey_light),
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.sunset),
                    modifier = Modifier.size(35.dp),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.tint_color))

                )
            }
            Spacer(modifier = Modifier
                .padding(horizontal = 24.dp)
                .height(1.dp)
                .fillMaxWidth()
                .background(colorResource(id = R.color.tint_color_alpha)))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .background(color = colorResource(id = R.color.white))
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Column() {
                    Text(
                        text = stringResource(R.string.magharib), fontSize = 18.sp,
                        color = colorResource(id = R.color.black),
                    )
                    Text(
                        text = stringResource(R.string.magharib_time),
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.grey_light),
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.maghrib),
                    modifier = Modifier.size(35.dp),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.tint_color))
                )
            }
            Spacer(modifier = Modifier
                .padding(horizontal = 24.dp)
                .height(1.dp)
                .fillMaxWidth()
                .background(colorResource(id = R.color.tint_color_alpha)))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .background(color = colorResource(id = R.color.white))
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Column() {
                    Text(
                        text = stringResource(R.string.isha), fontSize = 18.sp,
                        color = colorResource(id = R.color.black),
                    )
                    Text(
                        text = stringResource(R.string.isha_time),
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.grey_light),
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.cloudy),
                    modifier = Modifier.size(35.dp),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.tint_color))
                )
            }
            //Navigation(navController = navController)
        }
    }

}

@Composable
private fun Toolbar() {
    Column(modifier = Modifier.padding(top = 10.dp)) {
        Text(
            text = stringResource(R.string.title), fontSize = 18.sp,
            color = colorResource(id = R.color.black),
            style = MaterialTheme.typography.h1
        )
        Text(
            text = stringResource(R.string.city),
            fontSize = 12.sp,
            color = colorResource(id = R.color.grey_light),
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HiltComposeStoreTheme {
        DrawerNavigation()
    }
}