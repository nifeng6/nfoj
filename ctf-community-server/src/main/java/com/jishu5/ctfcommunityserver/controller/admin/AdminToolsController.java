package com.jishu5.ctfcommunityserver.controller.admin;

import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.ToolList;
import com.jishu5.ctfcommunityserver.service.ToolListService;
import com.jishu5.ctfcommunityserver.service.ToolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/tools")
public class AdminToolsController {

    @Autowired
    private ToolListService toolListService;

    @Autowired
    private ToolTypeService toolTypeService;


    @GetMapping("/list")
    public R getList(@RequestParam(value = "currentPage", required = true) Integer currentPage,
                     @RequestParam(value = "pageSize", required = true) Integer pageSize,
                     @RequestParam(value = "keywords", required = false) String keywords,
                     @RequestParam(value = "type", required = false) Integer type
    ){
        return toolListService.getList(currentPage, pageSize, keywords, type);
    }

    @DeleteMapping("/delete")
    public R deleteById(@RequestParam("id") Integer id){
        return toolListService.deleteById(id);
    }


    @DeleteMapping("/delete/list")
    public R deleteListById(@RequestParam("ids") String ids){
        return toolListService.deleteListById(ids);
    }

    @GetMapping("/type/list")
    public R getToolsTypeList(){
        return toolTypeService.getList();
    }


    @PostMapping("/add")
    public R addTools(@RequestBody ToolList toolList){
        return toolListService.addTools(toolList);
    }

    @PostMapping("/update")
    public R updateTools(@RequestBody ToolList toolList){
        return toolListService.updateTools(toolList);
    }

}
