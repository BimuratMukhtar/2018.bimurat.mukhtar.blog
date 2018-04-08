package impl;

import dao.AuthDao;
import dao.postgres.AuthDaoPostgres;
import kz.greetgo.depinject.core.BeanGetter;

public class AuthRegisterImpl implements AuthDaoPostgres{

    public BeanGetter<AuthDao>  testDao;

    @Override
    public String getAuthText() {
        return testDao.get().getAuthText();
    }
}
