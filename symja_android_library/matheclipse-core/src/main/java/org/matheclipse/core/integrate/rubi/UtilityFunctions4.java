package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.*;

import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
/** 
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class UtilityFunctions4 { 
  public static IAST RULES = List( 
SetDelayed(FunctionOfExponentialOfLinear(u_,$p("x",$s("Symbol"))),
    Module(List(Set($s("lst"),FunctionOfExponentialOfLinear(u,x,False,False,False)),a,b,f),If(Or(FalseQ($s("lst")),FalseQ(Part($s("lst"),C1))),False,CompoundExpression(CompoundExpression(CompoundExpression(CompoundExpression(Set(a,Part($s("lst"),C1)),Set(b,Part($s("lst"),C2))),Set(f,Part($s("lst"),C3))),If(And(MatchQ(u,Condition(Times(v_,Power(g_,Plus($p("c",true),Times(d_,x)))),And(FreeQ(List(c,d,g),x),Less(NumericFactor(d),C0)))),Greater(NumericFactor(b),C0)),CompoundExpression(Set(a,Times(CN1,a)),Set(b,Times(CN1,b))))),List(FunctionOfExponentialOfLinearSubst(u,a,b,f,x),a,b,f))))),
SetDelayed(FunctionOfExponentialOfLinear(u_,x_,a_,b_,f_),
    If(FreeQ(u,x),List(a,b,f),If(Or(SameQ(u,x),CalculusQ(u)),False,If(And(And(PowerQ(u),FreeQ(Part(u,C1),x)),LinearQ(Part(u,C2),x)),FunctionOfExponentialOfLinearAux(a,b,f,Coefficient(Part(u,C2),x,C0),Coefficient(Part(u,C2),x,C1),Part(u,C1)),If(And(HyperbolicQ(u),LinearQ(Part(u,C1),x)),FunctionOfExponentialOfLinearAux(a,b,f,Coefficient(Part(u,C1),x,C0),Coefficient(Part(u,C1),x,C1),E),Module(List($s("lst")),If(And(And(PowerQ(u),FreeQ(Part(u,C1),x)),SumQ(Part(u,C2))),CompoundExpression(Set($s("lst"),FunctionOfExponentialOfLinear(Power(Part(u,C1),First(Part(u,C2))),x,a,b,f)),If(SameQ($s("lst"),False),False,FunctionOfExponentialOfLinear(Power(Part(u,C1),Rest(Part(u,C2))),x,Part($s("lst"),C1),Part($s("lst"),C2),Part($s("lst"),C3)))),CompoundExpression(Set($s("lst"),List(a,b,f)),Catch(CompoundExpression(Scan(Function(CompoundExpression(Set($s("lst"),FunctionOfExponentialOfLinear(Slot1,x,Part($s("lst"),C1),Part($s("lst"),C2),Part($s("lst"),C3))),If(SameQ($s("lst"),False),Throw(False)))),u),$s("lst"))))))))))),
SetDelayed(FunctionOfExponentialOfLinearAux(a_,b_,f_,c_,d_,g_),
    If(FalseQ(a),List(c,d,g),If(ZeroQ(Plus(Times(Log(f),NonnumericFactors(b)),Times(CN1,Times(Log(g),NonnumericFactors(d))))),Module(List(Set($s("gcd"),GCD(NumericFactor(b),NumericFactor(d)))),CompoundExpression(If(And(Less(NumericFactor(b),C0),Less(NumericFactor(d),C0)),Set($s("gcd"),Times(CN1,$s("gcd")))),If(Equal($s("gcd"),NumericFactor(b)),List(a,b,f),If(Equal($s("gcd"),NumericFactor(d)),List(c,d,g),List(C0,Times($s("gcd"),NonnumericFactors(b)),f))))),False))),
SetDelayed(FunctionOfExponentialOfLinearSubst(u_,a_,b_,f_,x_),
    If(FreeQ(u,x),u,If(And(And(PowerQ(u),FreeQ(Part(u,C1),x)),LinearQ(Part(u,C2),x)),Module(List(c,d,g),CompoundExpression(CompoundExpression(CompoundExpression(Set(c,Coefficient(Part(u,C2),x,C0)),Set(d,Coefficient(Part(u,C2),x,C1))),Set(g,Part(u,C1))),Times(Power(g,Plus(c,Times(CN1,Times(a,Times(d,Power(b,CN1)))))),Power(x,Times(d,Times(Log(g),Power(Times(b,Log(f)),CN1))))))),If(And(HyperbolicQ(u),LinearQ(Part(u,C1),x)),Module(List(c,d,$s("tmp")),CompoundExpression(CompoundExpression(CompoundExpression(Set(c,Coefficient(Part(u,C1),x,C0)),Set(d,Coefficient(Part(u,C1),x,C1))),Set($s("tmp"),Times(Power(E,Plus(c,Times(CN1,Times(a,Times(d,Power(b,CN1)))))),Power(x,Times(d,Power(Times(b,Log(f)),CN1)))))),If(SinhQ(u),Plus(Times($s("tmp"),C1D2),Times(CN1,Times(C1,Power(Times(C2,$s("tmp")),CN1)))),If(CoshQ(u),Plus(Times($s("tmp"),C1D2),Times(C1,Power(Times(C2,$s("tmp")),CN1))),If(TanhQ(u),Times(Plus($s("tmp"),Times(CN1,Times(C1,Power($s("tmp"),CN1)))),Power(Plus($s("tmp"),Times(C1,Power($s("tmp"),CN1))),CN1)),If(CothQ(u),Times(Plus($s("tmp"),Times(C1,Power($s("tmp"),CN1))),Power(Plus($s("tmp"),Times(CN1,Times(C1,Power($s("tmp"),CN1)))),CN1)),If(SechQ(u),Times(C2,Power(Plus($s("tmp"),Times(C1,Power($s("tmp"),CN1))),CN1)),Times(C2,Power(Plus($s("tmp"),Times(CN1,Times(C1,Power($s("tmp"),CN1)))),CN1))))))))),If(And(And(PowerQ(u),FreeQ(Part(u,C1),x)),SumQ(Part(u,C2))),Times(FunctionOfExponentialOfLinearSubst(Power(Part(u,C1),First(Part(u,C2))),a,b,f,x),FunctionOfExponentialOfLinearSubst(Power(Part(u,C1),Rest(Part(u,C2))),a,b,f,x)),Map(Function(FunctionOfExponentialOfLinearSubst(Slot1,a,b,f,x)),u)))))),
SetDelayed(FunctionOfTrig(u_,$p("x",$s("Symbol"))),
    Module(List(Set(v,FunctionOfTrig(u,Null,x))),If(SameQ(v,Null),False,v))),
SetDelayed(FunctionOfTrig(u_,v_,x_),
    If(AtomQ(u),If(SameQ(u,x),False,v),If(And(TrigQ(u),LinearQ(Part(u,C1),x)),If(SameQ(v,Null),Part(u,C1),Module(List(Set(a,Coefficient(v,x,C0)),Set(b,Coefficient(v,x,C1)),Set(c,Coefficient(Part(u,C1),x,C0)),Set(d,Coefficient(Part(u,C1),x,C1))),If(And(ZeroQ(Plus(Times(a,d),Times(CN1,Times(b,c)))),RationalQ(Times(b,Power(d,CN1)))),Plus(Times(a,Power(Numerator(Times(b,Power(d,CN1))),CN1)),Times(b,Times(x,Power(Numerator(Times(b,Power(d,CN1))),CN1)))),False))),If(CalculusQ(u),False,Module(List(Set(w,v)),Catch(CompoundExpression(Scan(Function(If(FalseQ(Set(w,FunctionOfTrig(Slot1,w,x))),Throw(False))),u),w))))))),
SetDelayed(FunctionOfHyperbolic(u_,$p("x",$s("Symbol"))),
    Module(List(Set(v,FunctionOfHyperbolic(u,Null,x))),If(SameQ(v,Null),False,v))),
SetDelayed(FunctionOfHyperbolic(u_,v_,x_),
    If(AtomQ(u),If(SameQ(u,x),False,v),If(And(HyperbolicQ(u),LinearQ(Part(u,C1),x)),If(SameQ(v,Null),Part(u,C1),Module(List(Set(a,Coefficient(v,x,C0)),Set(b,Coefficient(v,x,C1)),Set(c,Coefficient(Part(u,C1),x,C0)),Set(d,Coefficient(Part(u,C1),x,C1))),If(And(ZeroQ(Plus(Times(a,d),Times(CN1,Times(b,c)))),RationalQ(Times(b,Power(d,CN1)))),Plus(Times(a,Power(Numerator(Times(b,Power(d,CN1))),CN1)),Times(b,Times(x,Power(Numerator(Times(b,Power(d,CN1))),CN1)))),False))),If(CalculusQ(u),False,Module(List(Set(w,v)),Catch(CompoundExpression(Scan(Function(If(FalseQ(Set(w,FunctionOfHyperbolic(Slot1,w,x))),Throw(False))),u),w))))))),
SetDelayed(FunctionOfQ(v_,u_,$p("x",$s("Symbol")),$p("PureFlag")),
    If(FreeQ(u,x),False,If(AtomQ(v),True,If(And(PowerQ(v),FreeQ(Part(v,C2),x)),FunctionOfPowerQ(u,Part(v,C1),Part(v,C2),x),If($s("PureFlag"),If(Or(SinQ(v),CscQ(v)),PureFunctionOfSinQ(u,Part(v,C1),x),If(Or(CosQ(v),SecQ(v)),PureFunctionOfCosQ(u,Part(v,C1),x),If(TanQ(v),PureFunctionOfTanQ(u,Part(v,C1),x),If(CotQ(v),PureFunctionOfCotQ(u,Part(v,C1),x),If(Or(SinhQ(v),CschQ(v)),PureFunctionOfSinhQ(u,Part(v,C1),x),If(Or(CoshQ(v),SechQ(v)),PureFunctionOfCoshQ(u,Part(v,C1),x),If(TanhQ(v),PureFunctionOfTanhQ(u,Part(v,C1),x),If(CothQ(v),PureFunctionOfCothQ(u,Part(v,C1),x),FunctionOfExpnQ(u,v,x))))))))),If(Or(SinQ(v),CscQ(v)),FunctionOfSinQ(u,Part(v,C1),x),If(Or(CosQ(v),SecQ(v)),FunctionOfCosQ(u,Part(v,C1),x),If(Or(TanQ(v),CotQ(v)),FunctionOfTanQ(u,Part(v,C1),x),If(Or(SinhQ(v),CschQ(v)),FunctionOfSinhQ(u,Part(v,C1),x),If(Or(CoshQ(v),SechQ(v)),FunctionOfCoshQ(u,Part(v,C1),x),If(Or(TanhQ(v),CothQ(v)),FunctionOfTanhQ(u,Part(v,C1),x),FunctionOfExpnQ(u,v,x)))))))))))),
SetDelayed(FunctionOfExpnQ(u_,v_,x_),
    If(SameQ(u,v),True,If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,Catch(CompoundExpression(Scan(Function(If(FunctionOfExpnQ(Slot1,v,x),Null,Throw(False))),u),True)))))),
SetDelayed(FunctionOfPowerQ(u_,$p("bas"),$p("deg"),x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(And(PowerQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,$s("bas"))))),FreeQ(Part(u,C2),x)),If(RationalQ($s("deg")),If(RationalQ(Part(u,C2)),And(IntegerQ(Times(Part(u,C2),Power($s("deg"),CN1))),Or(Greater($s("deg"),C0),Less(Part(u,C2),C0))),False),IntegerQ(Simplify(Times(Part(u,C2),Power($s("deg"),CN1))))),Catch(CompoundExpression(Scan(Function(If(FunctionOfPowerQ(Slot1,$s("bas"),$s("deg"),x),Null,Throw(False))),u),True)))))),
SetDelayed(FindTrigFactor($p("func1"),$p("func2"),u_,v_,$p("flag")),
    If(SameQ(u,C1),False,If(And(And(And(Or(SameQ(Head(LeadBase(u)),$s("func1")),SameQ(Head(LeadBase(u)),$s("func2"))),OddQ(LeadDegree(u))),IntegerQuotientQ(Part(LeadBase(u),C1),v)),Or($s("flag"),NonzeroQ(Plus(Part(LeadBase(u),C1),Times(CN1,v))))),List(Part(LeadBase(u),C1),RemainingFactors(u)),Module(List(Set($s("lst"),FindTrigFactor($s("func1"),$s("func2"),RemainingFactors(u),v,$s("flag")))),If(FalseQ($s("lst")),False,List(Part($s("lst"),C1),Times(LeadFactor(u),Part($s("lst"),C2)))))))),
SetDelayed(PureFunctionOfSinQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(TrigQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),Or(SinQ(u),CscQ(u)),Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfSinQ(Slot1,v,x)),Throw(False))),u),True)))))),
SetDelayed(PureFunctionOfCosQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(TrigQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),Or(CosQ(u),SecQ(u)),Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfCosQ(Slot1,v,x)),Throw(False))),u),True)))))),
SetDelayed(PureFunctionOfTanQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(TrigQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),Or(TanQ(u),CotQ(u)),Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfTanQ(Slot1,v,x)),Throw(False))),u),True)))))),
SetDelayed(PureFunctionOfCotQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(TrigQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),CotQ(u),Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfCotQ(Slot1,v,x)),Throw(False))),u),True)))))),
SetDelayed(FunctionOfSinQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(TrigQ(u),IntegerQuotientQ(Part(u,C1),v)),If(OddQuotientQ(Part(u,C1),v),Or(SinQ(u),CscQ(u)),Or(CosQ(u),SecQ(u))),If(And(And(IntegerPowerQ(u),TrigQ(Part(u,C1))),IntegerQuotientQ(Part(u,C1,C1),v)),If(EvenQ(Part(u,C2)),True,FunctionOfSinQ(Part(u,C1),v,x)),If(ProductQ(u),If(And(And(And(CosQ(Part(u,C1)),SinQ(Part(u,C2))),ZeroQ(Plus(Part(u,C1,C1),Times(CN1,Times(v,C1D2))))),ZeroQ(Plus(Part(u,C2,C1),Times(CN1,Times(v,C1D2))))),FunctionOfSinQ(Drop(u,C2),v,x),Module(List($s("lst")),CompoundExpression(Set($s("lst"),FindTrigFactor($s("Sin"),$s("Csc"),u,v,False)),If(And(NotFalseQ($s("lst")),EvenQuotientQ(Part($s("lst"),C1),v)),FunctionOfSinQ(Times(Cos(v),Part($s("lst"),C2)),v,x),CompoundExpression(Set($s("lst"),FindTrigFactor($s("Cos"),$s("Sec"),u,v,False)),If(And(NotFalseQ($s("lst")),OddQuotientQ(Part($s("lst"),C1),v)),FunctionOfSinQ(Times(Cos(v),Part($s("lst"),C2)),v,x),CompoundExpression(Set($s("lst"),FindTrigFactor($s("Tan"),$s("Cot"),u,v,True)),If(NotFalseQ($s("lst")),FunctionOfSinQ(Times(Cos(v),Part($s("lst"),C2)),v,x),Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfSinQ(Slot1,v,x)),Throw(False))),u),True)))))))))),Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfSinQ(Slot1,v,x)),Throw(False))),u),True)))))))),
SetDelayed(FunctionOfCosQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(TrigQ(u),IntegerQuotientQ(Part(u,C1),v)),Or(CosQ(u),SecQ(u)),If(And(And(IntegerPowerQ(u),TrigQ(Part(u,C1))),IntegerQuotientQ(Part(u,C1,C1),v)),If(EvenQ(Part(u,C2)),True,FunctionOfCosQ(Part(u,C1),v,x)),If(ProductQ(u),Module(List($s("lst")),CompoundExpression(Set($s("lst"),FindTrigFactor($s("Sin"),$s("Csc"),u,v,False)),If(NotFalseQ($s("lst")),FunctionOfCosQ(Times(Sin(v),Part($s("lst"),C2)),v,x),CompoundExpression(Set($s("lst"),FindTrigFactor($s("Tan"),$s("Cot"),u,v,True)),If(NotFalseQ($s("lst")),FunctionOfCosQ(Times(Sin(v),Part($s("lst"),C2)),v,x),Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfCosQ(Slot1,v,x)),Throw(False))),u),True))))))),Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfCosQ(Slot1,v,x)),Throw(False))),u),True)))))))),
SetDelayed(FunctionOfTanQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(TrigQ(u),IntegerQuotientQ(Part(u,C1),v)),Or(Or(TanQ(u),CotQ(u)),EvenQuotientQ(Part(u,C1),v)),If(And(And(And(PowerQ(u),EvenQ(Part(u,C2))),TrigQ(Part(u,C1))),IntegerQuotientQ(Part(u,C1,C1),v)),True,If(ProductQ(u),Module(List(Set($s("lst"),ReapList(Scan(Function(If(Not(FunctionOfTanQ(Slot1,v,x)),Sow(Slot1))),u)))),If(SameQ($s("lst"),List()),True,And(And(Equal(Length($s("lst")),C2),OddTrigPowerQ(Part($s("lst"),C1),v,x)),OddTrigPowerQ(Part($s("lst"),C2),v,x)))),Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTanQ(Slot1,v,x)),Throw(False))),u),True)))))))),
SetDelayed(OddTrigPowerQ(u_,v_,x_),
    If(Or(Or(Or(SinQ(u),CosQ(u)),SecQ(u)),CscQ(u)),OddQuotientQ(Part(u,C1),v),If(PowerQ(u),And(OddQ(Part(u,C2)),OddTrigPowerQ(Part(u,C1),v,x)),If(ProductQ(u),Module(List(Set($s("lst"),ReapList(Scan(Function(If(Not(FunctionOfTanQ(Slot1,v,x)),Sow(Slot1))),u)))),If(SameQ($s("lst"),List()),True,And(Equal(Length($s("lst")),C1),OddTrigPowerQ(Part($s("lst"),C1),v,x)))),False)))),
SetDelayed(FunctionOfTanWeight(u_,v_,x_),
    If(AtomQ(u),C0,If(CalculusQ(u),C0,If(And(TrigQ(u),IntegerQuotientQ(Part(u,C1),v)),If(And(TanQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),C1,If(And(CotQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),CN1,C0)),If(And(And(And(PowerQ(u),EvenQ(Part(u,C2))),TrigQ(Part(u,C1))),IntegerQuotientQ(Part(u,C1,C1),v)),If(Or(Or(TanQ(Part(u,C1)),CosQ(Part(u,C1))),SecQ(Part(u,C1))),C1,CN1),If(ProductQ(u),If(Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTanQ(Slot1,v,x)),Throw(False))),u),True)),Apply($s("Plus"),Map(Function(FunctionOfTanWeight(Slot1,v,x)),Apply($s("List"),u))),C0),Apply($s("Plus"),Map(Function(FunctionOfTanWeight(Slot1,v,x)),Apply($s("List"),u))))))))),
SetDelayed(FunctionOfTrigQ(u_,v_,$p("x",$s("Symbol"))),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(TrigQ(u),IntegerQuotientQ(Part(u,C1),v)),True,Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTrigQ(Slot1,v,x)),Throw(False))),u),True)))))),
SetDelayed(PureFunctionOfSinhQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(HyperbolicQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),Or(SinhQ(u),CschQ(u)),Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfSinhQ(Slot1,v,x)),Throw(False))),u),True)))))),
SetDelayed(PureFunctionOfCoshQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(HyperbolicQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),Or(CoshQ(u),SechQ(u)),Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfCoshQ(Slot1,v,x)),Throw(False))),u),True)))))),
SetDelayed(PureFunctionOfTanhQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(HyperbolicQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),Or(TanhQ(u),CothQ(u)),Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfTanhQ(Slot1,v,x)),Throw(False))),u),True)))))),
SetDelayed(PureFunctionOfCothQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(HyperbolicQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),CothQ(u),Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfCothQ(Slot1,v,x)),Throw(False))),u),True)))))),
SetDelayed(FunctionOfSinhQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(HyperbolicQ(u),IntegerQuotientQ(Part(u,C1),v)),If(OddQuotientQ(Part(u,C1),v),Or(SinhQ(u),CschQ(u)),Or(CoshQ(u),SechQ(u))),If(And(And(IntegerPowerQ(u),HyperbolicQ(Part(u,C1))),IntegerQuotientQ(Part(u,C1,C1),v)),If(EvenQ(Part(u,C2)),True,FunctionOfSinhQ(Part(u,C1),v,x)),If(ProductQ(u),If(And(And(And(CoshQ(Part(u,C1)),SinhQ(Part(u,C2))),ZeroQ(Plus(Part(u,C1,C1),Times(CN1,Times(v,C1D2))))),ZeroQ(Plus(Part(u,C2,C1),Times(CN1,Times(v,C1D2))))),FunctionOfSinhQ(Drop(u,C2),v,x),Module(List($s("lst")),CompoundExpression(Set($s("lst"),FindTrigFactor($s("Sinh"),$s("Csch"),u,v,False)),If(And(NotFalseQ($s("lst")),EvenQuotientQ(Part($s("lst"),C1),v)),FunctionOfSinhQ(Times(Cosh(v),Part($s("lst"),C2)),v,x),CompoundExpression(Set($s("lst"),FindTrigFactor($s("Cosh"),$s("Sech"),u,v,False)),If(And(NotFalseQ($s("lst")),OddQuotientQ(Part($s("lst"),C1),v)),FunctionOfSinhQ(Times(Cosh(v),Part($s("lst"),C2)),v,x),CompoundExpression(Set($s("lst"),FindTrigFactor($s("Tanh"),$s("Coth"),u,v,True)),If(NotFalseQ($s("lst")),FunctionOfSinhQ(Times(Cosh(v),Part($s("lst"),C2)),v,x),Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfSinhQ(Slot1,v,x)),Throw(False))),u),True)))))))))),Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfSinhQ(Slot1,v,x)),Throw(False))),u),True)))))))),
SetDelayed(FunctionOfCoshQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(HyperbolicQ(u),IntegerQuotientQ(Part(u,C1),v)),Or(CoshQ(u),SechQ(u)),If(And(And(IntegerPowerQ(u),HyperbolicQ(Part(u,C1))),IntegerQuotientQ(Part(u,C1,C1),v)),If(EvenQ(Part(u,C2)),True,FunctionOfCoshQ(Part(u,C1),v,x)),If(ProductQ(u),Module(List($s("lst")),CompoundExpression(Set($s("lst"),FindTrigFactor($s("Sinh"),$s("Csch"),u,v,False)),If(NotFalseQ($s("lst")),FunctionOfCoshQ(Times(Sinh(v),Part($s("lst"),C2)),v,x),CompoundExpression(Set($s("lst"),FindTrigFactor($s("Tanh"),$s("Coth"),u,v,True)),If(NotFalseQ($s("lst")),FunctionOfCoshQ(Times(Sinh(v),Part($s("lst"),C2)),v,x),Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfCoshQ(Slot1,v,x)),Throw(False))),u),True))))))),Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfCoshQ(Slot1,v,x)),Throw(False))),u),True)))))))),
SetDelayed(FunctionOfTanhQ(u_,v_,x_),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(HyperbolicQ(u),IntegerQuotientQ(Part(u,C1),v)),Or(Or(TanhQ(u),CothQ(u)),EvenQuotientQ(Part(u,C1),v)),If(And(And(And(PowerQ(u),EvenQ(Part(u,C2))),HyperbolicQ(Part(u,C1))),IntegerQuotientQ(Part(u,C1,C1),v)),True,If(ProductQ(u),Module(List(Set($s("lst"),ReapList(Scan(Function(If(Not(FunctionOfTanhQ(Slot1,v,x)),Sow(Slot1))),u)))),If(SameQ($s("lst"),List()),True,And(And(Equal(Length($s("lst")),C2),OddHyperbolicPowerQ(Part($s("lst"),C1),v,x)),OddHyperbolicPowerQ(Part($s("lst"),C2),v,x)))),Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTanhQ(Slot1,v,x)),Throw(False))),u),True)))))))),
SetDelayed(OddHyperbolicPowerQ(u_,v_,x_),
    If(Or(Or(Or(SinhQ(u),CoshQ(u)),SechQ(u)),CschQ(u)),OddQuotientQ(Part(u,C1),v),If(PowerQ(u),And(OddQ(Part(u,C2)),OddHyperbolicPowerQ(Part(u,C1),v,x)),If(ProductQ(u),Module(List(Set($s("lst"),ReapList(Scan(Function(If(Not(FunctionOfTanhQ(Slot1,v,x)),Sow(Slot1))),u)))),If(SameQ($s("lst"),List()),True,And(Equal(Length($s("lst")),C1),OddHyperbolicPowerQ(Part($s("lst"),C1),v,x)))),False)))),
SetDelayed(FunctionOfTanhWeight(u_,v_,x_),
    If(AtomQ(u),C0,If(CalculusQ(u),C0,If(And(HyperbolicQ(u),IntegerQuotientQ(Part(u,C1),v)),If(And(TanhQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),C1,If(And(CothQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),CN1,C0)),If(And(And(And(PowerQ(u),EvenQ(Part(u,C2))),HyperbolicQ(Part(u,C1))),IntegerQuotientQ(Part(u,C1,C1),v)),If(Or(Or(TanhQ(Part(u,C1)),CoshQ(Part(u,C1))),SechQ(Part(u,C1))),C1,CN1),If(ProductQ(u),If(Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTanhQ(Slot1,v,x)),Throw(False))),u),True)),Apply($s("Plus"),Map(Function(FunctionOfTanhWeight(Slot1,v,x)),Apply($s("List"),u))),C0),Apply($s("Plus"),Map(Function(FunctionOfTanhWeight(Slot1,v,x)),Apply($s("List"),u))))))))),
SetDelayed(FunctionOfHyperbolicQ(u_,v_,$p("x",$s("Symbol"))),
    If(AtomQ(u),UnsameQ(u,x),If(CalculusQ(u),False,If(And(HyperbolicQ(u),IntegerQuotientQ(Part(u,C1),v)),True,Catch(CompoundExpression(Scan(Function(If(FunctionOfHyperbolicQ(Slot1,v,x),Null,Throw(False))),u),True)))))),
SetDelayed(IntegerQuotientQ(u_,v_),
    Or(Or(SameQ(u,v),ZeroQ(Plus(u,Times(CN1,v)))),IntegerQ(Times(u,Power(v,CN1))))),
SetDelayed(OddQuotientQ(u_,v_),
    Or(Or(SameQ(u,v),ZeroQ(Plus(u,Times(CN1,v)))),OddQ(Times(u,Power(v,CN1))))),
SetDelayed(EvenQuotientQ(u_,v_),
    EvenQ(Times(u,Power(v,CN1)))),
SetDelayed(FunctionOfDensePolynomialsQ(u_,$p("x",$s("Symbol"))),
    If(FreeQ(u,x),True,If(PolynomialQ(u,x),Greater(Length(Exponent(u,x,$s("List"))),C1),Catch(CompoundExpression(Scan(Function(If(FunctionOfDensePolynomialsQ(Slot1,x),Null,Throw(False))),u),True))))),
SetDelayed(FunctionOfLog(u_,$p("x",$s("Symbol"))),
    Module(List(Set($s("lst"),FunctionOfLog(u,False,False,x))),If(Or(FalseQ($s("lst")),FalseQ(Part($s("lst"),C2))),False,$s("lst")))),
SetDelayed(FunctionOfLog(u_,v_,n_,x_),
    If(AtomQ(u),If(SameQ(u,x),False,List(u,v,n)),If(CalculusQ(u),False,Module(List($s("lst")),If(And(And(LogQ(u),NotFalseQ(Set($s("lst"),BinomialTest(Part(u,C1),x)))),ZeroQ(Part($s("lst"),C1))),If(Or(FalseQ(v),SameQ(Part(u,C1),v)),List(x,Part(u,C1),Part($s("lst"),C3)),False),CompoundExpression(Set($s("lst"),List(C0,v,n)),Catch(List(Map(Function(CompoundExpression(Set($s("lst"),FunctionOfLog(Slot1,Part($s("lst"),C2),Part($s("lst"),C3),x)),If(SameQ($s("lst"),False),Throw(False),Part($s("lst"),C1)))),u),Part($s("lst"),C2),Part($s("lst"),C3))))))))),
SetDelayed(FunctionOfProductLog(u_,$p("x",$s("Symbol"))),
    Module(List(Set($s("lst"),FunctionOfProductLog(u,False,False,x))),If(Or(FalseQ($s("lst")),FalseQ(Part($s("lst"),C2))),False,$s("lst")))),
SetDelayed(FunctionOfProductLog(u_,v_,n_,x_),
    If(AtomQ(u),If(SameQ(u,x),False,List(u,v,n)),If(CalculusQ(u),False,Module(List($s("lst")),If(And(And(ProductLogQ(u),NotFalseQ(Set($s("lst"),BinomialTest(Part(u,C1),x)))),ZeroQ(Part($s("lst"),C1))),If(Or(FalseQ(v),SameQ(Part(u,C1),v)),List(x,Part(u,C1),Part($s("lst"),C3)),False),CompoundExpression(Set($s("lst"),List(C0,v,n)),Catch(List(Map(Function(CompoundExpression(Set($s("lst"),FunctionOfProductLog(Slot1,Part($s("lst"),C2),Part($s("lst"),C3),x)),If(SameQ($s("lst"),False),Throw(False),Part($s("lst"),C1)))),u),Part($s("lst"),C2),Part($s("lst"),C3))))))))),
SetDelayed(PowerVariableExpn(u_,m_,$p("x",$s("Symbol"))),
    If(IntegerQ(m),Module(List(Set($s("lst"),PowerVariableDegree(u,m,C1,x))),If(FalseQ($s("lst")),False,List(Times(Power(x,Times(m,Power(Part($s("lst"),C1),CN1))),PowerVariableSubst(u,Part($s("lst"),C1),x)),Part($s("lst"),C1),Part($s("lst"),C2)))),False)),
SetDelayed(PowerVariableDegree(u_,m_,c_,$p("x",$s("Symbol"))),
    If(FreeQ(u,x),List(m,c),If(Or(AtomQ(u),CalculusQ(u)),False,If(And(PowerQ(u),FreeQ(Times(Part(u,C1),Power(x,CN1)),x)),If(Or(ZeroQ(m),And(SameQ(m,Part(u,C2)),SameQ(c,Times(Part(u,C1),Power(x,CN1))))),List(Part(u,C2),Times(Part(u,C1),Power(x,CN1))),If(And(And(And(IntegerQ(Part(u,C2)),IntegerQ(m)),Greater(GCD(m,Part(u,C2)),C1)),SameQ(c,Times(Part(u,C1),Power(x,CN1)))),List(GCD(m,Part(u,C2)),c),False)),Catch(Module(List(Set($s("lst"),List(m,c))),CompoundExpression(Scan(Function(CompoundExpression(Set($s("lst"),PowerVariableDegree(Slot1,Part($s("lst"),C1),Part($s("lst"),C2),x)),If(SameQ($s("lst"),False),Throw(False)))),u),$s("lst")))))))),
SetDelayed(PowerVariableSubst(u_,m_,$p("x",$s("Symbol"))),
    If(Or(Or(FreeQ(u,x),AtomQ(u)),CalculusQ(u)),u,If(And(PowerQ(u),FreeQ(Times(Part(u,C1),Power(x,CN1)),x)),Power(x,Times(Part(u,C2),Power(m,CN1))),Map(Function(PowerVariableSubst(Slot1,m,x)),u)))),
SetDelayed(FunctionOfSquareRootOfQuadratic(u_,$p("x",$s("Symbol"))),
    If(MatchQ(u,Condition(Times(Power(x,$p("m",true)),Power(Plus(a_,Times($p("b",true),Power(x,$p("n",true)))),p_)),FreeQ(List(a,b,m,n,p),x))),False,Module(List(Set($s("tmp"),FunctionOfSquareRootOfQuadratic(u,False,x))),If(Or(FalseQ($s("tmp")),FalseQ(Part($s("tmp"),C1))),False,CompoundExpression(Set($s("tmp"),Part($s("tmp"),C1)),Module(List(Set(a,Coefficient($s("tmp"),x,C0)),Set(b,Coefficient($s("tmp"),x,C1)),Set(c,Coefficient($s("tmp"),x,C2)),$s("sqrt"),q,r),If(And(ZeroQ(a),ZeroQ(b)),False,If(PosQ(c),CompoundExpression(CompoundExpression(CompoundExpression(Set($s("sqrt"),Rt(c,C2)),Set(q,Plus(Plus(Times(a,$s("sqrt")),Times(b,x)),Times($s("sqrt"),Power(x,C2))))),Set(r,Plus(b,Times(Times(C2,$s("sqrt")),x)))),List(Simplify(Times(SquareRootOfQuadraticSubst(u,Times(q,Power(r,CN1)),Times(Plus(Times(CN1,a),Power(x,C2)),Power(r,CN1)),x),Times(q,Power(Power(r,C2),CN1)))),Simplify(Plus(Times($s("sqrt"),x),Sqrt($s("tmp")))),C2)),If(PosQ(a),CompoundExpression(CompoundExpression(CompoundExpression(Set($s("sqrt"),Rt(a,C2)),Set(q,Plus(Plus(Times(c,$s("sqrt")),Times(CN1,Times(b,x))),Times($s("sqrt"),Power(x,C2))))),Set(r,Plus(c,Times(CN1,Power(x,C2))))),List(Simplify(Times(SquareRootOfQuadraticSubst(u,Times(q,Power(r,CN1)),Times(Plus(Times(CN1,b),Times(Times(C2,$s("sqrt")),x)),Power(r,CN1)),x),Times(q,Power(Power(r,C2),CN1)))),Simplify(Times(Plus(Times(CN1,$s("sqrt")),Sqrt($s("tmp"))),Power(x,CN1))),C1)),CompoundExpression(Set($s("sqrt"),Rt(Plus(Power(b,C2),Times(CN1,Times(Times(C4,a),c))),C2)),If(ZeroQ($s("sqrt")),False,CompoundExpression(Set(r,Plus(c,Times(CN1,Power(x,C2)))),List(Simplify(Times(Times(Times(CN1,$s("sqrt")),SquareRootOfQuadraticSubst(u,Times(Times(CN1,$s("sqrt")),Times(x,Power(r,CN1))),Times(Times(CN1,Plus(Plus(Times(b,c),Times(c,$s("sqrt"))),Times(Plus(Times(CN1,b),$s("sqrt")),Power(x,C2)))),Power(Times(Times(C2,c),r),CN1)),x)),Times(x,Power(Power(r,C2),CN1)))),FullSimplify(Times(Times(C2,c),Times(Sqrt($s("tmp")),Power(Plus(Plus(b,Times(CN1,$s("sqrt"))),Times(Times(C2,c),x)),CN1)))),C3))))))))))))),
SetDelayed(FunctionOfSquareRootOfQuadratic(u_,v_,$p("x",$s("Symbol"))),
    If(Or(AtomQ(u),FreeQ(u,x)),List(v),If(And(PowerQ(u),FreeQ(Part(u,C2),x)),If(And(And(And(FractionQ(Part(u,C2)),Equal(Denominator(Part(u,C2)),C2)),PolynomialQ(Part(u,C1),x)),Equal(Exponent(Part(u,C1),x),C2)),If(Or(FalseQ(v),SameQ(Part(u,C1),v)),List(Part(u,C1)),False),FunctionOfSquareRootOfQuadratic(Part(u,C1),v,x)),If(Or(ProductQ(u),SumQ(u)),Catch(Module(List(Set($s("lst"),List(v))),CompoundExpression(Scan(Function(CompoundExpression(Set($s("lst"),FunctionOfSquareRootOfQuadratic(Slot1,Part($s("lst"),C1),x)),If(SameQ($s("lst"),False),Throw(False)))),u),$s("lst")))),False)))),
SetDelayed(SquareRootOfQuadraticSubst(u_,$p("vv"),$p("xx"),$p("x",$s("Symbol"))),
    If(Or(AtomQ(u),FreeQ(u,x)),If(SameQ(u,x),$s("xx"),u),If(And(PowerQ(u),FreeQ(Part(u,C2),x)),If(And(And(And(FractionQ(Part(u,C2)),Equal(Denominator(Part(u,C2)),C2)),PolynomialQ(Part(u,C1),x)),Equal(Exponent(Part(u,C1),x),C2)),Power($s("vv"),Numerator(Part(u,C2))),Power(SquareRootOfQuadraticSubst(Part(u,C1),$s("vv"),$s("xx"),x),Part(u,C2))),Map(Function(SquareRootOfQuadraticSubst(Slot1,$s("vv"),$s("xx"),x)),u)))),
SetDelayed(RegularizeSubst(u_,x_,w_),
    Module(List(Set($s("lst"),ConstantFactor(Regularize(Subst(u,x,w),x),x))),Times(Part($s("lst"),C1),Part($s("lst"),C2)))),
SetDelayed(Subst(u_,v_,w_),
    Condition(If(SameQ(u,v),w,If(AtomQ(u),u,If(PowerQ(u),If(And(And(PowerQ(v),SameQ(Part(u,C1),Part(v,C1))),SumQ(Part(u,C2))),Times(Subst(Power(Part(u,C1),First(Part(u,C2))),v,w),Subst(Power(Part(u,C1),Rest(Part(u,C2))),v,w)),Power(Subst(Part(u,C1),v,w),Subst(Part(u,C2),v,w))),If(And(SubstQ(u),Or(SameQ(Part(u,C2),v),FreeQ(Part(u,C1),v))),Subst(Part(u,C1),Part(u,C2),Subst(Part(u,C3),v,w)),Map(Function(Subst(Slot1,v,w)),u))))),Or(Or(AtomQ(u),And(SubstQ(u),Or(SameQ(Part(u,C2),v),FreeQ(Part(u,C1),v)))),Not(Or(And(CalculusQ(u),Not(FreeQ(v,Part(u,C2)))),MemberQ(List($s("Pattern"),$s("Defer"),$s("Hold"),$s("HoldForm")),Head(u))))))),
SetDelayed(SubstFor(v_,u_,x_),
    If(AtomQ(v),Subst(u,v,x),If(And(PowerQ(v),FreeQ(Part(v,C2),x)),SubstForPower(u,Part(v,C1),Part(v,C2),x),If(SinQ(v),SubstForTrig(u,x,Sqrt(Plus(C1,Times(CN1,Power(x,C2)))),Part(v,C1),x),If(CosQ(v),SubstForTrig(u,Sqrt(Plus(C1,Times(CN1,Power(x,C2)))),x,Part(v,C1),x),If(TanQ(v),SubstForTrig(u,Times(x,Power(Sqrt(Plus(C1,Power(x,C2))),CN1)),Times(C1,Power(Sqrt(Plus(C1,Power(x,C2))),CN1)),Part(v,C1),x),If(CotQ(v),SubstForTrig(u,Times(C1,Power(Sqrt(Plus(C1,Power(x,C2))),CN1)),Times(x,Power(Sqrt(Plus(C1,Power(x,C2))),CN1)),Part(v,C1),x),If(SecQ(v),SubstForTrig(u,Times(C1,Power(Sqrt(Plus(C1,Times(CN1,Power(x,C2)))),CN1)),Times(C1,Power(x,CN1)),Part(v,C1),x),If(CscQ(v),SubstForTrig(u,Times(C1,Power(x,CN1)),Times(C1,Power(Sqrt(Plus(C1,Times(CN1,Power(x,C2)))),CN1)),Part(v,C1),x),If(SinhQ(v),SubstForHyperbolic(u,x,Sqrt(Plus(C1,Power(x,C2))),Part(v,C1),x),If(CoshQ(v),SubstForHyperbolic(u,Sqrt(Plus(CN1,Power(x,C2))),x,Part(v,C1),x),If(TanhQ(v),SubstForHyperbolic(u,Times(x,Power(Sqrt(Plus(C1,Times(CN1,Power(x,C2)))),CN1)),Times(C1,Power(Sqrt(Plus(C1,Times(CN1,Power(x,C2)))),CN1)),Part(v,C1),x),If(CothQ(v),SubstForHyperbolic(u,Times(C1,Power(Sqrt(Plus(CN1,Power(x,C2))),CN1)),Times(x,Power(Sqrt(Plus(CN1,Power(x,C2))),CN1)),Part(v,C1),x),If(SechQ(v),SubstForHyperbolic(u,Times(C1,Power(Sqrt(Plus(CN1,Power(x,C2))),CN1)),Times(C1,Power(x,CN1)),Part(v,C1),x),If(CschQ(v),SubstForHyperbolic(u,Times(C1,Power(x,CN1)),Times(C1,Power(Sqrt(Plus(C1,Power(x,C2))),CN1)),Part(v,C1),x),SubstForExpn(u,v,x)))))))))))))))),
SetDelayed(SubstForExpn(u_,v_,x_),
    If(SameQ(u,v),x,If(AtomQ(u),u,Map(Function(SubstForExpn(Slot1,v,x)),u)))),
SetDelayed(SubstForPower(u_,$p("bas"),$p("deg"),x_),
    If(AtomQ(u),u,If(And(And(And(PowerQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,$s("bas"))))),FreeQ(Part(u,C2),x)),IntegerQ(Simplify(Times(Part(u,C2),Power($s("deg"),CN1))))),Power(x,Times(Part(u,C2),Power($s("deg"),CN1))),Map(Function(SubstForPower(Slot1,$s("bas"),$s("deg"),x)),u)))),
SetDelayed(SubstForTrig(u_,$p("sin"),$p("cos"),v_,x_),
    If(AtomQ(u),u,If(And(TrigQ(u),IntegerQuotientQ(Part(u,C1),v)),If(Or(SameQ(Part(u,C1),v),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),If(SinQ(u),$s("sin"),If(CosQ(u),$s("cos"),If(TanQ(u),Times($s("sin"),Power($s("cos"),CN1)),If(CotQ(u),Times($s("cos"),Power($s("sin"),CN1)),If(SecQ(u),Times(C1,Power($s("cos"),CN1)),Times(C1,Power($s("sin"),CN1))))))),Map(Function(SubstForTrig(Slot1,$s("sin"),$s("cos"),v,x)),ReplaceAll(TrigExpand($(Head(u),Times(Times(Part(u,C1),Power(v,CN1)),x))),Rule(x,v)))),If(And(And(And(And(ProductQ(u),CosQ(Part(u,C1))),SinQ(Part(u,C2))),ZeroQ(Plus(Part(u,C1,C1),Times(CN1,Times(v,C1D2))))),ZeroQ(Plus(Part(u,C2,C1),Times(CN1,Times(v,C1D2))))),Times(Times($s("sin"),C1D2),SubstForTrig(Drop(u,C2),$s("sin"),$s("cos"),v,x)),Map(Function(SubstForTrig(Slot1,$s("sin"),$s("cos"),v,x)),u))))),
SetDelayed(SubstForHyperbolic(u_,$p("sinh"),$p("cosh"),v_,x_),
    If(AtomQ(u),u,If(And(HyperbolicQ(u),IntegerQuotientQ(Part(u,C1),v)),If(Or(SameQ(Part(u,C1),v),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),If(SinhQ(u),$s("sinh"),If(CoshQ(u),$s("cosh"),If(TanhQ(u),Times($s("sinh"),Power($s("cosh"),CN1)),If(CothQ(u),Times($s("cosh"),Power($s("sinh"),CN1)),If(SechQ(u),Times(C1,Power($s("cosh"),CN1)),Times(C1,Power($s("sinh"),CN1))))))),Map(Function(SubstForHyperbolic(Slot1,$s("sinh"),$s("cosh"),v,x)),ReplaceAll(TrigExpand($(Head(u),Times(Times(Part(u,C1),Power(v,CN1)),x))),Rule(x,v)))),If(And(And(And(And(ProductQ(u),CoshQ(Part(u,C1))),SinhQ(Part(u,C2))),ZeroQ(Plus(Part(u,C1,C1),Times(CN1,Times(v,C1D2))))),ZeroQ(Plus(Part(u,C2,C1),Times(CN1,Times(v,C1D2))))),Times(Times($s("sinh"),C1D2),SubstForHyperbolic(Drop(u,C2),$s("sinh"),$s("cosh"),v,x)),Map(Function(SubstForHyperbolic(Slot1,$s("sinh"),$s("cosh"),v,x)),u))))),
SetDelayed(SubstForFractionalPowerOfLinear(u_,$p("x",$s("Symbol"))),
    Module(List(Set($s("lst"),FractionalPowerOfLinear(u,C1,False,x)),n,a,b,$s("tmp")),If(Or(FalseQ($s("lst")),FalseQ(Part($s("lst"),C2))),False,CompoundExpression(CompoundExpression(CompoundExpression(CompoundExpression(CompoundExpression(Set(n,Part($s("lst"),C1)),Set(a,Coefficient(Part($s("lst"),C2),x,C0))),Set(b,Coefficient(Part($s("lst"),C2),x,C1))),Set($s("tmp"),Times(Power(x,Plus(n,Times(CN1,C1))),SubstForFractionalPower(u,Part($s("lst"),C2),n,Plus(Times(Times(CN1,a),Power(b,CN1)),Times(Power(x,n),Power(b,CN1))),x)))),Set($s("tmp"),SplitFreeFactors(Regularize($s("tmp"),x),x))),List(Part($s("tmp"),C2),n,Part($s("lst"),C2),Times(Part($s("tmp"),C1),Power(b,CN1))))))),
SetDelayed(FractionalPowerOfLinear(u_,n_,v_,x_),
    If(Or(AtomQ(u),FreeQ(u,x)),List(n,v),If(CalculusQ(u),False,If(And(And(FractionalPowerQ(u),LinearQ(Part(u,C1),x)),Or(FalseQ(v),ZeroQ(Plus(Part(u,C1),Times(CN1,v))))),List(LCM(Denominator(Part(u,C2)),n),Part(u,C1)),Catch(Module(List(Set($s("lst"),List(n,v))),CompoundExpression(Scan(Function(If(FalseQ(Set($s("lst"),FractionalPowerOfLinear(Slot1,Part($s("lst"),C1),Part($s("lst"),C2),x))),Throw(False))),u),$s("lst")))))))),
SetDelayed(SubstForFractionalPowerOfQuotientOfLinears(u_,$p("x",$s("Symbol"))),
    Module(List(Set($s("lst"),FractionalPowerOfQuotientOfLinears(u,C1,False,x)),n,a,b,c,d,$s("tmp")),If(Or(FalseQ($s("lst")),FalseQ(Part($s("lst"),C2))),False,CompoundExpression(CompoundExpression(CompoundExpression(CompoundExpression(CompoundExpression(CompoundExpression(CompoundExpression(Set(n,Part($s("lst"),C1)),Set($s("tmp"),Part($s("lst"),C2))),Set($s("lst"),QuotientOfLinearsParts($s("tmp"),x))),Set(a,Part($s("lst"),C1))),Set(b,Part($s("lst"),C2))),Set(c,Part($s("lst"),C3))),Set(d,Part($s("lst"),C4))),If(ZeroQ(d),False,CompoundExpression(CompoundExpression(Set($s("lst"),Times(Power(x,Plus(n,Times(CN1,C1))),Times(SubstForFractionalPower(u,$s("tmp"),n,Times(Plus(Times(CN1,a),Times(c,Power(x,n))),Power(Plus(b,Times(CN1,Times(d,Power(x,n)))),CN1)),x),Power(Power(Plus(b,Times(CN1,Times(d,Power(x,n)))),C2),CN1)))),Set($s("lst"),SplitFreeFactors(Regularize($s("lst"),x),x))),List(Part($s("lst"),C2),n,$s("tmp"),Times(Part($s("lst"),C1),Plus(Times(b,c),Times(CN1,Times(a,d))))))))))),
SetDelayed(SubstForFractionalPowerQ(u_,v_,$p("x",$s("Symbol"))),
    If(Or(AtomQ(u),FreeQ(u,x)),True,If(FractionalPowerQ(u),SubstForFractionalPowerAuxQ(u,v,x),Catch(CompoundExpression(Scan(Function(If(Not(SubstForFractionalPowerQ(Slot1,v,x)),Throw(False))),u),True))))),
SetDelayed(SubstForFractionalPowerAuxQ(u_,v_,x_),
    If(AtomQ(u),False,If(And(FractionalPowerQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),True,Catch(CompoundExpression(Scan(Function(If(SubstForFractionalPowerAuxQ(Slot1,v,x),Throw(True))),u),False))))),
SetDelayed(FractionalPowerOfQuotientOfLinears(u_,n_,v_,x_),
    If(Or(AtomQ(u),FreeQ(u,x)),List(n,v),If(CalculusQ(u),False,If(And(And(FractionalPowerQ(u),QuotientOfLinearsQ(Part(u,C1),x)),Or(FalseQ(v),ZeroQ(Plus(Part(u,C1),Times(CN1,v))))),List(LCM(Denominator(Part(u,C2)),n),Part(u,C1)),Catch(Module(List(Set($s("lst"),List(n,v))),CompoundExpression(Scan(Function(If(FalseQ(Set($s("lst"),FractionalPowerOfQuotientOfLinears(Slot1,Part($s("lst"),C1),Part($s("lst"),C2),x))),Throw(False))),u),$s("lst")))))))),
SetDelayed(SubstForInverseFunctionOfLinear(u_,$p("x",$s("Symbol"))),
    Module(List(Set($s("tmp"),InverseFunctionOfLinear(u,x)),h,a,b),If(FalseQ($s("tmp")),False,CompoundExpression(CompoundExpression(CompoundExpression(Set(h,InverseFunction(Head($s("tmp")))),Set(a,Coefficient(Part($s("tmp"),C1),x,C0))),Set(b,Coefficient(Part($s("tmp"),C1),x,C1))),List(Times(SubstForInverseFunction(u,$s("tmp"),Plus(Times(Times(CN1,a),Power(b,CN1)),Times($(h,x),Power(b,CN1))),x),D($(h,x),x)),$s("tmp"),b))))),
SetDelayed(InverseFunctionOfLinear(u_,$p("x",$s("Symbol"))),
    If(Or(AtomQ(u),CalculusQ(u)),False,If(And(InverseFunctionQ(u),LinearQ(Part(u,C1),x)),u,Module(List($s("tmp")),Catch(CompoundExpression(Scan(Function(If(NotFalseQ(Set($s("tmp"),InverseFunctionOfLinear(Slot1,x))),Throw($s("tmp")))),u),False)))))),
SetDelayed(SubstForInverseFunctionOfQuotientOfLinears(u_,$p("x",$s("Symbol"))),
    Module(List(Set($s("tmp"),InverseFunctionOfQuotientOfLinears(u,x)),h,a,b,c,d,$s("lst")),If(FalseQ($s("tmp")),False,CompoundExpression(CompoundExpression(CompoundExpression(CompoundExpression(CompoundExpression(CompoundExpression(Set(h,InverseFunction(Head($s("tmp")))),Set($s("lst"),QuotientOfLinearsParts(Part($s("tmp"),C1),x))),Set(a,Part($s("lst"),C1))),Set(b,Part($s("lst"),C2))),Set(c,Part($s("lst"),C3))),Set(d,Part($s("lst"),C4))),List(Times(SubstForInverseFunction(u,$s("tmp"),Times(Plus(Times(CN1,a),Times(c,$(h,x))),Power(Plus(b,Times(CN1,Times(d,$(h,x)))),CN1)),x),Times(D($(h,x),x),Power(Power(Plus(b,Times(CN1,Times(d,$(h,x)))),C2),CN1))),$s("tmp"),Plus(Times(b,c),Times(CN1,Times(a,d)))))))),
SetDelayed(InverseFunctionOfQuotientOfLinears(u_,$p("x",$s("Symbol"))),
    If(Or(AtomQ(u),CalculusQ(u)),False,If(And(InverseFunctionQ(u),QuotientOfLinearsQ(Part(u,C1),x)),u,Module(List($s("tmp")),Catch(CompoundExpression(Scan(Function(If(NotFalseQ(Set($s("tmp"),InverseFunctionOfQuotientOfLinears(Slot1,x))),Throw($s("tmp")))),u),False)))))),
SetDelayed(SubstForFractionalPower(u_,v_,n_,w_,$p("x",$s("Symbol"))),
    If(AtomQ(u),If(SameQ(u,x),w,u),If(And(FractionalPowerQ(u),ZeroQ(Plus(Part(u,C1),Times(CN1,v)))),Power(x,Times(n,Part(u,C2))),Map(Function(SubstForFractionalPower(Slot1,v,n,w,x)),u)))),
SetDelayed(SubstForInverseFunction(u_,v_,$p("x",$s("Symbol"))),
    SubstForInverseFunction(u,v,Times(Plus(Times(CN1,Coefficient(Part(v,C1),x,C0)),$(InverseFunction(Head(v)),x)),Power(Coefficient(Part(v,C1),x,C1),CN1)),x)),
SetDelayed(SubstForInverseFunction(u_,v_,w_,$p("x",$s("Symbol"))),
    If(AtomQ(u),If(SameQ(u,x),w,u),If(And(SameQ(Head(u),Head(v)),ZeroQ(Plus(Part(u,C1),Times(CN1,Part(v,C1))))),x,Map(Function(SubstForInverseFunction(Slot1,v,w,x)),u)))),
SetDelayed(SubstForInverseLinear(u_,$p("x",$s("Symbol"))),
    Module(List(Set($s("lst"),FunctionOfInverseLinear(u,x)),a,b),If(FalseQ($s("lst")),False,CompoundExpression(CompoundExpression(Set(a,Part($s("lst"),C1)),Set(b,Part($s("lst"),C2))),List(RegularizeSubst(u,x,Plus(Times(Times(CN1,a),Power(b,CN1)),Times(C1,Power(Times(b,x),CN1)))),Plus(a,Times(b,x)),b))))),
SetDelayed(DerivativeDivides(u_,v_,$p("x",$s("Symbol"))),
    If(If(PolynomialQ(u,x),And(PolynomialQ(v,x),Equal(Exponent(v,x),Plus(Exponent(u,x),Times(CN1,C1)))),EasyDQ(u,x)),Module(List(Set(w,Block(List(Set($s("ShowSteps"),False)),D(u,x)))),If(ZeroQ(w),False,CompoundExpression(Set(w,Simplify(Times(v,Power(w,CN1)))),If(FreeQ(w,x),w,False)))),False)),
SetDelayed(EasyDQ(u_,$p("x",$s("Symbol"))),
    If(Or(Or(AtomQ(u),FreeQ(u,x)),Equal(Length(u),C0)),True,If(CalculusQ(u),False,If(Equal(Length(u),C1),EasyDQ(Part(u,C1),x),If(And(RationalFunctionQ(u,x),SameQ(RationalFunctionExponents(u,x),List(C1,C1))),True,If(ProductQ(u),If(FreeQ(First(u),x),EasyDQ(Rest(u),x),If(FreeQ(Rest(u),x),EasyDQ(First(u),x),False)),If(SumQ(u),And(EasyDQ(First(u),x),EasyDQ(Rest(u),x)),If(Equal(Length(u),C2),If(FreeQ(Part(u,C1),x),EasyDQ(Part(u,C2),x),If(FreeQ(Part(u,C2),x),EasyDQ(Part(u,C1),x),False)),False)))))))),
SetDelayed(Rt(Times($p("v",true),Power(u_,w_)),$p("n",$s("Integer"))),
    Condition(Module(List(Set(m,Numerator(NumericFactor(w)))),Condition(Times(Rt(v,n),Power(Rt(Power(u,Times(w,Power(m,CN1))),Times(n,Power(GCD(m,n),CN1))),Times(m,Power(GCD(m,n),CN1)))),Greater(m,C1))),Not(NegativeOrZeroQ(v)))),
SetDelayed(Rt(Times(u_,Power(v_,m_)),$p("n",$s("Integer"))),
    Condition(Times(Rt(Times(CN1,u),n),Power(Rt(Times(CN1,Power(v,Times(CN1,m))),n),CN1)),And(And(RationalQ(m),Less(m,C0)),NegativeQ(u)))),
SetDelayed(Rt(Times(u_,v_),$p("n",$s("Integer"))),
    Condition(Times(Rt(u,n),Rt(v,n)),Or(OddQ(n),And(Not(NegativeOrZeroQ(u)),Not(NegativeOrZeroQ(v)))))),
SetDelayed(Rt(Times($p("u",true),Power(Plus(a_,Times($p("b",true),Power(Sin(v_),C2))),$p("m",true))),$p("n",$s("Integer"))),
    Condition(Rt(Times(u,Power(Times(a,Power(Cos(v),C2)),m)),n),ZeroQ(Plus(a,b)))),
SetDelayed(Rt(Times($p("u",true),Power(Plus(a_,Times($p("b",true),Power(Cos(v_),C2))),$p("m",true))),$p("n",$s("Integer"))),
    Condition(Rt(Times(u,Power(Times(a,Power(Sin(v),C2)),m)),n),ZeroQ(Plus(a,b)))),
SetDelayed(Rt(Times($p("u",true),Power(Plus(a_,Times($p("b",true),Power(Sinh(v_),C2))),$p("m",true))),$p("n",$s("Integer"))),
    Condition(Rt(Times(u,Power(Times(a,Power(Cosh(v),C2)),m)),n),ZeroQ(Plus(a,Times(CN1,b))))),
SetDelayed(Rt(Times($p("u",true),Power(Plus(a_,Times($p("b",true),Power(Cosh(v_),C2))),$p("m",true))),$p("n",$s("Integer"))),
    Condition(Rt(Times(u,Power(Times(b,Power(Sinh(v),C2)),m)),n),ZeroQ(Plus(a,b)))),
SetDelayed(Rt(u_,$p("n",$s("Integer"))),
    Module(List(Set(v,Simplify(u))),CompoundExpression(If(Less(LeafCount(Together(v)),LeafCount(v)),Set(v,Together(v))),If(UnsameQ(v,u),Rt(v,n),Power(u,Times(C1,Power(n,CN1))))))),
SetDelayed(Mods(u_),
    If(Less(LeafCount(Plus(C1D2,Times(CN1,u))),LeafCount(u)),Times(ArcCot(Tan(Times(Pi,Plus(C1D2,Times(CN1,u))))),Power(Pi,CN1)),Times(ArcTan(Tan(Times(Pi,u))),Power(Pi,CN1)))),
SetDelayed(Mods(n_),
    Condition(Plus(C1D2,Times(CN1,Times(Mod(Plus(C1,Times(CN1,Times(C2,n))),C2),C1D2))),NumericQ(n)))
  );
}
