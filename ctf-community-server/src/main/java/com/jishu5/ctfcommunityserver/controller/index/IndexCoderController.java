package com.jishu5.ctfcommunityserver.controller.index;

import com.jishu5.ctfcommunityserver.dao.CoderService;
import com.jishu5.ctfcommunityserver.dto.params.index.CoderParamsDto;
import com.jishu5.ctfcommunityserver.dto.ShareCodeDto;
import com.jishu5.ctfcommunityserver.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index/coder")
public class IndexCoderController {

    @Autowired
    private CoderService coderService;

    @PostMapping("/run")
    public R run(@RequestBody CoderParamsDto coderParamsDto){
        return coderService.run(coderParamsDto);
    }

    @PostMapping("/share/code")
    public R shareCode(@RequestBody ShareCodeDto shareCodeDto){
        return coderService.shareCode(shareCodeDto);
    }

    @GetMapping("/share/code/detail")
    public R getShareCode(String key){
        return coderService.getShareCode(key);
    }

}
