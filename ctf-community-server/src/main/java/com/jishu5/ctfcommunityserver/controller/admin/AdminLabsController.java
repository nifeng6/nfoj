package com.jishu5.ctfcommunityserver.controller.admin;

import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.SafeLabs;
import com.jishu5.ctfcommunityserver.service.SafeDockerService;
import com.jishu5.ctfcommunityserver.service.SafeLabsService;
import com.jishu5.ctfcommunityserver.service.SafeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/labs")
public class AdminLabsController {

    @Autowired
    private SafeTypeService safeTypeService;

    @Autowired
    private SafeLabsService safeLabsService;

    @Autowired
    private SafeDockerService safeDockerService;

    @GetMapping("/list")
    public R getList(@RequestParam(value = "currentPage", required = true) Integer currentPage,
                     @RequestParam(value = "pageSize", required = true) Integer pageSize,
                     @RequestParam(value = "keywords", required = false) String keywords,
                     @RequestParam(value = "type", required = false) Integer type
    ){
        return safeLabsService.getList(currentPage, pageSize, keywords, type);
    }

    @DeleteMapping("/delete")
    public R deleteById(@RequestParam("id") Integer id){
        return safeLabsService.deleteById(id);
    }


    @DeleteMapping("/delete/list")
    public R deleteListById(@RequestParam("ids") String ids){
        return safeLabsService.deleteListById(ids);
    }

    @PostMapping("/add")
    public R addLabs(@RequestBody SafeLabs safeLabs){
        return safeLabsService.addLabs(safeLabs);
    }

    @PostMapping("/update")
    public R updateLabs(@RequestBody SafeLabs safeLabs){
        return safeLabsService.updateLabsById(safeLabs);
    }

    @GetMapping("/type/list")
    public R getLabsTypeList(){
        return safeTypeService.getList();
    }

    @GetMapping("/rule/list")
    public R getLabsDockerList(){
        return safeDockerService.getList();
    }

}
