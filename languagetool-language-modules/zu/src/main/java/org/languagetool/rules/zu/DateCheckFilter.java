/* LanguageTool, a natural language style checker
 * Copyright (C) 2014 Daniel Naber (http://www.danielnaber.de)
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

import org.languagetool.rules.AbstractDateCheckFilter;

import java.util.Calendar;
import java.util.Locale;

public class DateCheckFilter extends AbstractDateCheckFilter {

  @Override
  protected Calendar getCalendar() {
    return Calendar.getInstance(new Locale("zu", "ZA"));
  }

  @SuppressWarnings("ControlFlowStatementWithoutBraces")
  @Override
  protected int getDayOfMonth(String dayStr) {
    String day = dayStr.toLowerCase();
    // In Zulu, numbers 1-31 are used for dates
    if (day.equals("kunye")) return 1;
    if (day.equals("kubili")) return 2;
    if (day.equals("kuthathu")) return 3;
    if (day.equals("kune")) return 4;
    if (day.equals("kuhlanu")) return 5;
    if (day.equals("isithupha")) return 6;
    if (day.equals("isikhombisa")) return 7;
    if (day.equals("isishiyagalombili")) return 8;
    if (day.equals("isishiyagalolunye")) return 9;
    if (day.equals("ishumi")) return 10;
    // 11-19
    if (day.equals("ishumi nanye")) return 11;
    if (day.equals("ishumi nambili")) return 12;
    if (day.equals("ishumi nantathu")) return 13;
    if (day.equals("ishumi nane")) return 14;
    if (day.equals("ishumi nanhlanu")) return 15;
    if (day.equals("ishumi nesithupha")) return 16;
    if (day.equals("ishumi nesikhombisa")) return 17;
    if (day.equals("ishumi nesishiyagalombili")) return 18;
    if (day.equals("ishumi nesishiyagalolunye")) return 19;
    // 20-31
    if (day.equals("amashumi amabili")) return 20;
    if (day.equals("amashumi amabili nanye")) return 21;
    if (day.equals("amashumi amabili nambili")) return 22;
    if (day.equals("amashumi amabili nantathu")) return 23;
    if (day.equals("amashumi amabili nane")) return 24;
    if (day.equals("amashumi amabili nanhlanu")) return 25;
    if (day.equals("amashumi amabili nesithupha")) return 26;
    if (day.equals("amashumi amabili nesikhombisa")) return 27;
    if (day.equals("amashumi amabili nesishiyagalombili")) return 28;
    if (day.equals("amashumi amabili nesishiyagalolunye")) return 29;
    if (day.equals("amashumi amathathu")) return 30;
    if (day.equals("amashumi amathathu nanye")) return 31;
    return 0;
  }

  @SuppressWarnings("ControlFlowStatementWithoutBraces")
  @Override
  protected int getDayOfWeek(String dayStr) {
    String day = dayStr.toLowerCase();
    if (day.startsWith("isonto")) return Calendar.SUNDAY;
    if (day.startsWith("umsombuluko")) return Calendar.MONDAY;
    if (day.startsWith("ulwesibili")) return Calendar.TUESDAY;
    if (day.startsWith("ulwesithathu")) return Calendar.WEDNESDAY;
    if (day.startsWith("ulwesine")) return Calendar.THURSDAY;
    if (day.startsWith("ulwesihlanu")) return Calendar.FRIDAY;
    if (day.startsWith("umgqibelo")) return Calendar.SATURDAY;
    throw new RuntimeException("Could not find day of week for '" + dayStr + "'");
  }

  @SuppressWarnings("ControlFlowStatementWithoutBraces")
  @Override
  protected String getDayOfWeek(Calendar date) {
    String englishDay = date.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.UK);
    if (englishDay.equals("Sunday")) return "iSonto";
    if (englishDay.equals("Monday")) return "uMsombuluko";
    if (englishDay.equals("Tuesday")) return "uLwesibili";
    if (englishDay.equals("Wednesday")) return "uLwesithathu";
    if (englishDay.equals("Thursday")) return "uLwesine";
    if (englishDay.equals("Friday")) return "uLwesihlanu";
    if (englishDay.equals("Saturday")) return "uMgqibelo";
    return "";
  }

  @SuppressWarnings({"ControlFlowStatementWithoutBraces", "MagicNumber"})
  @Override
  protected int getMonth(String monthStr) {
    String mon = monthStr.toLowerCase();
    if (mon.startsWith("masingana")) return 1;     // January
    if (mon.startsWith("nhlolanja")) return 2;     // February
    if (mon.startsWith("ndasa")) return 3;         // March
    if (mon.startsWith("mbasa")) return 4;         // April
    if (mon.startsWith("nhlaba")) return 5;        // May
    if (mon.startsWith("nhlangula")) return 6;     // June
    if (mon.startsWith("ntulikazi")) return 7;     // July
    if (mon.startsWith("ncwabakazi")) return 8;    // August
    if (mon.startsWith("mandulo")) return 9;       // September
    if (mon.startsWith("mfumfu")) return 10;       // October
    if (mon.startsWith("lwezi")) return 11;        // November
    if (mon.startsWith("zibandlela")) return 12;   // December
    throw new RuntimeException("Could not find month '" + monthStr + "'");
  }
}