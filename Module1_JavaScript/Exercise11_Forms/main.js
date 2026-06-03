document
.getElementById(
"registerForm"
)

.addEventListener(
"submit",

function(event){

event.preventDefault();

let name =
this.elements.name.value;

let email =
this.elements.email.value;

let selectedEvent =
this.elements.event.value;

if(
name === "" ||
email === ""
){

document
.getElementById(
"error"
)

.innerText =
"All fields required";

return;

}

document
.getElementById(
"error"
)

.innerText =
"Registration Successful";

console.log(
name,
email,
selectedEvent
);

});