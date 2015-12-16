<%--
  Created by IntelliJ IDEA.
  User: nni
  Date: 12/11/2015
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
<%@include file="/WEB-INF/commons/common.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>Invoice</title>
</head>
<body>
<div class="container">
    <table class="table">
        <tr>
            <td class="td logo"><img src="images/atrium_windows.jpeg" class="img-rounded" width="220" height="100"/>
            </td>
            <td class="td remit">
                <div class="div remit head">REMIT TO:</div>
                <div class="div remit text">
                    <div>C/O Bank of America Lockbox.</div>
                    <div>P.O. Box 404581</div>
                    <div>Atlanta, GA 30384-4581</div>
                    <div>336/764-6400</div>
                    <div>FAX 336/764-1501</div>
                </div>
            </td>
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
                </div>
            </td>
            <td class="td body1">
                <div class="div body1">
                    <div><span>${requestScope.header.shipToAddr1}</span></div>
                    <div><span>${requestScope.header.shipToAddr2}</span></div>
                    <div><span>${requestScope.header.shipToAddr3}</span></div>
                    <div><span>${requestScope.header.shipToAddr4}</span></div>
                    <div><span>${requestScope.header.shipToAddr5}</span></div>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="td body1">
                <div class="div body1">
                    <span><b>JOB NAME: </b></span>
                    <span>${requestScope.header.jobName}</span>
                </div>
            </td>
            <td class="td body1">
                <div class="div body1">
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
                                ${requestScope.header.cashDiscPct}%
                                <fmt:formatDate value="${requestScope.header.discTerms}" pattern="MM/dd/yyyy"/>,
                                NET <fmt:formatDate value="${requestScope.header.netTerms}" pattern="MM/dd/yyyy"/>
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
                <table class="table table-linetable">
                    <tr class="tr divide">
                        <td class="td head" width="50%">PARTNUMBER DESCRIPTION</td>
                        <td align="center" class="td head">QTY SHIPPED</td>
                        <td align="center" class="td head">UNIT PRICE</td>
                        <td align="center" class="td head">DISCOUNT</td>
                        <td align="center" class="td head">EXTENSION</td>
                    </tr>
                    <c:forEach items="${requestScope.lines}" var="lineWrapper">
                        <c:if test="${!empty lineWrapper.configLine}">
                            <tr>
                                <td WIDTH="50%"><b>${lineWrapper.configLine.lineDesc}</b></td>
                                <td align="center"><b>${lineWrapper.configLine.shippedQty}</b></td>
                                <td align="center"></td>
                                <td align="center"></td>
                                <td align="center"></td>
                            </tr>
                        </c:if>
                        <c:forEach items="${lineWrapper.lines}" var="line">
                            <tr>
                                    <%--indent when mulled unit--%>
                                <c:choose>
                                    <c:when test="${!empty lineWrapper.configLine}">
                                        <td WIDTH="50%" style="padding-left: 20px">${line.lineDesc}<br/>${line.size}
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td WIDTH="50%">${line.lineDesc}<br/>${line.size}</td>
                                    </c:otherwise>
                                </c:choose>
                                <td align="center">${line.shippedQty}</td>
                                <td align="center">${line.unitPrice}</td>
                                <td align="center"></td>
                                <td align="center">${line.extensionPrice}</td>
                            </tr>
                        </c:forEach>
                        <tr class="tr divide">
                            <td colspan="5"></td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td colspan="2"></td>
                        <td colspan="2"><b>INVOICE TOTAL:</b></td>
                        <td align="center"><b>${requestScope.header.invoiceTotal}</b></td>
                    </tr>

                </table>
            </td>
        </tr>

    </table>
</div>

</body>
</html>
