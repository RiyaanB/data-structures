package com.company;

public class ArrayMatrix {
    int[][] matrix;
    public ArrayMatrix(int[][] m)
    {
        matrix = m;
    }
    public ArrayMatrix add(ArrayMatrix a)
    {
        ArrayMatrix b = new ArrayMatrix(new int[matrix.length][a.matrix[0].length]);
        for(int row = 0; row < matrix.length; row++)
        {
            for(int col = 0; col < a.matrix[0].length; col++)
            {
                int sum = 0;
                for(int x = 0; x < a.matrix.length; x++)
                {
                    sum += matrix[row][x] * a.matrix[x][col];
                }
                b.matrix[row][col] = sum;
            }
        }
        return b;
    }
    public String toString()
    {
        String s = "";
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                s += matrix[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }
}
