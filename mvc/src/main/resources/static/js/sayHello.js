function createCalledName() {
    var url = "/person/calledName";
    var person = {
        "name" : document.getElementById("name").value,
        "vorname" : document.getElementById("vorname").value
    };
    fetch(url, {
        method: "POST", // *GET, POST, PUT, DELETE, etc.
        mode: "same-origin", // no-cors, cors, *same-origin
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        //credentials: "same-origin", // include, same-origin, *omit
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        redirect: "follow", // manual, *follow, error
        referrer: "no-referrer", // no-referrer, *client
        body: JSON.stringify(person) // body data type must match "Content-Type" header
    })
        .then(response => response.json())
        .catch(error => console.error("Fetch Error =\n", error))
        .then(person => setCalledName(person));
}

function setCalledName(person) {
    console.log('Success:', person);
    document.getElementById("calledName").value = person.calledName;
}