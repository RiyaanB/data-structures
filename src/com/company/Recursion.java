package com.company;

public class Recursion
{
    public static int factorial(int f)
    {
        if (f == 1)
            return 1;
        return f * factorial(f-1);
    }
    public static int power(int base,int power)
    {
        if (power == 0)
            return 1;
        return base * power(base,power-1);
    }
    public static int gcdOne(int a, int b)
    {
        if (a == b)
            return a;
        return a > b ? gcdOne(a - b, b) : gcdOne(b - a, a);
    }
    public static int gcdTwo(int a, int b)
    {
        int rem = a % b;
        if (rem == 0)
            return b;
        return gcdTwo(b,rem);
    }
    public static String toBinary(int num)
    {
        if (num == 0)
            return "0";
        return toBinary(num/2) + num % 2;
    }
}