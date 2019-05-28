package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

public interface BrandService {
    public List<TbBrand> findAll();

    /**
     * 品牌分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(int pageNum,int pageSize);

    /**
     * 增加品牌
     * @param tbBrand
     */
    public void add(TbBrand tbBrand);

    /**
     * 根据主键查品牌
     * @param id
     * @return
     */
    public TbBrand findOne(Long id);

    /**
     * 修改
     * @param brand
     */
    public void update(TbBrand brand);

    /**
     * 根据品牌id删除品牌
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 带条件品牌分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbBrand brand,int pageNum,int pageSize);

    /**
     * 返回下拉列表数据
     * @return
     */
    public List<Map> selectOptionList();
}
