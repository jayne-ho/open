package cn.jayneo.open.mapper;

import cn.jayneo.open.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * 用户处理持久层接口
 */
public interface UserMapper {

    /**
     * 根据email查询用户数据
     * @param Email 用户邮箱
     * @return 匹配的用户数据
     */
    @Select("SELECT uid, firstName, lastName, email, password, salt, avatar, is_delete isDelete" +
            " FROM t_user" +
            " WHERE email=#{email}")
    UserEntity findByEmail(String Email);

    /**
     * 插入数据
     * @param user 用户数据
     * @return 受影响的行数
     */
    @Insert(
            "INSERT INTO t_user (" +
                    "firstName, lastName, password, salt, gender, avatar, phone, email, is_delete) " +
                    "VALUES (" +
                    "#{firstName},#{lastName},#{password},#{salt}, #{gender}, #{avatar},#{phone},#{email},#{isDelete}" +
                    ")"
    )
    Integer addNew(UserEntity user);

}
