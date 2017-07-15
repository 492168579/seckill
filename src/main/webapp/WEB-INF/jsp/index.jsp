<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file ="common/tag.jsp"%>
<!doctype html>
<!--[if IE 8]>         <html class="ie8"> <![endif]-->
<!--[if IE 9]>         <html class="ie9"> <![endif]-->
<!--[if gt IE 9]><!--> <html> <!--<![endif]-->
    <head>
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>微信后台管理系统</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <!--<link rel="shortcut icon" href="favicon.ico">-->
        <base href=" <%=basePath%>">
        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/bootstrap/css/iriy-admin.min.css">
        <link rel="stylesheet" href="resources/demo/css/demo.css">
        <link rel="stylesheet" href="resources/bootstrap/assets/font-awesome/css/font-awesome.css">
        <link rel="stylesheet" href="resources/bootstrap/assets/plugins/jquery-jvectormap/jquery-jvectormap-1.2.2.css">
        <link rel="stylesheet" href="resources/bootstrap/css/plugins/rickshaw.min.css">
        <link rel="stylesheet" href="resources/bootstrap/css/plugins/morris.min.css"><!--[if lt IE 9]>
        <script src="resources/bootstrap/assets/libs/html5shiv/html5shiv.min.js"></script>
        <script src="resources/bootstrap/assets/libs/respond/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <header>
            <nav class="navbar navbar-default navbar-static-top no-margin" role="navigation">
                <div class="navbar-brand-group">
                    <a class="navbar-sidebar-toggle navbar-link" data-sidebar-toggle>
                        <i class="fa fa-lg fa-fw fa-bars"></i>
                    </a>
                    <a class="navbar-brand hidden-xxs" href="index.html">
                        <span class="sc-visible">
                            I
                        </span>
                        <span class="sc-hidden">
                            <span class="semi-bold"></span>
                        </span>
                    </a>
                </div>
                <ul class="nav navbar-nav navbar-nav-expanded pull-right margin-md-right">
                    <li class="dropdown">
                        <a data-toggle="dropdown" class=" btn-mini dropdown-toggle" href="javascript:;">
                            <span class="hidden-xs">系统操作</span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu pull-right-xs">
                            <li><a href="pages-sign-in.html">修改密码</a></li>
                            <li><a href="pages-sign-in.html">退出系统</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </header>
        <div class="page-wrapper">
            <aside class="sidebar sidebar-default">
                <div class="sidebar-profile">
                    <img class="img-circle profile-image" src="resources/demo/images/profile.jpg">

                    <div class="profile-body">
                        <h4>Marlon Brice</h4>
                    </div>
                </div>
                <nav>
                    <h5 class="sidebar-header"></h5>
                    <ul class="nav nav-pills nav-stacked">
                        <li class="active open">
                            <a href="index.html" title="Dashboard">
                                <i class="fa fa-lg fa-fw fa-home"></i> 首页
                            </a>
                        </li>
                        <c:forEach items="${roleDtos}" var="roleDto">
                        <li class="nav-dropdown">
                            <a href="#" title="Menu Levels">
                              <i class="fa fa-lg fa-fw fa-folder-open"></i>${roleDto.roleName}
                              </a>
                              <ul class="nav-sub">
                                    <c:forEach items="${roleDto.functionDtos}" var="functionDto">
                                      <li>
                                          <a href="${functionDto.functionUrl}" title="${functionDto.functionName}">
                                              <i class="fa fa-fw fa-file"></i>
                                              ${functionDto.functionName}
                                          </a>
                                      </li>
                                  </c:forEach>
                              </ul>
                        </li>
                        </c:forEach>
                    </ul>
                </nav>
            </aside>
         </div>
    </body>
    <script src="resources/bootstrap/assets/libs/jquery/jquery.min.js"></script>
    <script src="resources/bootstrap/assets/bs3/js/bootstrap.min.js"></script>
    <script src="resources/bootstrap/assets/plugins/jquery-navgoco/jquery.navgoco.js"></script>
    <script src="resources/bootstrap/js/main.js"></script>

    <!--[if lt IE 9]>
    <script src="resources/bootstrap/assets/plugins/flot/excanvas.min.js"></script>
    <![endif]-->
    <script src="resources/bootstrap/assets/plugins/jquery-sparkline/jquery.sparkline.js"></script>
    <script src="resources/demo/js/demo.js"></script>

    <script src="resources/bootstrap//assets/plugins/jquery-jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="resources/bootstrap//assets/plugins/jquery-jvectormap/maps/world_mill_en.js"></script>

    <!--[if gte IE 9]>-->
    <script src="resources/bootstrap//assets/plugins/rickshaw/js/vendor/d3.v3.js"></script>
    <script src="resources/bootstrap//assets/plugins/rickshaw/rickshaw.min.js"></script>
    <!--<![endif]-->

    <script src="resources/bootstrap//assets/plugins/flot/jquery.flot.js"></script>
    <script src="resources/bootstrap//assets/plugins/flot/jquery.flot.resize.js"></script>
    <script src="resources/bootstrap//assets/plugins/raphael/raphael-min.js"></script>
    <script src="resources/bootstrap//assets/plugins/morris/morris.min.js"></script>
    <script src="resources/demo/js/dashboard.js"></script>
</html>
