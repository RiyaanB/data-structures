package com.company;

public class TowerOfHanoi
{
    public static void MainDemo()
    {
        shift(5,1,3,2);
    }
    public static void shift(int numberOfDisks, int source, int target,int auxillary)
    {
        if (numberOfDisks == 1)
            System.out.println("Move from " + source + " to " + target);
        else
        {
            shift(numberOfDisks-1, source, auxillary, target);
            System.out.println("Move from " + source + " to " + target);
            shift(numberOfDisks-1,auxillary,target,source);
        }
    }
}
