package work.lemoon.demo.springboottest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Select;
import work.lemoon.demo.springboottest.service.dto.User;

/**
 * Tengfei Yang 3/31/20
 **/
public interface UserPlusMapper extends BaseMapper<User> {

    @Select("select id, name from user")
    IPage<User> selectByPage(Page<?> page);

}
