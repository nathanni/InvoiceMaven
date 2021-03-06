LOAD DATA                                                                     
INFILE '/oracle/extracts/awdarims.dat'
APPEND INTO TABLE DTS_ARIMASTER  
FIELDS TERMINATED BY '|'
TRAILING NULLCOLS
(
  CUSTCODE          		CHAR,
  INVOICE           		CHAR,
  PURCHASEORDER     		CHAR,
  SALESORDER        		CHAR,
  BOL               		CHAR,
  SHIPTO_NM_ADDR1      		CHAR,
  SHIPTO_NM_ADDR2      		CHAR,
  SHIPTO_NM_ADDR3      		CHAR,
  SHIPTO_NM_ADDR4      		CHAR,
  SHIPTO_NM_ADDR5      		CHAR,
  SHIPTO_NM_ADDR6      		CHAR,
  SOLDTO_NM_ADDR1      		CHAR,
  SOLDTO_NM_ADDR2      		CHAR,
  SOLDTO_NM_ADDR3      		CHAR,
  SOLDTO_NM_ADDR4      		CHAR,
  SOLDTO_NM_ADDR5      		CHAR,
  SOLDTO_NM_ADDR6      		CHAR,
  SHIP_DATE                     DATE "YYYYMMDD" NULLIF (SHIP_DATE = BLANKS), 
  HOW_SHIP                      CHAR,
  FOB                           CHAR,
  CARRIER                       CHAR,
  CARTONS                       DECIMAL EXTERNAL,
  SHIPMENT_WEIGHT               DECIMAL EXTERNAL,
  FT_BILL_NO                    CHAR,
  SALESMAN                      CHAR,
  COMMISION_SPLIT               DECIMAL EXTERNAL,
  REGION_CODE                   CHAR,
  PRICE_CODE                    CHAR,
  INVOICE_DATE			DATE "YYYYMMDD" NULLIF (INVOICE_DATE = BLANKS),
  EXPIRED_DATE			DATE "YYYYMMDD" NULLIF (EXPIRED_DATE = BLANKS),
  POST_DATE			DATE "YYYYMMDD" NULLIF (POST_DATE = BLANKS),
  ENTERED_DATE			DATE "YYYYMMDD" NULLIF (ENTERED_DATE = BLANKS),
  ENTERED_BY			CHAR,
  DATA_AREA_1			CHAR,
  DATA_AREA_2			CHAR,
  DATA_AREA_3			CHAR,
  DATA_AREA_4			CHAR,
  DATA_AREA_5			CHAR,
  DATA_AREA_6			CHAR,
  DATA_AREA_7			CHAR,
  DATA_AREA_8			CHAR,
  DATA_AREA_9			CHAR,
  DATA_AREA_10			CHAR,
  REC_ACCT			CHAR,
  FREIGHT_ACCT			CHAR,
  SALES_TAX_ACCT		CHAR,
  SALES_ACCT			CHAR,
  SALES_DISC_ACCT		CHAR,
  GROSS_INVOICE			DECIMAL EXTERNAL,
  DISC_PERCENT 			DECIMAL EXTERNAL,
  DISC_AMT     			DECIMAL EXTERNAL,
  FREIGHT_AMT  			DECIMAL EXTERNAL,
  SALES_TAX_AMT			DECIMAL EXTERNAL,
  NET_INVOICE_AMT		DECIMAL EXTERNAL,
  FILLER1			DECIMAL EXTERNAL NULLIF (FILLER1 = BLANKS),
  BILL_TO_INV_XREF		CHAR,
  SETTLEMENT_CODE		CHAR,
  STORE_NO			CHAR,
  SALES_TAX_CODE		CHAR,
  SALES_TAX_PCT			DECIMAL EXTERNAL,
  INVOICE_TYPE			CHAR,
  INVOICE_REASON		CHAR,
  TEXTID			CHAR,
  POST_INVENTORY		CHAR,
  POST_GL			CHAR,
  REC_TYPE			CHAR,
  TERMS_OF_SALE			CHAR,
  AMOUNT_DUE			DECIMAL EXTERNAL,
  CASH_DISC_PCT			DECIMAL EXTERNAL,
  DISC_TERMS			DECIMAL EXTERNAL,
  NET_TERMS			DECIMAL EXTERNAL,
  CUST_TYPE			CHAR,
  ACCT_XREF			CHAR,
  CURRENCY_CODE			CHAR,
  BILL_TO_XREF			CHAR,
  CUST_CODE			CHAR,
  INVOICE_NO			CHAR,
  PM_SO_FLAG			CHAR,
  PM_INV_FLAG			CHAR,
  ENGY_SURCHG_PCT		DECIMAL EXTERNAL NULLIF (ENGY_SURCHG_PCT = BLANKS),
  ENGY_SURCHG_TOT_AMT		DECIMAL EXTERNAL NULLIF (ENGY_SURCHG_TOT_AMT = BLANKS),
  OPEN_INVOICE_AMT   		DECIMAL EXTERNAL NULLIF (OPEN_INVOICE_AMT = BLANKS),
  CUR_BILLTO                    CHAR,
  FILLER            		CHAR,
  TRANS_TYPE			CHAR,
  INVOICE_PROCESSED   INTEGER EXTERNAL
)
