let currentSlideIndex = 0;
const slides = document.querySelectorAll('.slide');
const maxItemsPerSlide = 3;

function showSlide(index) {
    // Hide all slides first
    slides.forEach((slide) => {
        slide.style.display = 'none';
    });

    // Calculate start and end index for the visible items
    const startIndex = (index + slides.length) % slides.length;
    const endIndex = (startIndex + maxItemsPerSlide) % slides.length;

    // Display the three items
    for (let i = 0; i < maxItemsPerSlide; i++) {
        const slideIndex = (startIndex + i) % slides.length;
        slides[slideIndex].style.display = 'block';
    }
}

function nextSlide() {
    currentSlideIndex = (currentSlideIndex + maxItemsPerSlide) % slides.length;
    showSlide(currentSlideIndex);
}

function prevSlide() {
    currentSlideIndex = (currentSlideIndex - maxItemsPerSlide + slides.length) % slides.length;
    showSlide(currentSlideIndex);
}

// Initial display of slides
showSlide(currentSlideIndex);


