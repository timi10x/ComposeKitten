/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
