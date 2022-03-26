package sumeng.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sumeng.home.mapper.LogMapper;
import sumeng.log.beans.OpLog;

@Service
public class LogService {

    @Autowired
    private LogMapper logMapper;
    public void saveLog(OpLog opLog){
        logMapper.insertUserLog(opLog);
    }
}
