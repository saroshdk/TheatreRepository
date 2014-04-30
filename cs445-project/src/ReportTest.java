import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class ReportTest {
	Report r=new Report();
		@Before
		public void setUp() throws Exception {
		}

		@Test
		public void testreport_show(){
			String retResult=r.report_show("america");
			assertEquals(retResult,"Total bookings for this Show: america is 1 Total revenue made is 55.0");
		}
		
		@Test
		public void testreport_show1(){
			String retResult=r.report_show("AMERICA");
			assertEquals(retResult,"Total bookings for this Show: AMERICA is 1 Total revenue made is 55.0");
		}
		
		@Test
		public void testreport_show2(){
			String retResult=r.report_show("123");
			assertEquals(retResult,"No Information available for this show");
		}

		@Test
		public void testreport_date(){
			String retResult=r.report_date("10-jul-2014");
			assertEquals(retResult,"Total bookings for this date: 10-jul-2014 is 1 Total revenue made is 55.0");
		}
		@Test
		public void testreport_date1(){
			String retResult=r.report_date("10-JUL-2014");
			assertEquals(retResult,"Total bookings for this date: 10-JUL-2014 is 1 Total revenue made is 55.0");
		}
		@Test
		public void testreport_date2(){
			String retResult=r.report_date("10-Jul-2014");
			assertEquals(retResult,"Total bookings for this date: 10-Jul-2014 is 1 Total revenue made is 55.0");
		}
		@Test
		public void testreport_date3(){
			String retResult=r.report_date("djfd");
			assertEquals(retResult,"Invalid dates");
		}
		@Test
		public void testreport_date4(){
			String retResult=r.report_date("1-Jan-2014");
			assertEquals(retResult,"No bookings made for this date");
		}
		@Test
		public void testreport_date5(){
			String retResult=r.report_date("10-07-2014");
			assertEquals(retResult,"Invalid dates");
		}
		@Test
		public void testreport_daterange(){
			String retResult=r.report_daterange("10-Jul-2014","12-Jul-2014");
			assertEquals(retResult,"Total bookings between the start date:10-Jul-2014 and end date:12-Jul-2014 is 1 Total revenue made is 55.0");
		}
		@Test
		public void testreport_daterange1(){
			String retResult=r.report_daterange("dffsdm","vnsf");
			assertEquals(retResult,"Invalid dates");
		}
		@Test
		public void testreport_daterange2(){
			String retResult=r.report_daterange("dffsdm","11-jul-2014");
			assertEquals(retResult,"Invalid dates");
		}
		@Test
		public void testreport_daterange3(){
			String retResult=r.report_daterange("11-jul-2014","dffsdm");
			assertEquals(retResult,"Invalid dates");
		}
		@Test
		public void testreport_daterange4(){
			String retResult=r.report_daterange("1-jan-2014","15-jan-2014");
			assertEquals(retResult,"No data available");
		}
		
}
