package com.example.libarymanage.controller;

import com.example.libarymanage.entity.UserInfo;
import com.example.libarymanage.entity.dto.UserList;
import com.example.libarymanage.service.UserInfoService;
import com.example.libarymanage.service.UserService;
import com.example.libarymanage.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/userManage")
public class UserManageController {

    private final UserInfoService userInfoService;
    private final UserService userService;

    @Autowired
    public UserManageController(UserInfoService userInfoService, UserService userService) {
        this.userInfoService = userInfoService;
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getList")
    public JSONResult getList(int page, int pageSize) {
        Map input = new HashMap();
        input.put("page", page);
        input.put("pageSize", pageSize);
        JSONResult jsonResult = new JSONResult<>();
        List<UserList> listUserInfo = userInfoService.getList(input);
        jsonResult.setData(listUserInfo);
        /** 获取总记录数*/
        int totalCount = userService.getTotalCount();
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public JSONResult addUser(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int userId = userService.insert(input.get("userNumber").toString(), input.get("userName").toString());
        input.put("userId", userId);
        int status = userInfoService.insert(input);
        if (status == 0){
            jsonResult.setMessage("新增失败！");
        } else{
            jsonResult.setMessage("新增成功！");
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectUserInfoById")
    public JSONResult selectUserInfoById(int id) {
        JSONResult jsonResult = new JSONResult<>();
        UserList userList = userInfoService.selectUserInfoById(id);
        jsonResult.setData(userList);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteUser")
    public JSONResult deleteUser(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int userInfoId = Integer.parseInt(input.get("userInfoId").toString());
        int userId = Integer.parseInt(input.get("userId").toString());
        int status1 = userService.deleteByUserId(userId);
        int status2 = userInfoService.deleteByUserInfoId(userInfoId);
        if (status1 == 0 || status2 == 0){
            jsonResult.setMessage("删除失败！");
        } else{
            jsonResult.setMessage("删除成功！");
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editUser")
    public JSONResult editUser(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int status1 = userService.editUser(input);
        int status2 = userInfoService.updateByPrimaryKey(input);
        if (status1 == 0 || status2 == 0){
            jsonResult.setMessage("编辑失败！");
        } else{
            jsonResult.setMessage("编辑成功！");
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/resetPassword")
    public JSONResult resetPassword(int userId) {
        JSONResult jsonResult = new JSONResult<>();
        int status = userService.resetPassword(userId);
        if (status == 0){
            jsonResult.setMessage("重置失败！");
            jsonResult.setStatus(false);
        } else{
            jsonResult.setMessage("重置成功！");
            jsonResult.setStatus(true);
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/changeInformation")
    public JSONResult changeInformation(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int status = userInfoService.changeInformation(input);
        if (status == 0){
            jsonResult.setMessage("修改失败！");
            jsonResult.setStatus(true);
        } else{
            jsonResult.setMessage("修改成功！");
            jsonResult.setStatus(false);
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/changePassword")
    public JSONResult changePassword(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int status = userService.changePassword(input);
        if (status == 0){
            jsonResult.setMessage("原密码不正确！");
            jsonResult.setStatus(false);
        } else{
            jsonResult.setMessage("修改成功！");
            jsonResult.setStatus(true);
        }
        return jsonResult;
    }
}
