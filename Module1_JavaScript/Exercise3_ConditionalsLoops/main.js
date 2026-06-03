const events = [
    { name: "Music Fest", seats: 20, upcoming: true },
    { name: "Old Event", seats: 0, upcoming: false }
];

events.forEach(event => {
    if (event.upcoming && event.seats > 0) {
        console.log(event.name);
    }
});

try {
    let requestedSeats = 1;
    let availableSeats = 0;

    if (requestedSeats > availableSeats) {
        throw new Error("Registration Failed");
    }

} catch (err) {
    console.log(err.message);
}