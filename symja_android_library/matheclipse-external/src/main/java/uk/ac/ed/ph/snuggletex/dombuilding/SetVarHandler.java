/* $Id: SetVarHandler.java 525 2010-01-05 14:07:36Z davemckain $
 *
 * Copyright (c) 2010, The University of Edinburgh.
 * All Rights Reserved
 */
package uk.ac.ed.ph.snuggletex.dombuilding;

import uk.ac.ed.ph.snuggletex.internal.DOMBuilder;
import uk.ac.ed.ph.snuggletex.internal.SnuggleParseException;
import uk.ac.ed.ph.snuggletex.tokens.CommandToken;

import org.w3c.dom.Element;

/**
 * Handles the <tt>\\setvar</tt> macro.
 *
 * @author David McKain
 * @version $Revision: 525 $
 */
public final class SetVarHandler implements CommandHandler {

  public void handleCommand(DOMBuilder builder, Element parentElement, CommandToken token)
      throws SnuggleParseException {
    String namespace = null;
    if (token.getOptionalArgument() != null) {
      namespace = builder.extractStringValue(token.getOptionalArgument());
    }
    String variableName = builder.extractStringValue(token.getArguments()[0]);
    String value = builder.extractStringValue(token.getArguments()[1]);
    builder.getVariableManager().setVariable(namespace, variableName, value);
  }
}
