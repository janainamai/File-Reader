**File-Reader**

This system read .dat files and write in a .dat file some informations about data read.<br>
The read files must be in the directory: *HOMEPATH/data/in*<br>
The file recorded after data processing will be at the address: *HOMEPATH/data/out*

**Data that can be read:**

SALESMAN<br>
Format: 001çCPFçNameçSalary

CUSTOMER<br>
Format: 002çCNPJçNameçBusiness Area

SALE<br>
Format: 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name

**Data returned:**<br>
Amount of clients in the input file<br>
Amount of salesman in the input file<br>
ID of the most expensive sale<br>
Worst salesman ever

**Examples of lines in the .dat file:**<br>
*001ç1234567891234çDiegoç50000<br>*
*001ç3245678865434çRenatoç40000.99<br>*
*002ç2345675433444345çEduardoPereiraçRural<br>*
*003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego<br>*
*003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato<br>*
*002ç2345675434544345çJose da SilvaçRural<br>*