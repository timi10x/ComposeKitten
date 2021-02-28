package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Breed
import com.example.androiddevchallenge.data.Cat
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.data.CatColor

@Composable
fun CatListItem(
    cat: Cat,
    onCatListItemClicked: (Cat) -> Unit
) {
    Box(
        modifier = androidx.compose.ui.Modifier
            .wrapContentHeight()
    ) {
        Card(
            modifier = androidx.compose.ui.Modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
                .padding(vertical = 14.dp)
                .requiredHeight(130.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .clickable {
                    onCatListItemClicked(cat)
                },
            elevation = 8.dp,
        ) {
            Row(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp, top = 0.dp, end = 240.dp, bottom = 0.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
            )
            {
                val color =
                    if (cat.color == CatColor.Brown) Color(0xFFE5C096) else Color(0xFFDCE5EC)

                Column(
                    modifier = androidx.compose.ui.Modifier
                        .requiredWidth(250.dp)
                        .fillMaxHeight()
                        .background(color = color)
                        .padding(start = 0.dp, top = 0.dp, end = 260.dp, bottom = 0.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                }

            }


            Column(
                modifier = androidx.compose.ui.Modifier.padding(
                    start = 170.dp,
                    top = 20.dp,
                    end = 16.dp,
                    bottom = 0.dp
                )
            ) {

                Row {
                    Text(
                        text = cat.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Image(
                        modifier = androidx.compose.ui.Modifier
                            .size(20.dp)
                            .padding(start = 8.dp, top = 8.dp, end = 0.dp, bottom = 0.dp),
                        painter = painterResource(id = R.drawable.ic_gender_icon),
                        contentDescription = null
                    )

                    Image(
                        modifier = androidx.compose.ui.Modifier
                            .padding(start = 120.dp, top = 4.dp, end = 0.dp, bottom = 0.dp)
                            .wrapContentHeight()
                            .wrapContentWidth(),
                        painter = painterResource(id = R.drawable.liked),
                        contentDescription = null
                    )

                }

                Text(
                    text = "${cat.breed}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )

                Text(
                    text = "${cat.age} years",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Row(
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 10.dp),
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


        }
        val imageResourceId =
            if (cat.color == CatColor.Brown) R.drawable.browncat else R.drawable.greycat

        Image(
            modifier = androidx.compose.ui.Modifier
                .size(width = 250.dp, height = 200.dp)
                .align(Alignment.TopStart)
                .padding(start = 0.dp, top = 0.dp, end = 120.dp, bottom = 10.dp),
            painter = painterResource(id = imageResourceId),
            contentDescription = null
        )
    }
}

@Preview("List item")
@Composable
private fun ListItemPreview() {
    CatListItem(Cat("Kitty", Breed.Chihuahua, 1.5, "California (1.5km)", CatColor.Brown)) {}
}