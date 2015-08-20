package cn.com.bsfit.frms.manager.mapper;

import cn.com.bsfit.frms.manager.pojo.RolesResourcesExample;
import cn.com.bsfit.frms.manager.pojo.RolesResourcesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesResourcesMapper {
    int countByExample(RolesResourcesExample example);

    int deleteByExample(RolesResourcesExample example);

    int deleteByPrimaryKey(RolesResourcesKey key);

    int insert(RolesResourcesKey record);

    int insertSelective(RolesResourcesKey record);

    List<RolesResourcesKey> selectByExample(RolesResourcesExample example);

    int updateByExampleSelective(@Param("record") RolesResourcesKey record, @Param("example") RolesResourcesExample example);

    int updateByExample(@Param("record") RolesResourcesKey record, @Param("example") RolesResourcesExample example);
}