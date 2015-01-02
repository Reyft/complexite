package element;

public class Case {
	private Position p;
	private boolean uti;
	
	public Case(int x, int y){
		p = new Position(x, y);
		uti = false;
	}
	
	public Case(){
		this(0,0);
	}
	
	public void changePosition(int i, int y){
		p.setX(i);
		p.setY(y);
	}
	
	public void setUtilise(boolean y){
		uti = y;
	}
	
	public boolean utilise(){
		return uti;
	}	
}
