// Ensures the document is fully loaded before running scripts
$(function () {
    hentAlle(); // Fetches all tickets when the page loads
    // Attaches event handlers, if needed
    //  a different button or other event is needed, you can uncomment and use it
    // $("#someButton").click(kjopBillett);
});

// Function to purchase a ticket
function kjopBillett() {
    // Create an object with ticket data
    const billett = {
        velgfilm: $("#filmene").val(), // Correct ID
        antall: $("#antall").val(),
        fornavn: $("#fornavn").val(),
        etternavn: $("#etternavn").val(),
        telefonnr: $("#telefonnr").val(),
        epost: $("#epost").val()
    };

    // Send the POST request to the backend
    $.post("/lagre", billett, function () {
        hentAlle(); // Refresh the list of tickets after saving
    }).fail(function (error) { // Error handling
        console.error("Failed to save ticket:", error);
    });
}

// Function to fetch all tickets
function hentAlle() {
    $.get("/hentAlle", function (billetter) {
        formaterData(billetter); // Formats and displays the tickets
    });
}
// Function to format the fetched ticket data
function formaterData(billetter) {
    let ut = "<table class='table table-striped table-bordered'><tr>" +
        "<th>Valgt film</th>" +
        "<th>Antall billetter</th>" +
        "<th>Fornavn</th>" +
        "<th>Etternavn</th>" +
        "<th>Telefonnr</th>" +
        "<th>E-post</th></tr>";

    // Loops through the tickets and adds them to the table
    for (const billett of billetter) {
        ut += "<tr>" +
            "<td>" + billett.velgfilm + "</td>" +
            "<td>" + billett.antall + "</td>" +
            "<td>" + billett.fornavn + "</td>" +
            "<td>" + billett.etternavn + "</td>" +
            "<td>" + billett.telefonnr + "</td>" +
            "<td>" + billett.epost + "</td></tr>";
    }

    ut += "</table>"; // Closes the table structure
    $("#billettene").html(ut); // Displays the table in the correct div
}

// Function to delete all tickets
function slettBillett() {
    const ok = confirm("Sikker på at du vil slette alle?"); // Confirmation prompt
    if (ok) { // If confirmed
        $.get("/slettAlle", function () {
            hentAlle(); // Refreshes the ticket list after deletion
        });
    }
}