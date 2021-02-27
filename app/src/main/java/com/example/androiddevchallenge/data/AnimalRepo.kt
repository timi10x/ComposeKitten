package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

object AnimalRepo {

    private val animalType = listOf(
        Animals(
            id = "cat",
            name = "Cat",
            icon = R.drawable.cat
        ),
        Animals(
            id = "dog",
            name = "Dog",
            icon = R.drawable.dog
        ),
        Animals(
            id = "bird",
            name = "Bird",
            icon = R.drawable.bird
        ),
        Animals(
            id = "rabbit",
            name = "Rabbit",
            icon = R.drawable.rabbit
        ),
    )


    fun getAllAnimals(): List<Animals> = animalType

}