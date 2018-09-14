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

	void step(){
		if(isEmpty()){
			this.unsolvable = true;
			return;
		}
		Square s = next();
		if(s.getType() == 3){
			this.solved = true;
			return;
		}
		List <Square>n = m.getNeighbors(s);
		for(Square s1 : n){
			if(s1.getStatus() != '.')
				add(s1);
			s1.setStatus('o');
		}
		s.setStatus('.');
	}
	String getPath(){
		if(this.solved){
			return "Solved";
		}
		if(!isEmpty()){
			return "Solving";
		}
		return "unsolvable";
	}
	void solve(){
		while(!isSolved() && !unsolvable){
			step();
		}
	}
}
