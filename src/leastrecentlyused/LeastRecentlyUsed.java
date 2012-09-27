
package leastrecentlyused;

/**
 *
 * @author Rob_Weaver
 */

import java.util.*;
import java.io.*;

public class LeastRecentlyUsed {
    
    public static void main(String[] args) throws IOException
    {        
      
    int frm,page=0,ch,pgf=0,n,chn=0;
    boolean flag; 
    int pages[];        //pgf-page fault
    int k=0;

    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Enter number of frames: ");
 
    frm=Integer.parseInt(obj.readLine());

    int frame1[]=new int[frm]; //reads in pg numbers and saves them in an array
    int a[]=new int[frm];
    int b[]=new int[frm];

for(int i= 0; i<frm; i++)
{       
    frame1[i]=-1;   // initialize all frames to -1 as a place holder
    a[i]=-1;
    b[i]=-1;
}

// user inputs how many pages they want 
System.out.println("Enter the number of pages being used ");
n=Integer.parseInt(obj.readLine()); // sets n to num of pgs
pages=new int[n];

// user assigns each page a number
// for ex. Element 1 is: "4" 
//"Element" is used to not get confused with assigning pg numbers to pages.
System.out.println("Enter the page number ");
int q;
for(int j=0;j<n;j++)
{
    q = j+1;
    System.out.print("Element "+ q + " is: ");    
    pages[j]=Integer.parseInt(obj.readLine());
}

//Actual algorithm after parameters have been set
do{ 
    int pg = 0;
    for(pg=0;pg<n;pg++)
    {
        page = pages[pg];

        flag=true;

        for(int j=0;j<frm;j++)
        {   
            if(page==frame1[j]) //check if first frame is = to element number
            {
            flag=false;         //set flag
            break;
            }
        }

        for(int j=0;j<frm && flag;j++)
        {
            if(frame1[j]==a[frm-1])
            {
                k=j;
                break;
            }
        }

        if(flag)        //if a page fault occured, display new frames 
        {
            frame1[k]=page;
            System.out.println("frame :" );

            for(int j=0;j<frm;j++)
                System.out.print(frame1[j]+"  ");

            pgf++;      // increment pg faults for end result
            System.out.println();
        }
        else            // no page fault occured, still print frames
        {       
            System.out.println("frame :" );

            for(int j=0;j<frm;j++)
                System.out.print(frame1[j]+"  ");

            System.out.println();

        }

    int p=1;
    b[0]=page;

        for(int j=0;j<a.length;j++)
        {       
            if(page!=a[j] && p<frm)
            {       
                b[p]=a[j];
                p++;
            }

        }
        for(int j=0;j<frm;j++)
        {   
            a[j]=b[j];  
        }
        chn++;

    }
}
while(chn!=n);
System.out.println("Page fault:"+pgf);  // print number of page faults occurred

    }
}