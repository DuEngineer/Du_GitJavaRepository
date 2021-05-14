package com.du.hd_jdbc;
import com.du.hd_entity.Student;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcDemo {

    /***************************************************************************************************************************
     *  @fn             JDBC_SelectFun
     *  @brief          学生表全查询操作
     *  @type           静态方法
     *  @detail         调用方法,方法进行数据库中学生表全查询操作，并将封装好的学生结果集返回，若查询失败，函数返回null结果，调用者
     *                  需要做空指针判断。
     *  @param[in]      无
     *  @return         List<Student> 学生表结果集
     ****************************************************************************************************************************/
    public static List<Student> JDBC_SelectAllFun() {
        try {
            /* 获取数据库连接配置信息*/
            Properties properties = new Properties();
            InputStream resourceAsStream = JdbcDemo.class.getClassLoader().getResourceAsStream("mysql.properties");
            properties.load(resourceAsStream);
            String mysqlDriver = properties.getProperty("mysql.driver");
            String mysqlUrl = properties.getProperty("mysql.url");
            String mysqlUsername = properties.getProperty("mysql.username");
            String mysqlPassword = properties.getProperty("mysql.password");
            /* 注册mysql驱动*/
            Class.forName(mysqlDriver);
            /* 获取mysql连接*/
            Connection connection = DriverManager.getConnection(mysqlUrl,mysqlUsername,mysqlPassword);
            /* 通过连接获取sql执行对象*/
            Statement statement = connection.createStatement();
            /* 通过sql执行对象执行sql*/
            //定义查询sql
            String sql = "select * from student";
            ResultSet resultSet = statement.executeQuery(sql);
            /*- 遍历结果集输出数据*/
            List<Student> students = new ArrayList<>();
            while(resultSet.next()) {
                //封装学生表结果
                Student student = new Student();
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setBirth(resultSet.getString("birth"));
                student.setSex(resultSet.getString("sex"));
                students.add(student);
            }
            return students;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /***************************************************************************************************************************
     *  @fn             JDBC_SelectStudentByUsernameFun
     *  @brief          学生表通过用户名查询学生操作
     *  @type           静态方法
     *  @detail         调用方法,方法进根据输出参数学生姓名查询对应学生信息操作，并将封装好的学生结果集返回，若查询失败，
     *                  函数返回null结果，调用者需要做空指针判断。
     *  @param[in]      String username 学生姓名
     *  @return         Student 学生信息
     ****************************************************************************************************************************/
    public static Student JDBC_SelectStudentByUsernameFun(String username){
        try{
            /* 获取数据库连接配置信息*/
            Properties properties = new Properties();
            InputStream resourceAsStream = JdbcDemo.class.getClassLoader().getResourceAsStream("mysql.properties");
            properties.load(resourceAsStream);
            String mysqlDriver = properties.getProperty("mysql.driver");
            String mysqlUrl = properties.getProperty("mysql.url");
            String mysqlUsername = properties.getProperty("mysql.username");
            String mysqlPassword = properties.getProperty("mysql.password");
            /* 注册mysql驱动*/
            Class.forName(mysqlDriver);
            /* 获取mysql连接*/
            Connection connection = DriverManager.getConnection(mysqlUrl,mysqlUsername,mysqlPassword);
            /* 通过连接获取sql执行对象*/
            //定义模板查询sql,防止sql注入
            String sql = "select * from student where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            //封装学生表结果
            Student student = new Student();
            while(resultSet.next()){
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setBirth(resultSet.getString("birth"));
                student.setSex(resultSet.getString("sex"));
            }
            return student;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
