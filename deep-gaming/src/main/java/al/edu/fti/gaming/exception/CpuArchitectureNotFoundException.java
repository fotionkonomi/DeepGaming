package al.edu.fti.gaming.exception;

public class CpuArchitectureNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 940638662104988863L;

	private int id;

	public CpuArchitectureNotFoundException(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
