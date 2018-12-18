package com.studio216.fbs.Dao;

import com.studio216.fbs.bean.Book;

/**
 * 书籍Dao操作接口
 * Created by Book on 2015/1/13.
 */
public interface BookDao {
    /**
     * 通过条形码Id获取Book类
     *
     * @return
     */
    public void getBookBy1DCode(String code);

    /**
     * 通过ISBN获取Book类
     * @param code
     * @return
     */
    public void getBookByISBN(String code);
}
