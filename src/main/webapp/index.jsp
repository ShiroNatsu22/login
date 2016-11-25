<html>
<head>
    <title>File Uploading Form</title>

</head>

<body>
<%
Cookie[] cookie = request.getCookies();
String putCookie = "";
%>

<% if( session.getAttribute("error") != null){
    out.print(session.getAttribute("error"));
    session.removeAttribute("error");
}


    for(Cookie c : cookie){
        if(c.getName().equals("email")){
            putCookie = c.getValue();

        }
    }
%>




<form action="Login" method="POST">

    Email: <input type="email" name="email" value="<%=putCookie%>"/>
    <br />
    Password: <input type="password" name="pass" /><br>
    <input type="checkbox" name="check" value="cookie"> Recorda
    <input type="submit" value="Submit" />

</form>
</body>
</html>



