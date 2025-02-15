/* LanguageTool, a natural language style checker
 * Copyright (C) 2019 Daniel Naber (http://www.danielnaber.de)
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
package org.languagetool.rules.zu;

import org.junit.Test;
import org.languagetool.LanguageSpecificTest;
import org.languagetool.language.Zulu;

import java.io.IOException;
import java.util.Arrays;

public class ZuluTest extends LanguageSpecificTest {
  //todo fix this
  @Test
  public void testLanguage() throws IOException {
    // NOTE: this text needs to be kept in sync with config.ts -> DEMO_TEXTS:
    String s = "Algluu vian kontrolendan tekston ĉi tie... Aŭ nur kontrolu ĉi tiun ekzemplon. Ĉu vi vi rimarkis, ke estas gramatikaj eraro en tiu frazo? Rimarku, ke Lingvoilo ankaux atentigas pri literumaj erraroj kiel ĉi-tiu.";
    Zulu lang = new Zulu();
    testDemoText(lang, s,
      Arrays.asList("WORD_REPEAT_RULE", "NEKONG_NOMBR", "X_SISTEMO", "HUNSPELL_RULE", "CXI_TIU")
    );
    runTests(lang);
  }
}
