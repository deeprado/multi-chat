package com.deep.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3p0Utils {

    private static Logger logger = Logger.getLogger(C3p0Utils.class.getName());

    // 通过标识来创建相应连接池
    static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    // 获取连接池连接
    public static Connection getConnection() throws Exception {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("Exception in c3p0 Utils!", e);
            throw new Exception("数据库连接关闭出错!", e);
        }
    }

    // 关闭连接
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) throws Exception {

        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                // TODO: handle exception
                logger.error("Exception in C3p0Utils!", e);
                throw new Exception("数据库连接关闭出错!", e);
            }
        }

        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
                throw new Exception("数据库连接关闭出错!", e);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
                throw new Exception("数据库连接关闭出错!", e);
            }
        }
    }

}
