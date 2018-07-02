<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<table cellpadding="0" cellspacing="0" border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>gender</th>
        <th>address</th>
    </tr>
    <#list all as user>
        <tr>
            <td>${(user.id)!''}</td>
            <td>${(user.name)!''}</td>
            <#assign gender = (user.gender?c)!''/>
            <script>
                console.log("${gender}");
            </script>
            <#if gender = 'true'>
                <td>女</td>
            <#else >
                <td>男</td>
            </#if>
            <td>${(user.address)!''}</td>
        </tr>
    </#list>

</table>
</body>
</html>