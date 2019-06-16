app.controller('contentController', function ($controller, $scope, contentService) {
    $controller('baseController', {$scope: $scope});
    $scope.contentList = [];

    //根据广告分类查询广告
    $scope.findByCategoryId = function (categoryId) {
        contentService.findByCategoryId(categoryId).success(
            function (response) {
                $scope.contentList[categoryId] = response;
            }
        );
    }

})