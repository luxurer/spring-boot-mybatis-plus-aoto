package com.example.mybatisplus.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author liuwei
* @since 2020-01-06
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Fill extends Model<Fill> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "fill_id", type = IdType.AUTO)
    private Integer fillId;

        @TableField("subject")
    private String subject;

        @TableField("content")
    private String content;

        @TableField("difficulty_coe")
    private Integer difficultyCoe;

        @TableField("answer")
    private String answer;

        @TableField("chapter")
    private Integer chapter;

        @TableField("repeat_flag")
    private Integer repeatFlag;


    @Override
    protected Serializable pkVal() {
        return this.fillId;
    }

}
