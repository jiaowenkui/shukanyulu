package com.studio216.fbs.Dao;

/**
 * 其他的Dao操作
 * Created by Book on 2015/1/13.
 */
public interface OtherDao {
    /**
     * 通过条形码Id获取类型
     *
     * @return
     */
    public void getTypeBy1Code(String code);

    /**
     * 通过ISBN获取类型
     *
     * @param code
     * @return
     */
    public void getTypeByISBN(String code);
}
