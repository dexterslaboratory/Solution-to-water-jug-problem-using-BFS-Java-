import java.io.*;
import java.util.*;
public class WaterBFS {
	public static LinkedList<Pour> visited= new LinkedList<Pour>();
	public static Dictionary<String, String> backLink = new Hashtable<String,String>();
	public static Queue<Pour> q = new LinkedList<Pour>();
	public static Stack<String> sol = new Stack<String>();
	public static int jugOneMax;
	public static int jugTwoMax;
	public static int toObtain;
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter volume of jug one");
		jugOneMax = Integer.parseInt(br.readLine());
		System.out.println("Enter volume of jug two");
		jugTwoMax = Integer.parseInt(br.readLine());
		System.out.println("Enter volume to obtain");
		toObtain = Integer.parseInt(br.readLine());
		
		Pour initial = new Pour(0,0);
		q.add(initial);
		//visited.add(initial);
		try{
		popGenerateEnque();}
		catch(Exception e){
			System.out.println("No Solution exists");
		}
	}
	public static void popGenerateEnque(){
		Pour p = q.poll();
		if(!isVisited(p)){
			visited.add(p);
			generateStates(p);
			}
		popGenerateEnque();
	}
	public static void generateStates(Pour p){
		//fill
		System.out.println("Children of ("+p.jugOne+","+p.jugTwo+") are:");
		if(p.jugOne < jugOneMax){Pour pNew = new Pour(jugOneMax,p.jugTwo);q.add(pNew);
								System.out.print("("+pNew.jugOne+","+pNew.jugTwo+")");
								if(backLink.get("("+pNew.jugOne+","+pNew.jugTwo+")")==null)
								backLink.put("("+pNew.jugOne+","+pNew.jugTwo+")", "("+p.jugOne+","+p.jugTwo+")");
								checkIfSolution(pNew);
		}
		if(p.jugTwo < jugTwoMax){Pour pNew = new Pour(p.jugOne,jugTwoMax);q.add(pNew);
								System.out.print(" ("+pNew.jugOne+","+pNew.jugTwo+")");
								if(backLink.get("("+pNew.jugOne+","+pNew.jugTwo+")")==null)
								backLink.put("("+pNew.jugOne+","+pNew.jugTwo+")", "("+p.jugOne+","+p.jugTwo+")");
								checkIfSolution(pNew);}
		//fill over
		//throw
		if(p.jugOne>0){Pour pNew = new Pour(0,p.jugTwo);q.add(pNew);
						System.out.print(" ("+pNew.jugOne+","+pNew.jugTwo+")");
						if(backLink.get("("+pNew.jugOne+","+pNew.jugTwo+")")==null)
						backLink.put("("+pNew.jugOne+","+pNew.jugTwo+")", "("+p.jugOne+","+p.jugTwo+")");
						checkIfSolution(pNew);}
		if(p.jugTwo>0){Pour pNew = new Pour(p.jugOne,0);q.add(pNew);
						System.out.print(" ("+pNew.jugOne+","+pNew.jugTwo+")");
						if(backLink.get("("+pNew.jugOne+","+pNew.jugTwo+")")==null)
						backLink.put("("+pNew.jugOne+","+pNew.jugTwo+")", "("+p.jugOne+","+p.jugTwo+")");
						checkIfSolution(pNew);}
		//throw over
		//pour
		if(p.jugOne<jugOneMax && p.jugTwo!=0){
			if(p.jugOne+p.jugTwo > jugOneMax){//case of equality has already been considered in fill case
			int One = jugOneMax;
			int Two = p.jugOne+p.jugTwo - jugOneMax;
			Pour pNew = new Pour(One,Two);
			q.add(pNew);
			System.out.print(" ("+pNew.jugOne+","+pNew.jugTwo+")");
			if(backLink.get("("+pNew.jugOne+","+pNew.jugTwo+")")==null)
			backLink.put("("+pNew.jugOne+","+pNew.jugTwo+")", "("+p.jugOne+","+p.jugTwo+")");
			checkIfSolution(pNew);}
			else if(p.jugOne+p.jugTwo < jugOneMax){
				Pour pNew = new Pour(p.jugOne+p.jugTwo,0);
				q.add(pNew);
				System.out.print(" ("+pNew.jugOne+","+pNew.jugTwo+")");
				if(backLink.get("("+pNew.jugOne+","+pNew.jugTwo+")")==null)
				backLink.put("("+pNew.jugOne+","+pNew.jugTwo+")", "("+p.jugOne+","+p.jugTwo+")");
				checkIfSolution(pNew);
			}
			}
		if(p.jugTwo<jugTwoMax && p.jugOne!=0){
			if(p.jugTwo+p.jugOne > jugTwoMax){
			int Two = jugTwoMax;
			int One = p.jugTwo+p.jugOne - jugTwoMax;
			Pour pNew = new Pour(One,Two);
			System.out.print(" ("+pNew.jugOne+","+pNew.jugTwo+")");
			if(backLink.get("("+pNew.jugOne+","+pNew.jugTwo+")")==null)
			backLink.put("("+pNew.jugOne+","+pNew.jugTwo+")", "("+p.jugOne+","+p.jugTwo+")");
			checkIfSolution(pNew);
				}
			else if(p.jugOne+p.jugTwo < jugTwoMax){
				Pour pNew = new Pour(0,p.jugOne+p.jugTwo);
				q.add(pNew);
				System.out.print(" ("+pNew.jugOne+","+pNew.jugTwo+")");
				if(backLink.get("("+pNew.jugOne+","+pNew.jugTwo+")")==null)
				backLink.put("("+pNew.jugOne+","+pNew.jugTwo+")", "("+p.jugOne+","+p.jugTwo+")");
				checkIfSolution(pNew);
			}
			}
		//pour over
		System.out.println();
	}
	public static boolean checkIfSolution(Pour p){
		if(p.jugOne == toObtain && p.jugTwo==0){
			System.out.println("\n Volume obtained ");
			String parent = "("+p.jugOne+","+p.jugTwo+")";
			//sol.add(parent);
			while(!parent.equals("(0,0)")){
				//System.out.println(parent);
				sol.push(parent);
				parent = backLink.get(parent);
				}
			//System.out.println("(0,0)");
			sol.push("(0,0)");
			for(int i=sol.size()-1;i>=0;i--){
				System.out.println(sol.get(i));
			}
			System.exit(0);}
		
		return false;
	}
	public static boolean isVisited(Pour p){
		for(Pour check : visited){
			if(p.jugOne==check.jugOne && p.jugTwo==check.jugTwo)
				return true;
		}
		return false;
	}
	public static class Pour{
		int jugOne;
		int jugTwo;
		public Pour(int One,int Two){
			this.jugOne = One;
			this.jugTwo = Two;
		}
	}
}
