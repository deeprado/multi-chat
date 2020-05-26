package com.deep.utils;

public class TestC3p0 {

    public static void main(String[] args) throws Exception {

        DBUtil_BO dbBo = new DBUtil_BO();
        dbBo.conn = C3p0Utils.getConnection();

        String sql = "select * from user where username = ? and password = ? ";
        dbBo.st = dbBo.conn.prepareStatement(sql);

        dbBo.st.setString(1, "aaa");
        dbBo.st.setString(2, "aaa");

        DBUtils.executeQuery(dbBo);

        if (dbBo.rs.next()) {
            int uid = dbBo.rs.getInt("id");
            System.out.println("用户ID： " + uid);
        }
    }
}
