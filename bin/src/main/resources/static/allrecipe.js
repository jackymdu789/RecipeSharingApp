// document.addEventListener('DOMContentLoaded', () => {
//     fetch('http://localhost:8090/recipe')
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error('Network response was not ok ' + response.statusText);
//             }
//             return response.json();
//         })
//         .then(recipes => {
//             const recipesContainer = document.getElementById('recipes');
//             recipesContainer.innerHTML = ''; // Clear any existing content
//             if (recipes.length === 0) {
//                 recipesContainer.innerHTML = '<p>No recipes found.</p>';
//                 return;
//             }
//             recipes.forEach(recipe => {
//                 const recipeCard = document.createElement('div');
//                 recipeCard.className = 'recipe-card';
                
//                 const recipeTitle = document.createElement('h2');
//                 recipeTitle.textContent = recipe.recipename;
//                 recipeCard.appendChild(recipeTitle);

//                 const ingredients = document.createElement('p');
//                 ingredients.textContent = `Ingredients: ${recipe.ingredients.join(', ')}`;
//                 recipeCard.appendChild(ingredients);
                
//                 const steps = document.createElement('p');
//                 steps.textContent = `Steps: ${recipe.steps}`;
//                 recipeCard.appendChild(steps);
                
//                 const serves = document.createElement('p');
//                 serves.textContent = `Serves: ${recipe.serves}`;
//                 recipeCard.appendChild(serves);

//                 const duration = document.createElement('p');
//                 duration.textContent = `Duration: ${recipe.duration}`;
//                 recipeCard.appendChild(duration);

//                 recipesContainer.appendChild(recipeCard);
//             });
//         })
//         .catch(error => {
//             console.error('Error fetching recipes:', error);
//             document.getElementById('recipes').innerHTML = '<p>Error loading recipes. Please try again later.</p>';
//         });
// });


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

                const recipeTitle = document.createElement('h2');
                recipeTitle.textContent = recipe.recipeName;
                recipeCard.appendChild(recipeTitle);

                const ingredients = document.createElement('p');
                ingredients.textContent = `Ingredients: ${recipe.ingredients ? recipe.ingredients.join(', ') : 'No ingredients provided'}`;
                recipeCard.appendChild(ingredients);

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
                duration.textContent = `category: ${recipe.category}`;
                recipeCard.appendChild(category);

                recipesContainer.appendChild(recipeCard);
            });
        })
        .catch(error => {
            console.error('Error fetching recipes:', error);
            document.getElementById('recipes').innerHTML = '<p>Error loading recipes. Please try again later.</p>';
        });
});
