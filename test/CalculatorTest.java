package com.fdmgroup.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
	Calculator calc = new Calculator();

	// Addition
	@Test
	public void check_when_evaluating_empty_string_return_0() {

		double result = calc.evaluate("");

		assertEquals(0.0, result, 0.1);

	}

	@Test
	public void if_space_passed_in_string_then_return_zero() {

		double result = calc.evaluate(" ");

		assertEquals(0.0, result, 0.1);

	}

	@Test
	public void if_single_number_passed_then_return_that_number() {

		double result = calc.evaluate("15");

		assertEquals(15.0, result, 0.1);

	}

	@Test
	public void check_one_plus_one_is_two() {

		double result = calc.evaluate("1+1");

		assertEquals(2.0, result, 0.1);

	}

	@Test
	public void check_15_plus_10_is_25() {

		double result = calc.evaluate("10+15");

		assertEquals(25.0, result, 0.1);

	}

	@Test
	public void calculate_add_decmial_to_other_decimal_results_to_other_decimal_number() {

		double result = calc.evaluate("12.30+50.28");

		assertEquals(62.58, result, 0.01);
	}

	@Test
	public void calculate_add_negitve_12_to_negative_50() {

		double result = calc.evaluate("-12+-50");

		assertEquals(-62.0, result, 0.01);
	}

	@Test
	public void calculate_negative12_plus_fifty_check_output() {

		double result = calc.evaluate("-12+50");

		assertEquals(38.0, result, 0.01);
	}
	// Subtraction

	@Test
	public void pass_negative_should_return_negative(){
		double result = calc.evaluate("-1");

	}
	
	@Test
	public void check_1_minus_1_is_0() {

		double result = calc.evaluate("1-1");

		assertEquals(0, result, 0.01);

	}

	@Test
	public void calculate_subtract_12_minus_34_output_minus22() {
		double result = calc.evaluate("12-34");

		assertEquals(-22, result, 0.01);
	}

	@Test
	public void calculate_subtract_12point2_minus_20_output_minus22point2() {
		double result = calc.evaluate("12.2-22.2");

		assertEquals(-10.0, result, 0.01);
	}

	@Test
	public void calculate_subtract_33_minus_2_output_22() {
		double result = calc.evaluate("33-2");

		assertEquals(31, result, 0.01);
	}

	@Test
	public void calculate_subtract_minus2_minus_3_output_minus5() {
		double result = calc.evaluate("-2-3");

		assertEquals(-5, result, 0.01);
	}

	@Test
	public void calculate_subtract_minus12_minus_minus34_output_22() {
		double result = calc.evaluate("-12--34");

		assertEquals(22, result, 0.01);
	}

	// Multiplication

	@Test
	public void check_one_multiplied_by_one_output_one() {

		double result = calc.evaluate("1*1");

		assertEquals(1.0, result, 0.01);
	}

	@Test
	public void calculate_multiply_12_and_34_output_408() {
		double result = calc.evaluate("12*34");

		assertEquals(408, result, 0.01);
	}

	@Test
	public void calculate_multiply_12_dot_34_and_56_dot_78_output_700_dot_67() {
		double result = calc.evaluate("12.34*56.78");

		assertEquals(700.67, result, 0.01);
	}

	@Test
	public void calculate_multiply_minus12_and_minus34_output_408() {
		double result = calc.evaluate("-12*-34");

		assertEquals(408, result, 0.01);
	}

	@Test
	public void calculate_multiply_minus12_and_34_output_minus408() {
		double result = calc.evaluate("-12*34");

		assertEquals(-408, result, 0.01);
	}

	@Test
	public void calculate_multiply_12_and_0_output_0() {
		double result = calc.evaluate("12*0");

		assertEquals(0, result, 0.01);
	}

	// Division tests
	@Test
	public void calculate_Divide_1_and_1_output_1() {
		double result = calc.evaluate("1/1");

		assertEquals(1, result, 0.01);
	}

	@Test
	public void calculate_Divide_12_and_4_output_3() {
		double result = calc.evaluate("12/4");

		assertEquals(3, result, 0.01);
	}

	@Test
	public void calculate_Divide_12_and_34_output_0_dot_35() {
		double result = calc.evaluate("12/34");

		assertEquals(0.35, result, 0.01);
	}

	@Test
	public void calculate_Divide_12_dot_34_and_56_dot_78_output_0_dot_22() {
		double result = calc.evaluate("12.34/56.78");

		assertEquals(0.22, result, 0.01);
	}

	@Test
	public void calculate_Divide_12_and_minus4_output_minus3() {
		double result = calc.evaluate("12/-4");

		assertEquals(-3, result, 0.01);
	}

	@Test
	public void calculate_Divide_minus12_and_minus4_output_3() {
		double result = calc.evaluate("-12/-4");

		assertEquals(3, result, 0.01);
	}

	@Test
	public void calculate_Divide_0_and_1_output_0() {
		double result = calc.evaluate("0/1");

		assertEquals(0, result, 0.01);
	}

	@Test
	public void calculate_Divide_1_and_0_output_exception() {
		double result = calc.evaluate("1/0");

		assertEquals("divide double by zero should be infinity", true, Double.isInfinite(result));
	}

	// BODMAS tests
	@Test
	public void calculate_BODMAS_1_plus_2_multiply_3_output_7() {
		double result = calc.evaluate("1+2*3");

		assertEquals(7, result, 0.01);
	}

	@Test
	public void calculate_BODMAS_1_plus_3_plus_3_output_4() {
		double result = calc.evaluate("1+3+3");

		assertEquals(7, result, 0.01);
	}

	@Test
	public void calculate_BODMAS_1_plus_6_divide_3_output_3() {
		double result = calc.evaluate("1+6/3");

		assertEquals(3, result, 0.01);
	}

	@Test
	public void calculate_BODMAS_7_minus_6_multiply_3_output_minus11() {
		double result = calc.evaluate("7-6*3");

		assertEquals(-11, result, 0.01);
	}

	@Test
	public void calculate_BODMAS_7_minus_6_divide_3_output_5() {
		double result = calc.evaluate("7-6/3");

		assertEquals(5, result, 0.01);
	}

	@Test
	public void calculate_BODMAS_7_minus_6_add_3_output_4() {
		double result = calc.evaluate("7-6+3");

		assertEquals(4, result, 0.01);
	}

	@Test
	public void calculate_BODMAS_7_multply_6_divide_3_output_14() {
		double result = calc.evaluate("7*6/3");

		assertEquals(14, result, 0.01);
	}

	@Test
	public void crazy_BODMAS() {
		double result = calc.evaluate("1+8*9/7-9+1/6+7");

		assertEquals(9.45, result, 0.01);
	}

	@Test
	public void random_test() {
		double result = calc.evaluate("9-4-3-2");

		assertEquals(0.0, result, 0.01);

	}
	@Test
	public void four_divided_2_divided_2_output_1(){
		double result = calc.evaluate("4/2/2");

		assertEquals(1.0, result, 0.01);
		
	}
	
	@Test
	public void two_times_2_times_2_output_8(){
		double result = calc.evaluate("2*2*2");

		assertEquals(8.0, result, 0.01);
	}
	
	@Test
	public void nine_minus_four_times_two__minus_oneplus_five_dividedby_five(){
		double result = calc.evaluate("9-4*2-1+5/5");

		assertEquals(1.0, result, 0.01);
	}
	//Bracket Tests
	@Test
	public void six_plus_bracket_9_multiplied_2_output_24(){
		double result = calc.evaluate("6+(9*2)");

		assertEquals(24.0, result, 0.01);
	}
	
	@Test
	public void two_brackets_in_expression(){
		
		double result = calc.evaluate("(9+6)*2+(2-3)");

		assertEquals(29.0, result, 0.01);
		
	}
	
	@Test
	public void ugly_bracket_test(){
		double result = calc.evaluate("9+(6*1-2+(10/2))");

		assertEquals(18.0, result, 0.01);
		
	}
	
	@Test
	public void test_product_brackets(){
		
		double result =calc.evaluate("(2)(2)(2+1)");
		
		assertEquals(12.0, result, 0.01);
	}
	
	

}
