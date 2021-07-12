# natwest-transaction
A Transaction API to debit an account and credit another account

# End point

The API endpoint will be available at http://localhost:8081/natwest-transaction-api/transfer
There is no authentication mechanism. So, no nee to use any credential.
A Postman JSON will look like the below

# Sample JSON

{
    "sourceAccount":1,
    "destinationAccount":2,
    "amount": 3.0
}

After the application is deployed by Spring boot, the database will be avialble at the
URL http://localhost:8081/natwest-transaction-api/h2-console

Please use user id = sa and password = password to access the database.

## THERE IS NO AUTHENTICATION AND VALIDATION OF INPUT.
