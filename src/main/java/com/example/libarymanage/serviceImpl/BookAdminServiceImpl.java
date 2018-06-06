package com.example.libarymanage.serviceImpl;

import com.example.libarymanage.dao.mapper.BookAdminMapper;
import com.example.libarymanage.entity.BookAdmin;
import com.example.libarymanage.service.BookAdminService;
import com.example.libarymanage.utils.PasswordUtil;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class BookAdminServiceImpl implements BookAdminService {
    private final BookAdminMapper bookAdminMapper;

    public BookAdminServiceImpl(BookAdminMapper bookAdminMapper) {
        this.bookAdminMapper = bookAdminMapper;
    }

    @Override
    public BookAdmin selectByAdName(String adName){
        return bookAdminMapper.selectByAdName(adName);
    }

    @Override
    public List<BookAdmin> getList(Map input){
        return bookAdminMapper.getList(input);
    }

    @Override
    public int editById(Map input){
        BookAdmin bookAdmin = new BookAdmin();
        bookAdmin.setAdName(input.get("adName").toString());
        bookAdmin.setAdmail(input.get("admail").toString());
        bookAdmin.setAdPhone(input.get("adPhone").toString());
        bookAdmin.setId(Integer.parseInt(input.get("id").toString()));
        return bookAdminMapper.editById(bookAdmin);
    }

    @Override
    public BookAdmin selectById(Integer id){
        return bookAdminMapper.selectById(id);
    }

    @Override
    public int deleteById(Integer id){
        return bookAdminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addBookAdmin(Map input){
        BookAdmin bookAdmin = new BookAdmin();
        PasswordUtil passwordUtil = new PasswordUtil();
        String password = passwordUtil.generate("123456");  //初始化密码123456
        bookAdmin.setAdPassword(password);
        bookAdmin.setAdName(input.get("adName").toString());
        bookAdmin.setAdmail(input.get("admail").toString());
        bookAdmin.setAdPhone(input.get("adPhone").toString());
        return bookAdminMapper.insert(bookAdmin);
    }

    @Override
    public int getTotalCount(){
        return bookAdminMapper.getTotalCount();
    }
}
