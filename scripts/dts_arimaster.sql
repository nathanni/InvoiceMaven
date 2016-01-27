--this field is to validate whether the invoice is new generated
ALTER TABLE mssql.dts_arimaster
ADD(INVOICE_PROCESSED NUMBER(1));