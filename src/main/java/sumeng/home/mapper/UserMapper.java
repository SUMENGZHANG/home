package sumeng.home.mapper;


import log.annotation.MyLog;
import sumeng.entity.User;


public interface UserMapper {

    @MyLog(operateType = "1",operateExplain = "123")
    User selectUserById(Integer id);
}
