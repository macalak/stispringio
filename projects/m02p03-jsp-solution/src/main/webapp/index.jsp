<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Quotes</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
    <h1>Quotes</h1>

    <%
        String[] sentences = {
            "The most radical revolutionary will become a conservative the day after the revolution.",
            "The brain is a wonderful organ. It starts working the moment you get up in the morning and does not stop until you get into the office.",
            "The hardest thing in the world to understand is taxes.",
            "I have enough money to last me the rest of my life, unless I buy something."
        };
        int index = (int) (Math.random() * sentences.length);
        out.write(sentences[index]);
    %>

</body>
</html>
