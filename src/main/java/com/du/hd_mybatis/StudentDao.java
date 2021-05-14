package com.du.hd_mybatis;
import com.du.hd_entity.Student;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StudentDao {
    /***************************************************************************************************************************
     *  @fn             Mybatis_SelectAllFun
     *  @brief          学生表全查询操作
     *  @type           抽象方法
     *  @detail         mybatis框架将此抽象方法与dao.xml做映射操作，通过代理调用该接口的实现类实现的此方法来寻找执行的sql语句，
     *      *                  方法进行数据库中学生表全查询操作，并将封装好的学生结果集返回，若查询失败，函数返回null结果，调用者
     *      *                  需要做空指针判断。
     *  @param[in]      无
     *  @return         List<Student> 学生表结果集
     ****************************************************************************************************************************/
    List<Student> Mybatis_SelectAllFun();

    /***************************************************************************************************************************
     *  @fn             Mybatis_SelectStudentByUsernameFun
     *  @brief          学生表通过用户名查询学生操作
     *  @type           抽象方法
     *  @detail          mybatis框架将此抽象方法与dao.xml做映射操作，通过代理调用该接口的实现类实现的此方法来寻找执行的sql语句,
     *                  方法根据输入参数学生姓名查询对应学生信息操作，并将封装好的学生结果集返回，若查询失败，
     *                  函数返回null结果，调用者需要做空指针判断。
     *  @param[in]      String username 学生姓名
     *  @return         Student 学生信息
     ****************************************************************************************************************************/
    Student Mybatis_SelectStudentByUsernameFun(@Param("username")String username);
}
