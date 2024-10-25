const inputs = document.querySelectorAll("input");
const labels = document.querySelectorAll("label");
inputs.forEach(input => {
    const label = document.createElement("label");
    let contentName = input.getAttribute("id");
    label.textContent = contentName + ": "; 
    input.parentNode.insertBefore(label, input);
});

function onRydBtnClick(event) {
    inputs.forEach(input => {
        let inputValue = input.value;

        labels.forEach(label => {
            if (label.textContent === input.getAttribute("id") + ": ") {
                label.textContent = inputValue;
            }
        });
    });
}

