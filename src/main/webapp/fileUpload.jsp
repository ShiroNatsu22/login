<html>
<head>
    <title>File Uploading Form</title>

</head>

<body>

<h3>File Upload:</h3>


<p> Benvingut <% out.print(session.getAttribute("name")); %></p>


Select a file to upload: <br />

<form action="UploadServlet" method="POST"
      enctype="multipart/form-data">
    <input type="file" name="file" size="100" />
    <br />
    <input type="submit" value="Upload File" />
</form>

<form action="LogOut">
    <input type="submit" value="TancaSessio" />
</form>
</body>
</html>

