package com.pinyougou.sellergoods.service;
import java.util.List;
import com.pinyougou.pojo.TbGoods;

import com.pinyougou.pojogroup.Goods;
import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface GoodsService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbGoods> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Goods goods);
	
	
	/**
	 * 修改
	 */
	public void update(Goods goods);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Goods findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbGoods goods, int pageNum, int pageSize);

	/**
	 * 修改状态
	 * @param ids 商品ID集合
	 * @param status 审核后的状态
	 */
	public void updateStatus(Long[] ids,String status);

	/**
	 * 商品上下架
	 * @param ids 选中的商品
	 * @param isMarketable  1上架 0 下架 只有通过审核的商品才能上下架
	 */
	public void updateIsMarketable(Long[] ids,String isMarketable );

	/**
	 * 商家商品提交审核
	 * @param ids
	 */
	public void goodsCommitCheck(Long[] ids);
}
