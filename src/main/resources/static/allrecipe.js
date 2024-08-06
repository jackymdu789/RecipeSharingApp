document.addEventListener('DOMContentLoaded', () => {
    fetch('http://localhost:8090/recipe')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(recipes => {
            const recipesContainer = document.getElementById('recipes');
            recipesContainer.innerHTML = ''; // Clear any existing content

            if (recipes.length === 0) {
                recipesContainer.innerHTML = '<p>No recipes found.</p>';
                return;
            }

            recipes.forEach(recipe => {
                const recipeCard = document.createElement('div');
                recipeCard.className = 'recipe-card';
                if (recipe.imageUrl) {
                    const image = document.createElement('img');
                    image.src = recipe.imageUrl;
                    image.alt = `${recipe.recipeName} image`;
                    image.className = 'recipe-image';
                    recipeCard.appendChild(image);
                }
                const recipeTitle = document.createElement('h2');
                recipeTitle.textContent = recipe.recipeName;
                recipeCard.appendChild(recipeTitle);

                const ingredients = document.createElement('p');
                ingredients.textContent = `Ingredients: ${recipe.ingredients ? recipe.ingredients.join(', ') : 'No ingredients provided'}`;
                recipeCard.appendChild(ingredients);
                console.log(recipe)

                const steps = document.createElement('p');
                steps.textContent = `Steps: ${recipe.steps}`;
                recipeCard.appendChild(steps);

                const serves = document.createElement('p');
                serves.textContent = `Serves: ${recipe.serves}`;
                recipeCard.appendChild(serves);

                const duration = document.createElement('p');
                duration.textContent = `Duration: ${recipe.duration}`;
                recipeCard.appendChild(duration);

                const category = document.createElement('p');
                category.textContent = `category: ${recipe.category.categoryName}`;
                recipeCard.appendChild(category);

                const dietary = document.createElement('p');
                dietary.textContent = `dietary: ${recipe.dietary.dietaryName}`;
                recipeCard.appendChild(dietary);

                
                recipesContainer.appendChild(recipeCard);
            });
        })
        .catch(error => {
            console.error('Error fetching recipes:', error);
            document.getElementById('recipes').innerHTML = '<p>Error loading recipes. Please try again later.</p>';
        });
});
