<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Branch2.aspx.cs" Inherits="sqlserver.Branch2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    我是<%if (Session["TrueName"] != null) Response.Write(Session["TrueName"].ToString());%>
    <pdf id="DisplayScript" runat="server"></pdf>
    </div>
    </form>
</body>
</html>
