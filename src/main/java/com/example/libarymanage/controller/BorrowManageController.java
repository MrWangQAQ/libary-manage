package com.example.libarymanage.controller;

import com.example.libarymanage.entity.BookAdmin;
import com.example.libarymanage.entity.BookInfo;
import com.example.libarymanage.entity.BorrowRecords;
import com.example.libarymanage.entity.dto.BorrowRecordsDTO;
import com.example.libarymanage.entity.dto.UserList;
import com.example.libarymanage.service.BookAdminService;
import com.example.libarymanage.service.BookInfoService;
import com.example.libarymanage.service.BorrowRecordsService;
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
@RequestMapping("/borrowManage")
public class BorrowManageController {

    private final BorrowRecordsService borrowRecordsService;
    private final BookInfoService bookInfoService;
    private final UserService userService;
    private final BookAdminService bookAdminService;

    @Autowired
    public BorrowManageController(BorrowRecordsService borrowRecordsService, BookInfoService bookInfoService, UserService userService, BookAdminService bookAdminService) {
        this.borrowRecordsService = borrowRecordsService;
        this.bookInfoService = bookInfoService;
        this.userService = userService;
        this.bookAdminService = bookAdminService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/borrowBook")
    public JSONResult borrowBook(@RequestBody @Valid BorrowRecords borrowRecords){
        JSONResult jsonResult = new JSONResult<>();
        int status1 = borrowRecordsService.borrowBook(borrowRecords);
        int status2 = bookInfoService.borrowBook(borrowRecords.getBookId());
        if (status1 == 0 || status2 == 0){
            jsonResult.setStatus(false);
            jsonResult.setMessage("借书失败！");
        } else{
            jsonResult.setStatus(true);
            jsonResult.setMessage("借书成功！");
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/backBook")
    public JSONResult backBook(@RequestBody @Valid BorrowRecords borrowRecords){
        JSONResult jsonResult = new JSONResult<>();
        int status1 = borrowRecordsService.backBook(borrowRecords);
        int status2 = bookInfoService.backBook(borrowRecords.getBookId());
        if (status1 == 0 || status2 == 0){
            jsonResult.setMessage("还书失败！");
            jsonResult.setStatus(false);
        } else{
            jsonResult.setStatus(true);
            jsonResult.setMessage("还书成功！");
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getList")
    public JSONResult getList(int page, int pageSize, String userId) {
        JSONResult jsonResult = new JSONResult<>();
        Map input = new HashMap();
        input.put("page", page);
        input.put("pageSize", pageSize);
        input.put("userId", userId);
        List<BorrowRecordsDTO> borrowRecordsDTOList = borrowRecordsService.getBookList(input);
        jsonResult.setData(borrowRecordsDTOList);
        int totalCount = borrowRecordsService.getTotalCountByNumber(userId);
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllList")
    public JSONResult getAllList(int page, int pageSize, String search) {
        JSONResult jsonResult = new JSONResult<>();
        Map input = new HashMap();
        input.put("page", page);
        input.put("pageSize", pageSize);
        input.put("search", search);
        List<BorrowRecordsDTO> borrowRecordsDTOList = borrowRecordsService.getBookALLList(input);
        jsonResult.setData(borrowRecordsDTOList);
        int totalCount = borrowRecordsService.getTotalCount();
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getBookByNumber")
    public JSONResult getBookByNumber(Boolean state, String userNumber, int page, int pageSize) {
        JSONResult jsonResult = new JSONResult<>();
        Map input = new HashMap();
        input.put("state", state);
        input.put("userNumber", userNumber);
        input.put("page", page);
        input.put("pageSize", pageSize);
        List<BorrowRecordsDTO> borrowRecordsDTO = borrowRecordsService.getBookByNumber(input);
        jsonResult.setData(borrowRecordsDTO);
        int totalCount = borrowRecordsService.getTotalCountBookByNumber(userNumber, state);
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getBook")
    public JSONResult getBook(String bookNumber) {
        JSONResult jsonResult = new JSONResult<>();
        BookInfo bookInfo = bookInfoService.getBookByNumber(bookNumber);
        jsonResult.setData(bookInfo);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/judgeUser")
    public JSONResult judgeUser(String userNumber, Boolean state) {
        JSONResult jsonResult = new JSONResult<>();
        UserList user = userService.getUserByNumber(userNumber);
        jsonResult.setData(user);
        int totalCount = borrowRecordsService.getTotalCountBookByNumber(userNumber, state);
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/changePassword")
    public JSONResult changePassword(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int status = bookAdminService.changePassword(input);
        if (status == 0){
            jsonResult.setMessage("原密码不正确");
            jsonResult.setStatus(false);
        } else{
            jsonResult.setMessage("修改成功");
            jsonResult.setStatus(true);
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getDataById")
    public JSONResult getDataById(int id) {
        JSONResult jsonResult = new JSONResult<>();
        BookAdmin bookAdmin = bookAdminService.selectById(id);
        jsonResult.setData(bookAdmin);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editData")
    public JSONResult editData(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int status = bookAdminService.editById(input);
        if (status == 0){
            jsonResult.setMessage("没有修改");
            jsonResult.setStatus(false);
        } else{
            jsonResult.setMessage("修改成功");
            jsonResult.setStatus(true);
        }
        return jsonResult;
    }
}
