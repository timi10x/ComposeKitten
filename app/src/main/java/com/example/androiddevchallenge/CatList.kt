package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.example.androiddevchallenge.ui.theme.brown
import androidx.compose.ui.Modifier

@Composable
fun CatList(
    cats: List<Cat>,
    onClickCatDetails: (Cat) -> Unit
) {
    LazyColumn {
        itemsIndexed(cats) { _, cat ->
            CatListItem(cat = cat,
                modifier = Modifier
                    .clickable { onClickCatDetails(cat) }
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun CatListItem(
    cat: Cat,
    modifier: Modifier = Modifier
) {
    Box(modifier = androidx.compose.ui.Modifier.wrapContentHeight()) {
        Card(
            modifier = androidx.compose.ui.Modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
                .padding(vertical = 14.dp)
                .requiredHeight(130.dp)
                .clip(shape = RoundedCornerShape(16.dp)),
            elevation = 8.dp,
        ) {
            Row(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp, top = 0.dp, end = 240.dp, bottom = 0.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
            )
            {
                Column(
                    modifier = androidx.compose.ui.Modifier
                        .requiredWidth(250.dp)
                        .fillMaxHeight()
                        .background(color = brown)
                        .padding(start = 0.dp, top = 0.dp, end = 260.dp, bottom = 0.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                }

            }


            Column(
                modifier = androidx.compose.ui.Modifier.padding(
                    start = 150.dp,
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
                        contentDescription = "Distance",
                        tint = Color(0xFFF59056),
                        modifier = androidx.compose.ui.Modifier.sizeIn(maxWidth = 14.dp)
                    )
                    Spacer(modifier = androidx.compose.ui.Modifier.size(4.dp))
                    Text(
                        text = cat.location,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )


                }
            }


        }
        Image(
            modifier = androidx.compose.ui.Modifier
                .size(width = 250.dp, height = 200.dp)
                .align(Alignment.TopStart)
                .padding(start = 0.dp, top = 0.dp, end = 120.dp, bottom = 10.dp),
            painter = painterResource(id = R.drawable.browncat),
            contentDescription = null
        )
    }
}

@Preview("List item")
@Composable
private fun ListItemPreview() {
    CatListItem(Cat("Kitty", Breed.Chihuahua, 1.5, "California (1.5km)"))
}