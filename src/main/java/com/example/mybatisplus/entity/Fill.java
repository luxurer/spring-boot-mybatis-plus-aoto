package com.example.mybatisplus.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author huzhiting
* @since 2020-01-05
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Fill implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "fill_id", type = IdType.AUTO)
    private Integer fillId;

    private String subject;

    private String content;

    private Integer difficultyCoe;

    private String answer;

    private Integer chapter;

    private Integer repeatFlag;


}
