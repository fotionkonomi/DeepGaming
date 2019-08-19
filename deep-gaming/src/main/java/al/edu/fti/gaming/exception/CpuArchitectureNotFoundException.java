package al.edu.fti.gaming.exception;

public class CpuArchitectureNotFoundException extends ObjectNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 940638662104988863L;

	public CpuArchitectureNotFoundException(int cpuArchitectureId) {
		super(cpuArchitectureId);
	}

}
