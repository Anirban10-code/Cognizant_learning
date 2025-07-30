CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR rec IN (
    SELECT account_id, balance
    FROM accounts
    WHERE account_type = 'SAVINGS'
  ) LOOP
    UPDATE accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_id = rec.account_id;

    DBMS_OUTPUT.PUT_LINE('Interest applied to Account ID: ' || rec.account_id);
  END LOOP;
END;