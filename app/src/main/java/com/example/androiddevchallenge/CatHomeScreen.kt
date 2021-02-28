package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.*
import com.example.androiddevchallenge.utils.ChipGroup

@Composable
fun CatHomeScreen(onCatListItemClicked: (Cat) -> Unit) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(0.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.size(26.dp))

            ProfileDetails()

            Spacer(modifier = Modifier.size(25.dp))

            CardContent(onCatListItemClicked)

        }
    }
}

@Composable
fun CardContent(onCatListItemClicked: (Cat) -> Unit) {
    val cardCornerRadius = 30.dp
    val bottomRoundedShape = RoundedCornerShape(
        topStart = cardCornerRadius,
        topEnd = cardCornerRadius,
        bottomEnd = 0.dp,
        bottomStart = 0.dp
    )

    val cats = arrayListOf(
        Cat("Kitty", Breed.Chihuahua, 1.5, "California(1.5 Km)", CatColor.Brown),
        Cat("Lucy", Breed.Boxer, 2.0, "New York(2 km)", CatColor.Gray)
    )

    Card(
        shape = bottomRoundedShape,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        backgroundColor = Color(0xFFF6F6F6)
    ) {
        Column {
            Spacer(modifier = Modifier.height(0.dp))
            CatListSearchBar()
            Spacer(modifier = Modifier.height(12.dp))
            AnimalChipGroup()

            PetText()
            LazyColumn(
                modifier = Modifier.padding(4.dp)
            ) {
                items(cats) {
                    CatListItem(cat = it, onCatListItemClicked)
                    Spacer(modifier = Modifier.size(6.dp))
                }
            }


        }
    }
}

@Composable
fun CatListSearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .width(290.dp)
                .height(60.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 2.dp
                    ),
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onSurface.copy(alpha = 0.50f),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Search here...",
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.40f),
                    style = MaterialTheme.typography.subtitle1,
                )
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Image(
            modifier = Modifier
                .size(100.dp),
            painter = painterResource(id = R.drawable.filter),
            contentDescription = null
        )

    }

}

@Composable
fun ProfileDetails() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = androidx.compose.ui.Modifier
                .size(100.dp)
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
                text = "IB, NIGERIA",
                style = MaterialTheme.typography.subtitle1
            )
        }
        Spacer(modifier = Modifier.size(90.dp))
        Image(
            modifier = Modifier
                .size(40.dp),
            painter = painterResource(id = R.drawable.menu),
            contentDescription = null
        )

    }

}

@Composable
fun AnimalChipGroup() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val selectedBreedFilters: MutableState<List<Animals>> =
            remember {
                mutableStateOf(
                    listOf(
                        AnimalRepo.getAllAnimals().first()
                    )
                )
            }

        ChipGroup(
            items = AnimalRepo.getAllAnimals(),
            selectedItems = selectedBreedFilters.value,
            itemFormatter = { it.name },
            itemIconFormatter = { it.icon },
            onSelectionChanged = { selectedBreeds ->
                selectedBreedFilters.value = selectedBreeds
            }
        )
    }

}

@Composable
fun PetText() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 10.dp, end = 0.dp, bottom = 0.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Newest Pet",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, top = 0.dp, end = 20.dp, bottom = 0.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                modifier = Modifier
                    .size(25.dp),
                painter = painterResource(id = R.drawable.viewmore),
                contentDescription = null
            )
        }
    }


}

@Preview
@Composable
fun ProfilePreview() {
    ProfileDetails()
}

@Preview
@Composable
fun ScreenPreview() {
    CatHomeScreen(onCatListItemClicked = {})
}