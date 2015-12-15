<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Invoice History Tool</title>
</head>
<body>


    <div class="container">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="panel-title" align="left">Invoice History</div>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-12">
                        <form action="invoice" method="post" role="form" class="form-horizontal">
                            <div class="input-group">
                                <input type="text" name="invoice" class="form-control" placeholder="Please input Invoice Number">
                                <span class="input-group-btn">
                                    <input type="submit" class="btn btn-primary" name="submit" value="Enter"/>
                                </span>
                            </div>
                            <c:if test="${!empty requestScope.error}">
                                <br>
                                <div class="alert alert-warning alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <strong>Sorry! </strong>The Invoice Number is not found in our system.
                                </div>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>