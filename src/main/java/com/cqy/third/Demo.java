package com.cqy.third;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Demo {
    private static SqlSessionFactory factory=null;
    static {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
            factory=new SqlSessionFactoryBuilder().build(resourceAsReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void findByCid(){
        SqlSession session = factory.openSession();
        CourseDao mapper = session.getMapper(CourseDao.class);
        Course course = mapper.findByCid(2);
        List<Student> stuList = course.getStuList();
        for (Student student : stuList) {
            System.out.println(student);
        }
        session.commit();
        session.close();
    }
    public static void findByCid1(){
        SqlSession session = factory.openSession();
        CourseDao mapper = session.getMapper(CourseDao.class);
        Course course = mapper.findByCid1(2);
        List<Student> stuList = course.getStuList();
        for (Student student : stuList) {
            System.out.println(student);
        }
        session.commit();
        session.close();
    }
    public static void main(String[] args) {
        findByCid1();
    }
}
