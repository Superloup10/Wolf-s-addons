/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.recipe;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;

public class RecipesSorterCompressor implements Comparator
{
	private final RecipesCompressor recipes;

	public RecipesSorterCompressor(RecipesCompressor recipesCompressor)
	{
		this.recipes = recipesCompressor;
	}

	public int compareRecipe(IRecipe recipe, IRecipe recipe2)
	{
		return recipe instanceof ShapelessRecipes && recipe2 instanceof ShapedRecipesCompressor ? 1 : (recipe2 instanceof ShapelessRecipes && recipe instanceof ShapedRecipesCompressor ? -1 : (recipe2.getRecipeSize() < recipe.getRecipeSize() ? -1 : (recipe2.getRecipeSize() > recipe.getRecipeSize() ? 1 : 0)));
	}

	@Override
	public int compare(Object o1, Object o2)
	{
		return this.compareRecipe((IRecipe)o1, (IRecipe)o2);
	}
}
