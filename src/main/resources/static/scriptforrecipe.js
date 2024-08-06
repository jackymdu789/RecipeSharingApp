document.addEventListener("DOMContentLoaded", () => {
    const createRecipeForm = document.getElementById("create-recipe");
    createRecipeForm.addEventListener("submit", async (event) => {
        event.preventDefault();
        const recipeName = document.getElementById("recipe-name").value;
        const ingredients = document.getElementById("ingredients").value.split(',');
        const steps = document.getElementById("recipe-steps").value;
        const serves = document.getElementById("recipe-serves").value;
        const duration = document.getElementById("recipe-duration").value;
        const categoryId = document.getElementById("category").value;
        const dietaryId = document.getElementById("dietary").value;
        const imageUrl = document.getElementById("image-url").value; 
        const userId = sessionStorage.getItem("userId")
        console.log(userId)
        const recipeData = {
            recipeName: recipeName,
            ingredients,
            steps: steps,
            serves: serves,
            duration: duration,
            category: {
                categoryId: categoryId
            },
            dietary:{
                dietaryId: dietaryId
            },
            imageUrl: imageUrl 

        };
        console.log(recipeData);
        try {
            const response = await fetch(`http://localhost:8090/recipe/${userId}/createRecipe`, {
                method: "post",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(recipeData)
            });
            if (response.ok) {
                const result = await response.text();
                 console.log('Recipe created successfully:', result);
                window.location.href = `home.html`;
            } 
             
            else {
                const errorText = await response.text();
                console.error('Error:', response.statusText, errorText);
            }
           
        } catch (error) {
            // console.error('Error:', error);
        }
    });
});
