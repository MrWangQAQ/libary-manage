package com.example.libarymanage.controller;

import com.example.libarymanage.entity.BookAdmin;
import com.example.libarymanage.entity.SystemAdmin;
import com.example.libarymanage.service.BookAdminService;
import com.example.libarymanage.service.SystemAdminService;
import com.example.libarymanage.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/bookAdminManage")
public class BookAdminManageController {

    private final BookAdminService bookAdminService;
    private final SystemAdminService systemAdminService;

    @Autowired
    public BookAdminManageController(BookAdminService bookAdminService, SystemAdminService systemAdminService) {
        this.bookAdminService = bookAdminService;
        this.systemAdminService = systemAdminService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getList")
    public JSONResult getList(int page, int pageSize) {
        JSONResult jsonResult = new JSONResult<>();
        Map input = new HashMap();
        input.put("page", page);
        input.put("pageSize", pageSize);
        List<BookAdmin> bookAdminList = bookAdminService.getList(input);
        jsonResult.setData(bookAdminList);
        int totalCount = bookAdminService.getTotalCount();
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editById")
    public JSONResult editById(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int status = bookAdminService.editById(input);
        if (status == 0){
            jsonResult.setMessage("编辑失败！");
        } else{
            jsonResult.setMessage("编辑成功！");
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addBookAdmin")
    public JSONResult addBookAdmin(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int status = bookAdminService.addBookAdmin(input);
        if (status == 0){
            jsonResult.setMessage("新增失败！");
        } else{
            jsonResult.setMessage("新增成功！");
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteById")
    public JSONResult deleteById(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int status = bookAdminService.deleteById(Integer.parseInt(input.get("id").toString()));
        if (status == 0){
            jsonResult.setMessage("删除失败！");
        } else{
            jsonResult.setMessage("删除成功！");
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/changePassword")
    public JSONResult changePassword(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int status = systemAdminService.changePassword(input);
        if (status == 0){
            jsonResult.setMessage("密码不正确！");
            jsonResult.setStatus(false);
        } else{
            jsonResult.setMessage("修改成功！");
            jsonResult.setStatus(true);
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectById")
    public JSONResult selectById(int id) {
        JSONResult jsonResult = new JSONResult<>();
        BookAdmin bookAdmin = bookAdminService.selectById(id);
        jsonResult.setData(bookAdmin);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editData")
    public JSONResult editData(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int status = systemAdminService.editData(input);
        if (status == 0){
            jsonResult.setMessage("没有修改！");
            jsonResult.setStatus(false);
        } else{
            jsonResult.setMessage("修改成功！");
            jsonResult.setStatus(true);
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getDataById")
    public JSONResult getDataById(int id) {
        JSONResult jsonResult = new JSONResult<>();
        SystemAdmin systemAdmin = systemAdminService.getDataById(id);
        jsonResult.setData(systemAdmin);
        return jsonResult;
    }
}
