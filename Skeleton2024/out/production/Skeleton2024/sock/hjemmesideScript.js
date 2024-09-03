
document.addEventListener("DOMContentLoaded", () => {
    const button = document.getElementById("storKnap");

    button.addEventListener("click", () => {
        const image = document.getElementById("billede");

        if(image)
        {
            image.remove();
        }
    });
});