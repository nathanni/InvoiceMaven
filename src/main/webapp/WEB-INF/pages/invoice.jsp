<%--
  Created by IntelliJ IDEA.
  User: nni
  Date: 12/11/2015
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/common.jsp" %>
<html>
<head>
    <title>Invoice</title>
</head>
<body>
<div class="container">
    <table class="table table-striped table-bordered">
        <tr>
            <td class="td logo"><img src="images/atrium_windows.jpeg" class="img-rounded" width="200" height="95"></td>
            <td class="td remit">
                <div class="div remit head">REMIT TO:</div>
                <div class="div remit text">
                    <div>C/O Bank of America Lockbox.</div>
                    <div>P.O.Box 404581</div>
                    <div>Atlanta, GA 30384-4581</div>
                    <div>336/764-6400</div>
                    <div>FAX 336/764-1501</div>
                </div>
            </td>
            <td class="td invoice">
                <div class="div invoice head">INVOICE</div>
                <div>
                    <table class="table-bordered" width="100%">
                        <%--<tr class="tr invoice head">--%>
                        <td>
                            <div class="div invoice tableheader">INVOICE NUMBER</div>
                            <div class="div invoice tablebody">04375096</div>
                        </td>
                        <td>
                            <div class="div invoice tableheader">DATE</div>
                            <div class="div invoice tablebody">11/22/15</div>
                        </td>
                        <td>
                            <div class="div invoice tableheader">PAGE</div>
                            <div class="div invoice tablebody">1</div>
                        </td>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td class="td zeropadding" colspan="2">
                <span class="span shiptag">&nbsp;TO&nbsp;</span>
            </td>
            <td class="td zeropadding">
                <span class="span shiptag">&nbsp;SHIP TO&nbsp;</span>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="td body1">
                <div class="div body1">
                    <span>ABC SUPPLY CO INC</span><br>
                    <span>PO BOX 8188</span><br>
                    <span>BERLIN           CT 06037</span>
                </div>
            </td>
            <td class="td body1">
                <div class="div body1">
                    <span>ABC SUPPLY #215 (ROCHESTER NY)</span><br>
                    <span>1450 LYELL AVE</span><br>
                    <span>ROCHESTER        NY 14606-213</span>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="td body1">
                <div class="div body1">
                    <span><b>JOB NAME: </b></span>
                    <span>189 DART APT2</span>
                </div>
            </td>
            <td class="td body1">
                <div class="div body1">
                    <span><b>CUSTOMER NUMBER: </b></span>
                    <span>AB0215</span>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <table class="table table-bordered table-striped">
                    <tr>
                        <td>
                            <div class="div tableheader">PAYMENT TERMS</div>
                            <div class="div tablebody">1.00 %</div>
                        </td>
                        <td>
                            <div class="div tableheader">CUSTOMER P.O. NUMBER</div>
                            <div class="div tablebody">935-5465896</div>
                        </td>
                        <td>
                            <div class="div tableheader">SALES ORDER NUMBER</div>
                            <div class="div tablebody">07210017</div>
                        </td>
                        <td>
                            <div class="div tableheader">BILL OF LADING</div>
                            <div class="div tablebody">1</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="div tableheader">SHIPPED VIA</div>
                            <div class="div tablebody">00/OUR TRUCK</div>
                        </td>
                        <td>
                            <div class="div tableheader">F.O.B</div>
                            <div class="div tablebody">00/0-DAY</div>
                        </td>
                        <td colspan="2">
                            <div class="div tablebody inquiries">FOR INQUIRIES:</div>
                            <div class="div tablebody inquiries">PRICING-INSIDE SALES</div>
                            <div class="div tablebody inquiries">UNIT DISCREPANCY-ACCOUNTING</div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <table  class="table table-bordered table-striped" >
                    <tr>
                        <td>123</td>
                        <td>123</td>
                        <td>123</td>
                        <td>123</td>
                        <td>123</td>
                        <td>123</td>
                        <td>123</td>
                    </tr>
                </table>
            </td>
        </tr>


        <%--<tr>--%>
        <%--<td colspan="3">--%>
        <%--<table border="1" cellpadding="10" cellspacing="0">--%>
        <%--<tr>--%>
        <%--<td>--%>
        <%--<table>--%>
        <%--<tr>--%>
        <%--<th>PAYMENT TERMS</th>--%>
        <%--<th>CUSTOMER P.O. NUMBER</th>--%>
        <%--<th>SALES ORDER</th>--%>
        <%--<th>BILL OF LADING</th>--%>
        <%--</tr>--%>
        <%--<tr>--%>
        <%--<td>VALUE</td>--%>
        <%--<td>VALUE</td>--%>
        <%--<td>VALUE</td>--%>
        <%--<td>VALUE</td>--%>
        <%--</tr>--%>
        <%--</table>--%>
        <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
        <%--<td>--%>
        <%--<table width="100%">--%>
        <%--<tr>--%>
        <%--<th>SHIPPED VIA</th>--%>
        <%--<th>F.O.B</th>--%>
        <%--</tr>--%>
        <%--<tr>--%>
        <%--<td>VALUE</td>--%>
        <%--<td>VALUE</td>--%>
        <%--</tr>--%>
        <%--</table>--%>
        <%--</td>--%>
        <%--<td>--%>
        <%--<div>FOR INQUIRIES:</div>--%>
        <%--<div>PRICING-SINSIDE SALES</div>--%>
        <%--<div>UNIT DISCREPANCY-ACCOUNTING</div>--%>
        <%--</td>--%>
        <%--</tr>--%>
        <%--</table>--%>
        <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
        <%--<td colspan="3">--%>
        <%--<table border="1" cellspacing="0"  cellpadding="10" width="100%">--%>
        <%--<tr>--%>
        <%--<th>PART NUMBER</th>--%>
        <%--<th>DESCRIPTION</th>--%>
        <%--<th>QTY ORDERED</th>--%>
        <%--<th>QTY SHIPPED</th>--%>
        <%--<th>UNIT PRICE</th>--%>
        <%--<th>DISCOUNT</th>--%>
        <%--<th>EXTENSION</th>--%>
        <%--</tr>--%>
        <%--<tr>--%>
        <%--<td>VALUE</td>--%>
        <%--<td>VALUE</td>--%>
        <%--<td>VALUE</td>--%>
        <%--<td>VALUE</td>--%>
        <%--<td>VALUE</td>--%>
        <%--<td>VALUE</td>--%>
        <%--<td>VALUE</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
        <%--<td>INVOICE TOTAL:</td>--%>
        <%--<td>VALUE</td>--%>
        <%--</tr>--%>
        <%--</table>--%>
        <%--</td>--%>
        <%--</tr>--%>
    </table>
</div>

</body>
</html>
