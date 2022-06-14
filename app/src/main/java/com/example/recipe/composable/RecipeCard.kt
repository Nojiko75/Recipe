package com.example.recipe.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipe.R
import com.example.recipe.model.Recipe

val defaultRecipes = listOf(
    Recipe(
        R.drawable.ramen,
        "Ramen",
        listOf(
            "Noodles (340 g)",
            "2 eggs",
            "Mushrooms (60 g)",
            "Carrots (50 g)",
            "Soy sauce (60 ml)"
        )
    ),
    Recipe(
        R.drawable.croissant,
        "Croissant",
        listOf(
            "Butter",
            "More butter",
            "A touch of butter",
            "Floor"
        )
    )
)

@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier) {
    val image: Painter = painterResource(recipe.imageResource)
    Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp, modifier = modifier) {
        Column(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
            Image(
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(144.dp)
            )
            Text(recipe.title, modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.h4)
            for (ingredient in recipe.ingredients) {
                Text(text = "• $ingredient", modifier = Modifier.padding(start = 16.dp))
            }
        }
    }
}

@Composable
@Preview
fun DefaultRecipeCard() {
    RecipeCard(defaultRecipes[0], Modifier.padding(16.dp))
}
