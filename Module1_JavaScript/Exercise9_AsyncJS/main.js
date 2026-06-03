fetch(
"https://jsonplaceholder.typicode.com/posts"
)

.then(response =>
response.json()
)

.then(data => {

console.log(data);

})

.catch(error => {

console.log(error);

});

async function loadEvents() {

try {

document.getElementById(
"loader"
).innerText =
"Loading Events...";

const response =
await fetch(
"https://jsonplaceholder.typicode.com/posts"
);

const data =
await response.json();

console.log(data);

document.getElementById(
"loader"
).innerText =
"Events Loaded";

}

catch(error) {

console.log(error);

}

}

loadEvents();