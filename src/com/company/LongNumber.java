package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LongNumber extends DoubleLinkedList implements Comparable<LongNumber>
{
    int length;
    LongNumber(String number)
    {
        int len = number.length();
        int temp = 0;

        for(int j = len; j > 0; j-=3)
        {
            String num="";
            if(j-3>0)
                num = number.substring(j-3,j);
            else
                num = number.substring(0,j);
            temp = Integer.parseInt(num);
            insertAt(0,temp);
        }

    }
    LongNumber(FileReader fr)
    {

        BufferedReader br = new BufferedReader(fr);
        String number = "";
        try
        {
            number = br.readLine();
        }
        catch (IOException e) {}
        int len = number.length();
        int temp = 0;

        for(int j = len; j > 0; j-=3)
        {
            String num="";
            if(j-3>0)
                num = number.substring(j-3,j);
            else
                num = number.substring(0,j);
            temp = Integer.parseInt(num);
            insertAt(0,temp);
        }

    }
    public LongNumber addition(LongNumber n)
    {
        Node two = n.first;
        while(two.getNextNode() != null)
        {
            two = two.getNextNode();
        }
        Node one = first;
        while(one.getNextNode() != null)
        {
            one = one.getNextNode();
        }
        int carry = 0;
        int sum;
        int oneVal = 0;
        int twoVal = 0;
        LongNumber p = new LongNumber("");
        while(one != null || two != null || carry != 0)
        {
            if (one == null)
                oneVal = 0;
            else
            {
                oneVal = one.getData();
                one = one.getPrevNode();
            }

            if (two == null)
                twoVal = 0;
            else
            {
                twoVal = two.getData();
                two = two.getPrevNode();
            }

            sum = carry + oneVal + twoVal;
            p.insertAt(0,sum%1000);
            carry=sum/1000;
        }
        return p;
    }

    public int compareTo(LongNumber n)
    {
        if(size() > n.size())
            return 1;
        else if(n.size() > size())
            return -1;
        else
        {
            for(int i = 0; i < size(); i ++)
            {
                if (n.get(i) == get(i))
                {}
                else if (n.get(i) > get(i))
                    return -1;
                else
                    return 1;
            }
        }
        return 0;
    }
    public LongNumber subtraction(LongNumber n)
    {
        Node one;
        Node two;
        int com = compareTo(n);
        if (com == 0)
            return new LongNumber("0");
        if(com > 0)
        {
            one = first;
            two = n.first;
        }
        else
        {
            two = first;
            one = n.first;
        }
        while(one.getNextNode() != null)
        {
            one = one.getNextNode();
        }
        while(two.getNextNode() != null)
        {
            two = two.getNextNode();
        }
        int oneVal = 0;
        int twoVal = 0;
        int carry = 0;
        int ans;
        LongNumber p = new LongNumber("");
        while(one != null || two != null || carry != 0)
        {
            if (one != null)
            {
                oneVal = one.getData();
                one = one.getPrevNode();
            }
            else
                oneVal = 0;

            if (two != null)
            {
                twoVal = two.getData();
                two = two.getPrevNode();
            }
            else
                twoVal = 0;
            if (oneVal - twoVal < 0)
            {
                Node temp = one;
                while (temp.getPrevNode().getData() != 0)
                {
                    temp = temp.getPrevNode();
                }
                temp.setData(temp.getData()-1);
                oneVal += 1000;
                ans = oneVal - twoVal;
            }
            else if(oneVal - twoVal  == 0)
                ans = 0;
            else
                ans = oneVal - twoVal;
            p.insertAt(0,ans);
        }
        p.first.setData(p.first.getData() * com);
        return p;
    }
    public int lengthOfInt(int a)
    {
        int c = 0;
        while (a > 0)
        {
            c++;
            a %= 10;
        }
        return c;
    }
    public String toString()
    {
        String s = "";
        Node temp = first;
        while(temp != null)
        {
            s += "" + temp.getData();
            temp = temp.getNextNode();
        }
        return s;
    }

    public void save(String name)
    {
        try
        {
            BufferedWriter br = new BufferedWriter(new FileWriter(name));
            br.write(toString());
            br.close();
        }
        catch (IOException e) {}
    }
}
