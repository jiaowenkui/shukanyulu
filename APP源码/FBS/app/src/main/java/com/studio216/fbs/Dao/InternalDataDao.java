package com.studio216.fbs.Dao;

/**
 * 内部资料Dao操作接口
 * Created by Book on 2015/1/13.
 */
public interface InternalDataDao {
    /**
     * 通过条形码Id获取内部资料类
     *
     * @return
     */
    public void getInternalDataBy1DCode(String code);

    /**
     * 通过ISBN获取内部资料类
     * @param code
     * @return
     */
    public void getInternalDataByISBN(String code);
}
