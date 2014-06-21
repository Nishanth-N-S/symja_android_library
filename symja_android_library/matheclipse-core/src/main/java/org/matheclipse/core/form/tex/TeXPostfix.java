package org.matheclipse.core.form.tex;

import org.matheclipse.core.interfaces.IAST;

public class TeXPostfix extends AbstractConverter {
  
  final String fOperator;
  public TeXPostfix(final TeXFormFactory factory, final String operator) {
    super(factory);
    fOperator = operator;
  }

  /** {@inheritDoc} */
  public boolean convert(final StringBuffer buf, final IAST f, final int precedence) {
    if (f.size() == 2) {
      fFactory.convert(buf, f.get(1), 0);
      buf.append(fOperator);
      return true;
    }
    return false;
  }
}