package al.edu.fti.gaming.exception;

public class NoCpuSocketsFoundForCompanyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6340863832684044060L;

	private String companyName;
	
	public NoCpuSocketsFoundForCompanyException(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
}
