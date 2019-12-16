package figuras;

public class Punto3D extends Punto {
	private int z;
	public Punto3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	@Override
	public void pintar() {
		super.pintar();
		System.out.println(", "+this.z);
	}

}
