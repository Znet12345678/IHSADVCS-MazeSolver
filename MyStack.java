//The better my stack
//by zach
public class MyStack{
	private zObject o;
	public MyStack(){
		this.o = null;

	}
	public  Square pop(){
		Square ret = o.curr;
		o = o.nxt;
		return ret;
	}
	public  void push(Square t){
		zObject ref = o;
		if(o == null){
			o = new zObject(t);
			return;
		}
		zObject top = new zObject(t);
		top.nxt = this.o;
		this.o = top;
	}
	public  Square peek(){
		return o.curr;
	}
	public  boolean empty(){
		return o == null;
	}
	public  boolean isEmpty(){
		return empty();
	}
	public String toString(){
		zObject ref = o;
		String str = (Square)o.curr + "\t" + "<---TOP\n";
		o = o.nxt;
		while(o != null){
			
			str+=(Square)o.curr + "\n";
			o = o.nxt;
		}
		o = ref;
		str+=("_ _ _ _ _\n");
		return str;
	}
}
