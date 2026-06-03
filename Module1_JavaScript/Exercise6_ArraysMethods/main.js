let events = [];

events.push("Music Festival");
events.push("Workshop");
events.push("Music Concert");

const musicEvents =
events.filter(event =>
    event.includes("Music")
);

console.log(musicEvents);

const cards =
events.map(event =>
    `Workshop on ${event}`
);

console.log(cards);