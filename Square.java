public class Square{
	public static final int TYPE_EMPTY = 0, TYPE_WALL = 1,TYPE_START = 2,TYPE_EMD = 3;
	public static final char WORK_LIST = 'o' , ALREADY_EXPLORED = '.', EXIT = 'x';
	private int row;
	private int col;
	private int type;
	private char status;
	public Square(int row,int col, int type){
		this.row = row;
		this.col = col;
		this.type = type;
		this.status = 0;
	}
	public String toString(){
		if(type == 0){
			if(status != 0){
				return "" + status;
			}
			return "_";
		}
		switch(type){
			case 1:
				return "#";
			case 2:
				return "S";
			case 3:
				return "E";
			default:
				return "_";
		}
	}

	public boolean equals(Object o){
		return ((Square)o).row == this.row && ((Square)o).col == this.col && ((Square)o).type == this.type && ((Square)o).status == this.status;
	}
	public int getRow(){return row;}
	public int getCol(){return col;}
	public int getType(){return type;}
	public char getStatus(){return status;}
	public void setStatus(char status){this.status = status;}
}
