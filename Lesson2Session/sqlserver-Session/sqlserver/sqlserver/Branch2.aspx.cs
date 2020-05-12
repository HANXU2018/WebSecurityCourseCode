using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Text;

namespace sqlserver
{
    public partial class Branch2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            StringBuilder SBTemp = new StringBuilder();
            if ((Session["BranchID"] == null) || int.Parse(Session["BranchID"].ToString()) != 2)
            {
                SBTemp.Length = 0;
                SBTemp.Append(@"<script type='text/JavaScript'>");
                SBTemp.Append(@"window.alert('教师页面，您无权访问本页面');");
                SBTemp.Append(@"self.location='default.aspx';");
                SBTemp.Append(@"</script>");
                //SBTemp.Append(@"");

                DisplayScript.InnerHtml = SBTemp.ToString();
            }

        }
    }
}