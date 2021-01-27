package com.cqy.first;

import com.cqy.secend.Employee;
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
            factory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void selectBySex(){
        SqlSession sqlSession = factory.openSession();
        List<Employee> list = sqlSession.selectList("empMapper.selectBySex", "男");
        for (Employee employee : list) {
            System.out.println(employee);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    private static void selectById(){
        SqlSession sqlSession = factory.openSession();
        List<Employee> list = sqlSession.selectList("empMapper.selectById", 3);
        for (Employee employee : list) {
            System.out.println(employee);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    private static void add2(){
        SqlSession sqlSession = factory.openSession();
        Employee employee = new Employee();
        employee.setName("熊大");
        employee.setAge(5);
        employee.setSex("熊");
        sqlSession.insert("employeeDao.add2",employee);
        sqlSession.commit();
        sqlSession.close();
    }
    public static void main(String[] args) {
        add2();
    }
}
