package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.IAST;

/**
 * Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.
 *
 * <p>See GIT repository at: <a
 * href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under
 * the tools directory</a>.
 */
public interface BesselIRules {
  /**
   *
   *
   * <ul>
   *   <li>index 0 - number of equal rules in <code>RULES</code>
   * </ul>
   */
  public static final int[] SIZES = {0, 3};

  public static final IAST RULES =
      List(
          IInit(BesselI, SIZES),
          // BesselI(Undefined,y_):=Undefined
          ISetDelayed(BesselI(Undefined, y_), Undefined),
          // BesselI(x_,Undefined):=Undefined
          ISetDelayed(BesselI(x_, Undefined), Undefined),
          // BesselI(-1/2,z_):=(Sqrt(2/Pi)*Cosh(z))/Sqrt(z)
          ISetDelayed(
              BesselI(CN1D2, z_), Times(Sqrt(Times(C2, Power(Pi, CN1))), Power(z, CN1D2), Cosh(z))),
          // BesselI(1/2,z_):=(Sqrt(2/Pi)*Sinh(z))/Sqrt(z)
          ISetDelayed(
              BesselI(C1D2, z_), Times(Sqrt(Times(C2, Power(Pi, CN1))), Power(z, CN1D2), Sinh(z))));
}
