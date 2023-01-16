import java.io.DataInputStream;
import java.io.IOException;
import java.util.Stack;

public class Denomination
{
    public static void main(String[] args) throws IOException
    {
        DataInputStream inp = new DataInputStream(System.in);
        System.out.print("Enter the Amount: ");
        int num= Integer.parseInt(inp.readLine());
        if(num/100000>0)
        {
            System.out.println("Invalid Amount\n\n");
            return;
        }

        displayWords(num);
        int deno[]= new int[7];
        int vals[]={2000,500,200,100,20,10,1};
        if(num/2000!=0)
        {
            deno[0]=num/2000;
            num%=2000;
        }
        if(num/500!=0)
        {
            deno[1]=num/500;
            num%=500;
        }
        if(num/200!=0)
        {
            deno[2]=num/200;
            num%=200;
        }
        if(num/100!=0)
        {
            deno[3]=num/100;
            num%=100;
        }
        if(num/20!=0)
        {
            deno[4]=num/20;
            num%=20;
        }
        if(num/10!=0)
        {
            deno[5]=num/10;
            num%=10;
        }
        deno[6]= num;

        System.out.println(vals[0]+"\t*\t"+deno[0]+"\t=\t"+(vals[0]*deno[0]));
        for(int i=1; i<7; i++)
            System.out.println(vals[i]+"\t\t*\t"+deno[i]+"\t=\t"+(vals[i]*deno[i]));
    }

    static void displayWords(int num)
    {
        String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        Stack<String> res = new Stack<String>();
        while(num!=0)
        {
            res.push(words[(num%10)]);
            num/=10;
        }

        while(!res.isEmpty())
        {
            System.out.print(res.peek()+" ");
            res.pop();
        }
        System.out.println();
    }
}
