package api.dateDiff.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import api.dateDiff.model.DateDiff;

//@WebServlet("/DateDiffJavaClass")
@Service
public class DateDiffWebServiceImpl {

	// private static final long serialVersionUID = 1L;

	// @Override
	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	public DateDiff calculateDifference(DateDiff dateDiff) {
		try {
			String date1 = dateDiff.getFromDate() + " " + dateDiff.getFromTime();
			String date2 = dateDiff.getToDate() + " " + dateDiff.getToTime();
			LocalDateTime from = LocalDateTime.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			LocalDateTime to = LocalDateTime.parse(date2, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

			if (from.isAfter(to)) {
				LocalDateTime temp = to;
				to = from;
				from = temp;
			}

			LocalDateTime fromTemp = LocalDateTime.from(from);

			long years = fromTemp.until(to, ChronoUnit.YEARS);
			dateDiff.setYears("Years:\t\t" + years);
			fromTemp = fromTemp.plusYears(years);

			long months = fromTemp.until(to, ChronoUnit.MONTHS);
			dateDiff.setMonths("Months:\t\t" + months);
			fromTemp = fromTemp.plusMonths(months);

			long days = fromTemp.until(to, ChronoUnit.DAYS);
			dateDiff.setDays("Days:\t\t" + days);
			fromTemp = fromTemp.plusDays(days);

			long hours = fromTemp.until(to, ChronoUnit.HOURS);
			dateDiff.setHours("Hours:\t\t" + hours);
			fromTemp = fromTemp.plusHours(hours);

			long minutes = fromTemp.until(to, ChronoUnit.MINUTES);
			dateDiff.setMinutes("Minutes:\t" + minutes);
			fromTemp = fromTemp.plusMinutes(minutes);

			long seconds = fromTemp.until(to, ChronoUnit.SECONDS);
			dateDiff.setSeconds("Seconds:\t" + seconds);
			fromTemp = fromTemp.plusSeconds(seconds);

			dateDiff.setResult(String.format("\nYears:\t\t%s\nMonths:\t\t%s\nDays:\t\t%s<br>Hours:\t\t%s<hr>Minutes:\t%s<hr>Seconds:\t%s", years, months, days, hours, minutes, seconds));
			return dateDiff;
		} catch (Exception e) {
			dateDiff.setResult("\nIncorrect Input. Must be in ISO Date Format: 'yyyy-MM-dd HH:mm:ss'");
			dateDiff.setYears("\nIncorrect Input. Must be in ISO Date Format: 'yyyy-MM-dd HH:mm:ss'");
			return dateDiff;
		}
	}

}
