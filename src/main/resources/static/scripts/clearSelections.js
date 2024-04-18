function clearSelections() {
    // Get all checkboxes and uncheck them
    const checkboxes = document.querySelectorAll('input[type="checkbox"]');
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = false;
    });

    // Clear the name input
    document.querySelector('input[type="text"]').value = '';
}
