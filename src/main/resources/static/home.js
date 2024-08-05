document.addEventListener("DOMContentLoaded", () => {
    fetchRecipes();
});

async function fetchUsers() {
    const apiUrl = "http://localhost:8090/alluser";
    const tableBody = document.getElementById("tableBody");

    try {
        const response = await fetch(apiUrl, {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' },
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();

        data.forEach(user => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <th>${user.userId}</th>
                <th>${user.userName}</th>
                <th>${user.userEmail}</th>
                <th>${user.userPassword}</th>
                <th>${user.recipe}</th>
            `;
            tableBody.appendChild(row);
        });

    } catch (error) {
        console.error("Error while calling API: ", error);
    }
}

async function fetchRecipes() {
    const apiUrl = 'http://localhost:8090/recipe';

    try {
        const response = await fetch(apiUrl);

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const recipes = await response.json();
        const container = document.querySelector('.grid-container');
        container.style.display = 'flex';
        container.innerHTML = '';
            recipes.forEach(recipe => {
                const recipeCard = document.createElement('div');
                recipeCard.className = 'grid-item';
        
                // Handle the ingredients field
                const ingredientsText = recipe.ingredients ? recipe.ingredients.join(', ') : 'No ingredients listed';
        
                recipeCard.innerHTML = `
                    <div class="recipe-card-content">
                        <h2>${recipe.recipeName}</h2>
                        <p><strong>Ingredients:</strong> ${ingredientsText}</p>
                        <p><strong>Serves:</strong> ${recipe.serves}</p>
                        <p><strong>Duration:</strong> ${recipe.duration} minutes</p>
                    </div>
                `;
                container.appendChild(recipeCard);            

        });

    } catch (error) {
        console.error('Error fetching recipes:', error);
    }
}

document.addEventListener("DOMContentLoaded", () => {
    const categorySelect = document.getElementById("category-select");
    const ingredientSearch = document.getElementById("ingredient-search");
    const searchButton = document.getElementById("search-button");
    const recipesList = document.getElementById("recipes-list");
    const additionalContent = document.getElementById("additional-content");

    fetchCategories(categorySelect);

    categorySelect.addEventListener("change", (event) => {
        const selectedCategory = event.target.value;

        if (selectedCategory) {
            fetchRecipesByCategory(selectedCategory, recipesList);
        } else {
            recipesList.innerHTML = ""; // Clear results when no category is selected
        }
    });
});

async function fetchCategories(categorySelect) {
    const apiUrl = "http://localhost:8090/category";

    try {
        const response = await fetch(apiUrl);

        if (!response.ok) {
            throw new Error("Failed to fetch categories");
        }

        const categories = await response.json();

        categories.forEach(category => {
            const option = document.createElement("option");
            option.value = category.id;
            option.textContent = category.name;
            categorySelect.appendChild(option);
        });

    } catch (error) {
        console.error("Error fetching categories:", error);
    }
}

async function fetchRecipesByCategory(categoryId, recipesList) {
    const apiUrl = `http://localhost:8090/recipe/bycategory?categoryId=${parseInt(categoryId)}`;

    try {
        const response = await fetch(apiUrl);

        if (!response.ok) {
            throw new Error("Failed to fetch recipes");
        }

        const recipes = await response.json();
        recipesList.innerHTML = ""; // Clear any existing content

        if (recipes.length > 0) {
            recipes.forEach(recipe => {
                const recipeItem = document.createElement("div");
                recipeItem.classList.add("recipe-item");
                recipeItem.innerHTML = `
                    <h3>${recipe.recipeName}</h3>
                    <p>${recipe.steps}</p>
                    <!-- Add more details as needed -->
                `;
                recipesList.appendChild(recipeItem);
            });
        } else {
            recipesList.innerHTML = "<p>No recipes found in this category.</p>";
        }

    } catch (error) {
        console.error("Error fetching recipes:", error);
    }
}
