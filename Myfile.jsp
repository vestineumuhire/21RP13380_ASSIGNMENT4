
<html>
<head>
<meta charset="UTF-8">
<title>21RP13380</title>
</head>
<body>
<h2>Enter your Username or Email</h2>
    <form action="Mycookieservlet" method="post">
        <label for="userInput">Username or Email:</label>
        <input type="text" id="userInput" name="userInput" value="<%= request.getAttribute("savedUser") != null ? request.getAttribute("savedUser") : "" %>" />
        <button type="submit">Submit</button>
    </form>

</body>
</html>
