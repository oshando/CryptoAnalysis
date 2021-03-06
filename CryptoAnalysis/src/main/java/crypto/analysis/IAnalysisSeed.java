package crypto.analysis;

import boomerang.WeightedForwardQuery;
import boomerang.jimple.Statement;
import boomerang.jimple.Val;
import crypto.predicates.PredicateHandler;
import soot.SootMethod;
import typestate.TransitionFunction;

public abstract class IAnalysisSeed extends WeightedForwardQuery<TransitionFunction> {

	protected final CryptoScanner cryptoScanner;
	protected final PredicateHandler predicateHandler;

	public IAnalysisSeed(CryptoScanner scanner, Statement stmt, Val fact, TransitionFunction func){
		super(stmt,fact, func);
		this.cryptoScanner = scanner;
		this.predicateHandler = scanner.getPredicateHandler();
	}
	abstract void execute();

	public SootMethod getMethod(){
		return stmt().getMethod();
	}
	
}
