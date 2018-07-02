<#assign path = (Request.request.getContextPath())!"">
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${path}/">
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="jquery.min.js"></script>
</head>
<body>
<form id="form" action="/user">
    <#if user?exists>
    <h4>修改</h4>
        id:<input value="${user.id}" name="id"><br>
        <script>
            $("#form").attr("method", "post");
        </script>
    <#else>
        <input type="hidden" value="PUT" name="_method"/>
    <h4>添加</h4>
    </#if>
    name:<input value="${(user.name)!''}" name="name"><br>
    gender:

        <select name="gender" style="width: 100px">
            <option value="true">女</option>
            <option value="false">男</option>
        </select><br/>
        <script>

            if(eval("${(user.gender?c)!''}"))
                $("option[value='true']").attr("selected", "selected");
            else
                $("option[value='false']").attr("selected", "selected");
        </script>
    address:<input value="${(user.address)!''}" name="address"><br>
        <input type='submit' value='提交'/>
</form>
<script>
/*    $("#form").submit(function () {
        console.log($("[name='gender']").val());
        return false;
    });*/
</script>
</body>
</html>