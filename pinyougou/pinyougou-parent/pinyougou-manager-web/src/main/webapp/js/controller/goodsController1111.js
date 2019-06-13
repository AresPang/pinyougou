//控制层
app.controller('goodsController', function ($scope, $controller, goodsService, itemCatService, typeTemplateService, $location) {

    $controller('baseController', {$scope: $scope});//继承

    //读取列表数据绑定到表单中  
    $scope.findAll = function () {
        goodsService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    }


    //查询实体
    	$scope.findOne=function(id){
            goodsService.findOne(id).success(
                function(response){
                    $scope.entity= response;
                }
            );
        }

    //查询实体
/*
    $scope.findOne = function () {
        var id = $location.search()['id'];
        goodsService.findOne(id).success(
            function (response) {
                $scope.entity = response;
                $scope.entity.goodsDesc = response.goodsDesc;
                $scope.entity.goodsDesc.introduction = response.goodsDesc.introduction
                $scope.entity.itemList = response.itemList;
                // 富文本编辑器
                editor.html($scope.entity.goodsDesc.introduction);
                //商品介绍
                $scope.entity.goodsDesc.itemImages = JSON.parse($scope.entity.goodsDesc.itemImages);
                //展示图片
                $scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.entity.goodsDesc.customAttributeItems);//展示图片
                //规格
                $scope.entity.goodsDesc.specificationItems = JSON.parse($scope.entity.goodsDesc.specificationItems);

                //SKU列表规格列转换
                for (var i = 0; i < $scope.entity.itemList.length; i++) {
                    $scope.entity.itemList[i].spec =
                        JSON.parse($scope.entity.itemList[i].spec);
                }
            }
        );
    }
*/


    //保存
    $scope.save = function () {
        var serviceObject;//服务层对象
        if ($scope.entity.id != null) {//如果有ID
            serviceObject = goodsService.update($scope.entity); //修改
        } else {
            serviceObject = goodsService.add($scope.entity);//增加
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    //重新查询
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    }


    //批量删除
    $scope.dele = function () {
        //获取选中的复选框
        goodsService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                    $scope.selectIds = [];
                }
            }
        );
    }

    $scope.searchEntity = {};//定义搜索对象

    //搜索
    $scope.search = function (page, rows) {
        goodsService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    $scope.status = ["未审核", "已审核", "审核未通过", "已关闭"];
    $scope.itemCatList = [];//商品分类总列表
    //查询商品分类列表
    $scope.findItemCatList = function () {
        itemCatService.findAll().success(
            function (response) {
                for (var i = 0; i < response.length; i++) {
                    $scope.itemCatList[response[i].id] = response[i].name;
                }
            }
        );
    }

//更新状态
    $scope.updateStatus = function (status) {
        goodsService.updateStatus($scope.selectIds, status).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();
                    $scope.selectIds=[];
                } else {
                    alert(response.message);
                    $scope.selectIds=[];
                }
            }
        );
    }

});	
