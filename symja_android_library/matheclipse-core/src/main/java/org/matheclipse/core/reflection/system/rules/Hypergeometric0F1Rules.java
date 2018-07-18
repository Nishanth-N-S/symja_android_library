package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.IAST;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface Hypergeometric0F1Rules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 0, 4 };

  final public static IAST RULES = List(
    IInit(Hypergeometric0F1, SIZES),
    // Hypergeometric0F1(1/2,z_):=Cosh(2*Sqrt(z))
    ISetDelayed(Hypergeometric0F1(C1D2,z_),
      Cosh(Times(C2,Sqrt(z)))),
    // Hypergeometric0F1(1/2,-z_):=Cos(2*Sqrt(z))
    ISetDelayed(Hypergeometric0F1(C1D2,Negate(z_)),
      Cos(Times(C2,Sqrt(z)))),
    // Hypergeometric0F1(3/2,z_):=Sinh(2*Sqrt(z))/(2*Sqrt(z))
    ISetDelayed(Hypergeometric0F1(QQ(3L,2L),z_),
      Times(Power(Times(C2,Sqrt(z)),-1),Sinh(Times(C2,Sqrt(z))))),
    // Hypergeometric0F1(3/2,-z_):=Sin(2*Sqrt(z))/(2*Sqrt(z))
    ISetDelayed(Hypergeometric0F1(QQ(3L,2L),Negate(z_)),
      Times(Power(Times(C2,Sqrt(z)),-1),Sin(Times(C2,Sqrt(z)))))
  );
}
