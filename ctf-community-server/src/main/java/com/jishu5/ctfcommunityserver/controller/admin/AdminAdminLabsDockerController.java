package com.jishu5.ctfcommunityserver.controller.admin;

import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.SafeDocker;
import com.jishu5.ctfcommunityserver.service.SafeDockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/labs/docker")
public class AdminAdminLabsDockerController {

    @Autowired
    private SafeDockerService safeDockerService;

    @GetMapping("/list")
    public R getList(@RequestParam(value = "currentPage", required = true) Integer currentPage,
                     @RequestParam(value = "pageSize", required = true) Integer pageSize,
                     @RequestParam(value = "keywords", required = false) String keywords,
                     @RequestParam(value = "type", required = false) Integer type
    ){
        return safeDockerService.getList(currentPage, pageSize, keywords, type);
    }

    @PreAuthorize("hasAuthority('admin:labdocker:delete')")
    @DeleteMapping("/delete")
    public R deleteById(@RequestParam("id") Integer id){
        return safeDockerService.deleteById(id);
    }

    @PreAuthorize("hasAuthority('admin:labdocker:delete')")
    @DeleteMapping("/delete/list")
    public R deleteListById(@RequestParam("ids") String ids){
        return safeDockerService.deleteListById(ids);
    }

    @PreAuthorize("hasAuthority('admin:labdocker:add')")
    @PostMapping("/add")
    public R addLabsDocker(@RequestBody SafeDocker safeDocker){
        return safeDockerService.addSafeDocker(safeDocker);
    }

    @PreAuthorize("hasAuthority('admin:labdocker:update')")
    @PostMapping("/update")
    public R updateLabsDocker(@RequestBody SafeDocker safeDocker){
        return safeDockerService.updateSafDocker(safeDocker);
    }



}
