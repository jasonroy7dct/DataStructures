package assignment2;

public class Task2 {

  /**
   * Task-2: Given a string str that represents an arithmetic expression, evaluate the arithmetic
   * expression. The arithmetic expression can only include any arithmetic operators (i.e., +, -, /,
   * *) and numeric operands, i.e., any integer from  (-2^31) to (2^31-1). There may be one or more
   * white spaces between an operand and an operator. You should ignore the white spaces while
   * scanning. For an invalid expression, i.e., any operand other than numeric values, invalid
   * operator, or division by 0, either return NaN or throw an exception. You have to use the stack
   * you implemented in Task-1 of the assignment. Write sample test cases to validate your
   * implementation.
   */
  public int caculateTheArithmeticExpression(String str) {
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      // if whitespace, skip space
      if (Character.isWhitespace(c)) {
        continue;
      }

      //
      if (Character.isDigit(c)) {
        int num = 0;
        for (; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
          num = num * 10 + Character.getNumericValue(str.charAt(i));
        }
        operands.push(num);
      } else if (c == '+' || c == '-' || c == '*' || c == '/') {
        while (!operators.isEmpty() && hasPriority(c, operators.peek())) {
          int operatedResult = operate(operators.pop(), operands.pop(), operands.pop());
          operands.push(operatedResult);
        }
        operators.push(c);
      } else {
        throw new UnsupportedOperationException(
            "Input cannot be any operand other than numeric values, invalid operator, otherwise it will be NaN");
      }
    }
    while (!operators.isEmpty()) {
      int operatedResult = operate(operators.pop(), operands.pop(), operands.pop());
      operands.push(operatedResult);
    }
    return operands.pop();
  }

  public boolean hasPriority(char operator1, char operator2) {
    // '*' & '/' should operate prior to '+' & '-'
    if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
      return false;
    } else {
      return true;
    }
  }

  public int operate(char operator, int second, int first) {
    if (operator == '+') {
      return first + second;
    } else if (operator == '-') {
      return first - second;
    } else if (operator == '*') {
      return first * second;
    } else if (operator == '/') {
      if (second == 0) {
        throw new UnsupportedOperationException("Number cannot be divided by 0");
      } else {
        return first / second;
      }
    } else {
      return 0;
    }
  }
}
