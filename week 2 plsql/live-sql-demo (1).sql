BEGIN
  FOR rec IN (
    SELECT customer_id, balance
    FROM customers
    WHERE balance > 10000
  ) LOOP
    UPDATE customers
    SET isVIP = 'TRUE'
    WHERE customer_id = rec.customer_id;

    DBMS_OUTPUT.PUT_LINE('Customer ID ' || rec.customer_id || ' promoted to VIP.');
  END LOOP;
END;