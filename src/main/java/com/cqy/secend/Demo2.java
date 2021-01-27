package com.cqy.secend;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
public class Demo2 {
    private static SqlSessionFactory factory=null;
    static {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
            factory= new SqlSessionFactoryBuilder().build(resourceAsReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void add2(){
        SqlSession sqlSession = factory.openSession();
        Employee employee = new Employee();
        employee.setName("熊二");
        employee.setSex("男");
        employee.setAge(15);
        employee.setPhone("1354597876");
        sqlSession.insert("employeeDao.add2",employee);
        sqlSession.commit();
        sqlSession.close();
    }
    public static void update(){
        SqlSession sqlSession = factory.openSession();
        Employee employee = new Employee();
        employee.setName("熊三");
        employee.setAge(16);
        employee.setPhone("13245687564");
        employee.setSex("女");
        employee.setId(2);
        sqlSession.update("employeeDao.update",employee);
        sqlSession.commit();
        sqlSession.close();
    }
    public static void main(String[] args) {
        update();
    }
}
