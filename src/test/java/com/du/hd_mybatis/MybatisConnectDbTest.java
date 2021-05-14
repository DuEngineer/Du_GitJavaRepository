package com.du.hd_mybatis;
import com.du.hd_entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

public class MybatisConnectDbTest {
    @Test
    public void Test_Mybatis_SelectFun() {
        try {
            /* 获取mybatis主配置文件输入流*/
            String config = "mybatis.xml";
            InputStream in = Resources.getResourceAsStream(config);
            /* 获取SqlSession对象*/
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            SqlSession dao = factory.openSession();
            /* 获取dao对象*/
            StudentDao mapper = dao.getMapper(StudentDao.class);
            /* 执行sql，遍历结果集*/
            List<Student> students = mapper.Mybatis_SelectAllFun();
            if(null!=students){
                for (Student s:students){
                    System.out.println(s);
                }
            }
            else{
                System.out.println("查询失败");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test_Mybatis_SelectStudentByUsernameFun() {
        try {
            /* 获取mybatis主配置文件输入流*/
            String config = "mybatis.xml";
            InputStream in = Resources.getResourceAsStream(config);
            /* 获取SqlSession对象*/
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            SqlSession dao = factory.openSession();
            /* 获取dao对象*/
            StudentDao mapper = dao.getMapper(StudentDao.class);
            /* 执行sql，遍历结果集*/
            Student student = mapper.Mybatis_SelectStudentByUsernameFun("孙风");
            if(null!=student){
                System.out.println(student);
            }
            else{
                System.out.println("查询失败");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
