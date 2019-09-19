package com.example.lishengbo.utils;

import com.example.lishengbo.User;
import com.example.lishengbo.api.GreendaoApp;
import com.example.lishengbo.dao.DaoMaster;
import com.example.lishengbo.dao.DaoSession;
import com.example.lishengbo.dao.UserDao;

import java.util.List;

public class DbUtil {
    private static DbUtil dbUtil;
    private final UserDao userDao;

    private DbUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GreendaoApp.getApp(), "user");

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());

        DaoSession daoSession = daoMaster.newSession();

        userDao = daoSession.getUserDao();

    }

    public static DbUtil getDbUtil() {
        if (dbUtil == null) {
            synchronized (DbUtil.class) {
                if (dbUtil == null) {
                    dbUtil = new DbUtil();
                }
            }
        }
        return dbUtil;
    }

    public long insert(User user) {
        if (!isInsertde(user)) {
            return userDao.insertOrReplace(user);
        }
        return -1;
    }

    private boolean isInsertde(User user) {

        List<User> list = userDao.queryBuilder().where(UserDao.Properties.Name.eq(user.getName())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

    public List<User> select() {
        List<User> users = userDao.loadAll();
        return users;
    }

    public User select(String name) {
        List<User> list = userDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).list();
        if (list!=null &&list.size()>0){
            User user = list.get(0);
            return user;
        }

        return null;
    }

   /* public User select(User user) {
        List<User> list = userDao.queryBuilder().where(UserDao.Properties.Pass.eq(user.getPass())).list();
        if (list != null && list.size() > 0) {
            User user = list.get(0);
            return user;
        }

        return null;
    }*/
}
