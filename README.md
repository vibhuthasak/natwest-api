# Account Transfer API

#### This REST APIs are designed to do transfer amounts between accounts.

### Data Models
- Account
  - accountId - integer (This value is autogenerated)
  - balance	- double
  - ownerId	- integer
- Transaction
  - transactionId - integer (This value is autogenerated)
  - amount - double
  - sourceAccountId - integer
  - destinationAccountId - integer
  - transactionStatus - ENUM [PENDING, SUCCESS, FAILED]
- TransactionRequest (This is used as the validator for Transaction data model. Values from
this is used as the constructor for Transaction)
  - amount - double
  - destinationAccountId - integer
  - sourceAccountId - integer

### APIs (Base URL - http://localhost:8080/)
1. Transaction APIs
   1. GET /api/transactions - Get all transactions
      * Parameters - No parameters
      * Responses - Sample response <br>
        ``
[
{
"amount": 0,
"destinationAccountId": 0,
"sourceAccountId": 0,
"transactionId": 0,
"transactionStatus": "PENDING"
}
]
``
   2. POST /api/transaction - Make a transaction
      * Parameters
2. Account APIs
   1. GET /api/accounts - Get all accounts
       * Parameters - No parameters
       * Responses - Sample response <br>
           ``[
             {
             "accountId": 0,
             "balance": 0,
             "ownerId": 0
             }
             ]``