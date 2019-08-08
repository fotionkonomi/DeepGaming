package al.edu.fti.gaming.exception;

public class CpuSocketNotFoundException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5737121007294053786L;
	
	private int cpuSocketId;

	public CpuSocketNotFoundException(int cpuSocketId) {
		this.cpuSocketId = cpuSocketId;
	}

	public int getcpuSocketId() {
		return cpuSocketId;
	}
}
