package com.du.hd_jdbc;
import com.du.hd_entity.Student;
import org.junit.Test;
import java.util.List;

public class JdbcConnectDbTest {

    @Test
    public void Test_JDBC_SelectAllFun() {
        List<Student> students = JdbcDemo.JDBC_SelectAllFun();
        if(null!=students){
            for (Student s:students){
                System.out.println(s);
            }
        }
        else{
            System.out.println("查询失败");
        }
    }

    @Test
    public void Test_JDBC_SelectStudentByUsernameFun()
    {
        Student student = JdbcDemo.JDBC_SelectStudentByUsernameFun("孙风");
        System.out.println(student);
    }
}
