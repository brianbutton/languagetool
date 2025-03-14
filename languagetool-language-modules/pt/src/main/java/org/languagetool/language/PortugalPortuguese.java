/* LanguageTool, a natural language style checker 
 * Copyright (C) 2012 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.language;

import org.jetbrains.annotations.NotNull;
import org.languagetool.Language;
import org.languagetool.Languages;
import org.languagetool.UserConfig;
import org.languagetool.rules.Rule;
import org.languagetool.rules.pt.*;

import java.io.IOException;
import java.util.*;

public class PortugalPortuguese extends Portuguese {
  private static final String LANGUAGE_SHORT_CODE = "pt-PT";

  private static volatile Throwable instantiationTrace;

  public PortugalPortuguese() {
    this(false);
    Throwable trace = instantiationTrace;
    if (trace != null) {
      throw new RuntimeException("Language was already instantiated, see the cause stacktrace below.", trace);
    }
    instantiationTrace = new Throwable();
  }

  protected PortugalPortuguese(boolean fakeValue) {
    super(fakeValue);
  }

  @Override
  public String getName() {
    return "Portuguese (Portugal)";
  }

  @Override
  public String[] getCountries() {
    return new String[]{"PT"};
  }

  @Override
  public List<Rule> getRelevantRules(ResourceBundle messages, UserConfig userConfig, Language motherTongue, List<Language> altLanguages) throws IOException {
    List<Rule> rules = new ArrayList<>(super.getRelevantRules(messages, userConfig, motherTongue, altLanguages));
    rules.add(new PostReformPortugueseCompoundRule(messages, this, userConfig));
    rules.add(new PostReformPortugueseDashRule(messages));
    rules.add(new PortugueseAgreementReplaceRule(messages, this));
    rules.add(new PortugalPortugueseReplaceRule(messages, "/pt/pt-PT/replace.txt", this));
    rules.add(new PortugueseBarbarismsRule(messages, "/pt/pt-PT/barbarisms.txt", this));
    rules.add(new PortugueseArchaismsRule(messages, "/pt/pt-PT/archaisms.txt", this));
    rules.add(new PortugueseClicheRule(messages, "/pt/pt-PT/cliches.txt", this));
    rules.add(new PortugueseRedundancyRule(messages, "/pt/pt-PT/redundancies.txt", this));
    rules.add(new PortugueseWordinessRule(messages, "/pt/pt-PT/wordiness.txt", this));
    rules.add(new PortugueseWikipediaRule(messages, "/pt/pt-PT/wikipedia.txt", this));
    return rules;
  }
  
  private final static Map<String, Integer> id2prio = new HashMap<>();
  static {
    id2prio.put("PT_COMPOUNDS_POST_REFORM", 1);
    id2prio.put("PORTUGUESE_OLD_SPELLING_INTERNAL", -9);	  
  }

  @Override
  public Map<String, Integer> getPriorityMap() {
    return id2prio;
  }

  @Override
  protected int getPriorityForId(String id) {
    Integer prio = id2prio.get(id);
    if (prio != null) {
      return prio;
    }
    return super.getPriorityForId(id);
  }

  @Override
  public String getOpeningDoubleQuote() {
    return "«";
  }

  @Override
  public String getClosingDoubleQuote() {
    return "»";
  }

  public static @NotNull Portuguese getInstance() {
    Language language = Objects.requireNonNull(Languages.getLanguageForShortCode(LANGUAGE_SHORT_CODE));
    if (language instanceof Portuguese portugalPortuguese) {
      return portugalPortuguese;
    }
    throw new RuntimeException("PortugalPortuguese language expected, got " + language);
  }
}
