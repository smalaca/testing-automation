## FizzBuzz
1. Write a program that returns String when number give ie. 
    - input: `(int) 1`
    - output: `(String) "1"`
2. For multiples of three return Fizz instead of the number
3. For the multiples of return print Buzz instead of the number
4. For numbers which are multiples of both three and five return FizzBuzz instead of the number

## String Calculator
Write a method `add` under an object `StringCalculator` that, given a delimited string, returns the sum of the numbers in the string.
1. An empty string returns zero `""` => `0`
2. A single number returns the value `"1"` => `1` `"2"` => `2`
3. Two numbers, comma delimited, returns the sum `"1,2"` => `3` `"10,20"` => `30`
4. Two numbers, newline delimited, returns the sum `"1\n2"` => `3`
5. Three numbers, delimited either way, returns the sum `"1\n2,3\n4"` => `10`
6. Negative numbers throw an exception with the message `"-1,2,-3"` => `"negatives not allowed: -1,-3"`