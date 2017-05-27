package com.company;
import java.util.HashMap;
import java.util.Scanner;
public class Rearrange {

    public static Scanner sc = new Scanner(System.in);

    public static int precedence(char op) {
        switch (op) {
            case ('*'):
                return 4;
            case ('/'):
                return 4;
            case ('%'):
                return 4;
            case ('+'):
                return 3;
            case ('-'):
                return 2;
            case ('('):
                return 1;
            case (')'):
                return 0;
        }
        return -1;
    }

    public static String postfix(String x)
    {
        if(!balanced(x))
            throw new ArithmeticException();
        String post = "";
        Stack<Character> ops = new Stack<Character>();
        for(int i = 0; i < x.length(); i++)
        {
            char c = x.charAt(i);
            if(precedence(c) == -1)
                post += c;
            else if(precedence(c) == 0)
            {
                while (!ops.peak().equals('('))
                {
                    post += ops.pop();
                }
                ops.pop();
            }
            else if (ops.size() == 0||c=='('||precedence(ops.peak()) < precedence(c))
                ops.push(c);

            else {
                while(ops.size()!=0&&precedence(c)<=precedence(ops.peak()))
                post += ops.pop();

                ops.push(c);
            }
        }
        while(ops.size()!=0)
            post+=ops.pop();

        return post;
    }

    public static boolean balanced(String x)
    {
        int c = 0;
        for(int i = 0; i < x.length(); i++)
        {
            if (x.charAt(i) == '(')
                c++;
            else if(x.charAt(i) == ')')
                c--;
            if(c < 0)
                return false;
        }
        if (c == 0)
            return true;
        return false;
    }
    public static int evalPost(String x)
    {
        HashMap<Character,Integer> vals = new HashMap<Character,Integer>();
        for(int i = 0; i < x.length(); i++)
        {
            if(!vals.containsKey(x.charAt(i)) && precedence(x.charAt(i)) == -1) {
                System.out.print("Enter value for " + x.charAt(i) + ": ");
                vals.put(x.charAt(i),sc.nextInt());
            }
        }
        Stack<Integer> nums = new Stack<Integer>();

        for(int i = 0; i < x.length(); i++)
        {
            if (Character.isLetter(x.charAt(i)))
                nums.push(vals.get(x.charAt(i)));
            else if(Character.isDigit(x.charAt(i)))
                nums.push(x.charAt(i)-48);
            else {
                switch (x.charAt(i)) {
                    case ('+'):
                        nums.push(nums.pop() + nums.pop());
                        break;
                    case ('-'):
                        nums.push(-nums.pop() + nums.pop());
                        break;
                    case ('*'):
                        nums.push(nums.pop() * nums.pop());
                        break;
                    case ('/'):
                        nums.push(nums.pop() / nums.pop());
                }
            }
        }
        return nums.pop();
    }
}
