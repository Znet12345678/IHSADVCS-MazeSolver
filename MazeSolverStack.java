public class MazeSolverStack extends MazeSolver{
	private MyStack worklist;
	Maze m;
	public MazeSolverStack(Maze m){
		super(m);
		this.m = m;
		worklist = new MyStack();
		worklist.push(m.getStart());
	}
	public void add(Square s){
		this.worklist.push(s);
	}
	public void makeEmpty(){
		this.worklist = new MyStack();
	}
	public boolean isEmpty(){
		return this.worklist.empty();
	}
	public Square next(){
		return this.worklist.pop();
	}
}
