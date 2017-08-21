package com.oa.fourth.dao;

import com.oa.fourth.model.OaBranchAih;
import com.oa.fourth.model.OaBranchAihExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaBranchAihMapper {
    /**
     *
     * @mbg.generated 2017-08-15
     */
    long countByExample(OaBranchAihExample example);

    /**
     *
     * @mbg.generated 2017-08-15
     */
    int deleteByExample(OaBranchAihExample example);

    /**
     *
     * @mbg.generated 2017-08-15
     */
    int insert(OaBranchAih record);

    /**
     *
     * @mbg.generated 2017-08-15
     */
    int insertSelective(OaBranchAih record);

    /**
     *
     * @mbg.generated 2017-08-15
     */
    List<OaBranchAih> selectByExample(OaBranchAihExample example);

    /**
     *
     * @mbg.generated 2017-08-15
     */
    int updateByExampleSelective(@Param("record") OaBranchAih record, @Param("example") OaBranchAihExample example);

    /**
     *
     * @mbg.generated 2017-08-15
     */
    int updateByExample(@Param("record") OaBranchAih record, @Param("example") OaBranchAihExample example);
}