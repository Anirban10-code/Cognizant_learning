CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  dept_id IN NUMBER,
  bonus_pct IN NUMBER  -- Example: 10 for 10%
) IS
BEGIN
  FOR rec IN (
    SELECT employee_id, salary
    FROM employees
    WHERE department_id = dept_id
  ) LOOP
    UPDATE employees
    SET salary = salary + (salary * bonus_pct / 100)
    WHERE employee_id = rec.employee_id;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID: ' || rec.employee_id);
  END LOOP;
END;