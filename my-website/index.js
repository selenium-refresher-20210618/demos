document.querySelector('#first-button').addEventListener('click', () => {
    alert('First button clicked!');
    const ourClosureFunction = insertParagraphElement('First button\'s data');
    setTimeout(ourClosureFunction, 3000);
});

document.querySelector('#second-button').addEventListener('click', () => {
    const ourClosureFunction = insertParagraphElement('Second button\'s data');
    setTimeout(ourClosureFunction, 7000);
});

function insertParagraphElement(customText) {
    return () => {
        const element = document.createElement('p');
        element.innerText = customText;
    
        document.querySelector('#data').appendChild(element);
    }
}