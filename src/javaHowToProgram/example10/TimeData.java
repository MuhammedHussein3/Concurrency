package javaHowToProgram.example10;

import java.time.Duration;
import java.time.Instant;

public class TimeData {

    public Instant start;
    public Instant end;

    public double timeInSeconds(){
        return Duration.between(start, end).toMillis();
    }
}
