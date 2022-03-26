package sumeng.home.mapper;

import org.springframework.stereotype.Component;
import sumeng.log.beans.OpLog;

@Component
public interface LogMapper {

    boolean insertUserLog(OpLog opLog);
}
