// Toggle Search Modal
const searchToggle = document.getElementById('searchToggle');
const searchModal = document.getElementById('searchModal');
const closeSearch = document.getElementById('closeSearch');

searchToggle.addEventListener('click', () => {
    searchModal.classList.add('open');
});

closeSearch.addEventListener('click', () => {
    searchModal.classList.remove('open');
});

// Close modal on outside click
searchModal.addEventListener('click', (e) => {
    if (e.target === searchModal) {
        searchModal.classList.remove('open');
    }
});
  