CREATE OR REPLACE PROCEDURE TransferFunds(
  from_account_id IN NUMBER,
  to_account_id IN NUMBER,
  amount IN NUMBER
) IS
  insufficient_funds EXCEPTION;
  from_balance NUMBER;
BEGIN
  -- Get source account balance
  SELECT balance INTO from_balance
  FROM accounts
  WHERE account_id = from_account_id
  FOR UPDATE;

  -- Check if sufficient balance
  IF from_balance < amount THEN
    RAISE insufficient_funds;
  END IF;

  -- Deduct from source account
  UPDATE accounts
  SET balance = balance - amount
  WHERE account_id = from_account_id;

  -- Add to destination account
  UPDATE accounts
  SET balance = balance + amount
  WHERE account_id = to_account_id;

  DBMS_OUTPUT.PUT_LINE('Transferred ' || amount || 
                       ' from Account ' || from_account_id || 
                       ' to Account ' || to_account_id);

EXCEPTION
  WHEN insufficient_funds THEN
    DBMS_OUTPUT.PUT_LINE('Transfer failed: insufficient balance in Account ' || from_account_id);
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;