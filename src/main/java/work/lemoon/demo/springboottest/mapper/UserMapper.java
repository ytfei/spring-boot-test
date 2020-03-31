package work.lemoon.demo.springboottest.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import work.lemoon.demo.springboottest.service.dto.User;

@Repository
public interface UserMapper {

    @Select("select count(1) from user")
    int countUser();

    @Insert("insert into user(name) values(#{name})")
    int addUser(User user);

    void updateName(@Param("id") long id, @Param("name") String name);
}
