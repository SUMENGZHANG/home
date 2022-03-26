package sumeng.home.mapper;



import org.springframework.stereotype.Component;
import sumeng.entity.User;


@Component
public interface UserMapper {


    User selectUserById(Integer id);
}
