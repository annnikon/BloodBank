<%
  // get the current year/month/day
 java.util.Calendar theCal = java.util.Calendar.getInstance();
  int currentYearInt  = theCal.get(java.util.Calendar.YEAR);
  int currentMonthInt = theCal.get(java.util.Calendar.MONTH);
  int currentDayInt   = theCal.get(java.util.Calendar.DATE);
  String currentYearString  = new Integer(currentYearInt).toString();
  String currentMonthString = new Integer(currentMonthInt).toString();

  // get parameters the user might have sent by clicking fwd or back
  String newMonth = request.getParameter("month");
  String newYear  = request.getParameter("year");

  // reset the month and year if necessary
  if ( newMonth != null )
  {
    currentMonthString = newMonth;
  }
  if ( newYear != null )
  {
    currentYearString = newYear;
  }

  // determine the next/previous month and year
  int intMonth = new Integer(currentMonthString).intValue();
  int intYear  = new Integer(currentYearString).intValue();

  // determine the name of the current intMonth
  String monthNames[] = {"January",
                         "February",
                         "March",
                         "April",
                         "May",
                         "June",
                         "July",
                         "August",
                         "September",
                         "October",
                         "November",
                         "December" };

  String monthName = monthNames[intMonth];

  // determine the next/previous month and year.
  // this is really only needed by calendar.jsp, but i moved it here
  // to simplify calendar.jsp.
  int nextYear = intYear;
  int prevYear = intYear;
  int prevMonth = intMonth-1;
  if ( prevMonth==-1 )
  {
    prevMonth=11;
    prevYear--;
  }
  int nextMonth = intMonth+1;
  if ( nextMonth==12 )
  {
    nextMonth = 0;
    nextYear++;
  }

%>


