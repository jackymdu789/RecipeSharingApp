document.addEventListener("DOMContentLoaded", async () => {
    const urlParams = new URLSearchParams(window.location.search);
    const recipeId = urlParams.get("id");
    if (recipeId) {
        try {
            const response = await fetch(`/localhost:8090/recipe/${recipeId}`);
            if (response.ok) {
                const recipeData = await response.json();
                document.getElementById("recipe-name").textContent = recipeData.recipe_name;
                document.getElementById("recipe-ingredients").textContent = recipeData.ingredients;
                document.getElementById("recipe-steps").textContent = recipeData.steps;
                document.getElementById("recipe-serves").textContent = recipeData.serves;
            } else {
                console.error('Error:', response.statusText);
            }
        } catch (error) {
            console.error('Error:', error);
        }
    }
});
