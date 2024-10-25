
const bodyNode = document.body;

for (let element of bodyNode.childNodes) {
    if (element.nodeType === Node.ELEMENT_NODE && element.tagName.toLowerCase() === 'h1') {
        for (let child of element.childNodes) {
            if (child.nodeType === Node.TEXT_NODE) {
                const span = document.createElement('span');
                span.style.color = 'brown';
                span.textContent = child.nodeValue;
                child.parentNode.replaceChild(span, child);
            }
        }
    }
}

document.addEventListener("DOMContentLoaded", () => {
    const listItems = document.querySelectorAll("ul li");
    const listParagraphs = document.querySelectorAll("p");
    const elements = document.body.children;
    let afterH1 = false; 
    let counter = 0; 
    afterH12 = false;
    


    listParagraphs.forEach((element, index) => {
        element.style.color = "red";
})

for (let element of elements) {
    if (element.tagName.toLowerCase() === "h1") {
        afterH1 = true; 
        counter = 0; 
    } else if (afterH1) {
        counter++;
        if (counter % 2 === 0) {
            element.style.color = "brown";
        }
    }
}



    listItems.forEach((element, index) => {
        if (index % 2 !== 0) {
            element.style.backgroundColor = "grey";
        }
    });

    for (let element of elements) {
        if (element.tagName.toLowerCase() === "h1") {
            afterH12 = true; 
            counter2 = 0;
        } else if (afterH12) {
            counter2++; 
            if (counter2 === 1) {
                const newH2 = document.createElement("h2");
                newH2.innerHTML = element.innerHTML; 
                element.replaceWith(newH2);
                afterH12 = false;
            }
        }
    }
});

