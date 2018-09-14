import java.util.*;
abstract class MazeSolver{
	private Maze m;
	private boolean solved;
	abstract void makeEmpty();
	abstract boolean isEmpty();
	abstract void add(Square s);
	abstract Square next();
	private boolean unsolvable;
	boolean isSolved(){
		return this.solved;
	}
	private MyStack s;
        MazeSolver(Maze m){
                this.m = m;
                this.solved = false;
                this.unsolvable = false;
		makeEmpty();
	}

	boolean step(){
		if(isEmpty()){
			this.unsolvable = true;
			return true;
		}
		Square s = next();
		if(s.getType() == 3){
			this.solved = true;
			return true;
		}
		List <Square>n = m.getNeighbors(s);
		for(Square s1 : n){
			if(s1.getStatus() != '.'){
				add(s1);	
				s1.setStatus('o');
			}
		}
		s.setStatus('.');
		return false;
	}
	String getPath(){
		if(this.solved){
			return "Solved";
		}
		if(this.unsolvable)
			return "unsolvable";

		return "solving";
	}
	void solve(){
		while((!isSolved() && !unsolvable)){
			step();
		}
	}
}
