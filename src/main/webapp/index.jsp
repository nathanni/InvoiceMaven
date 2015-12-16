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
                    <form action="/invoice" method="post" role="form" data-toggle="validator">
                        <div class="form-group has-feedback">
                            <label for="inputInvoice" class="control-label">Invoice</label>
                            <div class="input-group">
                                <span class="input-group-addon">#</span>
                                <input type="text" name="invoice" maxlength="20" id="inputInvoice" class="form-control"
                                       placeholder="Please Enter Invoice Number, only contains digits" required pattern="\s*\d+\s*">
                            </div>
                            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" name="submit" value="Search"/>
                            &nbsp;<input class="btn btn-danger" type="reset" value="Reset">
                        </div>
                        <c:if test="${!empty requestScope.error}">
                            <div class="alert alert-warning alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
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