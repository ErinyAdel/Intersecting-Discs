package intersecting.discs.three.solutions;

import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    //Solution_1
    public static int numberOf_DiscIntersections1(int[] A)
    {
        int k = 0;
        int[] start = new int[A.length];
        int[] end   = new int[A.length];
        while(k < A.length)
        {
            start[k] = k - A[k];
            end[k]   = k + A[k];
            k++;
        }
        
        int intersection = 0;
        for(int i=0; i<A.length-1; i++)
        {
            for(int j=i+1; j<=A.length-1; j++) {
                if(end[i] >= start[j]) {
                    intersection++;
                    System.out.println("Disc("+(i+1)+"),Disc("+(j+1)+") are intersect");
                }
            }
        }
        return intersection;
    }
    
    //Solution_2
    public static int numberOf_DiscIntersections2(int[] A)
    {
        int i = 0;
        int[] start = new int[A.length];
        int[] end   = new int[A.length];
        
        while(i < A.length)
        {
            start[i] = i - A[i];
            end[i]   = i + A[i];
            i++;
        }

        int intersections = 0;
        for(i=0; i<A.length-1; i++) 
        {
            for(int j=i+1; j<=A.length-1; j++) 
            {
                //Distance Between 2 Discs = Center1*Center2
                //     R1 + R2 
                if( (A[i] + A[j]) >= (Math.sqrt(Math.pow((start[i]+end[i])/2 - (start[j]+end[j])/2,2)))) {
                    intersections++;                
                    System.out.println("Disc("+(i+1)+"),Disc("+(j+1)+") are intersect");
                }    
            }
        }
        return intersections;
    }
    
    //Solution_3
    public static int numberOf_DiscIntersections3(int[] A)
    {
        int i = 0;
        int[] start = new int[A.length];
        int[] end   = new int[A.length];
        
        while(i < A.length)
        {
            start[i] = i - A[i];
            end[i]   = i + A[i];
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int openDiscs = 0 , intersections = 0 , startIndex = 0 , endIndex = 0;
        while(startIndex < A.length)
        {
            if(start[startIndex] <= end[endIndex])
            {
                intersections += openDiscs;
                startIndex++;
                openDiscs++;
            }
            else
            {
                openDiscs--;
                endIndex++;
            }
        }
        return intersections;
    }
}

public class IntersectingDiscsThreeSolutions 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Number Discs on a Plane : ");
        int N = in.nextInt();

        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            System.out.print("A["+i+"] : ");
            A[i] = in.nextInt();
        }
        
        System.out.println("There is/are (" + Solution.numberOf_DiscIntersections1(A) + ") Pair(s) of Discs That Intersect");
    }
}
