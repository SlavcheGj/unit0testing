import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimePeriod {

    private Date start;
    private Date end;

    public boolean overlapsWith(TimePeriod period) {
        // testAcontainsB()
        if ((this.start.before(period.start))
            && (this.end.after(period.end))) {
            return true;
        }
        // testBcontainsA()
        if ((this.start.after(period.start))
            && (this.end.before(period.end))) {
            return true;
        }
        // testBinteractA()
        if ((this.start.after(period.start))
            && (this.end.after(period.end))&& isEndInBetwineBeginingAndEndOfBInterA(period)) {
            return true;
        }
        // testAinteractB()
        if ((this.start.before(period.start))
            && (this.end.before(period.end))&& isEndBetwineBeginingAndEndOfAInterB(period)) {
            return true;
        }
        // testAequalsB()
        if ((this.start.equals(period.start))
            && (this.end.equals(period.end))) {
            return true;
        }
        // testAendEqualToBstart()
        if (this.end.equals(period.start)) {
            return true;
        }
        return false;
    }

  private boolean isEndInBetwineBeginingAndEndOfBInterA(TimePeriod timePeriod){
        return timePeriod.end.after(this.start)&&timePeriod.end.before(this.end);
    }

    private boolean isEndBetwineBeginingAndEndOfAInterB(TimePeriod timePeriod){
        return this.end.after(timePeriod.start)&&this.end.before(timePeriod.end);
    }



}

