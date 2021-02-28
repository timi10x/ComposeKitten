package com.example.androiddevchallenge

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Breed
import com.example.androiddevchallenge.data.Cat
import com.example.androiddevchallenge.data.CatColor

@Composable
fun CatDetailsScreen(cat: Cat, onBackPressed: () -> Unit) {
    val color =
        if (cat.breed == Breed.Chihuahua) Color(0xFFE5C096) else Color(0xFFDCE5EC)

    Box(
        modifier = Modifier
            .background(color = color)
            .fillMaxHeight()
    ) {
        val cardCornerRadius = 30.dp
        val bottomRoundedShape = RoundedCornerShape(
            topStart = cardCornerRadius,
            topEnd = cardCornerRadius,
            bottomEnd = 0.dp,
            bottomStart = 0.dp
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxHeight()
                .background(color = color)
        ) {

            BackArrow {
                onBackPressed()
            }

            PetImage(cat.breed)

            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
            ) {
                Text(
                    text = cat.name,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                )
                Spacer(modifier = Modifier.size(4.dp))

                Row(
                    modifier = androidx.compose.ui.Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = null,
                        tint = Color(0xFFF59056),
                        modifier = androidx.compose.ui.Modifier.sizeIn(maxWidth = 14.dp)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = cat.location,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }

            Spacer(modifier = Modifier.size(16.dp))

            Card(
                shape = bottomRoundedShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()

            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
                        .background(color = Color(0xFFF6F6F6))
                ) {
                    Row(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 25.dp, end = 6.dp, bottom = 0.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Card(
                            modifier = Modifier
                                .width(80.dp)
                                .height(60.dp),
                            elevation = 6.dp,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    modifier = Modifier.wrapContentWidth(),
                                    text = "Age",
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.40f),
                                    style = MaterialTheme.typography.subtitle1,
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    modifier = Modifier.wrapContentWidth(),
                                    text = "${cat.age}",
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.40f),
                                    style = MaterialTheme.typography.subtitle1,
                                )
                            }
                        }

                        Spacer(modifier = Modifier.size(16.dp))

                        Card(
                            modifier = Modifier
                                .width(80.dp)
                                .height(60.dp),
                            elevation = 6.dp,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    modifier = Modifier.wrapContentWidth(),
                                    text = "Color",
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.40f),
                                    style = MaterialTheme.typography.subtitle1,
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    modifier = Modifier.wrapContentWidth(),
                                    text = "${cat.color}",
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.40f),
                                    style = MaterialTheme.typography.subtitle1,
                                )
                            }
                        }

                        Spacer(modifier = Modifier.size(16.dp))

                        Card(
                            modifier = Modifier
                                .width(80.dp)
                                .height(60.dp),
                            elevation = 6.dp,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    modifier = Modifier.wrapContentWidth(),
                                    text = "Sex",
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.40f),
                                    style = MaterialTheme.typography.subtitle1,
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    modifier = Modifier.wrapContentWidth(),
                                    text = "Male",
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.40f),
                                    style = MaterialTheme.typography.subtitle1,
                                )
                            }
                        }

                        Spacer(modifier = Modifier.size(16.dp))

                        Card(
                            modifier = Modifier
                                .width(80.dp)
                                .height(60.dp),
                            elevation = 6.dp,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    modifier = Modifier.wrapContentWidth(),
                                    text = "Weight",
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.40f),
                                    style = MaterialTheme.typography.subtitle1,
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    modifier = Modifier.wrapContentWidth(),
                                    text = "3 KG",
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.40f),
                                    style = MaterialTheme.typography.subtitle1,
                                )
                            }
                        }

                    }

                    Spacer(modifier = Modifier.size(16.dp))

                    OwnersDetails()
                    Row(
                        modifier = Modifier.padding(
                            start = 80.dp,
                            top = 0.dp,
                            end = 80.dp,
                            bottom = 0.dp
                        )
                    ) {
                        Text(
                            modifier = Modifier.background(color),
                            text = "Meow!!! Can you adopt me!?",
                            style = MaterialTheme.typography.subtitle1
                        )
                    }

                    Spacer(modifier = Modifier.size(22.dp))

                    Card(
                        shape = bottomRoundedShape,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        elevation = 8.dp

                    ) {
                        Row(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 0.dp)
                        ) {
                            Image(
                                modifier = androidx.compose.ui.Modifier
                                    .size(60.dp)
                                    .padding(start = 0.dp, top = 30.dp, end = 0.dp, bottom = 0.dp),
                                painter = painterResource(id = R.drawable.ic_telephone_call),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.size(22.dp))

                            Image(
                                modifier = androidx.compose.ui.Modifier
                                    .size(60.dp)
                                    .padding(start = 0.dp, top = 30.dp, end = 0.dp, bottom = 0.dp),
                                painter = painterResource(id = R.drawable.ic_messenger),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.size(30.dp))

                            val context = LocalContext.current
                            Button(
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(80.dp)
                                    .padding(top = 10.dp),
                                onClick = {
                                    Toast.makeText(
                                        context,
                                        "thank you for adopting me",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            ) {
                                Text(
                                    text = "Adopt Now",
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFDCE5EC)
                                )
                            }
                        }

                    }


                }
            }

        }

    }


}


@Composable
fun OwnersDetails() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = androidx.compose.ui.Modifier
                .size(80.dp)
                .padding(8.dp),
            painter = painterResource(id = R.drawable.profilepic),
            contentDescription = null
        )

        Column {
            Text(
                text = "Timmy Coder",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
            Text(
                text = "Owner",
                style = MaterialTheme.typography.subtitle1
            )
        }
        Spacer(modifier = Modifier.size(60.dp))
        Text(
            text = "1 Feb, 2021",
            style = MaterialTheme.typography.subtitle1
        )

    }

}

@Composable
private fun BackArrow(onBackPressed: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onBackPressed()
            },
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier
                .size(60.dp)
                .padding(start = 0.dp, top = 10.dp, end = 0.dp, bottom = 0.dp), tint = Color.Black,
            imageVector = Icons.Outlined.ArrowBack, contentDescription = null
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, top = 0.dp, end = 20.dp, bottom = 0.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentHeight()
                    .wrapContentWidth(),
                painter = painterResource(id = R.drawable.liked),
                contentDescription = null
            )
        }
    }
}


@Composable
private fun PetImage(breed: Breed) {
    val imageResourceId =
        if (breed == Breed.Chihuahua) R.drawable.browncat else R.drawable.greycat

    val color =
        if (breed == Breed.Chihuahua) Color(0xFFE5C096) else Color(0xFFDCE5EC)


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.4f)
            .background(color = color),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .width(400.dp)
                .height(280.dp)
        )
    }
}

@Preview
@Composable
fun SeeBackArrow() {
    BackArrow(onBackPressed = {})
}

@Preview
@Composable
fun OwnersPrev() {
    OwnersPrev()
}

@Preview
@Composable
fun Screen() {
    CatDetailsScreen(
        cat = Cat("Kitty", Breed.Chihuahua, 1.5, "California (1.5km)", CatColor.Brown),
        onBackPressed = { /*TODO*/ })
}