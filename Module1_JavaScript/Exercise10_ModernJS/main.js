const event = {

name: "Workshop",

date: "20 June 2026",

seats: 50

};

const {
name,
date,
seats
} = event;

console.log(
name,
date,
seats
);

function register(
user = "Guest"
) {

console.log(
`Welcome ${user}`
);

}

register();

const events =
["Music","Sports"];

const clonedEvents =
[...events];

console.log(
clonedEvents
);