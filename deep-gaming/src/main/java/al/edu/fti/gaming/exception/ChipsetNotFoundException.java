package al.edu.fti.gaming.exception;

public class ChipsetNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5647379937314523692L;

	private int idChipset;

	public ChipsetNotFoundException(int idChipset) {
		this.idChipset = idChipset;
	}

	public int getIdChipset() {
		return idChipset;
	}
}
