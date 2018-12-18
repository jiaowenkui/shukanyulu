package com.studio216.fbs.Dao;

/**
 * 杂志Dao操作接口
 * Created by Book on 2015/1/13.
 */
public interface MagazineDao {
    /**
     * 通过条形码Id获取杂志类
     *
     * @return
     */
    public void getMagazineDaoBy1DCode(String code);

    /**
     * 通过ISBN获取Magazine类
     * @param code
     * @return
     */
    public void getMagazineDaoByISBN(String code);
}
