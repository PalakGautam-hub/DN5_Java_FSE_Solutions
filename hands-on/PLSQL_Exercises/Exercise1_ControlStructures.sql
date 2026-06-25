/*
PL/SQL Exercise 1: Control Structures
1. Apply 1% discount to loan interest rates for customers above 60.
2. Set IsVIP flag to Y for customers with balance over 10000.
3. Print reminders for loans due within the next 30 days.
*/

SET SERVEROUTPUT ON;

-- Add IsVIP column because it is not present in the given schema.
BEGIN
    EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD IsVIP CHAR(1) DEFAULT ''N''';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE = -1430 THEN
            DBMS_OUTPUT.PUT_LINE('Column IsVIP already exists.');
        ELSE
            RAISE;
        END IF;
END;
/

-- Scenario 1: Apply 1% discount to interest rate for customers above 60.
BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.CustomerID, c.Name, c.DOB, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
    ) LOOP
        IF TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('1% discount applied for ' || rec.Name || ', Loan ID: ' || rec.LoanID);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Promote customers to VIP if balance is greater than 10000.
BEGIN
    FOR rec IN (SELECT CustomerID, Name, Balance FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers SET IsVIP = 'Y' WHERE CustomerID = rec.CustomerID;
            DBMS_OUTPUT.PUT_LINE(rec.Name || ' promoted to VIP.');
        ELSE
            UPDATE Customers SET IsVIP = 'N' WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due within next 30 days.
BEGIN
    FOR rec IN (
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name || ', your loan ID ' || rec.LoanID ||
                             ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/
