<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.devdaily.calendar.Month,java.util.Calendar,java.io.*,java.sql.*,com.devdaily.*" errorPage="error.jsp" %>
<%-- TODO: CLEAN UP THE PAGE TAG ABOVE --%>

<%@ include file="calendarCommon.jsp" %>

<div id="calendar_main_div">
<table border="1" cellspacing="0" cellpadding="4" id="calendar_table" class="table-hover">
  <tr>
    <td width="100%" colspan="7" class="month_year_header">
      <%=monthName%>, <%=intYear%>
    </td>
  </tr>
  <tr class="week_header_row">
    <th width="14%" class="th_day_cell day">Sun</th>
    <th width="14%" class="th_day_cell day">Mon</th>
    <th width="14%" class="th_day_cell day">Tue</th>
    <th width="14%" class="th_day_cell day">Wed</th>
    <th width="14%" class="th_day_cell day">Thu</th>
    <th width="15%" class="th_day_cell day">Fri</th>
    <th width="15%" class="th_day_cell day">Sat</th>
  </tr>
 
<%
{
  Month aMonth = Month.getMonth( Integer.parseInt(currentMonthString), Integer.parseInt(currentYearString) );
  int [][] days = aMonth.getDays(); %>
    <c:set var = "month" scope = "session" value = "<%=aMonth.getMonth()%>"/>
      <c:set var = "year" scope = "session" value = "<%=aMonth.getYear()%>"/>
       <c:set var = "eMonth" scope = "session" value = "${event.getDate().getMonth()}"/>
      <c:set var = "eYear" scope = "session" value = "${event.getDate().getYear()} "/>
       <c:set var = "eDay" scope = "session" value = "${event.getDate().getDate()} "/>
      
  <%
  for( int i=0; i<aMonth.getNumberOfWeeks(); i++ )
  {
    %><tr class="week_data_row"><%
    for( int j=0; j<7; j++ )
    {
    	 %>
    	    <c:set var = "day" scope = "session" value = "<%=days[i][j]%>"/>
    	     
    	      
    	  <%
    	if( days[i][j] == 0 )
      {
        %><td class="empty_day_cell">&nbsp;</td><%
      }
      else
      {
        // this is "today"
        if( currentDayInt == days[i][j] && currentMonthInt == aMonth.getMonth() && currentYearInt == aMonth.getYear() )
        {
          %><td class="today_cell"><%=days[i][j]%> Today 
         </td><%
        }
        else
        {
        	%><td class="day_cell"><%=days[i][j]%> <a href="#">Add event</a>
        	
            </td><%
        }
      } // end outer if
    } // end for
    %>
    </tr>
  <%}
}
%>
</table>

<%-- end of "calendar_div" --%>
</div>

<!-- navigation links -->
<%-- sorry, i don't know how to get this look without a table --%>
<table id="calendar_nav_table" border="0" class="table-hover">
  <tr>
    <td id="prev_link">
      <form method="post">
        <input type="submit" name="PREV" value=" << " class="btn btn-xl">
        <input type="hidden" name="month" value="<%=prevMonth%>">
        <input type="hidden" name="year" value="<%=prevYear%>">
        
         <input type="hidden" name="login" value="${user.getLogin()}">
         <input type="hidden" name="password" value="${user.getPassword()}">
      </form>
    </td>
    
    <td id="next_link">
      <form method="post">
        <input type="submit" name="NEXT" value=" >> " class="btn btn-xl">
        <input type="hidden" name="month" value="<%=nextMonth%>">
        <input type="hidden" name="year" value="<%=nextYear%>">
        
         <input type="hidden" name="login" value="${user.getLogin()}">
         <input type="hidden" name="password" value="${user.getPassword()}">
      </form>
    </td>
  </tr>
</table>
  <!-- navigation links end -->


