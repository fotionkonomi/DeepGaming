package al.edu.fti.gaming.exception;

public abstract class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5182102709272287804L;

	private int objectId;

	public ObjectNotFoundException(int objectId) {
		this.objectId = objectId;
	}

	public int getObjectId() {
		return objectId;
	}
}
