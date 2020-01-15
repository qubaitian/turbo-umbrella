package com.qbt.template;

import com.qbt.template.entity.Blog;
import com.qbt.template.entity.Student;
import com.qbt.template.entity.Teacher;
import com.qbt.template.mapper.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestSqlSession {
    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            Blog blog = mapper.selectBlog(1L);
            System.out.println(blog.getId());
            System.out.println(blog.getName());
//            System.out.println(blog.getAuthor().getId());
//            System.out.println(blog.getAuthor().getName());
        }
    }
}
