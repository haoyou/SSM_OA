package com.chy.oa.base.pluging;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,
        Integer.class})
})
public class PagePluging implements Interceptor {
    //核心的拦截方法
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
       StatementHandler statementHandler = (StatementHandler) getNoProxy(invocation.getTarget());
       MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
       BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
       String sql = boundSql.getSql().toLowerCase().trim();


       if (!sql.startsWith("select")){
           //不是查询语句 无需分页
            return invocation.proceed();
       }

       if (sql.indexOf("limit") != -1){
           return invocation.proceed();
       }
        Object params = boundSql.getParameterObject();
       //解析参数
        Page page = parseParams(params);

       if (page == null){
           return invocation.proceed();
       }

//       分頁开始
        int total = getTotal(sql,invocation,metaObject);
       System.out.println("total page :"+total);

       //回设Page对象
        page.setPageCount(total);//设置总条数
        System.out.println(page.getPageSize());
        //设置总页码
        page.setPageSum(
                page.getPageCount() % page.getPageSize() == 0 ?
                page.getPageCount() / page.getPageSize() :
                        page.getPageCount() / page.getPageSize()+1);
        System.out.println(page.getPageSum());

        //防止传进来的SQL自带分号
        if (sql.endsWith(";")){
            sql = sql.substring(0,sql.length()-1);
        }
        System.out.println("sql"+sql);
        //开始分页 要加一个空格 防止连接在一起
        sql += " limit ?,?";
        System.out.println("SQL:"+sql);
        //回设SQL语句
        metaObject.setValue("delegate.boundSql.sql",sql);
        //放行
        PreparedStatement ps = (PreparedStatement) invocation.proceed();
        int parameterCount = ps.getParameterMetaData().getParameterCount();
        System.out.println("ParameterCount:"+parameterCount);
        System.out.println(ps.toString()+":page"+page.getPage());
        ps.setInt(parameterCount - 1,(page.getPage()-1)*page.getPageSize());
        System.out.println("ps-->setInt"+ps);
        ps.setInt(parameterCount,page.getPageSize());
        System.out.println("PS:"+ps);
        return ps;
    }

//    根据插件生成代理对象
    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private Object getNoProxy(Object target){
        MetaObject  metaObject = SystemMetaObject.forObject(target);
        while (metaObject.hasGetter("h")){
            target = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(target);
        }
        return target;
    }

    //解析查询参数
    private Page parseParams(Object params){
        if (params instanceof Map){
            Map<String,Object> paramsMap = (Map<String, Object>) params;
            for ( Map.Entry<String,Object> entry:paramsMap.entrySet()){
                if (entry.getValue() instanceof Page){
                    return (Page) entry.getValue();
                }
            }
        }else if (params instanceof Page){
            return (Page) params;
        }
        return null;
    }

    //计算共有多少条记录
    public Integer getTotal(String sql,Invocation invocation,MetaObject metaObject){
        //获得参数管理器
        ParameterHandler psh = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
        //拼接SQL
        int fromIndex = sql.indexOf("from");
        String countSql = "select count(1) as total " + sql.substring(fromIndex);
        //去除order by
        int orderbyIndex = -1;
        if ((orderbyIndex = countSql.indexOf("order by"))!= -1){
            countSql = countSql.substring(0,orderbyIndex);
        }
        System.out.println(countSql);

        //执行语句
        Connection connection = (Connection) invocation.getArgs()[0];
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
             ps = connection.prepareStatement(countSql);
             psh.setParameters(ps);
             rs = ps.executeQuery();

             if (rs.next()){
                 return rs.getInt("total");
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
