<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/mail-servlet", method="post">
        <table>
            <tr>
                <td>Send to:</td>
                <td>
                    <label>
                    <input type="text" name="to"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>Subject :</td>
                <td>
                    <label>
                    <input type="text" name="subject">
                    </label>
                </td>
            </tr>
        </table>
        <hr/>
        <label>
            <textarea type="text" name="body" rows="5" cols="45">Message text</textarea>
        </label>
        <br/><br/>
        <input type="submit" value="Send message!"/>
    </form>
</body>
</html>