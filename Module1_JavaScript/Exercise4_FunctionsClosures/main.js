function addEvent(name) {
    console.log(`${name} added`);
}

function registerUser(user) {
    console.log(`${user} registered`);
}

function filterEventsByCategory(events, callback) {
    return events.filter(callback);
}

function registrationTracker() {
    let count = 0;

    return function () {
        count++;
        return count;
    };
}

const counter = registrationTracker();

console.log(counter());
console.log(counter());

const events = [
    { name: "Music Fest", category: "Music" },
    { name: "Workshop", category: "Education" }
];

const result = filterEventsByCategory(
    events,
    e => e.category === "Music"
);

console.log(result);