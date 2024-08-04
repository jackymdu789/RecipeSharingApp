document.addEventListener('DOMContentLoaded', () => {
    const registerForm = document.getElementById('registerForm');
    const loginForm = document.getElementById('loginForm');

    // Handle registration form submission
    registerForm.querySelector('form').addEventListener('submit', async (event) => {
        event.preventDefault(); // Prevent the default form submission

        const username = document.getElementById('registerUsername').value;
        const email = document.getElementById('registerEmail').value;
        const password = document.getElementById('registerPassword').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        // Basic validation for passwords
        if (password !== confirmPassword) {
            alert('Passwords do not match!');
            return;
        }

        try {
            const response = await fetch('http://localhost:8090/newuser', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    username: username,
                    email: email,
                    password: password
                })
            });

            const result = await response.text();
            
            if (response.ok) {
                alert(result); // Display success message
                // Redirect to another page on successful login
                window.location.href = 'home.html'; // Change this to your desired URL
            } else {
                alert(result); // Display error message
            }
        } catch (error) {
            console.error('Error:', error);
            alert('An error occurred. Please try again.');
        }
    });

    // Handle login form submission
    loginForm.querySelector('form').addEventListener('submit', async (event) => {
        event.preventDefault(); // Prevent the default form submission

        const username = document.getElementById('loginUsername').value;
        const password = document.getElementById('loginPassword').value;

        try {
            const response = await fetch('http://localhost:8090/validateuser', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    username: username,
                    password: password
                })
            });

            const result = await response.text();
            
            if (response.ok) {
                alert(result); // Display success message or handle redirection
                window.location.href = 'home.html';
            } else {
                alert(result); // Display error message
            }
        } catch (error) {
            console.error('Error:', error);
            alert('An error occurred. Please try again.');
        }
    });

    // Show registration form
    window.showRegisterForm = function() {
        registerForm.classList.add('active');
        loginForm.classList.remove('active');
    };

    // Show login form
    window.showLoginForm = function() {
        registerForm.classList.remove('active');
        loginForm.classList.add('active');
    };
});
