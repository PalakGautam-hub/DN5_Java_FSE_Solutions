/*
PL/SQL Exercise 3: Stored Procedures
1. ProcessMonthlyInterest: Apply 1% monthly interest to all Savings accounts.
2. UpdateEmployeeBonus: Increase salary in a department by bonus percentage.
3. TransferFunds: Transfer funds after checking sufficient balance.
*/

SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE UPPER(AccountType) = 'SAVINGS';

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' savings account(s) updated.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in ProcessMonthlyInterest: ' || SQLERRM);
END;
/
SHOW ERRORS;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department      IN Employees.Department%TYPE,
    p_bonus_percent  IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE UPPER(Department) = UPPER(p_department);

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
    ELSE
        DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' employee(s) updated.');
    END IF;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in UpdateEmployeeBonus: ' || SQLERRM);
END;
/
SHOW ERRORS;

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN Accounts.AccountID%TYPE,
    p_to_account   IN Accounts.AccountID%TYPE,
    p_amount       IN NUMBER
)
IS
    v_balance Accounts.Balance%TYPE;
    v_transaction_id NUMBER;
BEGIN
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be greater than zero.');
    END IF;

    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20002, 'Insufficient balance.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    SELECT NVL(MAX(TransactionID), 0) + 1 INTO v_transaction_id FROM Transactions;

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (v_transaction_id, p_from_account, SYSDATE, p_amount, 'Withdrawal');

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (v_transaction_id + 1, p_to_account, SYSDATE, p_amount, 'Deposit');

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Invalid account ID.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in TransferFunds: ' || SQLERRM);
END;
/
SHOW ERRORS;

-- Sample calls
BEGIN
    ProcessMonthlyInterest;
    UpdateEmployeeBonus('IT', 10);
    TransferFunds(1, 2, 100);
END;
/
