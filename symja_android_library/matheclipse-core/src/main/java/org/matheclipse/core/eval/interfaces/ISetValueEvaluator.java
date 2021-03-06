package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

/**
 * Interface for &quot;core functions&quot; which can specially evaluated like <code>
 * Attributes, List, Part</code>
 */
public interface ISetValueEvaluator extends ISymbolEvaluator {

  default IExpr evaluateSet(IExpr rightHandSide, boolean setDelayed, final EvalEngine engine) {
    return rightHandSide;
  }
}
