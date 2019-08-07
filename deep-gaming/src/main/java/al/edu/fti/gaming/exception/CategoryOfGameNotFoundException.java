package al.edu.fti.gaming.exception;

public class CategoryOfGameNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 766719653206761506L;

	private int categoryOfGameId;

	public CategoryOfGameNotFoundException(int categoryOfGameId) {
		this.categoryOfGameId = categoryOfGameId;
	}

	public int getCompanyId() {
		return categoryOfGameId;
	}
}
