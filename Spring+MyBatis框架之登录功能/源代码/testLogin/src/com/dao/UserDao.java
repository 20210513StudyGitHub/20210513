package com.dao;

import java.util.Map;
import java.util.List;
import com.po.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//Dao层
@Repository("userDao")  //供Spring使用，注入
@Mapper //供MyBatis使用
    /*使用Spring自动扫描MyBatis的接口并装配
    (Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口)*/
public interface UserDao {
    /**
     * 接口方法selectOneUser对应SQL映射文件UserDaoMapper.xml中的id
     * 使用Map接口通过键值对传递多个参数
     */
    public List<UserInformation> selectOneUser(Map<String,Object> param);
}
