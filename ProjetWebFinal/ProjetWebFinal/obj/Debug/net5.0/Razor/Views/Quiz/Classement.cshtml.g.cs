#pragma checksum "C:\Users\maude\Desktop\École 2021-2022\ProjetServiceSession\ProjetWebFinal\ProjetWebFinal\Views\Quiz\Classement.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "3ae323e8b242eac68c1074c0ae1e42c8e50d476a"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Quiz_Classement), @"mvc.1.0.view", @"/Views/Quiz/Classement.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "C:\Users\maude\Desktop\École 2021-2022\ProjetServiceSession\ProjetWebFinal\ProjetWebFinal\Views\_ViewImports.cshtml"
using ProjetWebFinal;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\maude\Desktop\École 2021-2022\ProjetServiceSession\ProjetWebFinal\ProjetWebFinal\Views\_ViewImports.cshtml"
using ProjetWebFinal.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"3ae323e8b242eac68c1074c0ae1e42c8e50d476a", @"/Views/Quiz/Classement.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"43a0a4a6d77d61de313209d37a79db17a724b815", @"/Views/_ViewImports.cshtml")]
    public class Views_Quiz_Classement : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<dynamic>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("<table>\r\n    <tr>\r\n        <th>NOM</th>\r\n        <th></th>\r\n        <th>POINTS</th>\r\n\r\n    </tr>\r\n");
#nullable restore
#line 8 "C:\Users\maude\Desktop\École 2021-2022\ProjetServiceSession\ProjetWebFinal\ProjetWebFinal\Views\Quiz\Classement.cshtml"
       foreach (var j in ViewBag.lesJoueurs) {





#line default
#line hidden
#nullable disable
            WriteLiteral("        <tr>\r\n            <td>");
#nullable restore
#line 14 "C:\Users\maude\Desktop\École 2021-2022\ProjetServiceSession\ProjetWebFinal\ProjetWebFinal\Views\Quiz\Classement.cshtml"
           Write(j.nom_joueur);

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\r\n            <td></td>\r\n            <td>");
#nullable restore
#line 16 "C:\Users\maude\Desktop\École 2021-2022\ProjetServiceSession\ProjetWebFinal\ProjetWebFinal\Views\Quiz\Classement.cshtml"
           Write(j.score_art);

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\r\n\r\n        </tr>\r\n");
#nullable restore
#line 19 "C:\Users\maude\Desktop\École 2021-2022\ProjetServiceSession\ProjetWebFinal\ProjetWebFinal\Views\Quiz\Classement.cshtml"

                }
    

#line default
#line hidden
#nullable disable
            WriteLiteral("    \r\n</table>\r\n");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<dynamic> Html { get; private set; }
    }
}
#pragma warning restore 1591
