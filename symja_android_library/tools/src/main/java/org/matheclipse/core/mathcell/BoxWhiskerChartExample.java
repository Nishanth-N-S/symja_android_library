package org.matheclipse.core.mathcell;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;

public class BoxWhiskerChartExample extends BasePlotExample {

	@Override
	public String exampleFunction() { 
		return "BoxWhiskerChart(RandomVariate(NormalDistribution(0, 1), 100))";
	}

	public static void main(String[] args) {
		BoxWhiskerChartExample p = new BoxWhiskerChartExample();
		p.generateHTML();
	}

}
