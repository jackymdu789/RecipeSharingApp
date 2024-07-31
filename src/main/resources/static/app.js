document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById('login');
    const createRecipeForm = document.getElementById('create-recipe');
    const recipeList = document.getElementById('recipe-list');
    let userId;
    loginForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const userName = document.getElementById('username').value;
        const userEmail = document.getElementById('email').value;
        const userPassword = document.getElementById('password').value;
    
        try {
            const response = await fetch('http://localhost:8090/user', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ userName, userEmail, userPassword })
            });
    
            // Check if the response is ok
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
    
            // Check if the response has content
            // const text = await response.text();
            // if (!text) {
            //     throw new Error('Response body is empty.');
            // }
    
            // Parse JSON only if response text is available
            // const data = JSON.parse(text);
            // userId = data.id;
            // console.log(data);
            // document.getElementById('login-form').style.display = 'none';
            // document.getElementById('recipe-form').style.display = 'block';
            // fetchRecipes();
            window.location.href = "recipe.html";
        } catch (error) {
            console.error('Error:', error);
        }
    });
    
    

//     createRecipeForm.addEventListener('submit', (e) => {
//         e.preventDefault();
//         const name = document.getElementById('recipe-name').value;
//         const description = document.getElementById('recipe-description').value;

//         fetch('http://localhost:8080/api/recipes/create', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify({ name, description, user: { id: userId } })
//         })
//         .then(response => response.json())
//         .then(data => {
//             fetchRecipes();
//         })
//         .catch(error => console.error('Error:', error));
//     });
//     function fetchRecipes() {
//         fetch('http://localhost:8080/api/recipes')
//             .then(response => response.json())
//             .then(data => {
//                 recipeList.innerHTML = '';
//                 data.forEach(recipe => {
//                     const li = document.createElement('li');
//                     li.textContent = recipe.name;
//                     recipeList.appendChild(li);
//                 });
//             })
//             .catch(error => console.error('Error:', error));
//     }
});