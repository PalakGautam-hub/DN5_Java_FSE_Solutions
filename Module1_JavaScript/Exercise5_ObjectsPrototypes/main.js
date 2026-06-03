class Event {

    constructor(name, seats) {
        this.name = name;
        this.seats = seats;
    }

    checkAvailability() {
        return this.seats > 0;
    }
}

const event1 = new Event(
    "Workshop",
    30
);

console.log(
    event1.checkAvailability()
);

console.log(
    Object.entries(event1)
);