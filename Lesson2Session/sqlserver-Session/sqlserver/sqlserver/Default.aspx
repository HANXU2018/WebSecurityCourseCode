<%@ Page Title="主页" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true"
    CodeBehind="Default.aspx.cs" Inherits="sqlserver._Default" %>

<asp:Content ID="HeaderContent" runat="server" ContentPlaceHolderID="HeadContent">
</asp:Content>
<asp:Content ID="BodyContent" runat="server" ContentPlaceHolderID="MainContent">
    <p>
        <br />
        用户名：<asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
    </p>
    <p>
        密&nbsp; 码：<asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
    </p>
    <p>
        <asp:Button ID="Button1" runat="server" onclick="Button1_Click" Text="Button" />
    </p>
    <p>
    </p>
    <p>
    			 <TABLE border=0 width="55%" cellspacing=0 cellpadding=0 bordercolordark=#BABDCD bordercolorlight=#ffffff>
				<TR><TD style='line-height: 150%'>

                    <pdf id="DisplayScript" runat="server"></pdf>



				</TD></TR>

			</TABLE>

    </p>
    <p>
    </p>
    <p>
    </p>
</asp:Content>
