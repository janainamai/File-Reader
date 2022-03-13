**File-Reader**

This system read .dat files and write in a .dat file some informations about data read.

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