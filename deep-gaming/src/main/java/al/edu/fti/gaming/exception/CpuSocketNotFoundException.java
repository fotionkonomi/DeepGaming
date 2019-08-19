package al.edu.fti.gaming.exception;

public class CpuSocketNotFoundException extends ObjectNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5737121007294053786L;

	public CpuSocketNotFoundException(int cpuSocketId) {
		super(cpuSocketId);
	}

}
