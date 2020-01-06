package com.ltt.demo.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
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
    @TableName("t_property_value")
    public class PropertyValue extends Model<PropertyValue> {

    private static final long serialVersionUID = 1L;

            /**
            * 主键
            */
            @TableId("id")
    private String id;

            /**
            * 属性编码
            */
        @TableField("code")
    private String code;

            /**
            * 属性值
            */
        @TableField("value")
    private String value;

            /**
            * 所属学生ID
            */
        @TableField("student_id")
    private String studentId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
