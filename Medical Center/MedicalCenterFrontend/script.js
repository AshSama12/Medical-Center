// Simulate login functionality
document.getElementById("loginForm")?.addEventListener("submit", function (event) {
    event.preventDefault();
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    if (username === "admin" && password === "admin123") {
        window.location.href = "home.html";
    } else {
        alert("Invalid credentials. Please try again.");
    }
});

function searchPatient() {
    const dob = document.getElementById("searchPatientDOB").value;
    alert(`Searching for patients born on ${dob}...`);
}

function searchDrug() {
    const drugName = document.getElementById("searchDrug").value;
    alert(`Searching for drug: ${drugName}...`);
}
