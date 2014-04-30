import static org.junit.Assert.*;

	import org.junit.Before;
	import org.junit.Test;
public class ShowInfoTest {
	ShowInfo s=new ShowInfo();
		@Before
		public void setUp() throws Exception {
		}

		@Test
		public void testgetName() {
			s.setName("rio");
			assertEquals(s.getName(),"rio");
			
		}
		@Test
		public void testgetDate() {
			s.setDate("10-jul-2014");
			assertEquals(s.getDate(),"10-jul-2014");
			
		}
		@Test
		public void testgetLocation() {
			s.setLocation("Chicago");
			assertEquals(s.getLocation(),"Chicago");
			
		}
		@Test
		public void testgetTime() {
			s.setTime("6pm");
			assertEquals(s.getTime(),"6pm");
			
		}
		@Test
		public void testgetSeat() {
			s.setSeat("1");
			assertEquals(s.getSeat(),"1");
			
		}
		@Test
		public void testgetPrice() {
			s.setPrice("20");
			assertEquals(s.getPrice(),"20");
			
		}
		
		

}
