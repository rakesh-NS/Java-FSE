-- Scenario 1

DECLARE
BEGIN
    FOR rec IN (
        SELECT l.LoanID
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60
    )
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Discount applied successfully.');
END;
/
-- Scenario 2: Promote customers to VIP

DECLARE
BEGIN
    FOR rec IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    )
    LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP customers updated.');
END;
/
-- Scenario 3: Loan reminder

DECLARE
BEGIN
    FOR rec IN (
        SELECT c.Name, l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan due for '
            || rec.Name
            || ' on '
            || rec.DueDate
        );
    END LOOP;
END;
/