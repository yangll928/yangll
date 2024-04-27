package com.yll.cloud.service;


import com.yll.cloud.entities.Pay;

import java.util.List;

public interface PayService {

    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();

}
