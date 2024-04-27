package com.yll.cloud.mapper;

import com.yll.cloud.entities.Storage;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper extends Mapper<Storage> {

    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}