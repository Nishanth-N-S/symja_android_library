package org.matheclipse.io.system;

import org.matheclipse.core.combinatoric.MultisetPartitionsIterator;
import org.matheclipse.core.combinatoric.RosenNumberPartitionIterator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.patternmatching.FlatOrderlessStepVisitor;
import org.matheclipse.core.patternmatching.IPatternMap;
import org.matheclipse.core.patternmatching.PatternMatcher;

/** Tests for combinatorial functions */
public class CombinatoricTestCase extends AbstractTestCase {
  public CombinatoricTestCase(String name) {
    super(name);
  }

  /** Test combinatorial functions */
  public void testCombinatoric() {
    // check("KOrderlessPartitions(f(g),1)", //
    // "{f(g)}");
    // check("KOrderlessPartitions(f(),1)", //
    // "KOrderlessPartitions(f(),1)");
    check(
        "KOrderlessPartitions(w+x+x+y+z,5)", //
        "KOrderlessPartitions(w+2*x+y+z,5)");
    check(
        "KOrderlessPartitions(w+x+x+y+z,6)", //
        "KOrderlessPartitions(w+2*x+y+z,6)");
    check(
        "KOrderlessPartitions(w+x+x+y+z,3)", //
        "{{w,2*x,y+z},{w,2*x+y,z},{w+2*x,y,z},{w,2*x+z,y},{w+2*x,z,y},{w,y,2*x+z},{w+y,2*x,z},{w,y+z,\n"
            + "2*x},{w+y,z,2*x},{w,z,2*x+y},{w+z,2*x,y},{w+z,y,2*x},{2*x,w,y+z},{2*x,w+y,z},{2*x,w+z,y},{\n"
            + "2*x,y,w+z},{2*x+y,w,z},{2*x,y+z,w},{2*x+y,z,w},{2*x,z,w+y},{2*x+z,w,y},{2*x+z,y,w},{y,w,\n"
            + "2*x+z},{y,w+2*x,z},{y,w+z,2*x},{y,2*x,w+z},{y,2*x+z,w},{y,z,w+2*x},{y+z,w,2*x},{y+z,\n"
            + "2*x,w},{z,w,2*x+y},{z,w+2*x,y},{z,w+y,2*x},{z,2*x,w+y},{z,2*x+y,w},{z,y,w+2*x}}");

    check(
        "KPartitions({v,w,x,y,z},3)", //
        "{{{v},{w},{x,y,z}},{{v},{w,x},{y,z}},{{v},{w,x,y},{z}},{{v,w},{x},{y,z}},{{v,w},{x,y},{z}},{{v,w,x},{y},{z}}}");

    check(
        "IntegerPartitions(3)", //
        "{{3},{2,1},{1,1,1}}");
    check(
        "IntegerPartitions(5)", //
        "{{5},{4,1},{3,2},{3,1,1},{2,2,1},{2,1,1,1},{1,1,1,1,1}}");
    check(
        "IntegerPartitions(10)", //
        "{{10},{9,1},{8,2},{8,1,1},{7,3},{7,2,1},{7,1,1,1},{6,4},{6,3,1},{6,2,2},{6,2,1,1},{\n"
            + "6,1,1,1,1},{5,5},{5,4,1},{5,3,2},{5,3,1,1},{5,2,2,1},{5,2,1,1,1},{5,1,1,1,1,1},{\n"
            + "4,4,2},{4,4,1,1},{4,3,3},{4,3,2,1},{4,3,1,1,1},{4,2,2,2},{4,2,2,1,1},{4,2,1,1,1,\n"
            + "1},{4,1,1,1,1,1,1},{3,3,3,1},{3,3,2,2},{3,3,2,1,1},{3,3,1,1,1,1},{3,2,2,2,1},{3,\n"
            + "2,2,1,1,1},{3,2,1,1,1,1,1},{3,1,1,1,1,1,1,1},{2,2,2,2,2},{2,2,2,2,1,1},{2,2,2,1,\n"
            + "1,1,1},{2,2,1,1,1,1,1,1},{2,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1}}");

    check(
        "Permutations({1,1,1})", //
        "{{1,1,1}}");
    check(
        "Permutations({2,1,0})", //
        "{{2,1,0},{2,0,1},{1,2,0},{1,0,2},{0,2,1},{0,1,2}}");
    check(
        "Permutations({1,2,2,3})", //
        "{{1,2,2,3},{1,2,3,2},{1,3,2,2},{2,1,2,3},{2,1,3,2},{2,2,1,3},{2,2,3,1},{2,3,1,2},{\n"
            + "2,3,2,1},{3,1,2,2},{3,2,1,2},{3,2,2,1}}");
    check(
        "Partition({t,u,v,w,x,y,z},3,2)", //
        "{{t,u,v},{v,w,x},{x,y,z}}");
  }

  public void testRosenIterator() {
    IAST lhsPatternAST = F.Plus(F.x_, F.y_, F.z_);
    IAST lhsEvalAST = F.Plus(F.a, F.b, F.c, F.d);

    PatternMatcher patternMatcher = new PatternMatcher(lhsPatternAST);
    IPatternMap patternMap = patternMatcher.createPatternMap();
    // StackMatcher stackMatcher = patternMatcher.new StackMatcher(EvalEngine.get());
    FlatOrderlessStepVisitor visitor =
        new FlatOrderlessStepVisitor(F.Plus, lhsPatternAST, lhsEvalAST, patternMatcher, patternMap);
    MultisetPartitionsIterator iter =
        new MultisetPartitionsIterator(visitor, lhsPatternAST.argSize());
    boolean b = false;
    while (!b) {
      b = iter.execute();
      if (!b) {
        System.out.println(iter.toString());
        iter.initPatternMap();
      }
    }
    assertEquals(true, b);
  }

  public static void testRosenNumberPartitionIterator() {
    RosenNumberPartitionIterator i = new RosenNumberPartitionIterator(10, 4);
    StringBuilder buf = new StringBuilder(256);
    while (i.hasNext()) {
      int[] t = i.next();
      for (int j = 0; j < t.length; j++) {
        // System.out.print(t[j]);
        buf.append(t[j]);
        buf.append(" ");
      }
      // System.out.println();
      buf.append("|");
    }
    assertEquals(
        "1 1 1 7 |1 1 2 6 |1 1 3 5 |1 1 4 4 |1 1 5 3 |1 1 6 2 |1 1 7 1 |1 2 1 6 |1 2 2 5 |1 2 3 4 |1 2 4 3 |1 2 5 2 |1 2 6 1 |1 3 1 5 |1 3 2 4 |1 3 3 3 |1 3 4 2 |1 3 5 1 |1 4 1 4 |1 4 2 3 |1 4 3 2 |1 4 4 1 |1 5 1 3 |1 5 2 2 |1 5 3 1 |1 6 1 2 |1 6 2 1 |1 7 1 1 |2 1 1 6 |2 1 2 5 |2 1 3 4 |2 1 4 3 |2 1 5 2 |2 1 6 1 |2 2 1 5 |2 2 2 4 |2 2 3 3 |2 2 4 2 |2 2 5 1 |2 3 1 4 |2 3 2 3 |2 3 3 2 |2 3 4 1 |2 4 1 3 |2 4 2 2 |2 4 3 1 |2 5 1 2 |2 5 2 1 |2 6 1 1 |3 1 1 5 |3 1 2 4 |3 1 3 3 |3 1 4 2 |3 1 5 1 |3 2 1 4 |3 2 2 3 |3 2 3 2 |3 2 4 1 |3 3 1 3 |3 3 2 2 |3 3 3 1 |3 4 1 2 |3 4 2 1 |3 5 1 1 |4 1 1 4 |4 1 2 3 |4 1 3 2 |4 1 4 1 |4 2 1 3 |4 2 2 2 |4 2 3 1 |4 3 1 2 |4 3 2 1 |4 4 1 1 |5 1 1 3 |5 1 2 2 |5 1 3 1 |5 2 1 2 |5 2 2 1 |5 3 1 1 |6 1 1 2 |6 1 2 1 |6 2 1 1 |7 1 1 1 |", //
        buf.toString());
  }
}
