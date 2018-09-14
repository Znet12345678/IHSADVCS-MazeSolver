import java.util.*;
import java.io.*;
import java.nio.*;
public class Maze{
	private ArrayList <Square>b;
	private int x,y;
	public Maze(){
		b = new ArrayList<Square>();
	}
	public boolean loadMaze(String filename){
		try{
			b = new ArrayList<Square>();
			Scanner s = new Scanner(new File(filename));
			this.x = s.nextInt();
			this.y = s.nextInt();
			for(int i = 0; i < y;i++){
				for(int j = 0; j < x;j++){
					b.add(new Square(i,j,s.nextInt()));
				}
			}
		}catch(IOException e){
			System.out.printf("An I/O Exception has occured when trying to read from file %s\n",filename);
			return false;
		}
		return true;
	}
	List<Square> getNeighbors(Square s){
		ArrayList <Square>ret = new ArrayList<Square>();
		try{
			if(s.getType() != 1)
				ret.add(b.get(x*(s.getRow()-1)+s.getCol()));
		}catch(Exception e){

		}try{
			if(s.getCol() != 0 && s.getType() != 1)
				ret.add(b.get(x*s.getRow()+s.getCol()-1));
		}catch(Exception e){

		}try{
			if(s.getType() != 1)
				ret.add(b.get(x*(s.getRow()+1)+s.getCol()));
		}catch(Exception e){

		}try{
			if(s.getCol() != x-1 && s.getType() != 1)
				ret.add(b.get(x*s.getRow()+s.getCol()+1));
		}catch(Exception e){

		}
		return ret;
	}
	Square getStart(){
		for(Square s : b){
			if(s.getType() == 2)
				return s;
		}
		return null;
	}
	Square getExit(){
		for(Square s : b){
			if(s.getType() == 3)
				return s;
		}
		return null;
	}
	void reset(){
		for(Square s : b){
			s.setStatus('\0');
		}
	}
	public String toString(){
		String s = new String();
		for(int i = 0; i < y;i++){
			for(int j = 0; j < x;j++)
				s+=("" + b.get(i*x+j) + " ");
			s+="\n";
		}
		return s;
	}
}
