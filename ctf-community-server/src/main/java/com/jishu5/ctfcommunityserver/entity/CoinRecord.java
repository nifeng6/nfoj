package com.jishu5.ctfcommunityserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author nifeng
 * @since 2022-11-04 18:43:46
 */
@Getter
@Setter
@TableName("coin_record")
public class CoinRecord extends Model<CoinRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("amount")
    private String amount;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("user_id")
    private Integer userId;

    @TableField("remark")
    private String remark;

    @TableField("count")
    private String count;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
