<!DOCTYPE html>
<html>
<head>
	<title>Event Handling</title>
	<style>
		.red-color {
			color: red;
		}
	</style>
</head>
<body>
	<h1 id='heading'>Hover Over Me</h1>

	<button id="dateButton">Date and Time</button>

	<script type="text/javascript">
		const heading = document.getElementById("heading");

		// (i) Mouseover and Mouseout event handling
		heading.addEventListener("mouseover", function() {
			heading.classList.add("red-color");
		});

		heading.addEventListener("mouseout", function() {
			heading.classList.remove("red-color");
		});

		// (ii) Keydown event handling
		document.addEventListener("keydown", function(event) {
			const vowelKeys = ['a', 'e', 'i', 'o', 'u'];

			if (vowelKeys.includes(event.key)) {
				alert("Vowel is pressed");
			}
		});

		const dateButton = document.getElementById('dateButton');

		// (iii) Click event handling for Date and Time button
		dateButton.addEventListener("click", function() {
			const currentDate = new Date();
			const formattedDate = currentDate.toLocaleString();

			alert("Current Date and Time: " + formattedDate);
		});
	</script>
</body>
</html>
