package springboot.queryfunctioninjpa.exceptionhandle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ErrorFile {
    private Date date;
    private String message;


    public ErrorFile(Date date, String message) {
        super();
        this.date = date;
        this.message = message;

    }
}
