package crypto.analysis;

import boomerang.util.StmtWithMethod;
import crypto.rules.CryptSLPredicate;
import typestate.interfaces.ISLConstraint;

public class UnevaluableConstraintException extends Exception {

	private ISLConstraint failedConstraint;
	private StmtWithMethod atUnit;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnevaluableConstraintException(String message, CryptSLPredicate pred) {
		this(message, pred, null);
	}
	
	public UnevaluableConstraintException(String message, ISLConstraint cons, StmtWithMethod location) {
		super(message);
		atUnit = location; 
		failedConstraint = cons;
	}
	
	/**
	 * @return the failedConstraint
	 */
	public ISLConstraint getFailedConstraint() {
		return failedConstraint;
	}

	public StmtWithMethod getUnit() {
		return atUnit;
	}
}
