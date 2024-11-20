// JavaScript to toggle sections
function showSection(sectionId) {
    const sections = document.querySelectorAll("section");
    sections.forEach(section => {
        section.classList.remove('active');
    });

    // Show the targeted section
    const targetSection = document.getElementById(sectionId);
    if (targetSection) {
        targetSection.classList.add('active');
    }
}
document.addEventListener("DOMContentLoaded", function () {
    if (window.location.hash === "#stock") {
        // Ensure the stock section is visible
        document.getElementById("stock").classList.add("active");
    }
});