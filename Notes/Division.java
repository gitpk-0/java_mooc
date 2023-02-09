// Division

// Division of integers is a slightly trickier operation. The types of the 
// variables that are part of the division determine the type of result achieved 
// by executing the command. If all of the variables in the division expression 
// are integers, the resulting value is an integer as well.

// If the dividend or divisor (or both!) of the division is a floating point 
// number, the result is a floating point number as well.

// An integer can be converted into a floating point number by placing a 
// type-casting operation (double) before it:

int first = 3;
int second = 2;

double result1 = (double) first / second;
System.out.println(result1); // prints 1.5

double result2 = first / (double) second;
System.out.println(result2); // prints 1.5

double result3 = (double) (first / second);
System.out.println(result3); // prints 1.0

// Output:
// 1.5
// 1.5
// 1.0

// The last example produces an incorrectly rounded result, because the integer 
// division is executed before the type casting.