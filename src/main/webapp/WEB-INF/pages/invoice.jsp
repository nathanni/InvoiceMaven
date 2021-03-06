<%--
  Created by IntelliJ IDEA.
  User: nni
  Date: 12/11/2015
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/commons/common.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Invoice</title>
</head>
<body>


<div class="container">


    <table class="table">

        <%--if from get(pdf side) method,  hide header--%>
        <c:if test="${empty requestScope.hideHeader}">
            <div class="panel-heading">

                <div class="panel-title" align="right">
                    <a href="index.jsp" class="btn btn-default" role="button" aria-label="Left Align">
                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                    </a>
                    <a href="invoicetopdf.do?invoice=${requestScope.header.invoice}&invoicedate=${requestScope.header.invoiceDate}">
                        <button type="button" class="btn btn-success"
                                href=>Download PDF
                        </button>
                    </a>
                </div>
            </div>
            <tr>
                <td class="td logo"><img src="images/atrium_windows.jpeg" class="img-rounded" width="220" height="110">
                </td>

                <c:choose>
                    <c:when test="${requestScope.remit == 1}">
                        <td class="td remit" id="txremit">
                            <div class="div remit head">REMIT TO:</div>
                            <div class="div remit text">
                                <div>Atrium Windows and Doors</div>
                                <div>P.O. Box 848446</div>
                                <div>Dallas, TX 75284-8446</div>
                                <div>800/938-1000</div>
                                <div>FAX 214/424-6721</div>
                            </div>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="td remit" id="ncremit">
                            <div class="div remit head">REMIT TO:</div>
                            <div class="div remit text">
                                <div>C/O Bank of America Lockbox.</div>
                                <div>P.O. Box 404581</div>
                                <div>Atlanta, GA 30384-4581</div>
                                <div>336/764-6400</div>
                                <div>FAX 336/764-1501</div>
                            </div>
                        </td>
                    </c:otherwise>
                </c:choose>
                <td class="td invoice">
                    <div class="div invoice head">INVOICE</div>
                    <div>
                        <table class="table-mybordered" width="100%">
                            <td>
                                <div class="div invoice tableheader">INVOICE NUMBER</div>
                                <div class="div invoice tablebody">${requestScope.header.invoice}</div>
                            </td>
                            <td>
                                <div class="div invoice tableheader">DATE</div>
                                <div class="div invoice tablebody"><fmt:formatDate
                                        value="${requestScope.header.invoiceDate}" pattern="MM/dd/yyyy"/></div>
                            </td>
                            <td>
                                <div class="div invoice tableheader">PAGE</div>
                                <div class="div invoice tablebody">1</div>
                            </td>
                        </table>
                    </div>
                </td>
            </tr>
        </c:if>
        <tr>
            <td class="td zeropadding" colspan="2">
                <span class="span shiptag">TO</span>
            </td>
            <td class="td zeropadding">
                <span class="span shiptag">SHIP TO</span>
                <c:if test="${!empty requestScope.header.approvalCode}">
                    <span class="span shiptag">Approval Code: ${requestScope.header.approvalCode}</span>
                </c:if>
            </td>

        </tr>
        <tr>
            <td colspan="2" class="td body1">
                <div class="div body1">
                    <div><span>${requestScope.header.soldToAddr1}</span></div>
                    <div><span>${requestScope.header.soldToAddr2}</span></div>
                    <div><span>${requestScope.header.soldToAddr3}</span></div>
                    <div><span>${requestScope.header.soldToAddr4}</span></div>
                    <div><span>${requestScope.header.soldToAddr5}</span></div>
                    <div><span>${requestScope.header.soldToAddr6}</span></div>
                </div>
            </td>
            <td class="td body1">
                <div class="div body1">
                    <div><span>${requestScope.header.shipToAddr1}</span></div>
                    <div><span>${requestScope.header.shipToAddr2}</span></div>
                    <div><span>${requestScope.header.shipToAddr3}</span></div>
                    <div><span>${requestScope.header.shipToAddr4}</span></div>
                    <div><span>${requestScope.header.shipToAddr5}</span></div>
                    <div><span>${requestScope.header.shipToAddr6}</span></div>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="td body1">
                <div class="div body1">
                    <span><b>JOB NAME: </b></span>
                    <span>${requestScope.header.jobName}</span>
                </div>
                <div class="div body1">
                    <span><b>LOAD NUMBER: </b></span>
                    <span>${requestScope.header.loadNumber}</span>
                </div>
            </td>
            <td class="td body1">
                <div class="div body2">
                    <span><b>CUSTOMER NUMBER: </b></span>
                    <span>${requestScope.header.customerCode}</span>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <table class="table-mybordered" width="100%">
                    <tr>
                        <td>
                            <div class="div tableheader">PAYMENT TERMS</div>
                            <div class="div tablebody">
                                ${requestScope.header.termsDesc}
                            </div>
                        </td>
                        <td>
                            <div class="div tableheader">CUSTOMER P.O. NUMBER</div>
                            <div class="div tablebody">${requestScope.header.purchaseOrder}</div>
                        </td>
                        <td>
                            <div class="div tableheader">SALES ORDER NUMBER</div>
                            <div class="div tablebody">${requestScope.header.salesOrder}</div>
                        </td>
                        <td>
                            <div class="div tableheader">BILL OF LADING</div>
                            <div class="div tablebody">${requestScope.header.billOfLading}</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="div tableheader">SHIPPED VIA</div>
                            <div class="div tablebody">${requestScope.header.howShip}</div>
                        </td>
                        <td>
                            <div class="div tableheader">F.O.B</div>
                            <div class="div tablebody">${requestScope.header.fob}</div>
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

                <%--HEADER--%>
                <table class="table table-linetable-header">
                    <colgroup>
                        <col class="t10">
                        <col class="t20">
                        <col class="t30">
                        <col class="t40">
                        <col class="t50">
                    </colgroup>
                    <tr>
                        <td class="td head" width="50%" style="padding-left: 7px">PARTNUMBER DESCRIPTION</td>
                        <td class="td head" align="center">QTY SHIPPED</td>
                        <td class="td head" align="center">UNIT PRICE</td>
                        <td class="td head" align="center">DISCOUNT</td>
                        <td class="td head" align="center">EXTENSION</td>
                    </tr>
                </table>


                <%--LINE--%>
                <c:forEach items="${requestScope.lines}" var="lineWrapper">

                    <%--table to divide--%>
                    <table width="100%" border="0" cellspacing="0" height="4px" cellpadding="0"
                           style="border:#FFFFFF thin dotted">
                        <tr>
                            <td></td>
                        </tr>
                    </table>


                    <table class="table table-linetable">
                        <colgroup>
                            <col class="t10">
                            <col class="t20">
                            <col class="t30">
                            <col class="t40">
                            <col class="t50">
                        </colgroup>
                        <c:if test="${!empty lineWrapper.configLine}">
                            <tr>
                                <td><b>${lineWrapper.configLine.lineDesc}</b></td>
                                <td align="center"><b>${lineWrapper.configLine.shippedQty}</b></td>
                                <td align="center"></td>
                                <td></td>
                                <td align="center"></td>
                            </tr>
                        </c:if>
                        <c:forEach items="${lineWrapper.lines}" var="line">
                            <tr>
                                    <%--indent when mulled unit--%>
                                <c:choose>
                                    <c:when test="${!empty lineWrapper.configLine}">
                                        <td style="padding-left: 20px">${line.lineDesc}<br>${line.size}
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>${line.lineDesc}<br>${line.size}</td>
                                    </c:otherwise>
                                </c:choose>
                                <td align="center">${line.shippedQty}</td>
                                <td align="center"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2"
                                                                     value="${line.unitPrice}"
                                                                     type="number"></fmt:formatNumber></td>
                                <td></td>
                                <td align="center"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2"
                                                                     value="${line.extensionPrice}"
                                                                     type="number"></fmt:formatNumber></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:forEach>

                <%--table to divide--%>
                <table width="100%" border="0" cellspacing="0" height="4px" cellpadding="0"
                       style="border:#FFFFFF thin dotted">
                    <tr>
                        <td></td>
                    </tr>
                </table>


                <%--INVOICE TOTAL--%>
                <table class="table table-linetable">
                    <colgroup>
                        <col class="t10">
                        <col class="t20">
                        <col class="t30">
                        <col class="t40">
                        <col class="t50">
                    </colgroup>
                    <c:choose>
                        <c:when test="${requestScope.header.salesTax != 0}">
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td colspan="2"><b>GROSS INVOICE:</b></td>
                                    <td align="center"><b><fmt:formatNumber minFractionDigits="2"
                                                                            value="${requestScope.header.invoiceTotal}"
                                                                            type="number"></fmt:formatNumber></b></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td colspan="2"><b>SALES TAX:</b></td>
                                    <td align="center"><b><fmt:formatNumber minFractionDigits="2"
                                                                            value="${requestScope.header.salesTax}"
                                                                            type="number"></fmt:formatNumber></b></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td colspan="2"><b>INVOICE TOTAL:</b></td>
                                    <td align="center"><b><fmt:formatNumber minFractionDigits="2"
                                                                            value="${requestScope.header.netInvoice}"
                                                                            type="number"></fmt:formatNumber></b></td>
                                </tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td></td>
                                <td></td>
                                <td colspan="2"><b>INVOICE TOTAL:</b></td>
                                <td align="center"><b><fmt:formatNumber minFractionDigits="2"
                                                                        value="${requestScope.header.invoiceTotal}"
                                                                        type="number"></fmt:formatNumber></b></td>
                            </tr>
                        </c:otherwise>
                    </c:choose>

                </table>

            </td>
        </tr>

    </table>
</div>

</body>
</html>
