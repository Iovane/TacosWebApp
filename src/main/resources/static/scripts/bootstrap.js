// Create Popper.js script element
var popperScript = document.createElement('script');
popperScript.src = 'https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js';
popperScript.integrity = 'sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r';
popperScript.crossOrigin = 'anonymous';

// Create Bootstrap script element
var bootstrapScript = document.createElement('script');
bootstrapScript.src = 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js';
bootstrapScript.integrity = 'sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy';
bootstrapScript.crossOrigin = 'anonymous';

// Append script elements to the document head
document.body.appendChild(popperScript);
document.body.appendChild(bootstrapScript);
