package mapper;

import org.apache.ibatis.annotations.Insert;

import entity.User;

public interface UserMapper {

	@Insert("insert into t_user values(#{id},#{name},#{organization},#{email},#{phone},#{address}) ")
	int insert(User user);

}
