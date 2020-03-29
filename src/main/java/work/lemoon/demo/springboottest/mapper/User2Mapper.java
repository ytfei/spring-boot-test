package work.lemoon.demo.springboottest.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import work.lemoon.demo.springboottest.service.dto.User;

/**
 * 如果不加 @Mapper 注解，那么单元测试上要增加 @MapperScan("work.lemoon.demo.springboottest.mapper")
 */
@Mapper
public interface User2Mapper {

    @Select("select count(1) from user")
    int countUser();

    @Insert("insert into user(name) values(#{name})")
    int addUser(User user);

    @Select("select id, name from user where id = #{id}")
    User selectOne(@Param("id") long id);
}
