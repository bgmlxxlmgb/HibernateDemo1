package com.zkpk.bgm.hibernate.entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2016/8/5.
 */
public class Client {
    public static void main(String[]args){
        //读取hibernate.cfg.xml文件
        Configuration cfg = new Configuration().configure();
        //建立SessionFactory
        SessionFactory factory =cfg.buildSessionFactory();
        //取得session
        Session session = null;
        try{
            //开启session
            session = factory.openSession();
            //开启事务
            session.beginTransaction();
            User user = new User();
            String name = "lx";
            user.setName(name);
            user.setPassword("lx");
            user.setCreateTime(new Date());
            user.setExpireTime(new Date());
            //保存User对象
            session.save(user);
            //提交事务
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            //回滚事务
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                if(session.isOpen()){
                    //关闭session
                    session.close();
                }
            }
        }
    }
}
