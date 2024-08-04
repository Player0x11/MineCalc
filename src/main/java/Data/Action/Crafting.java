package Data.Action;

import Data.Category.Recipe;
import org.json.JSONArray;
import org.json.JSONObject;

public class Crafting {
    private Recipe[] recipe;

    public Crafting(JSONArray recipeArray) {
        recipe = new Recipe[recipeArray.length()];
        for (int i = 0; i < recipeArray.length(); i++) {
            JSONObject recipeObject = recipeArray.getJSONObject(i);
            recipe[i] = new Recipe(recipeObject.getString("item"), recipeObject.getInt("quantity"));
        }
    }

    public Recipe[] getRecipe() {
        return recipe;
    }
}