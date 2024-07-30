document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = '/api/recipes'; // Adjust based on your API base URL
    const categoryApiUrl = '/api/categories';

    // Load categories into the dropdown
    async function loadCategories() {
        try {
            const response = await fetch(categoryApiUrl);
            if (response.ok) {
                const categories = await response.json();
                const categoriesSelect = document.getElementById('categories');
                categoriesSelect.innerHTML = '<option value="">Select a category</option>';
                categories.forEach(category => {
                    const option = document.createElement('option');
                    option.value = category.id;
                    option.textContent = category.name;
                    categoriesSelect.appendChild(option);
                });
            } else {
                console.error('Error loading categories.');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    }

    loadCategories();

    // Search by Ingredient
    document.getElementById('search-ingredient-form').addEventListener('submit', async (e) => {
        e.preventDefault();
        const ingredient = document.getElementById('ingredient').value;

        try {
            const response = await fetch(`${apiUrl}/search?ingredient=${encodeURIComponent(ingredient)}`);
            if (response.ok) {
                const recipes = await response.json();
                const resultsList = document.getElementById('ingredient-results');
                resultsList.innerHTML = '';
                recipes.forEach(recipe => {
                    const li = document.createElement('li');
                    li.textContent = `Recipe ID: ${recipe.id}, Name: ${recipe.name}`;
                    resultsList.appendChild(li);
                });
            } else {
                console.error('Error searching recipes.');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    });

    // Search by Category
    document.getElementById('search-category-button').addEventListener('click', async () => {
        const categoryId = document.getElementById('categories').value;

        try {
            const response = await fetch(`${apiUrl}/by-category/${categoryId}`);
            if (response.ok) {
                const recipes = await response.json();
                const resultsList = document.getElementById('category-results');
                resultsList.innerHTML = '';
                recipes.forEach(recipe => {
                    const li = document.createElement('li');
                    li.textContent = `Recipe ID: ${recipe.id}, Name: ${recipe.name}`;
                    resultsList.appendChild(li);
                });
            } else {
                console.error('Error searching recipes.');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    });
});
