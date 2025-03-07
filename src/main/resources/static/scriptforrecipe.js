


document.addEventListener("DOMContentLoaded", () => {
    const createRecipeForm = document.getElementById("create-recipe");
    createRecipeForm.addEventListener("submit", async (event) => {
        event.preventDefault();

        const recipeName = document.getElementById("recipe-name").value;
       const ingredents = document.getElementById("ingredients").value.split(',');
        const steps = document.getElementById("recipe-steps").value;
        const serves = document.getElementById("recipe-serves").value;
        const duration = document.getElementById("recipe-duration").value;
        const categoryId = document.getElementById("category").value;
        const status = document.getElementById("status");  // private --or-- public
        console.log
        const userId = sessionStorage.getItem("userId")
        console.log(userId)
        const recipeData = {
            recipeName: recipeName,
            ingredents,
            steps: steps,
            serves: serves,
            duration: duration,
            category: {
                categoryId: categoryId
            }
            // recipe_fk: sessionStorage.getItem("userId")
        };


        console.log(recipeData);
        try {
            const response = await fetch(`http://localhost:8090/user/${userId}/addRecipe`, {
                method: "PUT",
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
