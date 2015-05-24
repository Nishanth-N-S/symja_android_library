package org.matheclipse.core.reflection.system;

import org.apache.commons.math3.fitting.AbstractCurveFitter;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.matheclipse.core.convert.Convert;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISignedNumber;
import org.matheclipse.core.interfaces.ISymbol;

/**
 * Polynomial fitting of a given data point set.
 * 
 * <p>
 * Syntax: <code>Fit[ data, degree, variable ] </code>
 * </p>
 * 
 * 
 * Examples:<br/>
 * <code>Fit[{{1,1},{2,4},{3,9},{4,16}},2,x]  gives  x^2.0</code><br/>
 * <code>Fit[{1,4,9,16},2,x]  gives  x^2.0</code>
 * 
 * <p>
 * See <a href="http://en.wikipedia.org/wiki/Levenberg%E2%80%93Marquardt_algorithm" >Levenberg–Marquardt algorithm</a>
 * </p>
 */
public class Fit extends AbstractFunctionEvaluator {

	public Fit() {
		super();
	}

	@Override
	public IExpr evaluate(final IAST ast) {
		// switch to numeric calculation
		return numericEval(ast);
	}

	@Override
	public IExpr numericEval(final IAST ast) {
		Validate.checkSize(ast, 4);

		if (ast.arg2().isSignedNumber() && ast.arg3().isSymbol()) {
			int degree = ((ISignedNumber) ast.arg2()).toInt();
			AbstractCurveFitter fitter = PolynomialCurveFitter.create(degree);
			int[] im = ast.arg1().isMatrix();
			WeightedObservedPoints obs = new WeightedObservedPoints();

			if (im != null && im[1] == 2) {
				IAST matrix = (IAST) ast.arg1();
				IAST row;
				for (int i = 1; i < matrix.size(); i++) {
					row = matrix.getAST(i);
					obs.add(1.0, ((ISignedNumber) row.arg1()).doubleValue(), ((ISignedNumber) row.arg2()).doubleValue());
				}
			} else {
				int rowSize = ast.arg1().isVector();
				if (rowSize < 0) {
					return null;
				}
				IAST vector = (IAST) ast.arg1();
				for (int i = 1; i < vector.size(); i++) {
					obs.add(1.0, i, ((ISignedNumber) vector.get(i)).doubleValue());
				}
			}
			return Convert.polynomialFunction2Expr(fitter.fit(obs.toList()), (ISymbol) ast.arg3());
		}

		return null;
	}
}