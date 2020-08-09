import java.util.*;

class Graph
{
	private int v;
	private int[][] Adj;
	private int[] visited;
	
	public Graph()
	{
		System.out.print("Enter the number of vertices: ");
		Scanner sc=new Scanner(System.in);
		v=sc.nextInt();
		if(v<=0)
		{
			System.out.println("Enter correct value!!");
			return ;
		}
		else
		{
			Adj = new int[v+1][v+1];
			System.out.println("Enter the Adjacenecy matrix of the graph");
			
			for(int i=1;i<=v;i++)
			{
				for(int j=1;j<=v;j++)
				{
					Adj[i][j]=sc.nextInt();
				}
				System.out.println("");
			}
		}
	}
	public void display()
	{
		System.out.println("The adjacency matrix is ");
		for(int i=1;i<=v;i++)
		{
			for(int j=1;j<=v;j++)
				System.out.print(Adj[i][j] + "   ");
			System.out.println("");
		}
	}
	
	private boolean allVisited()	
	{
		boolean status=true;
		for(int i=1;i<=v;i++)
		{
			if(visited[i]==0)
			{
				status=false;
				break;
			}
		}
		return status ;
	}
	public int dfs(int start)
	{
		int intiator=start;
		
		Stack<Integer> stack = new Stack<>();
		visited=new int[v+1];
		
		for(int i=1;i<=v;i++)
			visited[i]=0;
		
		visited[start]=1;
		//System.out.print(start + "  ");
		//stack.push(start);
		
		while(!allVisited())
		{
			int flag=0;
			for(int i=1;i<=v;i++)
			{
				if(Adj[start][i]==1 && visited[i]==0)
				{
					stack.push(start);
					visited[i]=1;
					//System.out.print(i + "  ");
					flag=1;
					start=i;
					break;
				}
				
			}
			if(flag==0)
			{
				if(stack.empty())
				{
					break;
				}
				else
				{
					start=stack.pop();
				}
			}
		}
		if(allVisited())
			return 1;
		else
			return 0;
	}
	
	public void printInitiator()
	{
		int count=0;
		int[] Init ;
		Init=new int[v];
		
		for(int i=1;i<=v;i++)
		{
			if(dfs(i)==1)
			{
				Init[count++]=i;
			}
		}
		if(count==0)
			System.out.println("No Initiator");
		else
		{
			System.out.println("Initiators are");
			for(int i=0;i<count;i++)
				System.out.print(Init[i] + "   ");
		}
	}
	
}
public class Initiator
{
	public static void main(String args[])
	{
		Graph g=new Graph();
		g.display();
		g.printInitiator();
		
	}
}