package com.example.recipe.composable

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipe.model.Recipe

@Composable
fun RecipeList(recipes: List<Recipe>) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = recipes, itemContent = { item ->
            RecipeCard(item, Modifier.padding(16.dp))
        })
    }
}

@Composable
@Preview
fun DefaultRecipeList() {
    RecipeList(defaultRecipes)
}