package org.languagetool.language;

import org.jetbrains.annotations.Nullable;
import org.languagetool.*;
import org.languagetool.rules.*;
import org.languagetool.rules.spelling.SpellingCheckRule;
import org.languagetool.rules.spelling.hunspell.HunspellRule;
import org.languagetool.tools.Tools;
//import org.languagetool.tagging.Tagger;
//import org.languagetool.tagging.disambiguation.Disambiguator;
//import org.languagetool.tagging.disambiguation.rules.XmlRuleDisambiguator;
//import org.languagetool.tagging.zu.ZuluTagger;
//import org.languagetool.tokenizers.*;
//import org.languagetool.tokenizers.zu.ZuluWordTokenizer;

import java.io.IOException;
import java.util.*;

public class Zulu extends Language {

  /*@Override
  public SentenceTokenizer createDefaultSentenceTokenizer() {
    return new SRXSentenceTokenizer(this);
  }*/

  /*@Override
  public Tokenizer createDefaultWordTokenizer() {
    return new ZuluWordTokenizer();
  }*/

  @Override
  public String getName() {
    return "Zulu";
  }
  
  @Override
  public String getShortCode() {
    return "zu";
  }

  @Override
  public String[] getCountries() {
    return new String[]{"ZA"};
  }

  @Override
  public String getCommonWordsPath() {
    // TODO: provide common words file
    return null;
  }

  @Override
  public Contributor[] getMaintainers() {
    return new Contributor[] { new Contributor("Brian Button") };
  }

  @Override
  public LanguageMaintainedState getMaintainedState() {
    return LanguageMaintainedState.ActivelyMaintained;
  }

  /*@NotNull
  @Override
  public Tagger createDefaultTagger() {
    return new ZuluTagger();
  }

  @Override
  public Disambiguator createDefaultDisambiguator() {
    return new XmlRuleDisambiguator(new Zulu());
  }*/

  @Override
  public List<Rule> getRelevantRules(ResourceBundle messages, UserConfig userConfig, Language motherTongue, List<Language> altLanguages) {
    return Arrays.asList(
            new CommaWhitespaceRule(messages,
              Example.wrong("Sibe nekhofi<marker> ,</marker> ushizi namakhukhi namagilebhisi."),
              Example.fixed("Sibe nekhofi<marker>,</marker> ushizi namakhukhi namagilebhisi.")),
            new DoublePunctuationRule(messages),
            new GenericUnpairedBracketsRule(messages),
            new HunspellRule(messages, this, userConfig, altLanguages),
            new UppercaseSentenceStartRule(messages, this,
              Example.wrong("Le ndlu indala. <marker>yakhiwa</marker> ngo-1950."),
              Example.fixed("Le ndlu indala. <marker>Yakhiwa</marker> ngo-1950."),
              Tools.getUrl("https://languagetool.org/insights/post/spelling-capital-letters/")),
            new WordRepeatRule(messages, this),
            new MultipleWhitespaceRule(messages, this),
            new SentenceWhitespaceRule(messages)
    );
  }



  @Nullable
  @Override
  protected SpellingCheckRule createDefaultSpellingRule(ResourceBundle messages) throws IOException {
    return new HunspellRule(messages, this, null,null);
  }
}
