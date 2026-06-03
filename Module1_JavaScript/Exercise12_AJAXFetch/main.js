function submitData() {

document
.getElementById(
"status"
)

.innerText =
"Submitting...";

setTimeout(() => {

fetch(
"https://jsonplaceholder.typicode.com/posts",
{

method: "POST",

headers: {
"Content-Type":
"application/json"
},

body: JSON.stringify({

name: "Palak",

event: "Workshop"

})

}

)

.then(response =>
response.json()
)

.then(data => {

document
.getElementById(
"status"
)

.innerText =
"Registration Successful";

console.log(data);

})

.catch(error => {

document
.getElementById(
"status"
)

.innerText =
"Registration Failed";

console.log(error);

});

},2000);

}