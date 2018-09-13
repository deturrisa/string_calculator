package com.fdmgroup.calculator;

public class Calculator {

	public double evaluate(String expression) {
		double result = 0;
		String format = "";
		// checks for no input and returns 0
		if (expression == "" || expression == " ") {

			return 0;
		}

		if (expression.contains("(")) {
			return bracketExtract(expression);

		} else
			format = expression;

		if (firstCharIsNegative(expression)) {
			format = expression.substring(1);
		} else
			format = expression;

		if (format.contains("+")) {

			return add(expression, format);
		}

		if (format.contains("-") && Character.isDigit(format.charAt(format.indexOf("-") - 1))) {

			return minus(expression, format);
		}

		if (format.contains("*")) {

			return multiply(expression, format);

		}
		if (format.contains("/")) {

			return divide(expression, format);
		}

		// returns number if no operators provided
		result = Double.parseDouble(expression);

		return result;

	}

	private double add(String expression, String format) {
		double result = 0;
		int indexOfplus = expression.indexOf("+");
		// makes a string from left of operator

		String left = expression.substring(0, indexOfplus);

		// makes a string from right of operator

		String right = expression.substring(indexOfplus + 1);

		result = evaluate(left) + evaluate(right);

		return result;
	}

	private double divide(String expression, String format) {
		double result = 0;
		int lastIndexOfDiv = expression.lastIndexOf("/");
		// makes a string from left of operator
		String left = expression.substring(0, lastIndexOfDiv);
		// makes a string from right of operator
		String right = expression.substring(lastIndexOfDiv + 1);

		result = evaluate(left) / evaluate(right);
		return result;

	}

	private double multiply(String expression, String format) {
		double result = 0;
		int indexOfMulti = expression.indexOf("*");
		// makes a string from left of operator
		String left = expression.substring(0, indexOfMulti);
		// makes a string from right of operator
		String right = expression.substring(indexOfMulti + 1);

		result = evaluate(left) * evaluate(right);
		return result;

	}

	private double minus(String expression, String format) {
		double result = 0;
		int indexOfNegative = 0;
		if (firstCharIsNegative(expression)) {
			indexOfNegative = format.indexOf("-") + 1;
		} else
			indexOfNegative = format.lastIndexOf("-");
		// makes a string from left of operator
		String left = expression.substring(0, indexOfNegative);
		// makes a string from right of operator
		String right = expression.substring(indexOfNegative + 1);

		result = evaluate(left) - evaluate(right);
		return result;
	}

	private boolean firstCharIsNegative(String expression) {

		if (expression.charAt(0) == '-') {
			return true;
		}

		return false;

	}

	private double bracketExtract(String expression) {
		
		expression = expression.replace(")(",")*(");
		
		int indexOfClose = expression.indexOf(')');

		String stringUpToClose = expression.substring(0, indexOfClose);

		int indexOfOpen = stringUpToClose.lastIndexOf('(');

		String insideBracket = expression.substring(indexOfOpen + 1, indexOfClose);
		double resultInsideBracket = evaluate(insideBracket);

		String beforeBracket = expression.substring(0, indexOfOpen);

		String afterBracket = expression.substring(indexOfClose + 1);

		String fullString = beforeBracket + resultInsideBracket + afterBracket;

		return evaluate(fullString);

	}

}