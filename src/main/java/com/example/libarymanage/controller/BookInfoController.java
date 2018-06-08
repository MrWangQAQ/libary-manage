package com.example.libarymanage.controller;

import com.example.libarymanage.entity.BookInfo;
import com.example.libarymanage.service.BookInfoService;
import com.example.libarymanage.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/bookInfo")
public class BookInfoController {

    private final BookInfoService bookInfoService;

    @Autowired
    public BookInfoController(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getList")
    public JSONResult getList(int page, int pageSize) {
        JSONResult jsonResult = new JSONResult<>();
        Map input = new HashMap();
        input.put("page", page);
        input.put("pageSize", pageSize);
        List<BookInfo> bookInfoList = bookInfoService.getList(input);
        jsonResult.setData(bookInfoList);
        int totalCount = bookInfoService.getTotalCount();
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getListByBookName")
    public JSONResult getListByBookName(int page, int pageSize, String bookName) {
        JSONResult jsonResult = new JSONResult<>();
        Map input = new HashMap();
        input.put("page", page);
        input.put("pageSize", pageSize);
        input.put("bookName", bookName);
        List<BookInfo> bookInfoList = bookInfoService.getListByBookName(input);
        jsonResult.setData(bookInfoList);
        int totalCount = bookInfoService.getTotalCount();
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addBook")
    public JSONResult addBook(@RequestBody @Valid BookInfo bookInfo) {
        JSONResult jsonResult = new JSONResult<>();
        int status = bookInfoService.addBook(bookInfo);
        if (status == 0){
            jsonResult.setMessage("新增失败！");
        } else{
            jsonResult.setMessage("新增成功！");
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteBook")
    public JSONResult deleteBook(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        int status = bookInfoService.deleteBook(Integer.parseInt(input.get("id").toString()));
        if (status == 0){
            jsonResult.setMessage("删除失败！");
        } else{
            jsonResult.setMessage("删除成功！");
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editBook")
    public JSONResult editBook(@RequestBody @Valid BookInfo bookInfo) {
        JSONResult jsonResult = new JSONResult<>();
        int status = bookInfoService.editBook(bookInfo);
        if (status == 0){
            jsonResult.setMessage("编辑失败！");
        } else{
            jsonResult.setMessage("编辑成功！");
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectBookById")
    public JSONResult selectBookById(int id) {
        JSONResult jsonResult = new JSONResult<>();
        BookInfo bookInfo = bookInfoService.selectBookById(id);
        jsonResult.setData(bookInfo);
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getBookByNumber")
    public JSONResult getBookByNumber(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        BookInfo bookInfo = bookInfoService.getBookByNumber(input.get("bookNumber").toString());
        jsonResult.setData(bookInfo);
        return jsonResult;
    }

}
