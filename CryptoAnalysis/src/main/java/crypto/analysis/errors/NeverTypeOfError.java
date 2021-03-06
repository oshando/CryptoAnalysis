package crypto.analysis.errors;

import boomerang.jimple.Statement;
import boomerang.jimple.Val;
import crypto.extractparameter.CallSiteWithExtractedValue;
import crypto.interfaces.ISLConstraint;
import crypto.rules.CryptSLRule;
import sync.pds.solver.nodes.Node;

public class NeverTypeOfError extends ConstraintError {

	public NeverTypeOfError(CallSiteWithExtractedValue cs, CryptSLRule rule, Node<Statement, Val> objectLocation, ISLConstraint con) {
		super(cs, rule, objectLocation, con);
	}

}
