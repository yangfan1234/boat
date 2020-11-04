package com.boat.web.mapper;

import com.boat.web.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * 用户mapper
 *
 * @author yangfan
 * @createTime 2020-08-03 16:40
 */
public interface UserMapper {

    /**
     * 根据主键查询
     *
     * @param id 用户主键
     * @return com.boat.web.domain.User
     * @author yangfan
     * @createTime 2020-08-03 04:43:27
     */
    @Select("select * from tb_user where id = #{id}")
    User get(Integer id);
}
