const container =
document.querySelector("#eventContainer");

const events = [
    "Music Festival",
    "Coding Workshop",
    "Sports Meet"
];

events.forEach(event => {

    const card =
    document.createElement("div");

    card.innerText = event;

    card.style.border =
    "1px solid black";

    card.style.padding = "10px";

    card.style.margin = "5px";

    container.appendChild(card);

});