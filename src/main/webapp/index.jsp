<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html class="no-js">
    <head>
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>登录</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <!--<link rel="shortcut icon" href="favicon.ico">-->
        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="stylesheet" href="<%=basePath%>resources/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=basePath%>resources/bootstrap/css/iriy-admin.min.css">
        <link rel="stylesheet" href="<%=basePath%>resources/demo/css/demo.css">
        <link rel="stylesheet" href="<%=basePath%>resources/bootstrap/assets/font-awesome/css/font-awesome.css">
    </head>
    <body class="body-sign-in">
    <div class="container">
        <div class="panel panel-default form-container">
            <div class="panel-body">
                <form  method ='post'  action='<%=basePath%>/login/in'>
                       <h3 class="text-center margin-xl-bottom">微信管理系统</h3>
                       ${message}
                       <div class="form-group text-center">
                           <input type="text" class="form-control input-lg"    name="adminAccount"  placeholder="请输入用户名...">
                       </div>
                       <div class="form-group text-center">
                           <input type="password" class="form-control input-lg" name="adminPsw"  placeholder="请输入密码...">
                       </div>
                        <input type="submit" class="btn btn-primary btn-block btn-lg" value="登录"/>
                </form>
            </div>
             <div class="panel-body text-center">
                        <div class="margin-bottom">
                            <a class="text-muted text-underline" href="javascript:;">忘记密码</a>
                        </div>
             </div>
        </div>
    </div>
</body>
</html>
