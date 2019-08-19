package al.edu.fti.gaming.exception;

public class ChipsetNotFoundException extends ObjectNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5647379937314523692L;

	public ChipsetNotFoundException(int idChipset) {
		super(idChipset);
	}

}
