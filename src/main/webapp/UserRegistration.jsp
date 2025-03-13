<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial;
            padding: 20px;
        }
        label {
            font-weight: bold;
        }
        select, input {
            margin-bottom: 15px;
            padding: 6px;
            width: 250px;
        }
    </style>
    <script>
        // Dynamic Taluka Load
        function loadTalukas() {
            var district = document.getElementById("districtcode").value;
            var taluka = document.getElementById("talukacode");

            taluka.innerHTML = '<option value="">-- Select Taluka --</option>';

            if (district === "301") {
                taluka.innerHTML += "<option value='3001'>Bengaluru North</option>";
                taluka.innerHTML += "<option value='3002'>Bengaluru South</option>";
                taluka.innerHTML += "<option value='3003'>Yelahanka</option>";
            } else if (district === "302") {
                taluka.innerHTML += "<option value='3004'>Mysuru</option>";
                taluka.innerHTML += "<option value='3005'>Nanjangud</option>";
                taluka.innerHTML += "<option value='3006'>T. Narasipur</option>";
            } else if (district === "303") {
                taluka.innerHTML += "<option value='3007'>Dharwad</option>";
                taluka.innerHTML += "<option value='3008'>Hubli</option>";
                taluka.innerHTML += "<option value='3009'>Kalghatgi</option>";
            }
        }
    </script>
</head>
<body>

    <h2>User Registration</h2>
    <form method="post" action="/Highcourt/UserRegistration">
        <label>Username:</label><br>
        <input type="text" name="username" required><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br>

        <label>Mobile Number:</label><br>
        <input type="text" name="mobileno" pattern="[0-9]{10}" required><br>

        <label>Email:</label><br>
        <input type="email" name="email" required><br>

        <label>Section:</label><br>
        <select name="sectioncode" required>
            <option value="">-- Select Section --</option>
            <option value="1">Administration</option>
            <option value="2">Accounts</option>
            <option value="3">Training</option>
            <option value="4">HR</option>
        </select><br>

        <label>State:</label><br>
        <select name="statecode" required>
            <option value="3" selected>Karnataka</option>
        </select><br>

        <label>District:</label><br>
        <select name="districtcode" id="districtcode" onchange="loadTalukas()" required>
            <option value="">-- Select District --</option>
            <option value="301">Bengaluru Urban</option>
            <option value="302">Mysuru</option>
            <option value="303">Dharwad</option>
        </select><br>

        <label>Taluka:</label><br>
        <select name="talukacode" id="talukacode" required>
            <option value="">-- Select Taluka --</option>
        </select><br>

        <input type="submit" value="Success">
        <input type="reset" value="Cancel">
    </form>

</body>
</html>