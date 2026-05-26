function calculateResult() {

    let n = parseInt(document.getElementById("subjects").value);

    if (n <= 0 || isNaN(n)) {
        document.getElementById("result").innerHTML =
            "Please enter a valid number of subjects.";
        return;
    }

    let total = 0;

    for (let i = 1; i <= n; i++) {

        let marks = parseFloat(
            prompt("Enter marks for Subject " + i)
        );

        total = total + marks;
    }

    let average = total / n;

    let grade;

    if (average >= 90) {
        grade = "A+";
    }
    else if (average >= 75) {
        grade = "A";
    }
    else if (average >= 60) {
        grade = "B";
    }
    else if (average >= 50) {
        grade = "C";
    }
    else {
        grade = "F";
    }

    document.getElementById("result").innerHTML =
        `
        Total Marks: ${total} <br>
        Average Marks: ${average.toFixed(2)} <br>
        Grade: ${grade}
        `;
}