
public interface Movimentacao {
	
	public default int mover(int x, int y){
		return x + y;
	}
}
