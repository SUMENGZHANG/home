package log.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OpLog {
    private String userName;
    private String desc;
    private Date insertTime;
    private String type;
    private String methodName;
    private String params;
    private String response;
}
