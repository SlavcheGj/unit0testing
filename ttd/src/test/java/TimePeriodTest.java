import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.smartcardio.TerminalFactory;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimePeriodTest {

    private TimePeriod testA;

    @Before
    public void setUp() throws ParseException {
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        testA = new TimePeriod(smp.parse("09/04/2019"), smp.parse("09/08/2019"));
    }

    @Test
    public void NotoverlapsWith() throws ParseException {
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        TimePeriod testB = new TimePeriod(smp.parse("09/03/2018"), smp.parse("09/10/2018"));
        Assert.assertFalse(testA.overlapsWith(testB));

    }

    @Test
    public void testAcontainsB() throws ParseException {
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        TimePeriod testB = new TimePeriod(smp.parse("01/06/2019"), smp.parse("04/07/2019"));
        Assert.assertTrue(testA.overlapsWith(testB));

    }

    @Test
    public void testBcontainsA() throws ParseException {
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        TimePeriod testB = new TimePeriod(smp.parse("11/06/2019"), smp.parse("03/08/2019"));
        Assert.assertTrue(testA.overlapsWith(testB));

    }

    @Test
    public void testBinteractA() throws ParseException {
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        TimePeriod testB = new TimePeriod(smp.parse("29/03/2019"), smp.parse("04/07/2019"));
        Assert.assertTrue(testA.overlapsWith(testB));

    }

    @Test
    public void testAinteractB() throws ParseException {
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        TimePeriod testB = new TimePeriod(smp.parse("29/04/2019"), smp.parse("04/09/2019"));
        Assert.assertTrue(testA.overlapsWith(testB));

    }

    @Test
    public void testAequalsB() throws ParseException {
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        TimePeriod testB = new TimePeriod(smp.parse("09/04/2019"), smp.parse("09/08/2019"));
        Assert.assertTrue(testA.overlapsWith(testB));

    }

    @Test
    public void testAendEqualToBstart() throws ParseException {
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        TimePeriod testA = new TimePeriod(smp.parse("09/04/2019"), smp.parse("09/08/2018"));
        TimePeriod testB = new TimePeriod(smp.parse("09/08/2018"), smp.parse("23/11/2018"));
        Assert.assertTrue(testA.overlapsWith(testB));
    }
}
