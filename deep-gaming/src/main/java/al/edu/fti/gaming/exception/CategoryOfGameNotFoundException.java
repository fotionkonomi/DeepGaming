package al.edu.fti.gaming.exception;

public class CategoryOfGameNotFoundException extends ObjectNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 766719653206761506L;

	public CategoryOfGameNotFoundException(int categoryOfGameId) {
		super(categoryOfGameId);
	}

}
