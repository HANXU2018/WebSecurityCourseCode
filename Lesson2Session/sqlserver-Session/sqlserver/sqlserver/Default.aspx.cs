using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Text;

namespace sqlserver
{
    public partial class _Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Session["BranchID"] = 0;
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            StringBuilder SBTemp = new StringBuilder();
            string LoginName = TextBox1.Text;
            string Password = TextBox2.Text;
            string connString = "server=(local);DaTABASE=mySample;UID=sa;PWD=123abc!@#";
            SqlConnection SQLConn = new SqlConnection(connString);
            SQLConn.Open();
                

            //查找管理员
            string sql = "SELECT * FROM UserTable WHERE LoginName='" + LoginName + "' and Password='" + Password + "'";
            SqlCommand SQLCmd = new SqlCommand(sql, SQLConn);
            SqlDataReader SQLReader = SQLCmd.ExecuteReader();
            if (SQLReader.Read())
            {
                SBTemp.Length = 0;
                SBTemp.Append(@"<script type='text/JavaScript'>");
                SBTemp.Append(@"window.alert('" + LoginName + "(" + SQLReader["TrueName"].ToString() + ")登录成功 ！');");
                SBTemp.Append(@"</script>");
                //SBTemp.Append(@"");

                DisplayScript.InnerHtml = SBTemp.ToString();
                Session["TrueName"] = SQLReader["TrueName"].ToString();
                Session["BranchID"] = SQLReader["BranchID"].ToString();
                Response.Redirect("Branch" + SQLReader["BranchID"].ToString() + ".aspx");
            }
            else
            {
                SBTemp.Length = 0;
                SBTemp.Append(@"<script type='text/JavaScript'>");
                SBTemp.Append(@"window.alert('" + LoginName + "登录失败 ！');");
                SBTemp.Append(@"</script>");
                //SBTemp.Append(@"");

                DisplayScript.InnerHtml = SBTemp.ToString();

            }
            SQLReader.Close();
            SQLConn.Close();
        }

    }
}
