# Personal Expense Wallet

Personal Expense Wallet is a Java-based wallet application that allows users to manage their personal finances and expenses.

## Features

- Create and manage multiple wallets.
- Track transactions and expenses.
- View wallet balances and transaction history.
- RESTful API for integration with other applications.

## Technologies Used

- Java 17
- Spring Boot 3.x
- H2 Database (or specify your database)
- Lombok
- Other relevant technologies

## Getting Started

### Prerequisites

- Java 17 installed
- Maven build tool

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/personal-expense-wallet.git
    ```

2. Build the project:

    ```bash
    cd personal-expense-wallet
    mvn clean install
    ```

3. Run the application:

    ```bash
    mvn spring-boot:run
    ```

    The application will be accessible at [http://localhost:8080](http://localhost:8080).

## API Endpoints

- **GET /wallet**: Retrieve all wallets.
- **GET /wallet/{id}**: Retrieve a wallet by ID.
- **POST /wallet**: Create a new wallet.
- **PUT /wallet/{id}**: Update an existing wallet.
- **DELETE /wallet/{id}**: Delete a wallet.

## Testing

To run tests, use the following command:

```bash
mvn test
